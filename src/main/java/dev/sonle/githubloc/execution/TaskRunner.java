package dev.sonle.githubloc.execution;

import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.filesystem.Unzip;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.output.TreePrinter;
import dev.sonle.githubloc.sort.RepoSorter;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;

@Slf4j
public class TaskRunner {
    public Tree createTree(Path repoPath, String repoName) {
        try {
            return new TreeBuilder().buildTreeWithBatchProcessing(repoPath);
        } catch (IOException e) {
            log.error("Failed to create the tree of: {} repo, the program had to stop", repoName);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public long runDownload(Path zipPath, String userName, String repoName) {
        return new RepoDownloader().downloadRepo(zipPath, userName, repoName);
    }

    public long runUnzip(Path zipPath, Path repoPath, String repoName) {
        try {
            Unzip unzipHandler = new Unzip();
            return unzipHandler.unzip(zipPath, repoPath);
        } catch (IOException e) {
            log.error("Failed to unzip: {} repo", repoName);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void runJsonProcess(Tree repoTree, String userName, String repoName, long repoSize, Path jsonPath) {
        try {
            JsonProcessor jsonProcessor = new JsonProcessor();
            jsonProcessor.exportTreeToJson(repoTree, userName, repoName, repoSize, jsonPath);
        } catch (IOException e) {
            log.error("Failed to export the json results of: {} repo", repoName);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void showTree(Tree repoTree) {
        TreePrinter treePrinter = new TreePrinter(repoTree);
        treePrinter.showTree();
    }

    public void runProcessNodesInOrder(Path repoPath, String repoName) {
        RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
        repoSorter.processNodesInOrder();
    }

    public void runProcessNodesSortedByMostUsedLanguage(Path repoPath, String repoName) {
        RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
        repoSorter.processNodesSortedByMostUsedLanguage();
    }

    public void runProcessNodesSortedByUsedLanguage(Path repoPath, String repoName) {
        RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
        repoSorter.processNodesSortedByUsedLanguage();
    }
}
