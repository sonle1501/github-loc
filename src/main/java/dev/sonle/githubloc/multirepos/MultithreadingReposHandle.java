package dev.sonle.githubloc.multirepos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.api.UserInfoFetching;
import dev.sonle.githubloc.execution.RunConfig;
import dev.sonle.githubloc.filesystem.Unzip;
import dev.sonle.githubloc.output.JsonProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import dev.sonle.githubloc.tree.TreeBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultithreadingReposHandle {

  public record RepoTarget(String repoName, long sizeProcess, Path validPath) {
  }

  private String userName;
  private RunConfig config;
  private RunConfig.BasePath base;
  private RunConfig.StoragePath storagePath;

  public MultithreadingReposHandle(RunConfig config) {
    this.config = config;
    this.userName = config.getUserName();
    Path userRepoBase = Paths.get("storage", "user-repos", userName);
    base = RunConfig.BasePath.customDir(userRepoBase);
  }

  public void preparePaths() throws IOException {
    Files.createDirectories(base.baseRepoPath());
    Files.createDirectories(base.baseZipPath());
    Files.createDirectories(base.baseJsonPath());
  }

  public List<String> fetchRepoNames() {
    UserInfoFetching userInfoFetching = new UserInfoFetching();
    List<String> repoNames = userInfoFetching.fetchRepoNames(userName);
    return repoNames;
  }

  public void runAppAsync() {
    try {
      preparePaths();
    } catch (IOException e) {
      log.error("Failed to create necessary storage directories. Reason: {}", e.getMessage());
      return; // Terminate app
    }

    List<String>repoNames = fetchRepoNames();

    ExecutorService ioExecutor = Executors.newCachedThreadPool(); 
    int cores = Runtime.getRuntime().availableProcessors();
    ExecutorService cpuExecutor = Executors.newFixedThreadPool(cores);


    List<CompletableFuture<Void>> futures = repoNames
    .stream()
    .map(repoName->runWorkflowForRepo(repoName, cpuExecutor, ioExecutor)).toList();

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();   
        
    ioExecutor.shutdown();
    cpuExecutor.shutdown();
  }

  private CompletableFuture<Void> runWorkflowForRepo(String repoName, ExecutorService cpuExecutor, ExecutorService ioExecutor) {
    CompletableFuture<Void> workflow = CompletableFuture
        .supplyAsync(() -> runSingleDownload(repoName), ioExecutor) // I/O task, need more threads
        .thenApplyAsync(repoInfo -> runSingileUnzip(repoInfo), ioExecutor) // I/O task, need more threads
        .thenAcceptAsync(repoInfo -> runSingleJsonProcess(repoInfo), cpuExecutor) // calculating task, need stable 
        .exceptionally(ex -> {
          log.error("Failed processing pipeline for '{}': {}", repoName, ex.getMessage());
          return null; // Continue processing
        });
    return workflow;
  }

  private RepoTarget runSingleDownload(String repoName) {
    RepoDownloader repoDownloader = new RepoDownloader();
    Path donwloadPath = base.baseZipPath().resolve(repoName + ".zip");
    long downloadedSize = repoDownloader.downloadRepo(donwloadPath, userName, repoName);
    return new RepoTarget(repoName, downloadedSize, donwloadPath);
  }

  private RepoTarget runSingileUnzip(RepoTarget repoInfo) {
    Unzip unzipRepo = new Unzip();
    try {
      Path sourceZipRepoPath = repoInfo.validPath();
      Path destRepoPath = base.baseRepoPath().resolve(repoInfo.repoName());
      long repoSizeOnDisk = unzipRepo.unzip(sourceZipRepoPath, destRepoPath); 
      return new RepoTarget(repoInfo.repoName(), repoSizeOnDisk, destRepoPath);
    } catch (IOException e) {
      log.error("Failed to unzip repo '{}'. Skipping to next. Reason: {}", repoInfo.repoName(), e.getMessage());
    }
    return null;
  }

  private void runSingleJsonProcess(RepoTarget repoInfo) {
    try {
        Tree repoTree = new TreeBuilder().buildTreeSequential(repoInfo.validPath());
      try {
        JsonProcessor jsonProcessor = new JsonProcessor();
        FileNode root = repoTree.getRoot();
        String repoName = root.getName();
        long repoSize = repoInfo.sizeProcess();
        Path jsonTarget = base.baseJsonPath().resolve(repoInfo.repoName() + ".json");
        jsonProcessor.exportTreeToJson(repoTree, userName, repoName, repoSize, jsonTarget); 
        log.info("Successfully exported the tree diretory of {} at: {}", repoName, jsonTarget.toString());
      } catch (IOException e) {
        log.error("Failed to process JSON for '{}'. Skipping to next. Reason: {}", repoTree.getRoot().getName(), e.getMessage());
      }
    } catch (IOException e) {
      log.error("Failed to process Tree for '{}'. Skipping to next. Reason: {}", repoInfo.repoName(), e.getMessage());
    }
  }

  public static void main(String[] args) {
    RunConfig options = new RunConfig();
    options.setUserName("sonle1501");
    MultithreadingReposHandle handle = new MultithreadingReposHandle(options);
    log.info("Initialized MultithreadingReposHandle for {}", options.getUserName());
  }
}