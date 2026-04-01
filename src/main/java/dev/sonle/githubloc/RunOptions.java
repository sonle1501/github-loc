package dev.sonle.githubloc;

import java.util.Scanner;

public class RunOptions {

  public enum Mode {
    USER,
    REPO,
    LOCAL,
    DEFAULT
  }

  public enum Action {
    SORT, // show and export file list in order, rank by LOC
    TREE, // only show tree dir
    JSON, // only export Json
    DOWNLOAD, // only download
    UNZIP, // download + unzip
    DEFAULT, // show and export tree dir
  }

  public enum SortArgument {
    ALL, // sort all nodes
    BYLANG, // group by used language and sort
    BYMOSTLANG// sort by most used Language
  }

  private String userName;
  private String repoName;
  private Action action = Action.DEFAULT; // default action : if no specific action
  private Mode mode = Mode.REPO; // default mode : if no cmd argument
  private SortArgument sortArgument = SortArgument.ALL;

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

  public Mode getMode() {
    return mode;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public void setSortArgument(SortArgument sortArgument) {
    this.sortArgument = sortArgument;
  }

  public SortArgument getSortArgument() {
    return this.sortArgument;
  }

  public static String[] parseConsoleInput() {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your command (for example: sonle1501/github-loc) :");
    String input = in.nextLine();
    String[] args = input.split(" ");
    // in.close();
    return args;
  }

  // valid github repo identity : spring-projects/spring-boot
  private static RunOptions parseHelper(String args[]) {
    RunOptions options = new RunOptions();

    if (args.length == 0) {
      options.setMode(Mode.DEFAULT);
      return options;
    }

    if (args.length >= 2 && "LOCAL".equalsIgnoreCase(args[0])) {
      setLocalMode(args, options);
      return options;
    }

    String firstArg = args[0];
    String[] parts = firstArg.split("/");

    if (parts.length == 1 && parts[0].strip() != "") {
      options.setUserName(parts[0]);
      options.setMode(Mode.USER);
      return options;
    }

    if (parts.length == 2 && !parts[0].strip().isEmpty() && !parts[1].strip().isEmpty()) {
      options.setUserName(parts[0]);
      options.setRepoName(parts[1]);
      return options;
    }

    else {
      throw new IllegalArgumentException("Invalid repo format. Expected: user/repo");
    }
  }

  private static void setLocalMode(String args[], RunOptions options) {
    options.setMode(Mode.LOCAL);
    options.setRepoName(args[1]);

    if (args.length == 2) {
      options.setAction(Action.DEFAULT);
      return;
    }
    else {
      int actionIndex = 2;
      parseActionHelper(actionIndex,args,options);
    }
  }

  // only use with sort action
  private static void setSortArgumentsHelper(String args[], int i, RunOptions options) {
    if (i + 2 >= args.length)
      options.setSortArgument(SortArgument.ALL);
    else if ("BYLANG".equalsIgnoreCase(args[i + 2])) {
      options.setSortArgument(SortArgument.BYLANG);
    } else if ("BYMOSTLANG".equalsIgnoreCase(args[i + 2])) {
      options.setSortArgument(SortArgument.BYMOSTLANG);
    } else
      options.setSortArgument(SortArgument.ALL);
  }

  private static void parseActionHelper(int actionIndex, String args[], RunOptions options) {
    String arg = args[actionIndex];
    if (("--action".equalsIgnoreCase(arg) || "-a".equalsIgnoreCase(arg)) && (actionIndex + 1 < args.length)) {
      String actionType = args[actionIndex + 1];
      if ("SORT".equalsIgnoreCase(actionType)) {
        setSortArgumentsHelper(args, actionIndex, options);
      }
      try {
        options.setAction(Action.valueOf(actionType.toUpperCase()));
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Invalid action");
      }
    } else {
      throw new IllegalArgumentException("invalid arguments");
    }
  }

  private static void validateArgument(RunOptions options){
    if (options.getMode() == Mode.USER && options.getUserName() == null)
      throw new IllegalArgumentException("User is not specified.");

    else if (options.getMode() == Mode.REPO && (options.getUserName() == null || options.getRepoName() == null))
      throw new IllegalArgumentException("Repository is not specified.");
  }

  public static RunOptions parse(String[] args) {
    RunOptions options = parseHelper(args);
    if (options.getMode() == Mode.DEFAULT || options.getMode() == Mode.USER || options.getMode() == Mode.LOCAL) {
      return options;
    }

    if (args.length == 1) {
      options.setMode(Mode.REPO);
      options.setAction(Action.DEFAULT);
      return options;
    }

    int actionIndex = 1;
    parseActionHelper(actionIndex, args, options);
    validateArgument(options);

    return options;
  }
}