package dev.sonle.githubloc.execution;

import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.filesystem.Unzip;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.output.TreePrinter;
import dev.sonle.githubloc.sort.RepoSorter;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;
import java.nio.file.Path;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskRunner {
    public Tree createTree(Path repoPath, String repoName) {
        return new TreeBuilder().buildTreeWithBatchProcessing(repoPath);
    }

    public long runDownload(Path zipPath, String userName, String repoName) {
        return new RepoDownloader().downloadRepo(zipPath, userName, repoName);
    }

    public long runUnzip(Path zipPath, Path repoPath, String repoName) {
        Unzip unzipHandler = new Unzip();
        return unzipHandler.unzip(zipPath, repoPath);
    }

    public void runJsonProcess(Tree repoTree, String userName, String repoName, long repoSize, Path jsonPath) {
        JsonProcessor jsonProcessor = new JsonProcessor();
        jsonProcessor.exportTreeToJson(repoTree, userName, repoName, repoSize, jsonPath);
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
