package dev.sonle.githubloc.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepoDownloaderTest {

    @Test
    void testDownloadRepoSuccess(@TempDir Path tempDir) throws IOException, InterruptedException {
        Path location = tempDir.resolve("repo.zip");
        RepoDownloader downloader = spy(new RepoDownloader());

        HttpResponse<InputStream> mockResponse = mock(HttpResponse.class);
        InputStream mockInputStream = new ByteArrayInputStream("fake content".getBytes());
        
        when(mockResponse.body()).thenReturn(mockInputStream);
        doReturn(mockResponse).when(downloader).getResponse("user", "repo");

        long size = downloader.downloadRepo(location, "user", "repo");

        assertTrue(size > 0);
        assertTrue(Files.exists(location));
        assertEquals("fake content", Files.readString(location));
    }

    @Test
    void testDownloadRepoThrowsException() throws IOException, InterruptedException {
        Path location = Path.of("fake/path");
        RepoDownloader downloader = spy(new RepoDownloader());

        doThrow(new IOException("Simulation failed")).when(downloader).getResponse("user", "repo");

        RepoDownloader.RepoDownloadException thrown = assertThrows(RepoDownloader.RepoDownloadException.class, () -> {
            downloader.downloadRepo(location, "user", "repo");
        });

        assertTrue(thrown.getCause() instanceof IOException);
    }
}
