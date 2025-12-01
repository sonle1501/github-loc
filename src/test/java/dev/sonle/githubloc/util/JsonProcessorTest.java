package dev.sonle.githubloc.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import dev.sonle.githubloc.tree.FileNode;

public class JsonProcessorTest {

    @TempDir
    Path tempDir;

    @Test
    void testExportTreeToJson() throws IOException {
        FileNode root = new FileNode("root", "root", null);
        root.locInfo.put("loc", 100);
        root.languageInfo.put("lang", Arrays.asList("Java", "Python", "C++"));

        FileNode child = new FileNode("root/child", "child", root);
        child.locInfo.put("loc", 60);
        child.languageInfo.put("lang", Arrays.asList("Java", "Python", "C++"));
        root.childs.add(child);

        Path jsonFile = tempDir.resolve("output.json");
        
        JsonProcessor.exportTreeToJson("dummy", jsonFile.toString(), root);

        File file = jsonFile.toFile();
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
}
