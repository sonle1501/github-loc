package dev.sonle.githubloc;

public class App {
  public static void main(String[] args) {
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
