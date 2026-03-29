package dev.sonle.githubloc.output;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import dev.sonle.githubloc.filesystem.SizeFormatter;
import dev.sonle.githubloc.loc.DirectoryLocProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;

@JsonPropertyOrder({ "userName", "repoName", "repoSize", "repoURL", "scanDate", "totalFiles", "totalNodes", "totalLoc",
        "percentageOfUsedLanguage", "rootNode" })
@JsonInclude(JsonInclude.Include.NON_EMPTY) // hide childs[] if node is a file or empty folder
public class RepoReport {
    @JsonIgnore
    private Tree repoTree; // only for collecting info

    private String userName;
    private String repoName;
    private String repoSize;
    private String repoURL;
    private String scanDate;
    private int totalFiles;
    private int totalNodes;
    private int totalLoc;
    private Map<String, String> percentageOfUsedLanguage;
    private FileNode rootNode; // use root to represent for entire tree

    public RepoReport(Tree tree, String userName, String repoName, long repoSize) {
        this.repoTree = tree;
        this.repoSize = new SizeFormatter().convertSize(repoSize);
        this.repoName = repoName;
        this.userName = userName;
    }

    public RepoReport createRepoReport() {
        totalFiles = repoTree.getFileList().size();
        totalNodes = repoTree.getNodeContainer().size();
        rootNode = repoTree.getRoot();
        totalLoc = rootNode.getLoc();
        percentageOfUsedLanguage = new DirectoryLocProcessor().getPercentageUsedLanguage(rootNode);

        if ("local-user".equalsIgnoreCase(userName) || userName == null)
            repoURL = null;
        else
            repoURL = String.format("https://github.com/%s/%s", userName, repoName);

        if ("undefined".equalsIgnoreCase(repoSize))
            repoSize = null;
        
        scanDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return this;
    }

    /*getter utilites, for jackson accessing */
    public String getUserName() {
        return userName;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getRepoSize() {
        return repoSize;
    }

    public String getRepoURL() {
        return repoURL;
    }

    public String getScanDate() {
        return scanDate;
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public int getTotalLoc() {
        return totalLoc;
    }

    public Map<String, String> getPercentageOfUsedLanguage() {
        return percentageOfUsedLanguage;
    }

    public FileNode getRootNode() {
        return rootNode;
    }

    
}
