package dev.sonle.githubloc;

import dev.sonle.githubloc.execution.CliParser;
import dev.sonle.githubloc.execution.Orchestrator;
import dev.sonle.githubloc.execution.RunConfig;
import dev.sonle.githubloc.output.ConsoleOutput;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
  public static void main(String[] args) {
    if (args.length == 0) { // no provided command line
      args = CliParser.parseConsoleInput();

      // args = new String[]{"local", "ghloc", "sort"};
    }
    try {
      ConsoleOutput.printAscii();
      RunConfig config = CliParser.parse(args);
      Orchestrator orchestrator = new Orchestrator(config);
      orchestrator.runApp();
      ConsoleOutput.waitForExit();
    } catch (IllegalArgumentException e) {
      log.error("\n[!] The application had to stop.");
      log.error("Error: {}", e.getMessage());
    }
  }
}
