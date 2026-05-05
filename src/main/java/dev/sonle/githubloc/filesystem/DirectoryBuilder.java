package dev.sonle.githubloc.filesystem;

import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;

public class DirectoryBuilder {

    public Tree traverse(Path path, Tree tree) {
        Path startPath = path;
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
                tree.addFileToFileList(node);

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

                return FileVisitResult.CONTINUE;
            }
        });
        } catch (IOException e) {
            throw new GithubLocException(ErrorCode.REPO_TREE_CREATION_FAILED, "Failed to build directory tree for path: " + path, e);
        }

        return tree;
    }

    // count LOC for folder
    public void countLocFolder(FileNode rootNode) {
        for (FileNode node : rootNode.getChilds()) {
            if (node.getChilds().size() > 0) { // is folder
                countLocFolder(node);
                rootNode.updateLoc(node.getLoc());
                rootNode.updateComments(node.getComments());
                rootNode.updateBlanks(node.getBlanks());
                rootNode.mergeLanguageSet(node.getLanguageSet());
                rootNode.mergeLocByLang(node.getLocByLang());
            } else { // is file or emtpy folder
                rootNode.updateLoc(node.getLoc());
                rootNode.updateComments(node.getComments());
                rootNode.updateBlanks(node.getBlanks());
                rootNode.mergeLanguageSet(node.getLanguageSet());
                rootNode.mergeLocByLang(node.getLocByLang());
            }
        }
    }

    public static void main(String[] args) {
        try {
            DirectoryBuilder builder = new DirectoryBuilder();
            Tree tree = builder.traverse(Paths.get("storage\\repos\\github-loc"), new Tree());
            System.out.println("Traversed successfully, found nodes: \n" + tree.getNodeContainer());
        } catch (Exception e) {
            System.err.println("traverse failed: " + e.getMessage());
        }
    }
}
