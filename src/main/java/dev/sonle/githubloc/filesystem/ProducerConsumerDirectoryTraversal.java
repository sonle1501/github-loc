package dev.sonle.githubloc.filesystem;

import dev.sonle.githubloc.loc.LocProcessor;
import dev.sonle.githubloc.locc4j.FileCounter;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;

public class ProducerConsumerDirectoryTraversal {

    public Tree traverse(Path path, Tree tree) { // the "producer"
        Path startPath = path;
        FileCounter fileCounter = new FileCounter();
        LocProcessor locProcessor = new LocProcessor();
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores * 4);

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) {
                FileNode node =
                        new FileNode(filePath.toString(), filePath.getFileName().toString(), null);
                String parentPath = filePath.getParent().toString();
                FileNode parentNode = tree.getNodeFromContainer(parentPath);
                if (parentNode != null) {
                    node.setParent(parentNode);
                    parentNode.addChild(node);
                }
                tree.addNodeToContainer(node);

                executor.submit(() -> {
                    try {
                        LocProcessor.FileInfo fileInfo = locProcessor.processFileInfo(filePath, fileCounter);

                        node.setLoc(fileInfo.loc());
                        node.setComments(fileInfo.comments());
                        node.setBlanks(fileInfo.blanks());
                        node.setLanguageSet(fileInfo.languageSet());
                        node.setLocByLang(fileInfo.locByLang());
                    } catch (GithubLocException e) {
                        System.err.println("Error occurs while counting LOC on file: " + filePath);
                    }
                });

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                FileNode node = new FileNode(dir.toString(), dir.getFileName().toString(), null);
                String parentPath = dir.getParent().toString();

                FileNode parentNode = tree.getNodeFromContainer(parentPath);
                if (parentNode != null) {
                    node.setParent(parentNode);
                    parentNode.addChild(node);
                }
                tree.addNodeToContainer(node);
                tree.addFileToFileList(node);

                return FileVisitResult.CONTINUE;
            }
            });
        } catch (IOException e) {
            throw new GithubLocException(ErrorCode.REPO_TREE_CREATION_FAILED, "Failed to traverse directory: " + path, e);
        }

        // 4. Wait for all Consumer threads to finish before returning the fully populated tree
        executor.shutdown();
        try {
            // Block main thread until all files are processed (timeout after 1 hour as a safety net)
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new GithubLocException(ErrorCode.INTERRUPTED, "Traversal was interrupted", e);
        }

        return tree;
    }

    public void countLocFolderMultithreading(FileNode rootNode) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        countLocFolderMultithreadingHelper(rootNode, executor);
        executor.shutdown();
    }

    public void countLocFolderMultithreadingHelper(FileNode rootNode, ExecutorService executor) {

        for (FileNode node : rootNode.getChilds()) {
            if (node.getChilds().size() > 0) { // "folder" need to count LOC
                countLocFolderMultithreadingHelper(node, executor);
                executor.submit(() -> {
                    rootNode.updateLoc(node.getLoc());
                    rootNode.updateComments(node.getComments());
                    rootNode.updateBlanks(node.getBlanks());
                    rootNode.mergeLanguageSet(node.getLanguageSet());
                    rootNode.mergeLocByLang(node.getLocByLang());
                });
            } else { // file or emtpy folder
                executor.submit(() -> {
                    rootNode.updateLoc(node.getLoc());
                    rootNode.updateComments(node.getComments());
                    rootNode.updateBlanks(node.getBlanks());
                    rootNode.mergeLanguageSet(node.getLanguageSet());
                    rootNode.mergeLocByLang(node.getLocByLang());
                });
            }
        }
    }

    public static void main(String[] args) {
        try {
            ProducerConsumerDirectoryTraversal traversal = new ProducerConsumerDirectoryTraversal();
            Tree tree = traversal.traverse(Paths.get("storage\\repos\\github-loc"), new Tree());
            System.out.println("Traversed successfully, network nodes: \n" + tree.getNodeContainer());
        } catch (Exception e) {
            System.err.println("traverse failed: " + e.getMessage());
        }
    }
}
