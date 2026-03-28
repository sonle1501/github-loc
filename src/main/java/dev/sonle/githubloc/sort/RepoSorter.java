package dev.sonle.githubloc.sort;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.filesystem.DirectoryTraversal;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.output.TreePrinter;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;

public class RepoSorter {
  private Path repoPath;
  private String repoName;

  public RepoSorter(Path path) {
    repoPath = path;
    repoName = null;
  }

  public RepoSorter(Path path, String name) {
    repoPath = path;
    repoName = name;
  }

  public void processNodesSortedByMostUsedLanguage() {
    try {
      Tree tree = Tree.buildTree(repoPath);
      FilesSorter filesSorter = new FilesSorter();
      JsonProcessor jsonProcessor = new JsonProcessor();
      List<FileNode> orderedNodes = filesSorter.sortNodeSameLanguage(tree.getNodeContainer(),
          tree.getMostUsedLanguage());
      String name = repoName == null ? tree.getRoot().getName() : repoName;
      String orderedListJsonFile = "storage/json-results/" + "ordered-list-in-same-lang-" + name
          + ".json";
      jsonProcessor.exportOrderedListToJson(Paths.get(orderedListJsonFile), orderedNodes);
      TreePrinter.printNodesFromList(orderedNodes);
    } catch (IOException e) {
      System.err.println("Failed to rank node by most used language. Reason: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void processNodesSortedByUsedLanguage() {
    try {
      Tree tree = Tree.buildTree(repoPath);
      FilesSorter filesSorter = new FilesSorter();
      JsonProcessor jsonProcessor = new JsonProcessor();
      Map<String, List<FileNode>> nodeListSortedByLang = filesSorter.sortNodeByLang(tree.getNodeContainer(),
          tree.getRoot());
      String name = repoName == null ? tree.getRoot().getName() : repoName;
      String orderedListJsonFile = "storage/json-results/" + "ordered-list-by-lang-" + name + ".json";
      jsonProcessor.exportNodeListSortedByLangToJson(Paths.get(orderedListJsonFile), nodeListSortedByLang);
      TreePrinter.printNodesFromMap(nodeListSortedByLang);
    } catch (IOException e) {
      System.err.println("Failed to rank node by used language. Reason: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void processNodesInOrder() {
    try {
      DirectoryTraversal directoryTraversal = new DirectoryTraversal();
      FilesSorter filesSorter = new FilesSorter();
      JsonProcessor jsonProcessor = new JsonProcessor();
      Tree tree = directoryTraversal.traverse(repoPath, new Tree());
      List<FileNode> orderedNodes = filesSorter.sortNodeContainerByLoc(tree.getNodeContainer());
      String name = repoName == null ? tree.getRoot().getName() : repoName;
      String orderedListJsonFile = "storage/json-results/" + "ordered-list-" + name + ".json";
      jsonProcessor.exportOrderedListToJson(Paths.get(orderedListJsonFile), orderedNodes);
      TreePrinter.printNodesFromList(orderedNodes);
    } catch (IOException e) {
      System.err.println("Failed to process nodes in order. Reason: " + e.getMessage());
      e.printStackTrace();
    }
  }
}