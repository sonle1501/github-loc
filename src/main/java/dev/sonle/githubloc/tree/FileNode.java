package dev.sonle.githubloc.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// annotation for json reader using jackson
@JsonPropertyOrder({ "name", "path", "loc", "comments", "blanks", "languageSet", "locByLang", "childs" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FileNode {
  @JsonIgnore
  private FileNode parent = null;
  
  private String name;
  private String path;
  private int loc = 0;
  private int comments = 0;
  private int blanks = 0;
  private Set<String> languageSet;
  private List<FileNode> childs;
  private Map<String, Integer> locByLang;

  public FileNode getParent() {
    return parent;
  }

  public void setParent(FileNode parent) {
    this.parent = parent;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public int getLoc() {
    return loc;
  }

  public void setLoc(int loc) {
    this.loc = loc;
  }

  public void updateLoc(int loc) {
    this.loc = this.loc + loc;
  }

  public void updateComments(int comments) {
    this.comments = this.comments + comments;
  }

  public void updateBlanks(int blanks) {
    this.blanks = this.blanks + blanks;
  }

  public int getComments() {
    return comments;
  }

  public void setComments(int comments) {
    this.comments = comments;
  }

  public int getBlanks() {
    return blanks;
  }

  public void setBlanks(int blanks) {
    this.blanks = blanks;
  }

  public Set<String> getLanguageSet() {
    return languageSet;
  }

  public void setLanguageSet(Set<String> languageSet) {
    this.languageSet = languageSet;
  }

  public boolean mergeLanguageSet(Set<String> setToMerge) {
    if (setToMerge == null || (this.languageSet == null && setToMerge == null))
      return false;
    else if (languageSet == null)
      this.languageSet = setToMerge;
    else {
      this.languageSet.addAll(setToMerge);
    }
    return true;
  }

  public List<FileNode> getChilds() {
    return childs;
  }

  public void setChilds(List<FileNode> childs) {
    this.childs = childs;
  }

  public void addChild(FileNode node) {
    this.childs.add(node);
  }

  public Map<String, Integer> getLocByLang() {
    return locByLang;
  }

  public void setLocByLang(Map<String, Integer> locByLang) {
    this.locByLang = locByLang;
  }

  public void mergeLocByLang(Map<String, Integer> locByLangToMerge){
    if (locByLangToMerge == null)
      return;
    for (Map.Entry<String, Integer> entry : locByLangToMerge.entrySet()){
      String language = entry.getKey();
      int loc = entry.getValue();
      if (locByLang.containsKey(language))
        this.locByLang.merge(language, loc, Integer::sum);
      else
        locByLang.put(language, loc);
    }
  }

  public FileNode(String path, String name, FileNode parent) {
    // this.id = UUID.randomUUID().toString();
    this.name = name;
    this.path = path;
    this.parent = parent;
    this.languageSet = new LinkedHashSet<>();
    this.childs = new ArrayList<>();
    this.locByLang = new HashMap<>();
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
      // Tree repoTree = Tree.buildTree("work/repos/Monty_Hall_Simulation");
      // repoTree.showTree();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
