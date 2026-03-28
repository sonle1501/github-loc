package dev.sonle.githubloc.tree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Tree {
  private Map<String, FileNode> nodeContainer;
  List<FileNode> fileList;
  private FileNode root;

  public Map<String, FileNode> getNodeContainer() {
    return nodeContainer;
  }

  public FileNode getNodeFromContainer(String path) {
    return nodeContainer.get(path);
  }

  public void addNodeToContainer(FileNode node) {
    nodeContainer.put(node.getPath(), node);
  }

  public List<FileNode> getFileList() {
    return fileList;
  }

  public void addFileToFileList(FileNode node) {
    fileList.add(node);
  }

  public FileNode getRoot() {
    return root;
  }

  public void setRoot(FileNode root) {
    this.root = root;
  }

  public FileNode getNode(Path path) {
    String standardPath = path.toString();

    if (nodeContainer.containsKey(standardPath))
      return nodeContainer.get(standardPath);
    else
      return null;
  }

  public Tree() {
    nodeContainer = new LinkedHashMap<>();
    fileList = new ArrayList<>();
  }
}
