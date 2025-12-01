package dev.sonle.githubloc.util;

import java.io.File;
import java.io.IOException;

import dev.sonle.githubloc.tree.FileNode;
import tools.jackson.databind.ObjectMapper;

public class JsonProcessor {

  public static void exportTreeToJson(String repoTarget, String jsonTarget, FileNode rootSoruce)
      throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget), rootSoruce);  // read tree dir recursively and write to target file
    System.out.println("Export Json completed !");
  }
}
