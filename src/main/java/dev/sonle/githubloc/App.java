package dev.sonle.githubloc;

import dev.sonle.githubloc.output.ConsoleOutput;

public class App {
  public static void main(String[] args) {
    if (args.length == 0) { // no provided command line
      args = RunOptions.parseConsoleInput();

      // args = new String[]{"local", "ghloc", "sort"};
    }
    try {
      System.out.println(ConsoleOutput.getAsciiTitle());
      System.out.println(ConsoleOutput.getSeperator());
      RunOptions options = RunOptions.parse(args); // use cmd args
      Runner r = new Runner(options);
      r.runApp();
      ConsoleOutput.waitForExit();
    } catch (IllegalArgumentException e) {
      System.err.println("\n[!] The application had to stop.");;
      System.err.println("Error: " + e.getMessage());
    }
  }
}
