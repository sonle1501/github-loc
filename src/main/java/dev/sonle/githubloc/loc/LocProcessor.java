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

// using locc4j 
public class LocProcessor {

  public record FileInfo (
    int loc,
    Set<String> languageSet,
    int comments,
    int blanks,
    Map<String, Integer> locByLang){}

  private Map<Language, Counts> fileCountResult;
  private Path filePath;
  private FileInfo fileInfo;

  private LocProcessor(){

  }

  public LocProcessor(Path filePath, FileCounter counter) throws IOException{
    this.filePath = filePath;
    processFileCountResult(counter);
    processFileInfo();
  } 

  public void processFileInfo(){
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
    this.fileInfo = new FileInfo(linesOfCode, languageSet, comments, blanks, locByLang);
  }

  public FileInfo getFileInfo(){
    return this.fileInfo;
  }

  public void processFileCountResult(FileCounter counter) throws IOException {
    Map<Path, Map<Language, Counts>> countResult = counter.count(this.filePath.toString());
    this.fileCountResult = countResult.get(this.filePath);
  }

  public static void main(String[] args) {
  //   try {
  //     Path p = Paths.get("src\\main\\java\\dev\\sonle\\githubloc\\App.java");
  //     LocProcessor locProcessorTemp = new LocProcessor(p);
  //     LocProcessor.FileInfo fileInfo = locProcessorTemp.getFileInfo();
  //     System.out.println(fileInfo.loc());
  //   } catch (Exception e) {
  //     System.err.println("LocProcessor failed: " + e.getMessage());
  //   }
  // }
  }
}
