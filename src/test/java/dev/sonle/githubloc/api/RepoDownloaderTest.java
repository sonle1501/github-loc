package dev.sonle.githubloc.api;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import dev.sonle.githubloc.api.RepoDownloader;

class RepoDownloaderTest {

  private MockedStatic<Files> filesMock;

  // We need to mock RepoDownloader itself partially if we want to test locate calling call
  // But since call is static, we can just mock the call method if we separate them or use spy.
  // However, since we are testing static methods, it's easier to mock the dependencies of locate.
  // locate calls RepoDownloader.call (which we might want to mock to avoid network) and Files.copy.

  // To mock a static method within the same class we are testing is tricky with Mockito.
  // Usually we should refactor. But here we can try to mock the network call inside 'call' or just
  // mock 'call' itself.
  // Since 'call' is in the same class, we can't easily mock it while testing 'locate' unless we use
  // PowerMock or similar,
  // but Mockito-inline supports some of this.
  // Let's try to mock RepoDownloader.call while testing locate.

  @Test
  void testLocate() {
    try (MockedStatic<RepoDownloader> repoDownloaderMock = mockStatic(RepoDownloader.class);
        MockedStatic<Files> filesMock = mockStatic(Files.class)) {

      // We need to configure the mock to call the real method for 'locate'
      // BUT 'locate' is static. Mockito mockStatic mocks ALL static methods by default.
      // We can configure it to call real method for locate?
      // repoDownloaderMock.when(() -> RepoDownloader.locate(anyString(), anyString(),
      // anyString())).thenCallRealMethod();
      // This is possible.

      HttpResponse<InputStream> mockResponse = mock(HttpResponse.class);
      InputStream mockInputStream = new ByteArrayInputStream("test data".getBytes());
      when(mockResponse.body()).thenReturn(mockInputStream);

      repoDownloaderMock
          .when(() -> RepoDownloader.call(anyString(), anyString()))
          .thenReturn(mockResponse);
      repoDownloaderMock
          .when(() -> RepoDownloader.locate(anyString(), anyString(), anyString()))
          .thenCallRealMethod();

      filesMock
          .when(
              () ->
                  Files.copy(
                      any(InputStream.class), any(Path.class), any(StandardCopyOption.class)))
          .thenReturn(100L);

      assertDoesNotThrow(() -> RepoDownloader.locate("target/path", "user", "repo"));

      repoDownloaderMock.verify(() -> RepoDownloader.call("user", "repo"));
      filesMock.verify(
          () -> Files.copy(any(InputStream.class), any(Path.class), any(StandardCopyOption.class)));
    }
  }
}
