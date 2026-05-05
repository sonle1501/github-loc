package dev.sonle.githubloc.benchmark;

import dev.sonle.githubloc.tree.TreeBuilder;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

// Configure benchmark behavior
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(1)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
public class CreateTreeBenchmark {

    private Path mockRepoPath;
    private String repoName;
    private TreeBuilder treeBuilder;

    @Setup(Level.Trial)
    public void setup() throws IOException {
        repoName = PropertyInjector.injectFromFile("benchmark/TreeBenchmark.properties", "repoName", "github-loc");
        mockRepoPath = Paths.get("storage", "repos", repoName);
        treeBuilder = new TreeBuilder();
    }

    @Benchmark
    public void measureBuildTreeMultithreading(){
        treeBuilder.buildTree(mockRepoPath);
    }

    @Benchmark
    public void measureBuildTreeMultithreadingWithBatch(){
        treeBuilder.buildTreeWithBatchProcessing(mockRepoPath);
    }
    @Benchmark
    public void measureBuildTreeSequential(){
        treeBuilder.buildTreeSequential(mockRepoPath);
    }
}