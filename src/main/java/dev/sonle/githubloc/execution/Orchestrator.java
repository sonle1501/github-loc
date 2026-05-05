package dev.sonle.githubloc.execution;

import dev.sonle.githubloc.execution.RunConfig.Mode;
import dev.sonle.githubloc.execution.RunConfig.SortArgument;
import dev.sonle.githubloc.multirepos.MultithreadingReposHandle;
import dev.sonle.githubloc.tree.Tree;
import java.io.IOException;
import java.nio.file.Files;
import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Orchestrator {
    private RunConfig config;
    private RunConfig.BasePath base;
    private RunConfig.StoragePath storagePath;
    private Tree repoTree;
    private TaskRunner taskRunner;

    public Orchestrator(RunConfig config) { // the only run constructor
        this.config = config;
        repoTree = null;
        taskRunner = new TaskRunner();
    }

    public Orchestrator(String userName, String repoName) {
        this(RunConfig.createDefaultRunConfig(userName, repoName));
    }

    public Orchestrator(String repoInfo) {
        this(RunConfig.createDefaultRunConfig(repoInfo.split("/")[1], repoInfo.split("/")[0]));
    }

    public void prepareDirectory() {
        this.base = RunConfig.BasePath.defaultDir();
        this.storagePath = RunConfig.StoragePath.from(config.getRepoName(), base);
        try {
            Files.createDirectories(base.baseRepoPath());
            Files.createDirectories(base.baseZipPath());
            Files.createDirectories(base.baseJsonPath());
        } catch (IOException e) {
            throw new GithubLocException(ErrorCode.FILE_PROCESSING_ERROR, "Failed to create directories", e);
        }
    }

    public void runDownloadTask() {
        long downloaded = taskRunner.runDownload(storagePath.zipPath(), config.getUserName(), config.getRepoName());
        config.setRepoSize(downloaded);
    }

    public void runUnzipTask() {
        long unzippedSize = taskRunner.runUnzip(storagePath.zipPath(), storagePath.repoPath(), config.getRepoName());
        config.setRepoSize(unzippedSize);
    }

    public void runCreateTreeTask() {
        repoTree = taskRunner.createTree(storagePath.repoPath(), config.getRepoName());
    }

    public void runShowTreeTask() {
        taskRunner.showTree(repoTree);
    }

    public void runJsonExportTask() {
        taskRunner.runJsonProcess(
                repoTree, config.getUserName(), config.getRepoName(), config.getRepoSize(), storagePath.jsonPath());
    }

    public void runProcessNodesSortedByUsedLanguageTask() {
        taskRunner.runProcessNodesSortedByUsedLanguage(storagePath.repoPath(), config.getRepoName());
    }

    public void runProcessNodesSortedByMostUsedLanguageTask() {
        taskRunner.runProcessNodesSortedByMostUsedLanguage(storagePath.repoPath(), config.getRepoName());
    }

    public void runProcessNodesInOrderTask() {
        taskRunner.runProcessNodesInOrder(storagePath.repoPath(), config.getRepoName());
    }

    // orchestrator
    public void runApp() {

        if (config.getMode() == Mode.USER) {
            MultithreadingReposHandle multiReposHandle = new MultithreadingReposHandle(config);
            multiReposHandle.runAppAsync();
            return;
        }

        if (config.getMode() == Mode.LOCAL) {
            LocalRunner localRunner = new LocalRunner(config);
            localRunner.runLocal();
            return;
        }

        if (config.getMode() == Mode.DEFAULT) {
            config.setUserName("sonle1501");
            config.setRepoName("github-loc");
        }

        prepareDirectory();

        switch (config.getAction()) {
            case DOWNLOAD -> runDownloadTask();
            case UNZIP -> {
                runDownloadTask();
                runUnzipTask();
            }
            case TREE -> {
                runDownloadTask();
                runUnzipTask();
                runCreateTreeTask();
                runShowTreeTask();
            }
            case JSON -> {
                runDownloadTask();
                runUnzipTask();
                runCreateTreeTask();
                runJsonExportTask();
            }
            case SORT -> {
                runDownloadTask();
                runUnzipTask();
                if (config.getSortArgument() == SortArgument.BYLANG) runProcessNodesSortedByUsedLanguageTask();
                else if (config.getSortArgument() == SortArgument.BYMOSTLANG)
                    runProcessNodesSortedByMostUsedLanguageTask();
                else runProcessNodesInOrderTask();
            }
            case DEFAULT -> {
                runDownloadTask();
                runUnzipTask();
                runCreateTreeTask();
                runJsonExportTask();
                runShowTreeTask();
            }
            default -> throw new GithubLocException(ErrorCode.INVALID_INPUT, "Invalid action");
        }
    }

    public static void main(String[] args) {
        try {
            Orchestrator runner = new Orchestrator("sonle1501", "github-loc");
            log.info("Starting Runner for test repo sonle1501/github-loc...");
            runner.runApp();
        } catch (GithubLocException e) {
            log.error("Error [Code {}]: {}", e.getErrorCode().getExitCode(), e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error", e);
        }
    }
}
