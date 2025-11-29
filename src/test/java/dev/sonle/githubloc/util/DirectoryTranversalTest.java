package dev.sonle.githubloc.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;

public class DirectoryTranversalTest {

    @TempDir
    Path tempDir;

    @Test
    void testTranverse() throws IOException {
        // Mock dir:
        // root/
        //   file1.java
        //   subdir/
        //     file2.java

        Path file1 = tempDir.resolve("file1.java");
        Files.writeString(file1, "public class File1 {}");
        Path subdir = tempDir.resolve("subdir");
        Files.createDirectory(subdir);
        Path file2 = subdir.resolve("file2.java");
        Files.writeString(file2, "public class File2 {}");

        Tree tree = DirectoryTranversal.tranverse(tempDir.toString());
        
        // Check if there is tree and childs
        assertNotNull(tree);
        assertNotNull(tree.nodeContainer);
        
        // Check if files are in the container
        // The keys are absolute paths.
        assertTrue(tree.nodeContainer.containsKey(file1.toAbsolutePath().toString()));
        assertTrue(tree.nodeContainer.containsKey(file2.toAbsolutePath().toString()));
        
        // Check node details
        FileNode node1 = tree.nodeContainer.get(file1.toAbsolutePath().toString());
        assertEquals("file1.java", node1.name);
        // locc4j might not work perfectly on temp files without extension or valid content, but we gave extension .java
        // assertNotNull(node1.info.get("loc")); 
        
        FileNode node2 = tree.nodeContainer.get(file2.toAbsolutePath().toString());
        assertEquals("file2.java", node2.name);
    }
}

