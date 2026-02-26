package dev.sonle.githubloc;

public class RunOptions {

  public enum Action {
    SORT,// download + unzip + show and export file list in order, rank by LOC
    TREE, // download + unzip + only show tree dir
    JSON, // download + unzip + export Json
    DOWNLOAD, // only download
    UNZIP, // download + unzip
    ALL // Default action : download + unzip + show and export tree dir
  }

  private String userName;
  private String repoName;
  private Action action = Action.ALL;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getRepoName() {
    return repoName;
  }

  public void setRepoName(String repoName) {
    this.repoName = repoName;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  // valid github repo identity : spring-projects/spring-boot
  public static void parseRepoHelper(String repoInfo, RunOptions options) { 
    String[] parts = repoInfo.split("/");
    if (parts.length == 2) {
      options.setUserName(parts[0]);
      options.setRepoName(parts[1]);
    } else {
      throw new IllegalArgumentException("Invalid repo format. Expected: user/repo");
    }
  }

  public static RunOptions parse(String[] args) {
    RunOptions options = new RunOptions();
    
    // default repo
    if (args.length == 0) {
      options.setUserName("sonle1501");
      options.setRepoName("github-loc");
      return options;
    }

    parseRepoHelper(args[0], options);

    for (int i = 1; i < args.length; i++) {
      String arg = args[i];

      switch (arg) {
        case "--action":
        case "-a":
          if (i + 1 < args.length) {
            try {
              options.setAction(Action.valueOf(args[++i].toUpperCase()));
            } catch (IllegalArgumentException e) {
              throw new IllegalArgumentException(
                  "Invalid action. Available: TREE, SORT, JSON, DOWNLOAD, UNZIP, ALL");
            }
          }
          break;

        default:
          throw new IllegalArgumentException("invalid arguments");
      }
    }

    if (options.getUserName() == null || options.getRepoName() == null) {
      throw new IllegalArgumentException("Repository is not specified.");
    }

    return options;
  }
}
