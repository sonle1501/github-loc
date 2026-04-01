package dev.sonle.githubloc.sort;

import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.filesystem.DirectoryTraversal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedConstruction;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RepoSorterTest {

    @Test
    void testProcessNodesSortedByMostUsedLanguage(@TempDir Path tempDir) {
        try (MockedConstruction<TreeBuilder> mockedBuilder = mockConstruction(TreeBuilder.class, (mock, context) -> {
                Tree tree = new Tree();
                FileNode root = new FileNode("root");
                root.getLocByLang().put("Java", 100);
                tree.setRoot(root);
                when(mock.buildTree(any())).thenReturn(tree);
            });
             MockedConstruction<FilesSorter> mockedSorter = mockConstruction(FilesSorter.class);
             MockedConstruction<JsonProcessor> mockedJson = mockConstruction(JsonProcessor.class)) {

            RepoSorter sorter = new RepoSorter(tempDir, "testRepo");

            assertDoesNotThrow(sorter::processNodesSortedByMostUsedLanguage);
        }
    }

    @Test
    void testProcessNodesSortedByUsedLanguage(@TempDir Path tempDir) {
        try (MockedConstruction<TreeBuilder> mockedBuilder = mockConstruction(TreeBuilder.class, (mock, context) -> {
                Tree tree = new Tree();
                FileNode root = new FileNode("root");
                tree.setRoot(root);
                when(mock.buildTree(any())).thenReturn(tree);
            });
             MockedConstruction<FilesSorter> mockedSorter = mockConstruction(FilesSorter.class);
             MockedConstruction<JsonProcessor> mockedJson = mockConstruction(JsonProcessor.class)) {

            RepoSorter sorter = new RepoSorter(tempDir, "testRepo");

            assertDoesNotThrow(sorter::processNodesSortedByUsedLanguage);
        }
    }

    @Test
    void testProcessNodesInOrder(@TempDir Path tempDir) {
        try (MockedConstruction<DirectoryTraversal> mockedTraversal = mockConstruction(DirectoryTraversal.class, (mock, context) -> {
                Tree tree = new Tree();
                FileNode root = new FileNode("root");
                tree.setRoot(root);
                when(mock.traverse(any(), any(Tree.class))).thenReturn(tree);
            });
             MockedConstruction<FilesSorter> mockedSorter = mockConstruction(FilesSorter.class);
             MockedConstruction<JsonProcessor> mockedJson = mockConstruction(JsonProcessor.class)) {

            RepoSorter sorter = new RepoSorter(tempDir, "testRepo");

            assertDoesNotThrow(sorter::processNodesInOrder);
        }
    }
}
