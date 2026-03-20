package dev.sonle.githubloc.multirepos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dev.sonle.githubloc.RunOptions;

public class MultiReposHandle {

  private final String userName;
  private final RunOptions options;

  private final Path userBasePath;
  private final Path reposPath;
  private final Path zipReposPath;
  private final Path jsonResultsPath;

  public MultiReposHandle(RunOptions options) {
    this.options = options;
    this.userName = options.getUserName();

    this.userBasePath = Paths.get("storage", "user-repos", userName);
    this.reposPath = userBasePath.resolve("repos");
    this.zipReposPath = userBasePath.resolve("zip-repos");
    this.jsonResultsPath = userBasePath.resolve("json-results");
  }

  public void preparePaths() throws IOException {
    Files.createDirectories(reposPath);
    Files.createDirectories(zipReposPath);
    Files.createDirectories(jsonResultsPath);
  }

  public void runApp() {
    try {
      preparePaths();
      
      List<String> downloadedRepoNames = runDownload();
          
      List<Path> validZipPaths = validatePaths(downloadedRepoNames, zipReposPath, ".zip");
      runUnzip(validZipPaths);
          
      List<Path> validRepoPaths = validatePaths(downloadedRepoNames, reposPath, "");
      runMultiJsonProcess(validRepoPaths);

    } catch (Exception e) {
      System.err.println("Failed to run multi-repo program for user: " + userName);
      e.printStackTrace();
    }
  }

  private List<Path> validatePaths(List<String> repoNames, Path baseDir, String suffix) {
    List<Path> validPaths = new ArrayList<>();
    
    for (String name : repoNames) {
        Path targetPath = baseDir.resolve(name + suffix);
        if (Files.exists(targetPath)) {
            validPaths.add(targetPath);
        } else {
            System.err.println("Warning: Expected path does not exist and will be skipped: " + targetPath);
        }
    }
    
    return validPaths;
  }

  private List<String> runDownload() {
    System.out.println("Starting download...");
    return null;
  }

  private void runUnzip(List<Path> validZipPaths) {
    if (validZipPaths.isEmpty()) return;
    System.out.println("Starting unzip for " + validZipPaths.size() + " valid zip files...");
  }

  private void runMultiJsonProcess(List<Path> validRepoPaths) {
    if (validRepoPaths.isEmpty()) return;
    // System.out.println("Starting JSON processing & Tree building for " + validRepoPaths.size() + " extracted repos...");
  }
}