package dev.sonle.githubloc.filesystem;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.locc4j.Counts;
import dev.sonle.githubloc.locc4j.FileCounter;
import dev.sonle.githubloc.locc4j.Language;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedConstruction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ProducerConsumerDirectoryTraversalTest {

    @Test
    void testTraverse(@TempDir Path tempDir) throws IOException {
        Path subDir = tempDir.resolve("src");
        Files.createDirectory(subDir);
        
        Path file1 = subDir.resolve("Main.java");
        Files.writeString(file1, "public class Main {}");
        
        Path file2 = tempDir.resolve("README.md");
        Files.writeString(file2, "# Readme");

        try (MockedConstruction<FileCounter> mockedCounter = mockConstruction(FileCounter.class, (mock, context) -> {
            Language javaLang = mock(Language.class);
            when(javaLang.getDisplayName()).thenReturn("Java");

            Counts mockCounts = mock(Counts.class);
            when(mockCounts.getCodeLines()).thenReturn(10);
            when(mockCounts.getCommentLines()).thenReturn(2);
            when(mockCounts.getBlankLines()).thenReturn(2);
            
            Map<Language, Counts> fileCounts = new HashMap<>();
            fileCounts.put(javaLang, mockCounts);

            Map<Path, Map<Language, Counts>> result = new HashMap<>();
            result.put(file1, fileCounts);
            result.put(file2, fileCounts);

            lenient().when(mock.count(anyString())).thenReturn(result);
        })) {

            ProducerConsumerDirectoryTraversal traversal = new ProducerConsumerDirectoryTraversal();
            Tree tree = new Tree();
            Tree result = traversal.traverse(tempDir, tree);

            assertNotNull(result);

            FileNode rootNode = result.getNodeFromContainer(tempDir.toString());
            assertNotNull(rootNode);

            FileNode mainJavaNode = result.getNodeFromContainer(file1.toString());
            assertNotNull(mainJavaNode);
            
            // Wait for threads to finish implicitly handled by awaitTermination in the class
            assertEquals(10, mainJavaNode.getLoc());
            assertEquals(2, mainJavaNode.getComments());
            assertTrue(mainJavaNode.getLanguageSet().contains("Java"));
        }
    }
}
