package dev.sonle.githubloc.tree;

import dev.sonle.githubloc.filesystem.DirectoryBuilder;
import dev.sonle.githubloc.filesystem.DirectoryTraversal;
import dev.sonle.githubloc.filesystem.ProducerConsumerDirectoryTraversal;
import dev.sonle.githubloc.loc.DirectoryLocProcessor;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TreeBuilderTest {

    @Test
    void testBuildTree() throws IOException {
        Path startPath = Path.of("/test/dir");

        try (MockedConstruction<ProducerConsumerDirectoryTraversal> mockedTraversal = mockConstruction(ProducerConsumerDirectoryTraversal.class, (mock, context) -> {
                doAnswer(invocation -> {
                    Tree treeArg = invocation.getArgument(1);
                    FileNode node = new FileNode(startPath.toString());
                    treeArg.addNodeToContainer(node);
                    return null;
                }).when(mock).traverse(eq(startPath), any(Tree.class));
            });
             MockedConstruction<DirectoryLocProcessor> mockedProcessor = mockConstruction(DirectoryLocProcessor.class)) {

            TreeBuilder builder = new TreeBuilder();
            Tree result = builder.buildTree(startPath);

            assertNotNull(result);
            assertNotNull(result.getRoot());
            assertEquals(startPath.toString(), result.getRoot().getPath());

            assertEquals(1, mockedTraversal.constructed().size());
            assertEquals(1, mockedProcessor.constructed().size());
            
            ProducerConsumerDirectoryTraversal traversal = mockedTraversal.constructed().get(0);
            DirectoryLocProcessor processor = mockedProcessor.constructed().get(0);

            verify(traversal, times(1)).traverse(eq(startPath), any(Tree.class));
            verify(processor, times(1)).countLocFolder(result.getRoot());
        }
    }

    @Test
    void testBuildTreeSequential() throws IOException {
        Path startPath = Path.of("/test/seq");

        try (MockedConstruction<DirectoryTraversal> mockedTraversal = mockConstruction(DirectoryTraversal.class, (mock, context) -> {
                doAnswer(invocation -> {
                    Tree treeArg = invocation.getArgument(1);
                    FileNode node = new FileNode(startPath.toString());
                    treeArg.addNodeToContainer(node);
                    return null;
                }).when(mock).traverse(eq(startPath), any(Tree.class));
            });
             MockedConstruction<DirectoryLocProcessor> mockedProcessor = mockConstruction(DirectoryLocProcessor.class)) {

            TreeBuilder builder = new TreeBuilder();
            Tree result = builder.buildTreeSequential(startPath);

            assertNotNull(result);
            assertNotNull(result.getRoot());
            assertEquals(startPath.toString(), result.getRoot().getPath());

            assertEquals(1, mockedTraversal.constructed().size());
            assertEquals(1, mockedProcessor.constructed().size());
            
            DirectoryTraversal traversal = mockedTraversal.constructed().get(0);
            DirectoryLocProcessor processor = mockedProcessor.constructed().get(0);

            verify(traversal, times(1)).traverse(eq(startPath), any(Tree.class));
            verify(processor, times(1)).countLocFolder(result.getRoot());
        }
    }

    @Test
    void testBuildTreeWithBatchProcessing() throws IOException {
        Path startPath = Path.of("/test/batch");

        try (MockedConstruction<DirectoryBuilder> mockedBuilder = mockConstruction(DirectoryBuilder.class, (mock, context) -> {
                doAnswer(invocation -> {
                    Tree treeArg = invocation.getArgument(1);
                    FileNode node = new FileNode(startPath.toString());
                    treeArg.addNodeToContainer(node);
                    return null;
                }).when(mock).traverse(eq(startPath), any(Tree.class));
            });
             MockedConstruction<DirectoryLocProcessor> mockedProcessor = mockConstruction(DirectoryLocProcessor.class)) {

            TreeBuilder builder = new TreeBuilder();
            Tree result = builder.buildTreeWithBatchProcessing(startPath);

            assertNotNull(result);
            assertNotNull(result.getRoot());
            assertEquals(startPath.toString(), result.getRoot().getPath());

            assertEquals(1, mockedBuilder.constructed().size());
            assertEquals(1, mockedProcessor.constructed().size());
            
            DirectoryBuilder dirBuilder = mockedBuilder.constructed().get(0);
            DirectoryLocProcessor processor = mockedProcessor.constructed().get(0);

            verify(dirBuilder, times(1)).traverse(eq(startPath), any(Tree.class));
            verify(processor, times(1)).processLocOnFileList(result.getFileList());
            verify(processor, times(1)).countLocFolder(result.getRoot());
        }
    }
}
