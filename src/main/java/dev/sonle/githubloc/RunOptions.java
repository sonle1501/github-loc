package dev.sonle.githubloc;

public class RunOptions {

  public enum Mode{
    USER,
    REPO,
    TEST
  }

  public enum Action {
    SORT,// download + unzip + show and export file list in order, rank by LOC
    TREE, // download + unzip + only show tree dir
    JSON, // download + unzip + export Json
    DOWNLOAD, // only download
    UNZIP, // download + unzip
    ALL, // Default action : download + unzip + show and export tree dir
  }

  private String userName;
  private String repoName;
  private Action action = Action.ALL;
  private Mode mode = Mode.TEST;

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

  public Mode getMode() {
    return mode;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }
  
  // valid github repo identity : spring-projects/spring-boot
  public static RunOptions parseRepoHelper(String args[]) { 
    RunOptions options = new RunOptions();

    if (args.length == 0) {
      options.setUserName("sonle1501");
      options.setRepoName("github-loc");
      options.setMode(Mode.TEST);
      return options;
    }

    String firstArg = args[0];
    String[] parts = firstArg.split("/");

    if (parts.length == 1){
      options.setUserName(parts[0]);
      options.setMode(Mode.USER);
      return options;
    }

    if (parts.length == 2) {
      options.setUserName(parts[0]);
      options.setRepoName(parts[1]);
      return options;
    } 
  
    else {
      throw new IllegalArgumentException("Invalid repo format. Expected: user/repo");
    }
  }

  public static RunOptions parse(String[] args) {
    RunOptions options = parseRepoHelper(args);
    if (options.getMode() == Mode.TEST || options.getMode() == Mode.USER){
      return options;
    }

    for (int i = 1; i < args.length; i++) {
      String arg = args[i];
      if ((arg == "--action" || arg == "-a") && (i +1 < args.length)){
        try {
          options.setAction(Action.valueOf(args[++i].toUpperCase()));
        } 
        catch (IllegalArgumentException e) {
          throw new IllegalArgumentException("Invalid action. Available: TREE, SORT, JSON, DOWNLOAD, UNZIP, ALL, TEST");
        }
      }
      else {
        throw new IllegalArgumentException("invalid arguments");
      }
    }

    if (options.getMode() == Mode.USER && options.getUserName() == null)  
      throw new IllegalArgumentException("User is not specified.");

    else if (options.getMode() == Mode.REPO && (options.getUserName() == null || options.getRepoName() == null))  
      throw new IllegalArgumentException("Repository is not specified.");
    return options;
    }
}