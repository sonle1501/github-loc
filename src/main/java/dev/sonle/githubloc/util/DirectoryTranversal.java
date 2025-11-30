package dev.sonle.githubloc.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
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
            Map<Path, Map.Entry<Integer, List<String>>> fileInfo = LocProcessor.getInfo(filePath); // get LOC and language
            Map.Entry<Integer, List<String>> fileInfoEntry = fileInfo.get(filePath);
            int loc = fileInfoEntry.getKey();
            List<String> languageList = fileInfoEntry.getValue();

            node.locInfo.put("loc", loc); 
            node.languageInfo.put("lang", languageList); 

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
