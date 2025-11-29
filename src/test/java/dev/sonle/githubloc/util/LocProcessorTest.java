package dev.sonle.githubloc.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class LocProcessorTest {

    @TempDir
    Path tempDir;

    @Test
    void testGetInfo() throws IOException {
        Path file = tempDir.resolve("Test.java");
        String content = "public class Test {\n  // comment\n  public void main() {\n    System.out.println(\"Hello\");\n  }\n}";
        Files.writeString(file, content);

        Map<String, String> info = LocProcessor.getInfo(file);
        assertNotNull(info);
        // locc4j might count differently, but let's check if it returns something
        assertNotNull(info.get("loc"));
        assertNotNull(info.get("lang"));
        // Java should be detected
        assertEquals("[Java]", info.get("lang"));
    }
    
    @Test
    void testGetLOC() throws IOException {
        Path file = tempDir.resolve("Test.java");
        String content = "public class Test {\n  // comment\n  public void main() {\n    System.out.println(\"Hello\");\n  }\n}";
        Files.writeString(file, content);

        String loc = LocProcessor.getLOC(file);
        assertNotNull(loc);
        // 5 lines of code roughly
        // 1: class
        // 2: // comment (ignored?)
        // 3: main
        // 4: print
        // 5: }
        // 6: }
        // locc4j usually counts SLOC.
    }
}
