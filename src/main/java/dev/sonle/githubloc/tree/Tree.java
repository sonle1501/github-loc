package dev.sonle.githubloc.tree;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.util.DirectoryTranversal;

public class Tree {
  public Map<String, FileNode> nodeContainer;
  public FileNode root;

  public enum Color {
    FOLDER("\u001B[38;2;135;206;235m"), // Sky Blue
    FILE("\u001B[32m"), // Green
    META("\u001B[90m"), // Dark Gray (for info)
    TREE("\u001B[37m"), // White 
    WRAPPER("\u001B[93m"), // Bright yellow
    RESET("\u001B[0m");

    private final String code;

    Color(String code) {
      this.code = code;
    }

    @Override
    public String toString() {
      return code;
    }
  }

  public Tree() {
    nodeContainer = new LinkedHashMap<>();
  }

  public static Tree buildTree(String startPath) throws IOException {
    Tree tree = DirectoryTranversal.tranverse(startPath);
    tree.root = tree.getNode(startPath);
    return tree;
  }

  public void addNode(FileNode node) {
    nodeContainer.put(node.path, node);
  }

  public FileNode getNode(String path) {
    String standardPath = Paths.get(path).toString();
    if (nodeContainer.containsKey(standardPath)) {
      return nodeContainer.get(standardPath);
    }
    return null;
  }

  public void tranversal(FileNode rootNode) {
    for (FileNode node : rootNode.childs) {
      if (this.nodeContainer.containsKey(node.path)) {
        FileNode tempNode = this.nodeContainer.get(node.path);
        tranversal(tempNode);
        tempNode.show();
      }
    }
  }

  public void showTree() {
    // show wrapper
    System.out.println(Color.WRAPPER + "Wrapper folder : " + this.root.name + Color.RESET);

    showTreeHelper(this.root.childs.get(0), true, "");
  }

  private void showTreeHelper(FileNode node, boolean isLast, String prefix) {
  // symbol └── " : "├── │
    String connector = isLast ? "└──" : "├──";

    if (node.childs.size() == 0 || node.childs == null) {
      // show file
      String fileInfo = "";
      fileInfo =
          String.format(
              " %sloc: %s | %s%s",
              Color.META,
              node.locInfo.getOrDefault("loc", 0),
              node.languageInfo.getOrDefault("lang", null),
              Color.RESET);
              
      System.out.println(
          Color.TREE
              + prefix
              + connector
              + Color.RESET
              + Color.FILE
              + node.name
              + Color.RESET
              + fileInfo);
      return;
    }
    // show folder
    System.out.println(
        Color.TREE
            + prefix
            + connector
            + Color.RESET
            + Color.FOLDER
            + node.name
            + "/"
            + Color.RESET);

    List<FileNode> nodeChilds = node.childs;
    for (int i = 0; i < nodeChilds.size(); i++) {
      String indent = isLast ? "     " : "│    ";

      if (i == nodeChilds.size() - 1) {
        showTreeHelper(nodeChilds.get(i), true, prefix + indent);
      } else {
        showTreeHelper(nodeChilds.get(i), false, prefix + indent);
      }
    }
    return;
  }

  public void printAllNodes() {
    for (Map.Entry<String, FileNode> entry : nodeContainer.entrySet()) {
      String name = entry.getValue().name;
      // String loc = entry.getValue().content;
      List<FileNode> childs = entry.getValue().childs;
      List<String> childNames = new ArrayList<>();
      for (FileNode child : childs) {
        childNames.add(child.name);
      }
      if (childNames.size() > 0) {
        System.out.println("folder: " + name);
        System.out.println("childs = " + childNames);
        System.out.println("-------------------------------------");
      } else {
        System.out.println("filename: " + name);
        System.out.println("loc = " + entry.getValue().locInfo.get("loc"));
        System.out.println("language = " + entry.getValue().languageInfo.get("lang"));
        System.out.println("-------------------------------------");
      }
    }
  }

  /*  show Tree (AI generated code)
  public void showTree2() {
      if (root == null) {
          System.out.println("Empty tree");
          return;
      }
      // Print root
      System.out.println("\u001B[1;35m" + (root.name != null ? root.name : ".") + "\u001B[0m");
      printChildren(root, "");
  }

  private void printChildren(FileNode node, String prefix) {
      List<FileNode> children = node.childs;
      List<FileNode> validChildren = new ArrayList<>();

      // Resolve children from the container to ensure we have full data
      if (children != null) {
          for (FileNode child : children) {
              if (nodeContainer.containsKey(child.path)) {
                  validChildren.add(nodeContainer.get(child.path));
              }
          }
      }

      for (int i = 0; i < validChildren.size(); i++) {
          FileNode child = validChildren.get(i);
          boolean isLast = (i == validChildren.size() - 1);

          System.out.print(prefix);
          System.out.print(isLast ? "└── " : "├── ");

          boolean isDir = (child.childs != null && !child.childs.isEmpty());
          // Bold Blue for Directories, Green for Files
          String color = isDir ? "\u001B[1;34m" : "\u001B[32m";
          String reset = "\u001B[0m";

          System.out.print(color + child.name + reset);

          // Print metadata for files
          if (!isDir && child.info != null) {
              String loc = child.info.get("loc");
              String lang = child.info.get("lang");

              if (loc != null || lang != null) {
                   System.out.print(" \u001B[90m"); // Gray color
                   if (loc != null) System.out.print(loc + " loc");
                   if (loc != null && lang != null) System.out.print(" | ");
                   if (lang != null) System.out.print(lang);
                   System.out.print("\u001B[0m");
              }
          }
          System.out.println();

          // Recurse
          printChildren(child, prefix + (isLast ? "    " : "│   "));
      }
  }
  */
}
