package dev.sonle.githubloc;

import dev.sonle.githubloc.RunOptions.Mode;
import dev.sonle.githubloc.RunOptions.SortArgument;
import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.multirepos.MultithreadingReposHandle;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreePrinter;
import dev.sonle.githubloc.util.DirectoryTraversal;
import dev.sonle.githubloc.util.FilesSorter;
import dev.sonle.githubloc.util.JsonProcessor;
import dev.sonle.githubloc.util.RepoSorter;
import dev.sonle.githubloc.util.Unzip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Runner {
  private String repoName;
  private String userName;
  private Path baseRepoPath = Paths.get("storage", "repos");
  private Path baseZipPath = Paths.get("storage", "zip-repos");
  private Path baseJsonPath = Paths.get("storage", "json-results");

  private Path repoPath;
  private Path zipPath;
  private Path jsonPath;

  private RunOptions options;
  private Tree repoTree;

  public Runner(RunOptions options) { // the only run constructor
    this.options = options;
  }

  public void setupRepoInfo() {
    this.userName = options.getUserName();
    this.repoName = options.getRepoName();

    this.repoPath = baseRepoPath.resolve(repoName);
    this.zipPath = baseZipPath.resolve(repoName + ".zip");
    this.jsonPath = baseJsonPath.resolve(repoName + ".json");
  }

  public Runner(String userName, String repoName) {
    this(createDefaultRunOptions(userName, repoName));
  }

  public Runner(String repoInfo) {
    this(createDefaultRunOptions(repoInfo.split("/")[1], repoInfo.split("/")[0]));
  }

  public static RunOptions createDefaultRunOptions(String userName, String repoName) {
    RunOptions defaultRunOptions = new RunOptions();
    defaultRunOptions.setUserName(userName);
    defaultRunOptions.setRepoName(repoName);
    return defaultRunOptions;
  }

  public void prepareDirectory() throws IOException {

    Files.createDirectories(baseRepoPath);
    Files.createDirectories(baseZipPath);
    Files.createDirectories(baseJsonPath);
  }

  public void createTree() {
    try {
      repoTree = Tree.buildTree(repoPath);
    } catch (IOException e) {
      System.err.println("Failed to create tree, program will be terminated");
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public void runDownload() {
    new RepoDownloader().downloadRepo(zipPath, userName, repoName);
  }

  public void runUnzip() {
    try {
      new Unzip().unzip(zipPath, repoPath);
    } catch (IOException e) {
      System.err.println("Failed to unzip repo");
      e.printStackTrace();
    }

  }

  public void runJsonProcess(FileNode root) {
    try {
      new JsonProcessor().exportTreeToJson(jsonPath, root);
    } catch (IOException e) {
      System.err.println("Failed to export Tree to Json");
      e.printStackTrace();
    }
  }

  public void showTree() {
    TreePrinter treePrinter = new TreePrinter(repoTree);
    treePrinter.showTree();
  }

  public void runProcessNodesInOrder() throws IOException {
    RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
    repoSorter.processNodesInOrder();
  }

  public void runProcessNodesSortedByMostUsedLanguage() {
    RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
    repoSorter.processNodesSortedByMostUsedLanguage();
  }

  public void runProcessNodesSortedByUsedLanguage() {
    RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
    repoSorter.processNodesSortedByUsedLanguage();
  }

  // orchestrator
  public void runApp() {

    if (options.getMode() == Mode.USER) {
      MultithreadingReposHandle multiReposHandle = new MultithreadingReposHandle(options);
      multiReposHandle.runAppAsync();
      return;
    }

    if (options.getMode() == Mode.TEST) {
      // do something
      options.setUserName("sonle1501");
      options.setRepoName("github-loc");
    }

    try {
      setupRepoInfo();
      prepareDirectory();

      switch (options.getAction()) {
        case DOWNLOAD -> runDownload();
        case UNZIP -> {
          runDownload();
          runUnzip();
        }
        case TREE -> {
          runDownload();
          runUnzip();
          createTree();
          showTree();
        }
        case JSON -> {
          runDownload();
          runUnzip();
          createTree();
          runJsonProcess(repoTree.getRoot());
        }
        case SORT -> {
          runDownload();
          runUnzip();
          if (options.getSortArgument() == SortArgument.BYLANG)
            runProcessNodesSortedByUsedLanguage();
          else if (options.getSortArgument() == SortArgument.BYMOSTLANG)
            runProcessNodesSortedByMostUsedLanguage();
          else
            runProcessNodesInOrder();
        }
        case DEFAULT -> {
          runDownload();
          runUnzip();
          createTree();
          runJsonProcess(repoTree.getRoot());
          showTree();
        }
        default -> throw new IllegalArgumentException("Invalid action");
      }
    } catch (Exception e) {
      System.err.println("Failed to run program");
      e.printStackTrace();
    }
  }
}
