package dev.sonle.githubloc;

import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreePrinter;
import dev.sonle.githubloc.util.DirectoryTraversal;
import dev.sonle.githubloc.util.FilesSorter;
import dev.sonle.githubloc.util.JsonProcessor;
import dev.sonle.githubloc.util.Unzip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Runner {
  private String repoName;
  private String userName;
  private final Path baseRepoPath = Paths.get("storage", "repos");
  private final Path baseZipPath = Paths.get("storage", "zip-repos");
  private final Path baseJsonPath = Paths.get("storage", "json-results");

  private final Path repoPath;
  private final Path zipPath;
  private final Path jsonPath;

  private RunOptions options;
  private Tree repoTree;

  public Runner(RunOptions options) { // the only run constructor
    this.options = options;
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

  public static RunOptions createDefaultRunOptions(String userName, String repoName){
    RunOptions defaultRunOptions = new RunOptions();
    defaultRunOptions.setUserName(userName);
    defaultRunOptions.setRepoName(repoName);
    return defaultRunOptions;
  }

  public void preparePath() throws IOException {

    Files.createDirectories(baseRepoPath);
    Files.createDirectories(baseZipPath);
    Files.createDirectories(baseJsonPath);
  }

  public void createTree(){
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

  public void showTree(){
    TreePrinter treePrinter = new TreePrinter(repoTree);
    treePrinter.showTree();
  }

  public void processNodesInOrder() throws IOException {
    try {
      DirectoryTraversal directoryTraversal = new DirectoryTraversal();
      FilesSorter filesSorter = new FilesSorter();
      JsonProcessor jsonProcessor = new JsonProcessor();
      Tree tree = directoryTraversal.traverse(repoPath, new Tree());
      List <FileNode> orderedNodes = filesSorter.sortNodeContainerByLoc(tree.getNodeContainer());
      String orderedListJsonFile = "work/json-results/" + "ordered-list-" + repoName + ".json"; 
      jsonProcessor.exportOrderedListToJson(Paths.get(orderedListJsonFile), orderedNodes);
      TreePrinter.printNodesFromList(orderedNodes);
    } catch (IOException e) {
      System.err.println("Failed to process nodes in order. Reason: " + e.getMessage());    
      e.printStackTrace();
    }
  }

  public void processNodesWithMostUsedLanguageNodesInOrder() throws IOException {
    try {
      Tree tree = Tree.buildTree(repoPath);
      FilesSorter filesSorter = new FilesSorter();
      JsonProcessor jsonProcessor = new JsonProcessor();
      List <FileNode> orderedNodes = filesSorter.sortNodeSameLanguage(tree.getNodeContainer(), tree.getMostUsedLanguage());
      String orderedListJsonFile = "work/json-results/" + "ordered-list-in-same-lang-" + repoName + ".json"; 
      jsonProcessor.exportOrderedListToJson(Paths.get(orderedListJsonFile), orderedNodes);
      TreePrinter.printNodesFromList(orderedNodes);
    } catch (IOException e) {
      System.err.println("Failed to rank node by most used language. Reason: " + e.getMessage());    
      e.printStackTrace();
    }
  }

  // orchestrator
  public void runApp() {
    try {
      preparePath();

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
          // processNodesInOrder();
          processNodesWithMostUsedLanguageNodesInOrder();
        }
        case ALL -> {
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

  public void showTree2() throws IOException {
    // not available
  }
}
