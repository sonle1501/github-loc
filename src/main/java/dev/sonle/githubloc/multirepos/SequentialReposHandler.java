package dev.sonle.githubloc.multirepos;

import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.api.UserInfoFetching;
import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;
import dev.sonle.githubloc.execution.RunConfig;
import dev.sonle.githubloc.filesystem.Unzip;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SequentialReposHandler {

    public record RepoTarget(String repoName, long sizeProcess, Path validPath) {}

    private String userName;
    private RunConfig config;
    private RunConfig.BasePath base;

    public SequentialReposHandler(RunConfig config) {
        this.config = config;
        this.userName = config.getUserName();
        Path userRepoBase = Paths.get("storage", "user-repos", userName);
        this.base = RunConfig.BasePath.customDir(userRepoBase);
    }

    public void preparePaths() {
        try {
            Files.createDirectories(base.baseRepoPath());
            Files.createDirectories(base.baseZipPath());
            Files.createDirectories(base.baseJsonPath());
        } catch (IOException e) {
            throw new GithubLocException(ErrorCode.FILE_PROCESSING_ERROR, "Failed to create storage directories", e);
        }
    }

    public List<String> fetchRepoNames() {
        UserInfoFetching userInfoFetching = new UserInfoFetching();
        return userInfoFetching.fetchRepoNames(userName);
    }

    public void runApp() {
        preparePaths();

        List<String> repoNames = fetchRepoNames();

        for (String repoName : repoNames) {
            try {
                RepoTarget downloadedRepo = runSingleDownload(repoName);
                RepoTarget unzippedRepo = runSingleUnzip(downloadedRepo);
                runSingleJsonProcess(unzippedRepo);
            } catch (Exception e) {
                Throwable cause = e.getCause() != null ? e.getCause() : e;
                log.error("Failed processing pipeline for '{}': {}", repoName, cause.getMessage());
            }
        }
    }

    private RepoTarget runSingleDownload(String repoName) {
        RepoDownloader repoDownloader = new RepoDownloader();
        Path downloadPath = base.baseZipPath().resolve(repoName + ".zip");
        long downloadedSize = repoDownloader.downloadRepo(downloadPath, userName, repoName);
        return new RepoTarget(repoName, downloadedSize, downloadPath);
    }

    private RepoTarget runSingleUnzip(RepoTarget repoInfo) {
        Unzip unzipRepo = new Unzip();
        Path sourceZipRepoPath = repoInfo.validPath();
        Path destRepoPath = base.baseRepoPath().resolve(repoInfo.repoName());
        long repoSizeOnDisk = unzipRepo.unzip(sourceZipRepoPath, destRepoPath);
        return new RepoTarget(repoInfo.repoName(), repoSizeOnDisk, destRepoPath);
    }

    private void runSingleJsonProcess(RepoTarget repoInfo) {
        Tree repoTree = new TreeBuilder().buildTreeSequential(repoInfo.validPath());
        JsonProcessor jsonProcessor = new JsonProcessor();
        FileNode root = repoTree.getRoot();
        String repoName = root.getName();
        long repoSize = repoInfo.sizeProcess();
        Path jsonTarget = base.baseJsonPath().resolve(repoInfo.repoName() + ".json");
        jsonProcessor.exportTreeToJson(repoTree, userName, repoName, repoSize, jsonTarget);
        log.info("Successfully exported the tree directory of {} at: {}", repoName, jsonTarget.toString());
    }

    public static void main(String[] args) {
        RunConfig options = new RunConfig();
        options.setUserName("sonle1501");
        SequentialReposHandler handle = new SequentialReposHandler(options);
        log.info("Initialized SequentialReposHandler for {}", options.getUserName());
    }
}
