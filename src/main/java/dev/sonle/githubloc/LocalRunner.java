package dev.sonle.githubloc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dev.sonle.githubloc.RunOptions.SortArgument;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.output.TreePrinter;
import dev.sonle.githubloc.sort.RepoSorter;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;

public class LocalRunner {
    private Path repoPath;
    private Path jsonPath;
    private String repoName;
    private String userName;
    private long repoSize;
    private Tree repoTree;
    private Path baseJsonPath = Paths.get("storage", "json-results");


    public LocalRunner() {
        // Empty constructor as requested
    }

    private void validateRepoPath() {
        Path standardPath = Paths.get("storage", "repos", this.repoName);

        if (Files.exists(standardPath) && Files.isDirectory(standardPath)) {
            this.repoPath = standardPath;
            System.out.println("Local repository found at: " + this.repoPath);
            return;
        }

        Path userRepoPath = Paths.get("storage", "user-repos", this.userName, "repos", this.repoName);
        if (Files.exists(userRepoPath) && Files.isDirectory(userRepoPath)) {
            this.repoPath = userRepoPath;
            System.out.println("Local repository found at: " + this.repoPath);
        } 
        else {
            throw new IllegalStateException( "Error: Local repository not found");
        }
    }

    public void runLocal(RunOptions options) {
        this.repoName = options.getRepoName();
        this.userName = options.getUserName() != null ? options.getUserName() : "local-user";
        this.repoSize = -1; // ignore for local runs

        // Resolve paths
        this.jsonPath = baseJsonPath.resolve(repoName + "-local.json");

        try {
            validateRepoPath();

            // Orchestrator
            switch (options.getAction()) {
                case TREE -> {
                    createTree();
                    showTree();
                }
                case JSON -> {
                    createTree();
                    runJsonProcess();
                }
                case SORT -> {
                    if (options.getSortArgument() == SortArgument.BYLANG)
                        runProcessNodesSortedByUsedLanguage();
                    else if (options.getSortArgument() == SortArgument.BYMOSTLANG)
                        runProcessNodesSortedByMostUsedLanguage();
                    else
                        runProcessNodesInOrder();
                }
                case DEFAULT -> {
                    createTree();
                    runJsonProcess();
                    showTree();
                }
                case DOWNLOAD, UNZIP -> {
                    System.err.println("DOWNLOAD and UNZIP actions are not supported for local repositories.");
                }
                default -> throw new IllegalArgumentException("Invalid action for LocalRunner");
            }
        } catch (Exception e) {
            System.err.println("Failed to run local analysis: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createTree() {
        try {
            this.repoTree = new TreeBuilder().buildTreeWithBatchProcessing(repoPath);
        } catch (IOException e) {
            System.err.println("Failed to create tree, program will be terminated");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void runJsonProcess() {
        try {
            JsonProcessor jsonProcessor = new JsonProcessor();
            jsonProcessor.exportTreeToJson(repoTree, userName, repoName, repoSize, jsonPath);
            System.out.println("JSON report successfully generated at: " + jsonPath);
        } catch (IOException e) {
            System.err.println("Failed to export Tree to Json");
            e.printStackTrace();
        }
    }

    public void showTree() {
        TreePrinter treePrinter = new TreePrinter(repoTree);
        treePrinter.showTree();
    }

    public void runProcessNodesInOrder() throws IOException {
        RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
        repoSorter.processNodesInOrder();
    }

    public void runProcessNodesSortedByMostUsedLanguage() {
        RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
        repoSorter.processNodesSortedByMostUsedLanguage();
    }

    public void runProcessNodesSortedByUsedLanguage() {
        RepoSorter repoSorter = new RepoSorter(repoPath, repoName);
        repoSorter.processNodesSortedByUsedLanguage();
    }

    public static void main(String[] args) {
        try {
            RunOptions options = new RunOptions();
            options.setMode(RunOptions.Mode.LOCAL);
            options.setRepoName("github-loc");
            options.setAction(RunOptions.Action.DEFAULT);
            LocalRunner localRunner = new LocalRunner();
            System.out.println("Starting LocalRunner for test local repo github-loc...");
            localRunner.runLocal(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
