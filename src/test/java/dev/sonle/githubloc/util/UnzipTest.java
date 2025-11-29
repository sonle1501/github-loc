package dev.sonle.githubloc.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class UnzipTest {

    @TempDir
    Path tempDir;

    @Test
    void testUnzip() throws IOException {
        Path zipFile = tempDir.resolve("test.zip");
        Path destDir = tempDir.resolve("output");

        // Create a dummy zip file
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile.toFile()))) {
            ZipEntry entry = new ZipEntry("test.txt");
            zos.putNextEntry(entry);
            zos.write("Hello World".getBytes());
            zos.closeEntry();

            ZipEntry dirEntry = new ZipEntry("subdir/");
            zos.putNextEntry(dirEntry);
            zos.closeEntry();

            ZipEntry fileInDir = new ZipEntry("subdir/inner.txt");
            zos.putNextEntry(fileInDir);
            zos.write("Inner file".getBytes());
            zos.closeEntry();
        }

        Unzip.unzip(zipFile.toString(), destDir.toString());

        File extractedFile = destDir.resolve("test.txt").toFile();
        assertTrue(extractedFile.exists());
        
        File extractedDir = destDir.resolve("subdir").toFile();
        assertTrue(extractedDir.exists());
        assertTrue(extractedDir.isDirectory());

        File extractedInnerFile = destDir.resolve("subdir/inner.txt").toFile();
        assertTrue(extractedInnerFile.exists());
    }
}
