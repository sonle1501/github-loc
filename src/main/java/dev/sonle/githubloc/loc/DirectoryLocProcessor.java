package dev.sonle.githubloc.loc;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import dev.sonle.githubloc.locc4j.FileCounter;

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

    public String getMostUsedLanguage(FileNode root) {
        Map<String, Integer> locByLang = root.getLocByLang();
        int maxLoc = -1;
        String lang = null;
        for (Map.Entry<String, Integer> entry : locByLang.entrySet()) {
            int currentLoc = entry.getValue();
            if (currentLoc > maxLoc) {
                maxLoc = currentLoc;
                lang = entry.getKey();
            }
        }
        return lang;
    }

    public Map<String, String> getPercentageUsedLanguage(FileNode root){
        Map<String, Integer> locByLang = root.getLocByLang();
        int totalLoc = root.getLoc();
        Map<String, String> percentageMap = new LinkedHashMap<>();

        //Avoid division by zero
        if (totalLoc == 0 || locByLang == null || locByLang.isEmpty()) {
            return percentageMap;
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(locByLang.entrySet());
        Collections.sort(sortedEntries, (entry1, entry2) -> 
            entry2.getValue().compareTo(entry1.getValue())  // reversed order
        );

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            String language = entry.getKey();
            int langLoc = entry.getValue();
            float percentage = (langLoc * 100.0f) / totalLoc;
            String formattedPercentage = String.format("%.2f%%", percentage);
            percentageMap.put(language, formattedPercentage);
        }
        return percentageMap;
    }

    public static void main(String[] args) {
        DirectoryLocProcessor processor = new DirectoryLocProcessor();
        FileNode root = new FileNode("storage\\repos\\github-loc", "github-loc", null);
        root.getLocByLang().put("Java", 100);
        root.getLocByLang().put("Python", 50);
        root.setLoc(150);
        System.out.println("Most used language: " + processor.getMostUsedLanguage(root));
        System.out.println("Percentage: " + processor.getPercentageUsedLanguage(root));
    }
}
