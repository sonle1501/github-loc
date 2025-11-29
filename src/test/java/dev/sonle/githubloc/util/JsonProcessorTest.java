package dev.sonle.githubloc.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import dev.sonle.githubloc.tree.FileNode;

public class JsonProcessorTest {

    @TempDir
    Path tempDir;

    @Test
    void testExportJson() throws IOException {
        FileNode root = new FileNode("root", "root", null);
        root.info.put("loc", "100");
        root.info.put("lang", "[Java]");

        FileNode child = new FileNode("root/child", "child", root);
        child.info.put("loc", "50");
        child.info.put("lang", "[Java]");
        root.childs.add(child);

        Path jsonFile = tempDir.resolve("output.json");
        
        JsonProcessor.exportJson("dummy", jsonFile.toString(), root);

        File file = jsonFile.toFile();
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
}
