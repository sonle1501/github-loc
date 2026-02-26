package dev.sonle.githubloc.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.tree.FileNode;

public class FilesSorter {
  public List<FileNode> sortNodeContainerByLoc(Map<String, FileNode> nodeContainer) {
    List<FileNode> listNode = new ArrayList<>(nodeContainer.values());
    listNode = filterFiles(listNode);
    Collections.sort(listNode, new Comparator<FileNode>() {
      @Override
      public int compare(FileNode node1, FileNode node2) {
        return Integer.compare(node2.getLoc(), node1.getLoc()); // reversed order
      }
    });
    return listNode;
  }

  private List<FileNode> filterFiles(List<FileNode> nodes) {
    List<FileNode> filtered = new ArrayList<>();
    for (FileNode node : nodes) {
      if (node.getChilds() == null || node.getChilds().isEmpty()) {
        filtered.add(node);
      }
    }
    return filtered;
  }
  private List<FileNode> filterFilesByLanguage(List<FileNode> nodes, String lang) {
    List<FileNode> filtered = new ArrayList<>();
    for (FileNode node : nodes) {
      if ((node.getChilds() == null || node.getChilds().isEmpty()) && node.getLocByLang().containsKey(lang)){
        filtered.add(node);
      }
    }
    return filtered;
  }

  public List<FileNode> sortNodeSameLanguage(Map<String, FileNode> nodeContainer, String lang) {
    List<FileNode> listNode = new ArrayList<>(nodeContainer.values());
    listNode = filterFilesByLanguage(listNode, lang);
    Collections.sort(listNode, new Comparator<FileNode>() {
      @Override
      public int compare(FileNode node1, FileNode node2) {
        return Integer.compare(node2.getLoc(), node1.getLoc()); // reversed order, default is sort desc
      }
    });
    return listNode;
  }
}
