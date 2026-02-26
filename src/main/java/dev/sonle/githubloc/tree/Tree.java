package dev.sonle.githubloc.tree;

import java.io.IOException;
import java.nio.file.Path;

import java.util.LinkedHashMap;
import java.util.Map;

import dev.sonle.githubloc.util.DirectoryTraversal;


public class Tree {
  private Map<String, FileNode> nodeContainer;
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
  }

  public static Tree buildTree(Path startPath) throws IOException {
    Tree tree = new Tree();
    DirectoryTraversal directoryTraversal = new DirectoryTraversal();
    directoryTraversal.traverse(startPath, tree);
    tree.setRoot(tree.getNode(startPath));
    directoryTraversal.countLocFolder(tree.getRoot());
    // Tree.countLocFolder(tree.getRoot());
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
