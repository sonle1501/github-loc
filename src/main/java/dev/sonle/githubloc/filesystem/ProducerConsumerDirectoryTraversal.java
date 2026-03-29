package dev.sonle.githubloc.filesystem;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import dev.sonle.githubloc.loc.LocProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;

import dev.sonle.githubloc.locc4j.FileCounter;


public class ProducerConsumerDirectoryTraversal {
  private FileCounter fileCounter;

  public ProducerConsumerDirectoryTraversal(){
    fileCounter = new FileCounter();
  }

  public Tree traverse(Path path, Tree tree) throws IOException { // the "producer"
    Path startPath = path;
    int cores = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newFixedThreadPool(cores*4);

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

        executor.submit(() -> {
          try {
            LocProcessor locProcessor = new LocProcessor(filePath, fileCounter);
            LocProcessor.FileInfo fileInfo = locProcessor.getFileInfo();
            
            node.setLoc(fileInfo.loc());
            node.setComments(fileInfo.comments());
            node.setBlanks(fileInfo.blanks());
            node.setLanguageSet(fileInfo.languageSet());
            node.setLocByLang(fileInfo.locByLang());
          } catch (IOException e) {
            System.err.println("Error occurs while counting LOC on file: " + filePath);
          }
        });

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
        tree.addFileToFileList(node);

        return FileVisitResult.CONTINUE;
      }
    });

    // 4. Wait for all Consumer threads to finish before returning the fully populated tree
    executor.shutdown();
    try {
      // Block main thread until all files are processed (timeout after 1 hour as a safety net)
      if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
        executor.shutdownNow();
      }
    } catch (InterruptedException e) {
      executor.shutdownNow();
      Thread.currentThread().interrupt();
      System.err.println("Traversal was interrupted.");
    }

    return tree;
  }

  public void countLocFolderMultithreading(FileNode rootNode){
    int cores = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newFixedThreadPool(cores);
    countLocFolderMultithreadingHelper(rootNode, executor);
    executor.shutdown();
  }

  public void countLocFolderMultithreadingHelper(FileNode rootNode, ExecutorService executor) {
    
    for (FileNode node : rootNode.getChilds()) {
      if (node.getChilds().size() > 0) { // "folder" need to count LOC
        countLocFolderMultithreadingHelper(node, executor);
        executor.submit(() -> {
          rootNode.updateLoc(node.getLoc());
          rootNode.updateComments(node.getComments());
          rootNode.updateBlanks(node.getBlanks());
          rootNode.mergeLanguageSet(node.getLanguageSet());
          rootNode.mergeLocByLang(node.getLocByLang());
        });
      } else { // file or emtpy folder
        executor.submit(() -> {
          rootNode.updateLoc(node.getLoc());
          rootNode.updateComments(node.getComments());
          rootNode.updateBlanks(node.getBlanks());
          rootNode.mergeLanguageSet(node.getLanguageSet());
          rootNode.mergeLocByLang(node.getLocByLang());
        });
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
