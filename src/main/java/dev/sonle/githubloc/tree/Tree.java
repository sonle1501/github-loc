package dev.sonle.githubloc.tree;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.filesystem.DirectoryBuilder;
import dev.sonle.githubloc.filesystem.DirectoryTraversal;
import dev.sonle.githubloc.filesystem.ProducerConsumerDirectoryTraversal;
import dev.sonle.githubloc.loc.DirectoryLocProcessor;


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

  public static Tree buildTree(Path startPath) throws IOException {
    Tree tree = new Tree();
    ProducerConsumerDirectoryTraversal directoryTraversal = new ProducerConsumerDirectoryTraversal();
    DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
    directoryTraversal.traverse(startPath, tree);
    tree.setRoot(tree.getNode(startPath));
    directoryLocProcessor.countLocFolder(tree.getRoot());
    return tree;
  }

  public static Tree buildTreeSequential(Path startPath) throws IOException {
    Tree tree = new Tree();
    DirectoryTraversal directoryTraversal = new DirectoryTraversal();
    DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
    directoryTraversal.traverse(startPath, tree);
    tree.setRoot(tree.getNode(startPath));
    directoryLocProcessor.countLocFolder(tree.getRoot());
    return tree;
  }

  public static Tree buildTreeWithBatchProcessing(Path startPath) throws IOException {
    Tree tree = new Tree();
    DirectoryBuilder directoryBuilder = new DirectoryBuilder();
    DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
    directoryBuilder.traverse(startPath, tree);
    tree.setRoot(tree.getNode(startPath));
    directoryLocProcessor.processLocOnFileList(tree.getFileList());
    directoryLocProcessor.countLocFolder(tree.getRoot());
    return tree;
  }

  public String getMostUsedLanguage(){
    Map<String, Integer>locByLang = root.getLocByLang();
    int maxLoc = -1;
    String lang = null;
    for (Map.Entry<String,Integer> entry: locByLang.entrySet()){
      int currentLoc = entry.getValue();
      if (currentLoc > maxLoc){
        maxLoc = currentLoc;
        lang = entry.getKey();
      }
    }
    return lang;
  }
}
