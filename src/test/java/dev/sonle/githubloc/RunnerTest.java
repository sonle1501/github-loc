package dev.sonle.githubloc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

import dev.sonle.githubloc.Runner;
import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.util.JsonProcessor;
import dev.sonle.githubloc.util.Unzip;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RunnerTest {

  private Runner runner;
  private MockedStatic<RepoDownloader> repoDownloaderMock;
  private MockedStatic<Unzip> unzipMock;
  private MockedStatic<JsonProcessor> jsonProcessorMock;
  private MockedStatic<Files> filesMock;

  @BeforeEach
  void setUp() {
    runner = new Runner("testUser", "testRepo");
    repoDownloaderMock = mockStatic(RepoDownloader.class);
    unzipMock = mockStatic(Unzip.class);
    jsonProcessorMock = mockStatic(JsonProcessor.class);
    filesMock = mockStatic(Files.class);
  }

  @AfterEach
  void tearDown() {
    repoDownloaderMock.close();
    unzipMock.close();
    jsonProcessorMock.close();
    filesMock.close();
  }

  @Test
  void testPreparePath() {
    assertDoesNotThrow(() -> runner.preparePath());
    filesMock.verify(() -> Files.createDirectories(any(Path.class)), atLeastOnce());
  }

  @Test
  void testRunApp() {
    assertDoesNotThrow(() -> runner.runApp());
    // Verify all steps are called
    filesMock.verify(() -> Files.createDirectories(any(Path.class)), atLeastOnce());
    repoDownloaderMock.verify(() -> RepoDownloader.locate(anyString(), anyString(), anyString()));
    unzipMock.verify(() -> Unzip.unzip(anyString(), anyString()));
    //  jsonProcessorMock.verify(() -> JsonProcessor.exportJson(anyString(), anyString()));
  }
}
