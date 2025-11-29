package dev.sonle.githubloc;

public class RunOptions {

  public enum Action {
    TREE, // download + unzip + show tree in console
    JSON, // download + unzip + export Json
    DOWNLOAD, // only download
    UNZIP, // download + unzip
    ALL // Default
  }

  public enum SortBy {
    LOC,
    SIZE,
    NAME,
    NONE
  }

  public enum SortOrder {
    ASC,
    DESC
  }

  private String userName;
  private String repoName;
  private Action action = Action.ALL; // function is not avaiable
  private SortBy sortBy = SortBy.NONE; //  function is not avaiable
  private SortOrder sortOrder = SortOrder.ASC; //  function is not avaiable

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

  public SortBy getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortBy sortBy) {
    this.sortBy = sortBy;
  }

  public SortOrder getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(SortOrder sortOrder) {
    this.sortOrder = sortOrder;
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
      options.setRepoName("Monty_Hall_Simulation");
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
                  "Invalid action. Available: TREE, JSON, DOWNLOAD, UNZIP, ALL");
            }
          }
          break;

        // sort feature is not available

        // case "--sort":
        // case "-s":
        //   if (i + 1 < args.length) {
        //     try {
        //       options.setSortBy(SortBy.valueOf(args[++i].toUpperCase()));
        //     } catch (IllegalArgumentException e) {
        //       throw new IllegalArgumentException(
        //           "Invalid sort option. Available: LOC, SIZE, NAME, NONE");
        //     }
        //   }
        //   break;
        // case "--order":
        // case "-o":
        //   if (i + 1 < args.length) {
        //     try {
        //       options.setSortOrder(SortOrder.valueOf(args[++i].toUpperCase()));
        //     } catch (IllegalArgumentException e) {
        //       throw new IllegalArgumentException("Invalid sort order. Available: ASC, DESC");
        //     }
        //   }
        //   break;

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
