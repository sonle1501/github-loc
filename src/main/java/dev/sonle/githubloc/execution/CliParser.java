package dev.sonle.githubloc.execution;

import java.util.Scanner;
import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;

public class CliParser {

    public static String[] parseConsoleInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your command (for example: sonle1501/github-loc) :");
        String input = in.nextLine();
        String[] args = input.split(" ");
        // in.close();
        return args;
    }

    // valid github repo identity : spring-projects/spring-boot
    private static RunConfig parseHelper(String args[]) {
        RunConfig config = new RunConfig();

        if (args.length == 0) {
            config.setMode(RunConfig.Mode.DEFAULT);
            return config;
        }

        if (args.length >= 2 && "LOCAL".equalsIgnoreCase(args[0])) {
            setLocalMode(args, config);
            return config;
        }

        String firstArg = args[0];
        String[] parts = firstArg.split("/");

        if (parts.length == 1 && !parts[0].strip().isEmpty()) {
            config.setUserName(parts[0]);
            config.setMode(RunConfig.Mode.USER);
            return config;
        }

        if (parts.length == 2
                && !parts[0].strip().isEmpty()
                && !parts[1].strip().isEmpty()) {
            config.setUserName(parts[0]);
            config.setRepoName(parts[1]);
            return config;
        } else {
            throw new GithubLocException(ErrorCode.INVALID_INPUT, "Invalid command");
        }
    }

    private static void setLocalMode(String args[], RunConfig config) {
        config.setMode(RunConfig.Mode.LOCAL);
        config.setRepoName(args[1]);

        if (args.length == 2) {
            config.setAction(RunConfig.Action.DEFAULT);
            return;
        } else {
            int actionIndex = 2;
            parseActionHelper(actionIndex, args, config);
        }
    }

    // only use with sort action
    private static void setSortArgumentsHelper(String args[], int i, RunConfig config) {
        if (i + 2 >= args.length) config.setSortArgument(RunConfig.SortArgument.ALL);
        else if ("BYLANG".equalsIgnoreCase(args[i + 2])) {
            config.setSortArgument(RunConfig.SortArgument.BYLANG);
        } else if ("BYMOSTLANG".equalsIgnoreCase(args[i + 2])) {
            config.setSortArgument(RunConfig.SortArgument.BYMOSTLANG);
        } else config.setSortArgument(RunConfig.SortArgument.ALL);
    }

    private static void parseActionHelper(int actionIndex, String args[], RunConfig config) {
        String arg = args[actionIndex];
        if (("--action".equalsIgnoreCase(arg) || "-a".equalsIgnoreCase(arg)) && (actionIndex + 1 < args.length)) {
            String actionType = args[actionIndex + 1];
            if ("SORT".equalsIgnoreCase(actionType)) {
                setSortArgumentsHelper(args, actionIndex, config);
            }
            try {
                config.setAction(RunConfig.Action.valueOf(actionType.toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new GithubLocException(ErrorCode.INVALID_INPUT, "Invalid action in a command");
            }
        } else {
            throw new GithubLocException(ErrorCode.INVALID_INPUT, "Invalid arguments in a command");
        }
    }

    private static void validateArgument(RunConfig config) {
        if (config.getMode() == RunConfig.Mode.USER && config.getUserName() == null)
            throw new GithubLocException(ErrorCode.INVALID_INPUT, "User is not specified.");
        else if (config.getMode() == RunConfig.Mode.REPO
                && (config.getUserName() == null || config.getRepoName() == null))
            throw new GithubLocException(ErrorCode.INVALID_INPUT, "Repository is not specified.");
    }

    public static RunConfig parse(String[] args) {
        RunConfig config = parseHelper(args);
        if (config.getMode() == RunConfig.Mode.DEFAULT
                || config.getMode() == RunConfig.Mode.USER
                || config.getMode() == RunConfig.Mode.LOCAL) {
            return config;
        }

        if (args.length == 1) {
            config.setMode(RunConfig.Mode.REPO);
            config.setAction(RunConfig.Action.DEFAULT);
            return config;
        }

        int actionIndex = 1;
        parseActionHelper(actionIndex, args, config);
        validateArgument(config);

        return config;
    }
}
