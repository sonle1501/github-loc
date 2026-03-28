package dev.sonle.githubloc.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;


public class DirectoryBuilder {
  public DirectoryBuilder(){
  }

  public Tree traverse(Path path, Tree tree) throws IOException {
    Path startPath = path;
    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) {
        FileNode node = new FileNode(filePath.toString(), filePath.getFileName().toString(), null);
        String parentPath = filePath.getParent().toString();
        FileNode parentNode = tree.getNodeFromContainer(parentPath);
        if (parentNode != null){
          node.setParent(parentNode);
          parentNode.addChild(node);
        }
        tree.addNodeToContainer(node);
        tree.addFileToFileList(node);

        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        FileNode node = new FileNode(dir.toString(), dir.getFileName().toString(), null);
        String parentPath = dir.getParent().toString();

        FileNode parentNode = tree.getNodeFromContainer(parentPath);
        if (parentNode != null){
          node.setParent(parentNode);
          parentNode.addChild(node);
        }
        tree.addNodeToContainer(node);


        return FileVisitResult.CONTINUE;
      }
    });

    return tree;
  }

  // count LOC for folder
  public void countLocFolder(FileNode rootNode) {
    for (FileNode node : rootNode.getChilds()) {
      if (node.getChilds().size() > 0) { // is folder
        countLocFolder(node);
        rootNode.updateLoc(node.getLoc());
        rootNode.updateComments(node.getComments());
        rootNode.updateBlanks(node.getBlanks());
        rootNode.mergeLanguageSet(node.getLanguageSet());
        rootNode.mergeLocByLang(node.getLocByLang());
      } else { // is file or emtpy folder
        rootNode.updateLoc(node.getLoc());
        rootNode.updateComments(node.getComments());
        rootNode.updateBlanks(node.getBlanks());
        rootNode.mergeLanguageSet(node.getLanguageSet());
        rootNode.mergeLocByLang(node.getLocByLang());
      }
    }
  }

  public static void main(String[] args) {
    try {
      // String path = "src/main/resources/repos/locc4j";
      String path = ".";
      // Tree tree = DirectoryTranversal.tranverse(path,new Tree());
      // tree.showTree();
      // Map <String, String> map = new HashMap<>();
    } catch (Exception e) {
      System.err.println("tranvesre failed: " + e.getMessage());
    }
  }
}
