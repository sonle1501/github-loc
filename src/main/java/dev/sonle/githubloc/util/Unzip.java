package dev.sonle.githubloc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

  public static void unzip(String sourceZipRepo, String destRepoPath) throws IOException {
    File destRepo = new File(destRepoPath);

    // ensure new repo root created
    if (!destRepo.exists()) {
      destRepo.mkdirs();
    } 

    try (ZipInputStream zipRepoInputStream = new ZipInputStream(new FileInputStream(sourceZipRepo))) {
      ZipEntry entry = zipRepoInputStream.getNextEntry();

      while (entry != null) {
        File newDestFile = new File(destRepoPath, entry.getName()); // new file for writting content

        // prevent Zip Slip vulnerability
        String destRepoCanonicalPath = destRepo.getCanonicalPath();
        String newDestFileCanonicalPath = newDestFile.getCanonicalPath();

        if (!newDestFileCanonicalPath.startsWith(destRepoCanonicalPath + File.separator)) {
          throw new IOException("Entry is outside of the target dir: " + entry.getName());
        }

        if (entry.isDirectory()) {
          if (!newDestFile.isDirectory() && !newDestFile.mkdirs()) {
            throw new IOException("Failed to create directory " + newDestFile);
          }
        } else {
          File parent = newDestFile.getParentFile();
          if (!parent.isDirectory() && !parent.mkdirs()) {
            throw new IOException("Failed to create directory " + parent);
          }

          // Write file content from zip stream 
          extractFile(zipRepoInputStream, newDestFile);
        }

        zipRepoInputStream.closeEntry();
        entry = zipRepoInputStream.getNextEntry();
      }
    }

    System.out.println("Unzip completed successfully!");
  }

  private static void extractFile(ZipInputStream zipRepoInputStream, File destFile) throws IOException {
    try (FileOutputStream fos = new FileOutputStream(destFile)) { 
      byte[] buffer = new byte[4096]; // buffer size 4KB
      int len;

      // zip stream read content from the its current entry and fill the buffer container
      while ((len = zipRepoInputStream.read(buffer)) > 0) { 
        fos.write(buffer, 0, len);
      }
    }
  }

  public static void main(String[] args) {
    try {
      Unzip.unzip("work/zip-repos/Monty_Hall_Simulation.zi", "work/repos/Monty_Hall_Simulation");
    } catch (IOException e) {
      System.err.println(e);    
    }
  }
}
