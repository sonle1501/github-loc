package dev.sonle.githubloc;

import dev.sonle.githubloc.output.ConsoleOutput;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
      log.error("\n[!] The application had to stop.");
      log.error("Error: {}", e.getMessage());
    }
  }
}
