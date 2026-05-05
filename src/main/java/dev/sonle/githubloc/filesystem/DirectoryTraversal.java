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
import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;

public class DirectoryTraversal {

    public Tree traverse(Path path, Tree tree) {
        Path startPath = path;
        FileCounter fileCounter = new FileCounter();
        LocProcessor locProcessor = new LocProcessor();

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) {
                FileNode node =
                        new FileNode(filePath.toString(), filePath.getFileName().toString(), null);
                try {
                    LocProcessor.FileInfo fileInfo = locProcessor.processFileInfo(filePath, fileCounter);
                    node.setLoc(fileInfo.loc());
                    node.setComments(fileInfo.comments());
                    node.setBlanks(fileInfo.blanks());
                    node.setLanguageSet(fileInfo.languageSet());
                    node.setLocByLang(fileInfo.locByLang());
                } catch (GithubLocException e) { // skip this file if there are errors while creating LocProcessor with
                    System.out.println("Error occurs while counting LOC on file: " + filePath);
                }

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
            throw new GithubLocException(ErrorCode.REPO_TREE_CREATION_FAILED, "Failed to traverse directory: " + path, e);
        }

        return tree;
    }

    public static void main(String[] args) {
        try {
            DirectoryTraversal traversal = new DirectoryTraversal();
            Tree tree = traversal.traverse(Paths.get("storage\\repos\\github-loc"), new Tree());
            System.out.println(
                    "Directory traversal successful, root contains files/folders: \n" + tree.getNodeContainer());
        } catch (Exception e) {
            System.err.println("traverse failed: " + e.getMessage());
        }
    }
}
