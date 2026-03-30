package dev.sonle.githubloc.filesystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class UnzipTest {

    private Unzip unzipper;

    @BeforeEach
    void setUp() {
        unzipper = new Unzip();
    }

    @Test
    void testSuccessfulUnzipNormalFiles(@TempDir Path tempDir) throws IOException {
        Path zipFile = tempDir.resolve("test.zip");
        Path destDir = tempDir.resolve("extracted");

        try (OutputStream fos = Files.newOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
             
            // Add a folder
            zos.putNextEntry(new ZipEntry("folder/"));
            zos.closeEntry();
            
            // Add a file
            zos.putNextEntry(new ZipEntry("folder/file.txt"));
            zos.write("hello".getBytes());
            zos.closeEntry();
        }

        long size = unzipper.unzip(zipFile, destDir);

        assertTrue(Files.exists(destDir.resolve("folder")));
        assertTrue(Files.exists(destDir.resolve("folder/file.txt")));
        assertEquals("hello", Files.readString(destDir.resolve("folder/file.txt")));
        assertTrue(size > 0);
    }

    @Test
    void testZipSlipVulnerabilityPrevention(@TempDir Path tempDir) throws IOException {
        Path zipFile = tempDir.resolve("malicious.zip");
        Path destDir = tempDir.resolve("extracted");

        try (OutputStream fos = Files.newOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
             
            // Add an entry with path traversal
            zos.putNextEntry(new ZipEntry("../outside.txt"));
            zos.write("malicious payload".getBytes());
            zos.closeEntry();
        }

        IOException thrown = assertThrows(IOException.class, () -> {
            unzipper.unzip(zipFile, destDir);
        });

        assertTrue(thrown.getMessage().contains("Entry is outside of the target dir"));
    }
}
