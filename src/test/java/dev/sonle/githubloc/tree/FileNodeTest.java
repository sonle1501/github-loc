package dev.sonle.githubloc.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileNodeTest {
    private FileNode node;

    @BeforeEach
    void setUp() {
        node = new FileNode("/test/path", "testFile.java", null);
    }

    @Test
    void testBasicProperties() {
        assertEquals("testFile.java", node.getName());
        assertEquals("/test/path", node.getPath());
        assertNull(node.getParent());

        node.setLoc(10);
        assertEquals(10, node.getLoc());

        node.updateLoc(5);
        assertEquals(15, node.getLoc());
        
        node.updateComments(2);
        assertEquals(2, node.getComments());

        node.updateBlanks(1);
        assertEquals(1, node.getBlanks());
    }

    @Test
    void testMergeLanguageSet() {
        Set<String> langSet = new HashSet<>();
        langSet.add("Java");
        
        assertTrue(node.mergeLanguageSet(langSet));
        assertTrue(node.getLanguageSet().contains("Java"));

        Set<String> moreLangs = new HashSet<>();
        moreLangs.add("XML");
        assertTrue(node.mergeLanguageSet(moreLangs));

        assertTrue(node.getLanguageSet().contains("Java"));
        assertTrue(node.getLanguageSet().contains("XML"));
    }

    @Test
    void testMergeLocByLang() {
        Map<String, Integer> locMap = new HashMap<>();
        locMap.put("Java", 100);
        locMap.put("Python", 50);

        node.mergeLocByLang(locMap);

        assertEquals(100, node.getLocByLang().get("Java"));
        assertEquals(50, node.getLocByLang().get("Python"));

        Map<String, Integer> additionalLoc = new HashMap<>();
        additionalLoc.put("Java", 20);
        additionalLoc.put("XML", 10);

        node.mergeLocByLang(additionalLoc);

        assertEquals(120, node.getLocByLang().get("Java"));
        assertEquals(50, node.getLocByLang().get("Python"));
        assertEquals(10, node.getLocByLang().get("XML"));
    }

    @Test
    void testAddChild() {
        FileNode child = new FileNode("/test/path/child", "child", node);
        node.addChild(child);

        assertEquals(1, node.getChilds().size());
        assertEquals(child, node.getChilds().get(0));
        assertEquals(node, child.getParent());
    }
}
