package dev.sonle.githubloc.output;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.sonle.githubloc.filesystem.SizeFormatter;
import dev.sonle.githubloc.loc.DirectoryLocProcessor;
import dev.sonle.githubloc.tree.FileNode;
import dev.sonle.githubloc.tree.Tree;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import lombok.Getter;

@JsonPropertyOrder({
    "userName",
    "repoName",
    "repoSize",
    "repoURL",
    "scanDate",
    "totalFiles",
    "totalNodes",
    "totalLoc",
    "percentageOfUsedLanguage",
    "rootNode"
})
@JsonInclude(JsonInclude.Include.NON_EMPTY) // hide childs[] if node is a file or empty folder
@Getter
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

    private void setNeededFields() {
        totalFiles = repoTree.getFileList().size();
        totalNodes = repoTree.getNodeContainer().size();
        rootNode = repoTree.getRoot();
        totalLoc = rootNode.getLoc();
        percentageOfUsedLanguage = new DirectoryLocProcessor().getPercentageUsedLanguage(rootNode);
    }

    public RepoReport createRepoReport() {
        setNeededFields();

        if (userName == null || "local-user".equalsIgnoreCase(userName)) repoURL = null;
        else repoURL = String.format("https://github.com/%s/%s", userName, repoName);

        if ("undefined".equalsIgnoreCase(repoSize)) repoSize = null;

        scanDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return this;
    }
}
