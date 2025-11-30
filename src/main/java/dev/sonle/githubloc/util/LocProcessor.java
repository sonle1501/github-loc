package dev.sonle.githubloc.util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.cthing.locc4j.Counts;
import org.cthing.locc4j.FileCounter;
import org.cthing.locc4j.Language;

// using locc4j 
public class LocProcessor {

  public static Counts getCounts(Path filePath) throws IOException {
    FileCounter counter = new FileCounter();
    Map<Path, Map<Language, Counts>> counts = counter.count(filePath.toString());
    Counts res = counts.get(filePath).values().iterator().next();
    return res;
  }

  public static String getLOC(Path filePath) throws IOException {
    FileCounter counter = new FileCounter();
    Map<Path, Map<Language, Counts>> counts = counter.count(filePath.toString());
    Counts LOCinfo = counts.get(filePath).values().iterator().next();
    int LOC = LOCinfo.getCodeLines();
    return Integer.toString(LOC);
  }

  public static Map<Path, Map.Entry<Integer, List<String>>> getInfo(Path filePath) {
    Map<Path, Map.Entry<Integer, List<String>>> res = new HashMap<>();
   
    FileCounter counter = new FileCounter();
    try {
      Map<Path, Map<Language, Counts>> countResult = counter.count(filePath.toString());
      Map<Language, Counts> fileInfo = countResult.get(filePath); // fileInfo : loc and programming language/type in a file
      List<String> languageList = new ArrayList<>();
      int linesOfCode = 0;
      for (Map.Entry<Language, Counts> entry : fileInfo.entrySet()) {
        languageList.add(entry.getKey().getDisplayName());
        linesOfCode = linesOfCode + entry.getValue().getCodeLines(); // sum all LOC in each language
      }
      
      res.put(filePath, Map.entry(linesOfCode, languageList));
      return res;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    try {
      Path p = Paths.get("src\\main\\java\\dev\\sonle\\githubloc\\App.java");
      System.out.println(LocProcessor.getInfo(p));
    } catch (Exception e) {
      System.err.println("LocProcessor failed: " + e.getMessage());
    }
  }
}
