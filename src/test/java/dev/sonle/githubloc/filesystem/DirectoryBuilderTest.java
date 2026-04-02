package dev.sonle.githubloc.filesystem;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryBuilderTest {

    private DirectoryBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new DirectoryBuilder();
    }

    @Test
    void testTraverse(@TempDir Path tempDir) throws IOException {
        Path subDir = tempDir.resolve("src");
        Files.createDirectory(subDir);
        
        Path file1 = subDir.resolve("Main.java");
        Files.writeString(file1, "public class Main {}");
        
        Path file2 = tempDir.resolve("README.md");
        Files.writeString(file2, "# Readme");

        Tree tree = new Tree();
        Tree result = builder.traverse(tempDir, tree);

        assertNotNull(result);

        FileNode rootNode = result.getNodeFromContainer(tempDir.toString());
        assertNotNull(rootNode);
        assertEquals(tempDir.getFileName().toString(), rootNode.getName());

        FileNode srcNode = result.getNodeFromContainer(subDir.toString());
        assertNotNull(srcNode);
        assertEquals(rootNode, srcNode.getParent());

        FileNode mainJavaNode = result.getNodeFromContainer(file1.toString());
        assertNotNull(mainJavaNode);
        assertEquals(srcNode, mainJavaNode.getParent());

        // Check file list size (should contain the 2 files)
        assertEquals(2, result.getFileList().size());
    }

    @Test
    void testCountLocFolder() {
        FileNode root = new FileNode("/project", "project", null);
        FileNode file = new FileNode("/project/Main.java", "Main.java", root);

        file.setLoc(100);
        file.setComments(10);
        file.setBlanks(5);
        
        Set<String> langSet = new LinkedHashSet<>();
        langSet.add("Java");
        file.setLanguageSet(langSet);
        
        Map<String, Integer> locByLang = new HashMap<>();
        locByLang.put("Java", 100);
        file.setLocByLang(locByLang);

        root.addChild(file);

        builder.countLocFolder(root);

        assertEquals(100, root.getLoc());
        assertEquals(10, root.getComments());
        assertEquals(5, root.getBlanks());
        assertTrue(root.getLanguageSet().contains("Java"));
    }
}
