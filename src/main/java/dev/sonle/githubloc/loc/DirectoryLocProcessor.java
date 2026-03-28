package dev.sonle.githubloc.loc;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.cthing.locc4j.FileCounter;

import dev.sonle.githubloc.tree.FileNode;

public class DirectoryLocProcessor {

    public void processLocOnFileList(List<FileNode> fileList) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores * 8);

        int listSize = fileList.size();
        int batchSize = cores;

        int numBatchs = listSize < batchSize ? 0 : listSize / batchSize;
        int remainder = listSize - batchSize * numBatchs;
        List<Callable<Void>> tasks = new ArrayList<>();

        tasks.add(() -> {
            executor.submit(() -> submitBatchToThreadPool(0, remainder, fileList));
            return null;
        });

        int batchStart = remainder;
        for (int batch = 1; batch <= numBatchs; batch++) {
            int start = batchStart;
            int end = start + batchSize;
            batchStart = end;
            tasks.add(() -> {
                executor.submit(() -> submitBatchToThreadPool(start, end, fileList));
                return null;
            });
        }

        try {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Batch processing was interrupted.");
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    private void submitBatchToThreadPool(int start, int end, List<FileNode> fileList) {
        FileCounter fileCounter = new FileCounter();
        for (int i = start; i < end; i++) {

            FileNode node = fileList.get(i);
            try {
                Path filePath = Paths.get(node.getPath());
                LocProcessor locProcessor = new LocProcessor(filePath, fileCounter);
                LocProcessor.FileInfo fileInfo = locProcessor.getFileInfo();

                node.setLoc(fileInfo.loc());
                node.setComments(fileInfo.comments());
                node.setBlanks(fileInfo.blanks());
                node.setLanguageSet(fileInfo.languageSet());
                node.setLocByLang(fileInfo.locByLang());
            } catch (IOException e) {
                System.err.println("Error occurs while counting LOC on file: " + node.getPath());
            }
        }
    }

    // count LOC for folder
    public void countLocFolder(FileNode rootNode) {
        for (FileNode node : rootNode.getChilds()) {
            if (node.getChilds().size() > 0) { // is folder
                countLocFolder(node);
                rootNode.updateLoc(node.getLoc());
                rootNode.updateComments(node.getComments());
                rootNode.updateBlanks(node.getBlanks());
                rootNode.mergeLanguageSet(node.getLanguageSet());
                rootNode.mergeLocByLang(node.getLocByLang());
            } else { // is file or emtpy folder
                rootNode.updateLoc(node.getLoc());
                rootNode.updateComments(node.getComments());
                rootNode.updateBlanks(node.getBlanks());
                rootNode.mergeLanguageSet(node.getLanguageSet());
                rootNode.mergeLocByLang(node.getLocByLang());
            }
        }
    }

    public static void main(String[] args) {
        int a = 8;
        int b = 3;
        System.out.println(a / b);
    }
}
