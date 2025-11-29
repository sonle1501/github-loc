package dev.sonle.githubloc.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;

public class DirectoryTranversal {
  public static Tree tranverse(String path) throws IOException {
    Tree tree = new Tree();
    Path startPath = Paths.get(path);

    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) {
            FileNode node = new FileNode(filePath.toString(), filePath.getFileName().toString(), null);
            Map<String, String> fileInfo = LocProcessor.getInfo(filePath); // get LOC and language
            node.info.put("loc", fileInfo.get("loc"));            // put LOC info to node
            node.info.put("lang", fileInfo.get("lang"));
            String parentPath = filePath.getParent().toString();

            if (tree.nodeContainer.containsKey(parentPath)) {             
              node.parent = tree.nodeContainer.get(parentPath);
              tree.nodeContainer.get(parentPath).childs.add(node); // add child node to its parent
            }

            tree.nodeContainer.put(filePath.toString(), node); // add node to tree
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            FileNode node = new FileNode(dir.toString(), dir.getFileName().toString(), null);
            String parentPath = dir.getParent().toString();

            if (tree.nodeContainer.containsKey(parentPath)) {
              node.parent = tree.nodeContainer.get(parentPath);
              tree.nodeContainer.get(parentPath).childs.add(node);
            }
            tree.nodeContainer.put(dir.toString(), node);

            return FileVisitResult.CONTINUE;
          }
        });

    return tree;
  }

  public static void main(String[] args) {
    try {
      // String path = "src/main/resources/repos/locc4j";
      String path = ".";
      Tree tree = DirectoryTranversal.tranverse(path);
      tree.showTree();
      // Map <String, String> map = new HashMap<>();
    } catch (Exception e) {
      System.err.println("tranvesre failed: " + e.getMessage());
    }
  }
}
