package dev.sonle.githubloc.output;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonProcessorTest {

    private JsonProcessor jsonProcessor;

    @BeforeEach
    void setUp() {
        jsonProcessor = new JsonProcessor();
    }

    @Test
    void testExportTreeToJson(@TempDir Path tempDir) throws IOException {
        Path jsonFile = tempDir.resolve("tree.json");

        Tree tree = new Tree();
        FileNode root = new FileNode("/project", "project", null);
        FileNode child = new FileNode("/project/src", "src", root);
        root.addChild(child);

        tree.setRoot(root);
        tree.addNodeToContainer(root);
        tree.addNodeToContainer(child);
        tree.addFileToFileList(child);

        jsonProcessor.exportTreeToJson(tree, "user", "repo", 1024, jsonFile);

        assertTrue(Files.exists(jsonFile));
        String content = Files.readString(jsonFile);
        assertTrue(content.contains("user"));
        assertTrue(content.contains("repo"));
        assertTrue(content.contains("project"));
    }

    @Test
    void testExportOrderedListToJson(@TempDir Path tempDir) throws IOException {
        Path jsonFile = tempDir.resolve("orderedList.json");

        FileNode node1 = new FileNode("file1.java");
        FileNode node2 = new FileNode("file2.java");
        List<FileNode> list = Arrays.asList(node1, node2);

        jsonProcessor.exportOrderedListToJson(jsonFile, list);

        assertTrue(Files.exists(jsonFile));
        String content = Files.readString(jsonFile);
        assertTrue(content.contains("file1.java"));
        assertTrue(content.contains("file2.java"));
    }

    @Test
    void testExportNodeListSortedByLangToJson(@TempDir Path tempDir) throws Exception {
        Path jsonFile = tempDir.resolve("sortedLang.json");

        FileNode node1 = new FileNode("file1.java");
        FileNode node2 = new FileNode("file2.py");
        
        Map<String, List<FileNode>> map = new HashMap<>();
        map.put("Java", Arrays.asList(node1));
        map.put("Python", Arrays.asList(node2));

        jsonProcessor.exportNodeListSortedByLangToJson(jsonFile, map);

        assertTrue(Files.exists(jsonFile));
        String content = Files.readString(jsonFile);
        assertTrue(content.contains("Java"));
        assertTrue(content.contains("Python"));
        assertTrue(content.contains("file1.java"));
    }
}
