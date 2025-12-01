package dev.sonle.githubloc.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// annotation for json reader using jackson
@JsonPropertyOrder({"name", "path", "locInfo","languageInfo", "children"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FileNode {
  @JsonIgnore public FileNode parent = null;

  public String name = null;
  public String path = null;
  public Map<String, Integer> locInfo = null;
  public Map<String, List<String>> languageInfo = null;
  public List<FileNode> childs = null;

  public FileNode(String path, String name, FileNode parent) {
    // this.id = UUID.randomUUID().toString();
    this.name = name;
    this.path = path;
    this.parent = parent;

    this.locInfo = new HashMap<>();
    this.locInfo.put("loc", 0);
    this.languageInfo = new HashMap<>();
    this.languageInfo.put("lang", null);
    this.childs = new ArrayList<>();
  }

  public FileNode(String path) {
    this(path, null, null);
  }

  public FileNode() {
    this("./", null, null);
  }

  void show() {
    System.out.println("name: " + this.path);
  }

  public static void main(String[] args) {
    try {
      Tree repoTree = Tree.buildTree("work/repos/Monty_Hall_Simulation");
      repoTree.showTree();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
