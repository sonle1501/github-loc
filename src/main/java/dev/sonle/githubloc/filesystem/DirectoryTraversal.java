package dev.sonle.githubloc.filesystem;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import dev.sonle.githubloc.loc.LocProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;

import org.cthing.locc4j.FileCounter;


public class DirectoryTraversal {
  private FileCounter fileCounter;
  public DirectoryTraversal(){
    fileCounter = new FileCounter();
  }

  public Tree traverse(Path path, Tree tree) throws IOException {
    Path startPath = path;
    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) {
        FileNode node = new FileNode(filePath.toString(), filePath.getFileName().toString(), null);
        LocProcessor locProcessor;
        try {
          locProcessor = new LocProcessor(filePath, fileCounter);
          LocProcessor.FileInfo fileInfo = locProcessor.getFileInfo();
          node.setLoc(fileInfo.loc());
          node.setComments(fileInfo.comments());
          node.setBlanks(fileInfo.blanks());
          node.setLanguageSet(fileInfo.languageSet());
          node.setLocByLang(fileInfo.locByLang());
        } catch (IOException e) { // skip this file if there are errors while creating LocProcessor with
          System.out.println("Error occurs while counting LOC on file: " + filePath);
        }

        String parentPath = filePath.getParent().toString();
        FileNode parentNode = tree.getNodeFromContainer(parentPath);
        if (parentNode != null){
          node.setParent(parentNode);
          parentNode.addChild(node);
        }
        tree.addNodeToContainer(node);

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
