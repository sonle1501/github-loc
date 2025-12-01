package dev.sonle.githubloc;

import dev.sonle.githubloc.RunOptions.Action;
import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.util.JsonProcessor;
import dev.sonle.githubloc.util.Unzip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {
  String REPO_NAME;
  String USER_NAME;
  String REPO_PATH = "work/repos";
  String ZIP_PATH = "work/zip-repos";
  String JSON_PATH = "work/json-results";
  RunOptions options;
  Tree repoTree;

  public Runner(RunOptions options) {
    this.options = options;
    this.USER_NAME = options.getUserName();
    this.REPO_NAME = options.getRepoName();
  }

  public Runner(String userName, String repoName) {
    this.USER_NAME = userName;
    this.REPO_NAME = repoName;
    this.options = new RunOptions();
    this.options.setUserName(userName);
    this.options.setRepoName(repoName);
  }

  public Runner(String repoInfo) {
    this.USER_NAME = repoInfo.split("/")[0];
    this.REPO_NAME = repoInfo.split("/")[1];
    this.options = new RunOptions();
    this.options.setUserName(USER_NAME);
    this.options.setRepoName(REPO_NAME);
  }

  public void preparePath() throws IOException {

    Files.createDirectories(Paths.get(REPO_PATH));
    Files.createDirectories(Paths.get(ZIP_PATH));
    Files.createDirectories(Paths.get(JSON_PATH));

    REPO_PATH = REPO_PATH + "/" + REPO_NAME;
    ZIP_PATH = ZIP_PATH + "/" + REPO_NAME + ".zip";
    JSON_PATH = JSON_PATH + "/" + REPO_NAME + ".json";
  }

  public void createTree() throws IOException {
    repoTree = Tree.buildTree(REPO_PATH);
  }

  public void runDownload() throws IOException {
    RepoDownloader.locate(ZIP_PATH, USER_NAME, REPO_NAME);
  }

  public void runUnzip() throws IOException {
    Unzip.unzip(ZIP_PATH, REPO_PATH);
  }

  public void runJsonProcess(FileNode root) throws IOException {
    JsonProcessor.exportTreeToJson(REPO_PATH, JSON_PATH, root);
  }

  public void showTree() throws IOException {
    repoTree.showTree();
  }

  public void showNodesInOrder() throws IOException{
    Tree.processNodesByOrder(REPO_PATH);
  }

  // orchestrator
  public void runApp() {
    try {
      preparePath();

      if (options.getAction() == RunOptions.Action.DOWNLOAD) {
        runDownload();
        return;
      }

      if (options.getAction() == RunOptions.Action.UNZIP) {
        runDownload();
        runUnzip();
        return;
      }

      if (options.getAction() == RunOptions.Action.TREE) {
        runDownload();
        runUnzip();
        createTree();
        showTree();
        return;
      }

      if (options.getAction() == RunOptions.Action.JSON) {
        runDownload();
        runUnzip();
        createTree();
        runJsonProcess(repoTree.root);
        return;
      }

      if (options.getAction() == RunOptions.Action.SORT) {
        runDownload();
        runUnzip();
        showNodesInOrder();
        return;
      }

      if (options.getAction() == RunOptions.Action.ALL) {
        runDownload();
        runUnzip();
        createTree();
        runJsonProcess(repoTree.root);
        showTree();
        return;
      } else {
        throw new IllegalArgumentException("Invalid action");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void showTree2() throws IOException {
    // not available
  }
}
