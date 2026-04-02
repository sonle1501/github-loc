package dev.sonle.githubloc.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree tree;

    @BeforeEach
    void setUp() {
        tree = new Tree();
    }

    @Test
    void testNodeContainerOperations() {
        FileNode node1 = new FileNode("/a/b/c");
        FileNode node2 = new FileNode("/a/b/d");

        tree.addNodeToContainer(node1);
        tree.addNodeToContainer(node2);

        assertEquals(2, tree.getNodeContainer().size());
        assertEquals(node1, tree.getNodeFromContainer("/a/b/c"));
        assertEquals(node2, tree.getNodeFromContainer("/a/b/d"));
    }

    @Test
    void testGetNodeByPath() {
        Path path = Path.of("/my/test/path");
        FileNode node = new FileNode(path.toString());
        tree.addNodeToContainer(node);

        assertEquals(node, tree.getNode(path));

        Path nonExistent = Path.of("/non/existent");
        assertNull(tree.getNode(nonExistent));
    }

    @Test
    void testFileListOperations() {
        FileNode fileNode = new FileNode("/root/file.txt");
        tree.addFileToFileList(fileNode);

        assertEquals(1, tree.getFileList().size());
        assertEquals(fileNode, tree.getFileList().get(0));
    }

    @Test
    void testRootOperations() {
        FileNode root = new FileNode("/root");
        tree.setRoot(root);

        assertEquals(root, tree.getRoot());
    }
}
