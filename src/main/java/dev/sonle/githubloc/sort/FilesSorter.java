package dev.sonle.githubloc.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.tree.FileNode;

public class FilesSorter {
  public record LocByLang(String lang, int loc) {
  }

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

  public Map<String, List<FileNode>> sortNodeByLang(Map<String, FileNode> nodeContainer, FileNode root) {
    Map<String, List<FileNode>> nodeListSortedByLang = new LinkedHashMap<>();
    List<FileNode> sortedList = sortNodeContainerByLoc(nodeContainer);
    List<LocByLang> sortedLanguageList = sortLangHelper(root);

    sortedLanguageList.forEach(locByLang -> {
      nodeListSortedByLang.put(locByLang.lang(), new ArrayList<>());
    });

    for (FileNode fileNode : sortedList){
      for (String lang : fileNode.getLanguageSet()){
        List<FileNode> list = nodeListSortedByLang.get(lang);
        if (list != null)
          list.add(fileNode);
      }
    }
    return nodeListSortedByLang;
  }

  private List<LocByLang> sortLangHelper(FileNode root) {
    List<LocByLang> sortedLanguageList = new ArrayList<>();
    Map<String, Integer> locByLang = root.getLocByLang();
    locByLang.forEach((lang, loc) -> {
      sortedLanguageList.add(new LocByLang(lang, loc));
    });

    Collections.sort(sortedLanguageList, new Comparator<LocByLang>() {
      @Override
      public int compare(LocByLang lang1, LocByLang lang2) {
        return Integer.compare(lang2.loc(), lang1.loc()); // reversed order
      }
    });
    return sortedLanguageList;
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
      if ((node.getChilds() == null || node.getChilds().isEmpty()) && node.getLocByLang().containsKey(lang)) {
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
