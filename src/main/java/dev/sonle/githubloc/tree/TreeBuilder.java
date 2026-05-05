package dev.sonle.githubloc.tree;

import dev.sonle.githubloc.filesystem.DirectoryBuilder;
import dev.sonle.githubloc.filesystem.DirectoryTraversal;
import dev.sonle.githubloc.filesystem.ProducerConsumerDirectoryTraversal;
import dev.sonle.githubloc.loc.DirectoryLocProcessor;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TreeBuilder {
    public Tree buildTree(Path startPath) {
        Tree tree = new Tree();
        ProducerConsumerDirectoryTraversal directoryTraversal = new ProducerConsumerDirectoryTraversal();
        DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
        directoryTraversal.traverse(startPath, tree);
        tree.setRoot(tree.getNode(startPath));
        directoryLocProcessor.countLocFolder(tree.getRoot());
        return tree;
    }

    public Tree buildTreeSequential(Path startPath) {
        Tree tree = new Tree();
        DirectoryTraversal directoryTraversal = new DirectoryTraversal();
        DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
        directoryTraversal.traverse(startPath, tree);
        tree.setRoot(tree.getNode(startPath));
        directoryLocProcessor.countLocFolder(tree.getRoot());
        return tree;
    }

    public Tree buildTreeWithBatchProcessing(Path startPath) {
        Tree tree = new Tree();
        DirectoryBuilder directoryBuilder = new DirectoryBuilder();
        DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
        directoryBuilder.traverse(startPath, tree);
        tree.setRoot(tree.getNode(startPath));
        directoryLocProcessor.processLocOnFileList(tree.getFileList());
        directoryLocProcessor.countLocFolder(tree.getRoot());
        return tree;
    }

    public static void main(String[] args) {
        try {
            TreeBuilder builder = new TreeBuilder();
            Tree tree = builder.buildTreeSequential(Paths.get("storage\\repos\\github-loc"));
            log.info(
                    "Tree built successfully, total files: {}",
                    tree.getFileList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
