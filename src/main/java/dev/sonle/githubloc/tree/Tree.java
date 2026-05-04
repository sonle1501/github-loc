package dev.sonle.githubloc.tree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tree {
  private Map<String, FileNode> nodeContainer;
  List<FileNode> fileList;
  private FileNode root;

  public FileNode getNodeFromContainer(String path) {
    return nodeContainer.get(path);
  }

  public void addNodeToContainer(FileNode node) {
    nodeContainer.put(node.getPath(), node);
  }

  public void addFileToFileList(FileNode node) {
    fileList.add(node);
  }

  public FileNode getNode(Path path) {
    String standardPath = path.toString();

    if (nodeContainer.containsKey(standardPath))
      return nodeContainer.get(standardPath);
    else
      return null;
  }

  public Tree() {
    nodeContainer = new LinkedHashMap<>();
    fileList = new ArrayList<>();
  }
}
