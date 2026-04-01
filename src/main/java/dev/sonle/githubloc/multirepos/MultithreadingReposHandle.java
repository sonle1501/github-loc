package dev.sonle.githubloc.multirepos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.sonle.githubloc.RunOptions;
import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.api.UserInfoFetching;
import dev.sonle.githubloc.filesystem.Unzip;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;

public class MultithreadingReposHandle {

  public record RepoTarget(String repoName, long sizeProcess, Path validPath) {
  }

  private String userName;
  private RunOptions options;

  private Path userBasePath;
  private Path reposPath;
  private Path zipReposPath;
  private Path jsonResultsPath;

  public MultithreadingReposHandle(RunOptions options) {
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

  public void runAppAsync() {
    try {
      preparePaths();
    } catch (IOException e) {
      System.err.println("Failed to create necessary storage directories. Reason: " + e.getMessage());
      return; // Terminate app
    }

    ExecutorService ioExecutor = Executors.newCachedThreadPool(); 
    int cores = Runtime.getRuntime().availableProcessors();
    ExecutorService cpuExecutor = Executors.newFixedThreadPool(cores);
    UserInfoFetching userInfoFetching = new UserInfoFetching();

    List<String>repoNames =userInfoFetching.fetchRepoNames(userName);

    List<CompletableFuture<Void>> futures = repoNames
    .stream()
    .map(repoName->runWorkflowForRepo(repoName,cpuExecutor, ioExecutor)).toList();

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();   
        
    ioExecutor.shutdown();
    cpuExecutor.shutdown();
  }

  private CompletableFuture<Void> runWorkflowForRepo(String repoName, ExecutorService cpuExecutor, ExecutorService ioExecutor) {
    CompletableFuture<Void> workflow = CompletableFuture
        .supplyAsync(() -> runSingleDownload(repoName), ioExecutor) // I/O task, need more threads
        .thenApplyAsync(repoInfo -> runSingileUnzip(repoInfo), ioExecutor) // I/O task, need more threads
        .thenAcceptAsync(repoInfo -> runSingleJsonProcess(repoInfo), cpuExecutor) // calculating task, need stable 
        .exceptionally(ex -> {
          System.err.println("Failed processing pipeline for '" + repoName + "': " + ex.getMessage());
          return null; // Continue processing
        });
    return workflow;
  }

  private RepoTarget runSingleDownload(String repoName) {
    RepoDownloader repoDownloader = new RepoDownloader();
    Path donwloadPath = zipReposPath.resolve(repoName + ".zip");
    long downloadedSize = repoDownloader.downloadRepo(donwloadPath, userName, repoName);
    return new RepoTarget(repoName, downloadedSize, donwloadPath);
  }

  private RepoTarget runSingileUnzip(RepoTarget repoInfo) {
    Unzip unzipRepo = new Unzip();
    try {
      Path sourceZipRepoPath = repoInfo.validPath();
      Path destRepoPath = reposPath.resolve(repoInfo.repoName());
      long repoSizeOnDisk = unzipRepo.unzip(sourceZipRepoPath, destRepoPath); 
      return new RepoTarget(repoInfo.repoName(), repoSizeOnDisk, destRepoPath);
    } catch (IOException e) {
      System.err.println("Failed to unzip repo '" + repoInfo.repoName() +
          "'. Skipping to next. Reason: " + e.getMessage());
    }
    return null;
  }

  private void runSingleJsonProcess(RepoTarget repoInfo) {
    try {
        Tree repoTree = new TreeBuilder().buildTreeSequential(repoInfo.validPath());
      try {
        JsonProcessor jsonProcessor = new JsonProcessor();
        FileNode root = repoTree.getRoot();
        String repoName = root.getName();
        long repoSize = repoInfo.sizeProcess();
        Path jsonTarget = jsonResultsPath.resolve(repoName + ".json");
        jsonProcessor.exportTreeToJson(repoTree, userName, repoName, repoSize, jsonTarget); 
        System.out.println("Successfully exported the tree diretory of " + repoName + "at: " + jsonTarget.toString());
      } catch (IOException e) {
        System.err.println("Failed to process JSON for " + repoTree.getRoot().getName() +
            "'. Skipping to next. Reason: " + e.getMessage());
      }
    } catch (IOException e) {
      System.err.println("Failed to process Tree for '" + repoInfo.repoName() +
          "'. Skipping to next. Reason: " + e.getMessage());
    }
  }
}