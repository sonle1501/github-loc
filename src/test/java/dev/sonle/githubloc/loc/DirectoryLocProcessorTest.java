package dev.sonle.githubloc.loc;

import dev.sonle.githubloc.tree.FileNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryLocProcessorTest {

    private DirectoryLocProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new DirectoryLocProcessor();
    }

    @Test
    void testCountLocFolder() {
        FileNode root = new FileNode("/project", "project", null);

        FileNode childFolder = new FileNode("/project/src", "src", root);
        root.addChild(childFolder);

        FileNode file1 = new FileNode("/project/src/Main.java", "Main.java", childFolder);
        file1.setLoc(100);
        file1.setComments(10);
        file1.setBlanks(5);
        
        Set<String> langSet1 = new LinkedHashSet<>();
        langSet1.add("Java");
        file1.setLanguageSet(langSet1);
        
        Map<String, Integer> locByLang1 = new HashMap<>();
        locByLang1.put("Java", 100);
        file1.setLocByLang(locByLang1);

        childFolder.addChild(file1);

        FileNode file2 = new FileNode("/project/README.md", "README.md", root);
        file2.setLoc(50);
        file2.setComments(0);
        file2.setBlanks(5);

        Set<String> langSet2 = new LinkedHashSet<>();
        langSet2.add("Markdown");
        file2.setLanguageSet(langSet2);

        Map<String, Integer> locByLang2 = new HashMap<>();
        locByLang2.put("Markdown", 50);
        file2.setLocByLang(locByLang2);

        root.addChild(file2);

        processor.countLocFolder(root);

        assertEquals(150, root.getLoc());
        assertEquals(10, root.getComments());
        assertEquals(10, root.getBlanks());

        assertTrue(root.getLanguageSet().contains("Java"));
        assertTrue(root.getLanguageSet().contains("Markdown"));

        assertEquals(100, root.getLocByLang().get("Java"));
        assertEquals(50, root.getLocByLang().get("Markdown"));
    }

    @Test
    void testGetMostUsedLanguage() {
        FileNode root = new FileNode("/project", "project", null);
        
        Map<String, Integer> locByLang = new HashMap<>();
        locByLang.put("Java", 500);
        locByLang.put("Python", 200);
        locByLang.put("C++", 800);
        
        root.setLocByLang(locByLang);

        String mostUsed = processor.getMostUsedLanguage(root);
        assertEquals("C++", mostUsed);
    }

    @Test
    void testGetPercentageUsedLanguage() {
        FileNode root = new FileNode("/project", "project", null);
        root.setLoc(1000);
        
        Map<String, Integer> locByLang = new HashMap<>();
        locByLang.put("Java", 500); // 50.00%
        locByLang.put("Python", 250); // 25.00%
        locByLang.put("C++", 250); // 25.00%
        
        root.setLocByLang(locByLang);

        Map<String, String> percentageMap = processor.getPercentageUsedLanguage(root);

        assertEquals("50.00%", percentageMap.get("Java"));
        assertEquals("25.00%", percentageMap.get("Python"));
        assertEquals("25.00%", percentageMap.get("C++"));
        
        // Check order (Descending)
        String firstKey = percentageMap.keySet().iterator().next();
        assertEquals("Java", firstKey);
    }

    @Test
    void testGetPercentageUsedLanguageDivisionByZero() {
        FileNode root = new FileNode("/project", "project", null);
        root.setLoc(0); // This will cause a zero total LOC
        
        Map<String, Integer> locByLang = new HashMap<>();
        root.setLocByLang(locByLang);

        Map<String, String> percentageMap = processor.getPercentageUsedLanguage(root);
        assertTrue(percentageMap.isEmpty());
    }
}
