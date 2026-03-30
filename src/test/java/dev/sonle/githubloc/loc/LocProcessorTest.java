package dev.sonle.githubloc.loc;

import dev.sonle.githubloc.locc4j.Counts;
import dev.sonle.githubloc.locc4j.FileCounter;
import dev.sonle.githubloc.locc4j.Language;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

class LocProcessorTest {

    @Mock
    private FileCounter mockCounter;

    @Mock
    private Language mockLanguage;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessFileInfo() throws IOException {
        Path filePath = Path.of("/path/to/Sample.java");

        Counts mockCounts = mock(Counts.class);
        when(mockCounts.getCodeLines()).thenReturn(10);
        when(mockCounts.getCommentLines()).thenReturn(2);
        when(mockCounts.getBlankLines()).thenReturn(5);
        
        Map<Language, Counts> fileCounts = new HashMap<>();
        fileCounts.put(mockLanguage, mockCounts);

        Map<Path, Map<Language, Counts>> result = new HashMap<>();
        result.put(filePath, fileCounts);

        when(mockLanguage.getDisplayName()).thenReturn("Java");
        when(mockCounter.count(anyString())).thenReturn(result);

        LocProcessor processor = new LocProcessor(filePath, mockCounter);
        LocProcessor.FileInfo fileInfo = processor.getFileInfo();

        assertNotNull(fileInfo);
        assertEquals(10, fileInfo.loc());
        assertEquals(2, fileInfo.comments());
        assertEquals(5, fileInfo.blanks());
        
        assertTrue(fileInfo.languageSet().contains("Java"));
        assertEquals(1, fileInfo.locByLang().size());
        assertEquals(10, fileInfo.locByLang().get("Java"));
    }

    @Test
    void testProcessEmptyFileCountResult() throws IOException {
        Path filePath = Path.of("/path/to/unknown.xyz");

        Map<Path, Map<Language, Counts>> result = new HashMap<>();
        result.put(filePath, new HashMap<>()); // Empty language map

        when(mockCounter.count(anyString())).thenReturn(result);

        LocProcessor processor = new LocProcessor(filePath, mockCounter);
        LocProcessor.FileInfo fileInfo = processor.getFileInfo();

        assertEquals(0, fileInfo.loc());
        assertEquals(0, fileInfo.comments());
        assertEquals(0, fileInfo.blanks());
        assertTrue(fileInfo.languageSet().isEmpty());
        assertTrue(fileInfo.locByLang().isEmpty());
    }
}
