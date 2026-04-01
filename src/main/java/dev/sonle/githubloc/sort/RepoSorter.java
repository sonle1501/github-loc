package dev.sonle.githubloc.sort;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.filesystem.DirectoryTraversal;
import dev.sonle.githubloc.loc.DirectoryLocProcessor;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.output.TreePrinter;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;

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
      Tree tree = new TreeBuilder().buildTree(repoPath);
      FilesSorter filesSorter = new FilesSorter();
      JsonProcessor jsonProcessor = new JsonProcessor();
      String mostUsedLanguage = new DirectoryLocProcessor().getMostUsedLanguage(tree.getRoot());
      List<FileNode> orderedNodes = filesSorter.sortNodeSameLanguage(tree.getNodeContainer(), mostUsedLanguage);
      String name = repoName == null ? tree.getRoot().getName() : repoName;
      String orderedListJsonFile = "storage/json-results/" + "ordered-list-in-same-lang-" + name
          + ".json";
      jsonProcessor.exportOrderedListToJson(Paths.get(orderedListJsonFile), orderedNodes);
      System.out.println("Successfully exported the ordered list by most used language of the " + name + " repo at: " + orderedListJsonFile);
      TreePrinter.printNodesFromList(orderedNodes);
    } catch (IOException e) {
      System.err.println("Failed to rank nodes by most used language. Reason: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void processNodesSortedByUsedLanguage() {
    try {
      Tree tree = new TreeBuilder().buildTree(repoPath);
      FilesSorter filesSorter = new FilesSorter();
      JsonProcessor jsonProcessor = new JsonProcessor();
      Map<String, List<FileNode>> nodeListSortedByLang = filesSorter.sortNodeByLang(tree.getNodeContainer(),
          tree.getRoot());
      String name = repoName == null ? tree.getRoot().getName() : repoName;
      String orderedListJsonFile = "storage/json-results/" + "ordered-list-by-lang-" + name + ".json";
      jsonProcessor.exportNodeListSortedByLangToJson(Paths.get(orderedListJsonFile), nodeListSortedByLang);
      System.out.println("Successfully exported the ordered list group by used language of the " + name + " repo at: " + orderedListJsonFile);
      TreePrinter.printNodesFromMap(nodeListSortedByLang);
    } catch (IOException e) {
      System.err.println("Failed to rank nodes by used language. Reason: " + e.getMessage());
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
      System.out.println("Successfully exported the tree diretory of " + repoName + "at: " + orderedListJsonFile);
      TreePrinter.printNodesFromList(orderedNodes);
    } catch (IOException e) {
      System.err.println("Failed to rank nodes. Reason: " + e.getMessage());
      e.printStackTrace();
    }
  }
}