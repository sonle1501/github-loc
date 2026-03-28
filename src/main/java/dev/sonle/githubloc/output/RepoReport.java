package dev.sonle.githubloc.output;

import dev.sonle.githubloc.tree.FileNode;

public class RepoReport {
    private String userName;
    private String repoName;
    private String scanDate;
    private int repoSize;
    private int totalLoc;
    private int totalFiles;
    private FileNode rootNode;  // use root to represent for entire tree
}
