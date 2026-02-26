package dev.sonle.githubloc.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreePrinter {
    private Tree tree;

    public enum Color {
        FOLDER("\u001B[38;2;135;206;235m"), // Sky Blue
        FILE("\u001B[32m"), // Green
        META("\u001B[90m"), // Dark Gray (for info)
        TREE("\u001B[37m"), // White
        WRAPPER("\u001B[93m"), // Bright yellow
        RESET("\u001B[0m");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    public TreePrinter(Tree tree) {
        this.tree = tree;
    }

    public void showTree() {
        // show wrapper
        FileNode root = tree.getRoot();
        System.out.println(Color.WRAPPER + "Wrapper folder : " + root.getName() + Color.RESET);

        showTreeHelper(root.getChilds().get(0), true, "");
    }

    private void showTreeHelper(FileNode node, boolean isLast, String prefix) {
        // symbol └── " : "├── │
        String connector = isLast ? "└──" : "├──";

        String fileInfo = "";

        if (node.getChilds() == null || node.getChilds().isEmpty()) { // priorty null checking first
            // show file
            fileInfo = String.format(
                    " %sloc: %s | %s%s",
                    Color.META,
                    node.getLoc(),
                    node.getLanguageSet(),
                    Color.RESET);

            System.out.println(
                    Color.TREE
                            + prefix
                            + connector
                            + Color.RESET
                            + Color.FILE
                            + node.getName()
                            + Color.RESET
                            + fileInfo);
            return;
        }
        // show folder
        else {
            fileInfo = String.format(
                    " %sloc: %s",
                    Color.META,
                    node.getLoc());

            System.out.println(
                    Color.TREE
                            + prefix
                            + connector
                            + Color.RESET
                            + Color.FOLDER
                            + node.getName()
                            + "/"
                            + fileInfo
                            + Color.RESET);
        }

        List<FileNode> nodeChilds = node.getChilds();
        for (int i = 0; i < nodeChilds.size(); i++) {
            String indent = isLast ? "     " : "│    ";

            if (i == nodeChilds.size() - 1) {
                showTreeHelper(nodeChilds.get(i), true, prefix + indent);
            } else {
                showTreeHelper(nodeChilds.get(i), false, prefix + indent);
            }
        }
        return;
    }

    public static void printNodesFromList(List<FileNode> nodes) {
        System.out.println("\n" + Color.WRAPPER + "View files by lines of code, desc" + Color.RESET);
        System.out.println();
        int top = 1;
        for (FileNode node : nodes) {
            if (node.getChilds().size() > 0)
                continue;

            String fileInfo = String.format(
                    " %sloc: %s | %s%s",
                    Color.META,
                    node.getLoc(),
                    node.getLanguageSet(),
                    Color.RESET);

            System.out.println(
                    "TOP " + (top++) + ": " +
                            Color.FILE
                            + node.getName()
                            + Color.RESET
                            + fileInfo);
        }
    }

    public void printAllNodes() {
        Map<String, FileNode> nodeContainer = tree.getNodeContainer();
        for (Map.Entry<String, FileNode> entry : nodeContainer.entrySet()) {
            String name = entry.getValue().getName();
            // String loc = entry.getValue().content;
            List<FileNode> childs = entry.getValue().getChilds();
            List<String> childNames = new ArrayList<>();
            for (FileNode child : childs) {
                childNames.add(child.getName());
            }
            if (childNames.size() > 0) {
                System.out.println("folder: " + name);
                System.out.println("childs = " + childNames);
                System.out.println("-------------------------------------");
            } else {
                System.out.println("filename: " + name);
                System.out.println("loc = " + entry.getValue().getLoc());
                System.out.println("language = " + entry.getValue().getLanguageSet());
                System.out.println("-------------------------------------");
            }
        }
    }

    public void traversal(FileNode rootNode) {
        Map<String, FileNode> nodeContainer = tree.getNodeContainer();
        for (FileNode node : rootNode.getChilds()) {
            if (nodeContainer.containsKey(node.getPath())) {
                FileNode tempNode = nodeContainer.get(node.getPath());
                traversal(tempNode);
                tempNode.show();
            }
        }
    }

}
