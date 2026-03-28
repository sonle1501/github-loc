package dev.sonle.githubloc.tree;

import java.io.IOException;
import java.nio.file.Path;

import dev.sonle.githubloc.filesystem.DirectoryBuilder;
import dev.sonle.githubloc.filesystem.DirectoryTraversal;
import dev.sonle.githubloc.filesystem.ProducerConsumerDirectoryTraversal;
import dev.sonle.githubloc.loc.DirectoryLocProcessor;

public class TreeBuilder {
  public Tree buildTree(Path startPath) throws IOException {
    Tree tree = new Tree();
    ProducerConsumerDirectoryTraversal directoryTraversal = new ProducerConsumerDirectoryTraversal();
    DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
    directoryTraversal.traverse(startPath, tree);
    tree.setRoot(tree.getNode(startPath));
    directoryLocProcessor.countLocFolder(tree.getRoot());
    return tree;
  }

  public Tree buildTreeSequential(Path startPath) throws IOException {
    Tree tree = new Tree();
    DirectoryTraversal directoryTraversal = new DirectoryTraversal();
    DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
    directoryTraversal.traverse(startPath, tree);
    tree.setRoot(tree.getNode(startPath));
    directoryLocProcessor.countLocFolder(tree.getRoot());
    return tree;
  }

  public Tree buildTreeWithBatchProcessing(Path startPath) throws IOException {
    Tree tree = new Tree();
    DirectoryBuilder directoryBuilder = new DirectoryBuilder();
    DirectoryLocProcessor directoryLocProcessor = new DirectoryLocProcessor();
    directoryBuilder.traverse(startPath, tree);
    tree.setRoot(tree.getNode(startPath));
    directoryLocProcessor.processLocOnFileList(tree.getFileList());
    directoryLocProcessor.countLocFolder(tree.getRoot());
    return tree;
  }
}
