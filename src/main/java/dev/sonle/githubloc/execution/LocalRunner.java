package dev.sonle.githubloc.execution;

import dev.sonle.githubloc.execution.RunConfig.SortArgument;
import dev.sonle.githubloc.tree.Tree;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class LocalRunner {
    private RunConfig config;
    private RunConfig.BasePath base;
    private Path repoPath;
    private Path jsonPath;
    private Tree repoTree;
    private TaskRunner taskRunner;

    public LocalRunner(RunConfig config) {
        this.config = config;
        this.base = RunConfig.BasePath.defaultDir();
        this.taskRunner = new TaskRunner();
    }

    private void validateRepoPath() {
        Path standardPath = base.baseRepoPath().resolve(config.getRepoName());

        if (Files.exists(standardPath) && Files.isDirectory(standardPath)) {
            this.repoPath = standardPath;
            System.out.println("Local repository found at: " + this.repoPath);
            return;
        }

        String userName = config.getUserName() != null ? config.getUserName() : "local-user";
        Path userRepoPath = Paths.get("storage", "user-repos", userName, "repos", config.getRepoName());
        if (Files.exists(userRepoPath) && Files.isDirectory(userRepoPath)) {
            this.repoPath = userRepoPath;
            System.out.println("Local repository found at: " + this.repoPath);
        } else {
            throw new IllegalStateException("Error: Local repository not found");
        }
    }

    public void runLocal() {
        if (config.getUserName() == null) {
            config.setUserName("local-user");
        }
        config.setRepoSize(-1); // ignore for local runs

        // Resolve paths
        this.jsonPath = base.baseJsonPath().resolve(config.getRepoName() + "-local.json");

        try {
            validateRepoPath();

            switch (config.getAction()) {
                case TREE -> {
                    runCreateTreeTask();
                    runShowTreeTask();
                }
                case JSON -> {
                    runCreateTreeTask();
                    runJsonExportTask();
                }
                case SORT -> {
                    if (config.getSortArgument() == SortArgument.BYLANG)
                        runProcessNodesSortedByUsedLanguageTask();
                    else if (config.getSortArgument() == SortArgument.BYMOSTLANG)
                        runProcessNodesSortedByMostUsedLanguageTask();
                    else
                        runProcessNodesInOrderTask();
                }
                case DEFAULT -> {
                    runCreateTreeTask();
                    runJsonExportTask();
                    runShowTreeTask();
                }
                case DOWNLOAD, UNZIP -> {
                    log.error("DOWNLOAD and UNZIP actions are not supported for local repositories.");
                }
                default -> throw new IllegalArgumentException("Invalid action for LocalRunner");
            }
        } catch (Exception e) {
            log.error("Failed to run local analysis: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public void runCreateTreeTask() {
        this.repoTree = taskRunner.createTree(repoPath, config.getRepoName());
    }

    public void runJsonExportTask() {
        taskRunner.runJsonProcess(repoTree, config.getUserName(), config.getRepoName(), config.getRepoSize(), jsonPath);
        log.info("JSON report successfully generated at: {}", jsonPath);
    }

    public void runShowTreeTask() {
        taskRunner.showTree(repoTree);
    }

    public void runProcessNodesInOrderTask() {
        taskRunner.runProcessNodesInOrder(repoPath, config.getRepoName());
    }

    public void runProcessNodesSortedByMostUsedLanguageTask() {
        taskRunner.runProcessNodesSortedByMostUsedLanguage(repoPath, config.getRepoName());
    }

    public void runProcessNodesSortedByUsedLanguageTask() {
        taskRunner.runProcessNodesSortedByUsedLanguage(repoPath, config.getRepoName());
    }

    public static void main(String[] args) {
        try {
            RunConfig config = new RunConfig();
            config.setMode(RunConfig.Mode.LOCAL);
            config.setRepoName("github-loc");
            config.setAction(RunConfig.Action.DEFAULT);
            LocalRunner localRunner = new LocalRunner(config);
            log.info("Starting LocalRunner for test local repo github-loc...");
            localRunner.runLocal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
