package dev.sonle.githubloc.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import dev.sonle.githubloc.tree.FileNode;
import tools.jackson.databind.ObjectMapper;

public class JsonProcessor {

  public static void exportTreeToJson(String jsonTarget, FileNode rootSoruce)
      throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget), rootSoruce);  // read tree dir recursively and write to target file
    System.out.println("Export Json Tree Dir completed !");
  }

  public static void exportOrderedListToJson(String jsonTarget, List<FileNode> list) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget), list);
    System.out.println("Export Ordered List Json completed !");
  }
}
