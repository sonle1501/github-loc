package dev.sonle.githubloc.output;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;

@Slf4j
public class JsonProcessor {

    public void exportTreeToJson(Tree tree, String userName, String repoName, long repoSize, Path jsonTarget) {
        RepoReport repoReport = new RepoReport(tree, userName, repoName, repoSize).createRepoReport();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(
                    new File(jsonTarget.toString()), repoReport); // read tree dir recursively and write to target file
        } catch (JacksonException e) {
            throw new GithubLocException(ErrorCode.JSON_PROCESSING_ERROR, "Failed to export tree to JSON", e);
        }
    }

    public void exportOrderedListToJson(Path jsonTarget, List<FileNode> list) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(jsonTarget.toString()), list);
        } catch (JacksonException e) {
            throw new GithubLocException(ErrorCode.JSON_PROCESSING_ERROR, "Failed to export ordered list to JSON", e);
        }
    }

    public void exportNodeListSortedByLangToJson(Path jsonTarget, Map<String, List<FileNode>> nodeList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(jsonTarget.toString()), nodeList);
        } catch (JacksonException e) {
            throw new GithubLocException(ErrorCode.JSON_PROCESSING_ERROR, "Failed to export node list sorted by language to JSON", e);
        }
    }

    public static void main(String[] args) {
        try {
            JsonProcessor processor = new JsonProcessor();
            Tree tree = new Tree(); // empty tree for test
            FileNode root = new FileNode("storage\\repos\\github-loc", "root", null);
            tree.setRoot(root);
            processor.exportTreeToJson(tree, "testUser", "testRepo", 1024, Path.of("storage/json-results/test.json"));
            log.info("Exported test JSON successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
