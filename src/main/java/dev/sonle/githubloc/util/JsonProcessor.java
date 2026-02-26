package dev.sonle.githubloc.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import dev.sonle.githubloc.tree.FileNode;
import tools.jackson.databind.ObjectMapper;

public class JsonProcessor {

  public void exportTreeToJson(Path jsonTarget, FileNode rootSoruce)
      throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget.toString()), rootSoruce);  // read tree dir recursively and write to target file
    System.out.println("Export Json Tree Dir completed !");
  }

  public void exportOrderedListToJson(Path jsonTarget, List<FileNode> list) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(jsonTarget.toString()), list);
    System.out.println("Export Ordered List Json completed !");
  }
}
