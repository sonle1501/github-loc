package dev.sonle.githubloc.output;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import tools.jackson.databind.ObjectMapper;

public class JsonProcessor {

  public void exportTreeToJson(Tree tree, String userName, String repoName, long repoSize, Path jsonTarget)
      throws IOException {
    RepoReport repoReport = new RepoReport(tree, userName, repoName, repoSize).createRepoReport();
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget.toString()), repoReport);  // read tree dir recursively and write to target file
  }

  public void exportOrderedListToJson(Path jsonTarget, List<FileNode> list) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget.toString()), list);
  }

  public void exportNodeListSortedByLangToJson(Path jsonTarget, Map<String, List<FileNode>> nodeList){
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget.toString()), nodeList);
  }
  public static void main(String[] args) {
    try {
      JsonProcessor processor = new JsonProcessor();
      Tree tree = new Tree(); // empty tree for test
      FileNode root = new FileNode("storage\\repos\\github-loc", "root", null);
      tree.setRoot(root);
      processor.exportTreeToJson(tree, "testUser", "testRepo", 1024, Path.of("storage/json-results/test.json"));
      System.out.println("Exported test JSON successfully");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
