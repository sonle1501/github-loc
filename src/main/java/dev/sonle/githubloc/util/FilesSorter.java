package dev.sonle.githubloc.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.tree.FileNode;

public class FilesSorter {
    public static List<FileNode> sortNodeContainerByLoc(Map<String, FileNode> nodeContainer){
    List<FileNode> listNode = new ArrayList<>(nodeContainer.values());
    listNode = filterFilesOnly(listNode);
    Collections.sort(listNode, new Comparator<FileNode>() {
            @Override
            public int compare(FileNode node1, FileNode node2) {
                return Integer.compare(node2.locInfo.get("loc"), node1.locInfo.get("loc")); // reversed order
            }
        });
    return listNode;
  }

  private static List<FileNode> filterFilesOnly(List<FileNode> nodes) {
    List<FileNode> filtered = new ArrayList<>();
    for (FileNode node : nodes) {
      if (node.childs == null || node.childs.isEmpty()) {
        filtered.add(node);
      }
    }
    return filtered;
  }
}
