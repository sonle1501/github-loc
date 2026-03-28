package dev.sonle.githubloc.filesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

    public long unzip(Path sourceZipRepo, Path destRepoPath) throws IOException {
        
        Path targetDir = destRepoPath.toAbsolutePath().normalize();
        Files.createDirectories(targetDir);
        long repoSizeInBytes = 0;

        try (ZipInputStream zipRepoInputStream = new ZipInputStream(Files.newInputStream(sourceZipRepo))){
            ZipEntry entry;
            while ((entry = zipRepoInputStream.getNextEntry()) != null) {
                Path resolvedDestPath = targetDir.resolve(entry.getName()).normalize();

                // prevent Zip Slip vulnerability
                if (!resolvedDestPath.startsWith(targetDir)) {
                    throw new IOException("Entry is outside of the target dir: " + entry.getName());
                }

                if (entry.isDirectory()) {
                    Files.createDirectories(resolvedDestPath);
                } else {
                    // Ensure the parent directory exists before writing the file
                    Files.createDirectories(resolvedDestPath.getParent());
                    
                    // unzip process: copy content from zipstream to target path
                    Files.copy(zipRepoInputStream, resolvedDestPath, StandardCopyOption.REPLACE_EXISTING);
                    repoSizeInBytes += Files.size(resolvedDestPath);
                }
                
                zipRepoInputStream.closeEntry();
            }
        }
        System.out.println("Successfully unzip " + new SizeFormatter().convertSize(repoSizeInBytes) + " at: " + targetDir);
        return repoSizeInBytes;
    }
}
