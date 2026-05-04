package dev.sonle.githubloc.loc;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import dev.sonle.githubloc.locc4j.Counts;
import dev.sonle.githubloc.locc4j.FileCounter;
import dev.sonle.githubloc.locc4j.Language;
import lombok.NoArgsConstructor;

// using locc4j
public class LocProcessor {

  public record FileInfo (
    int loc,
    Set<String> languageSet,
    int comments,
    int blanks,
    Map<String, Integer> locByLang){}

  public FileInfo processFileInfo(Path filePath, FileCounter counter) throws  IOException{
    Map<Language, Counts> fileCountResult = this.processFileCountResult(counter, filePath);
    Set<String> languageSet = new LinkedHashSet<>();
    Map<String, Integer> locByLang = new HashMap<>();
    int linesOfCode = 0;
    int blanks = 0;
    int comments = 0;

    for (Map.Entry<Language, Counts> entry : fileCountResult.entrySet()) {
      String language = entry.getKey().getDisplayName();
      int newLoc = entry.getValue().getCodeLines();

      linesOfCode = linesOfCode + newLoc;
      comments = comments + entry.getValue().getCommentLines();
      blanks = blanks + entry.getValue().getBlankLines();
      locByLang.put(language, newLoc);
      languageSet.add(language);
    }
    return new FileInfo(linesOfCode, languageSet, comments, blanks, locByLang);
  }

  private Map<Language, Counts> processFileCountResult(FileCounter counter, Path filePath) throws IOException {
    Map<Path, Map<Language, Counts>> countResult = counter.count(filePath.toString());
    Map<Language, Counts> fileCountResult = countResult.get(filePath);
    return fileCountResult;
  }

  public static void main(String[] args) {
    try {
      Path p = java.nio.file.Paths.get("src/main/java/dev/sonle/githubloc/App.java");
      LocProcessor.FileInfo fileInfo = new LocProcessor().processFileInfo(p, new FileCounter());
      System.out.println("LOC for App.java: " + fileInfo.loc());
    } catch (Exception e) {
      System.err.println("LocProcessor failed: " + e.getMessage());
    }
  }
}
