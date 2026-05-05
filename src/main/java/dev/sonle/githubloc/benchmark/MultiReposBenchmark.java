package dev.sonle.githubloc.benchmark;

import dev.sonle.githubloc.execution.RunConfig;
import dev.sonle.githubloc.multirepos.MultithreadingReposHandle;
import dev.sonle.githubloc.multirepos.SequentialReposHandler;
import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

// Configure benchmark behavior
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(1)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 3, time = 1)
public class MultiReposBenchmark {

    private String userName;
    private RunConfig config;
    // storage at : Paths.get("storage", "user-repos", userName);

    @Setup(Level.Trial)
    public void setup() {
        userName = PropertyInjector.injectFromFile("benchmark/MultiReposBenchmark.properties", "userName", "sonle1501");
        config = new RunConfig();
        config.setUserName(userName);
    }

    @Benchmark
    public void measureProcessingMultiReposMultithreading(){
        MultithreadingReposHandle handler = new MultithreadingReposHandle(config);
        handler.runAppAsync();
    }

    @Benchmark
    public void measureProcessingMultiReposSequential(){
        SequentialReposHandler handler =  new SequentialReposHandler(config);
        handler.runApp();
    }
}