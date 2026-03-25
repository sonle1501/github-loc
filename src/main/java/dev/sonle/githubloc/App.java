package dev.sonle.githubloc;

public class App {
  public static void main(String[] args) {
    if (args.length == 0) { // no provided command line
        args = RunOptions.parseConsoleInput(); 

        // args = new String[]{"sonle1501/github-loc", "-a", "sort"};
    }
    try {
      RunOptions options = RunOptions.parse(args); // use cmd args
      Runner r = new Runner(options);
      r.runApp();
    } catch (IllegalArgumentException e) {
      System.err.println("Error: " + e.getMessage());
      System.err.println("Command: java -jar app.jar user/repo [-a action]");
    }
  }
}
