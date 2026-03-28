package dev.sonle.githubloc.multirepos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dev.sonle.githubloc.RunOptions;
import dev.sonle.githubloc.api.UserInfoFetching;
import dev.sonle.githubloc.filesystem.Unzip;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;

public class MultiReposHandle {

  public record RepoTarget(String repoName, Path validPath) {
  }

  private final String userName;
  private final RunOptions options;

  private final Path userBasePath;
  private final Path reposPath;
  private final Path zipReposPath;
  private final Path jsonResultsPath;

  public MultiReposHandle(RunOptions options) {
    this.options = options;
    this.userName = options.getUserName();

    this.userBasePath = Paths.get("storage", "user-repos", userName);
    this.reposPath = userBasePath.resolve("repos");
    this.zipReposPath = userBasePath.resolve("zip-repos");
    this.jsonResultsPath = userBasePath.resolve("json-results");
  }

  public void preparePaths() throws IOException {
    Files.createDirectories(reposPath);
    Files.createDirectories(zipReposPath);
    Files.createDirectories(jsonResultsPath);
  }

  public void runApp() {
    try {
      preparePaths();
    } catch (IOException e) {
      System.err.println("Failed to create necessary storage directories. Reason: " + e.getMessage());
      return; // Terminate app gracefully
    }
    try {
      List<String> downloadedRepoNames = runDownload();

      List<RepoTarget> validZipRepos = getListTargets(downloadedRepoNames, zipReposPath, ".zip");
      runUnzip(validZipRepos);

      List<RepoTarget> validRepos = getListTargets(downloadedRepoNames, reposPath, "");
      runMultiJsonProcess(validRepos);

    } catch (Exception e) {
      System.err.println("An unexpected orchestration error occurred for user: " + userName);
      e.printStackTrace();
    }
  }

  private List<RepoTarget> getListTargets(List<String> repoNames, Path baseDir, String suffix) {
    List<RepoTarget> listRepoInfo = new ArrayList<>();

    for (String name : repoNames) {
      Path targetPath = baseDir.resolve(name + suffix);
      if (Files.exists(targetPath)) {
        RepoTarget repoInfo = new RepoTarget(name, targetPath);
        listRepoInfo.add(repoInfo);
      } else {
        System.err.println("Warning: Expected path does not exist and will be skipped: " + targetPath);
      }
    }

    return listRepoInfo;
  }

  private List<String> runDownload() {
    System.out.println("Starting download...");
    UserInfoFetching userInfoFetching = new UserInfoFetching();
    List<String> repoNames = userInfoFetching.fetchRepoNames(userName);
    return repoNames;
  }

  private void runUnzip(List<RepoTarget> validZipRepos) {
    if (validZipRepos.isEmpty())
      return;
    Unzip unzipRepo = new Unzip();
    for (RepoTarget zipRepoInfo : validZipRepos) {
      try {
        Path sourceZipRepoPath = zipRepoInfo.validPath();
        Path destRepoPath = this.reposPath.resolve(zipRepoInfo.repoName());
        unzipRepo.unzip(sourceZipRepoPath, destRepoPath);
        System.out.println("Starting unzip for " + sourceZipRepoPath);
      } catch (IOException e) {
        System.err.println("Failed to unzip repo '" + zipRepoInfo.repoName() +
            "'. Skipping to next. Reason: " + e.getMessage());
      }

    }
  }

  private List<Tree> getRepoTrees(List<RepoTarget> validRepos) {
    List<Tree> repoTrees = new ArrayList<>();
    for (RepoTarget repoInfo : validRepos) {
      try {
        Tree repoTree = Tree.buildTree(repoInfo.validPath());
        repoTrees.add(repoTree);
      } catch (IOException e) {
        System.err.println("Failed to process Tree for '" + repoInfo.repoName() +
            "'. Skipping to next. Reason: " + e.getMessage());
      }

    }
    return repoTrees;
  }

  private void runMultiJsonProcess(List<RepoTarget> validRepos) {
    List<Tree> repoTrees = getRepoTrees(validRepos);

    if (repoTrees.isEmpty())
      return;

    JsonProcessor jsonProcessor = new JsonProcessor();
    for (Tree tree : repoTrees) {
      try {
        FileNode root = tree.getRoot();
        String name = root.getName();
        jsonProcessor.exportTreeToJson(jsonResultsPath.resolve(name + ".json"), root);
      } catch (IOException e) {
        System.err.println("Failed to process JSON for " + tree.getRoot().getName() +
            "'. Skipping to next. Reason: " + e.getMessage());
      }

    }
  }
}