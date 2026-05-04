package dev.sonle.githubloc.execution;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Setter
public class RunConfig {

    private String userName;
    private String repoName;
    private long repoSize;
    private RunConfig.Action action = RunConfig.Action.DEFAULT; // default action : if no specific action
    private RunConfig.Mode mode = RunConfig.Mode.REPO; // default mode : if no cmd argument
    private RunConfig.SortArgument sortArgument = RunConfig.SortArgument.ALL;

    public enum Mode {
        USER,
        REPO,
        LOCAL,
        DEFAULT
    }

    public enum Action {
        SORT, // show and export file list in order, rank by LOC
        TREE, // only show tree dir
        JSON, // only export Json
        DOWNLOAD, // only download
        UNZIP, // download + unzip
        DEFAULT, // show and export tree dir
    }

    public enum SortArgument {
        ALL, // sort all nodes
        BYLANG, // group by used language and sort
        BYMOSTLANG// sort by most used Language
    }

    public record BasePath  (
            Path baseRepoPath,
            Path baseZipPath,
            Path baseJsonPath
    ){
        public static BasePath defaultDir(){
            return new BasePath ( Paths.get("storage", "repos"),
                    Paths.get("storage", "zip-repos"),
                    Paths.get("storage", "json-results"));
        }

        public static BasePath customDir(Path customBase){
            return new BasePath ( customBase.resolve("repos"),
                    customBase.resolve("zip-repos"),
                    customBase.resolve("json-results"));
        }
    }

    public record StoragePath(
            Path repoPath,
            Path zipPath,
            Path jsonPath
    ){
        public static StoragePath from(String repoName, BasePath basePath){
            return new StoragePath(
                    basePath.baseRepoPath.resolve(repoName),
                    basePath.baseZipPath.resolve(repoName + ".zip"),
                    basePath.baseJsonPath.resolve(repoName + ".json")
            );
        }
    }

    public static RunConfig createDefaultRunConfig(String userName, String repoName) {
        RunConfig defaultRunConfig = new RunConfig();
        defaultRunConfig.setUserName(userName);
        defaultRunConfig.setRepoName(repoName);
        return defaultRunConfig;
    }

}
