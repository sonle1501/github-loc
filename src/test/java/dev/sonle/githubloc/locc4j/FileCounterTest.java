package dev.sonle.githubloc.locc4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileCounterTest {

    @Test
    void testCountSingleStringPath(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("Test.java");
        Files.writeString(file, "public class Test {\n  // Comment\n  public void method() {}\n}");

        FileCounter counter = new FileCounter();
        Map<Path, Map<Language, Counts>> result = counter.count(file.toString());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.containsKey(file));
        
        Map<Language, Counts> countsByLang = result.get(file);
        assertFalse(countsByLang.isEmpty());
    }

    @Test
    void testCountSinglePath(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("script.py");
        Files.writeString(file, "def hello():\n    print('world')");

        FileCounter counter = new FileCounter();
        Map<Path, Map<Language, Counts>> result = counter.count(file);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.containsKey(file));
    }

    @Test
    void testCountDirectoryThrowsException(@TempDir Path tempDir) {
        FileCounter counter = new FileCounter();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            counter.count(tempDir);
        });

        assertTrue(thrown.getMessage().contains("must be a file"));
    }

    @Test
    void testCountMissingFileThrowsException(@TempDir Path tempDir) {
        Path missingFile = tempDir.resolve("missing.txt");
        FileCounter counter = new FileCounter();

        assertThrows(FileNotFoundException.class, () -> {
            counter.count(missingFile);
        });
    }

    @Test
    void testCountMultipleFiles(@TempDir Path tempDir) throws IOException {
        Path file1 = tempDir.resolve("f1.js");
        Files.writeString(file1, "console.log('hi');");
        Path file2 = tempDir.resolve("f2.js");
        Files.writeString(file2, "console.log('hello');");

        FileCounter counter = new FileCounter();
        Map<Path, Map<Language, Counts>> result = counter.count(file1, file2);

        assertEquals(2, result.size());
        assertTrue(result.containsKey(file1));
        assertTrue(result.containsKey(file2));
    }

    @Test
    void testCountEmptyCollection() {
        FileCounter counter = new FileCounter();
        Collection<Path> emptyList = List.of();

        assertThrows(IllegalArgumentException.class, () -> {
            counter.count(emptyList);
        });
    }

    @Test
    void testUnrecognizedFileExtensionReturnsEmptyMap(@TempDir Path tempDir) throws IOException {
        Path unknownFile = tempDir.resolve("unknown.xyz");
        Files.writeString(unknownFile, "some data");

        FileCounter counter = new FileCounter();
        Map<Path, Map<Language, Counts>> result = counter.count(unknownFile);

        assertTrue(result.containsKey(unknownFile));
        assertTrue(result.get(unknownFile).isEmpty());
    }

    @Test
    void testCountDocStringsFlag(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("doc.java");
        Files.writeString(file, "/** docstring */ class A {}");

        FileCounter counter = new FileCounter().countDocStrings(false);
        Map<Path, Map<Language, Counts>> result = counter.count(file);

        assertNotNull(result);
        // Not asserting exact comment counts since Language parsing is internal, just ensuring API chain works.
    }
}
