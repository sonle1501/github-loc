package dev.sonle.githubloc.sort;

import dev.sonle.githubloc.tree.FileNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FilesSorterTest {

    private FilesSorter sorter;
    private Map<String, FileNode> nodeContainer;

    @BeforeEach
    void setUp() {
        sorter = new FilesSorter();
        nodeContainer = new HashMap<>();
    }

    @Test
    void testSortNodeContainerByLoc() {
        FileNode node1 = new FileNode("file1.java");
        node1.setLoc(50);
        
        FileNode node2 = new FileNode("file2.java");
        node2.setLoc(150);
        
        FileNode node3 = new FileNode("file3.java");
        node3.setLoc(100);

        // Folders should be filtered out
        FileNode folder = new FileNode("srcDir");
        folder.setLoc(500);
        folder.addChild(node1); // makes it a folder

        nodeContainer.put("file1.java", node1);
        nodeContainer.put("file2.java", node2);
        nodeContainer.put("file3.java", node3);
        nodeContainer.put("srcDir", folder);

        List<FileNode> sorted = sorter.sortNodeContainerByLoc(nodeContainer);

        assertEquals(3, sorted.size()); // Folder excluded
        assertEquals(150, sorted.get(0).getLoc());
        assertEquals(100, sorted.get(1).getLoc());
        assertEquals(50, sorted.get(2).getLoc());
    }

    @Test
    void testSortNodeSameLanguage() {
        FileNode node1 = new FileNode("file1.java");
        node1.setLoc(50);
        node1.getLocByLang().put("Java", 50);

        FileNode node2 = new FileNode("file2.py");
        node2.setLoc(150);
        node2.getLocByLang().put("Python", 150);

        FileNode node3 = new FileNode("file3.java");
        node3.setLoc(200);
        node3.getLocByLang().put("Java", 200);

        nodeContainer.put("file1.java", node1);
        nodeContainer.put("file2.py", node2);
        nodeContainer.put("file3.java", node3);

        List<FileNode> sorted = sorter.sortNodeSameLanguage(nodeContainer, "Java");

        assertEquals(2, sorted.size());
        assertEquals(200, sorted.get(0).getLoc());
        assertEquals(50, sorted.get(1).getLoc());
    }

    @Test
    void testSortNodeByLang() {
        FileNode root = new FileNode("root");
        root.getLocByLang().put("Java", 250);
        root.getLocByLang().put("Python", 150);

        FileNode node1 = new FileNode("file1.java");
        node1.setLoc(50);
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("Java");
        node1.setLanguageSet(set1);
        
        FileNode node2 = new FileNode("file2.java");
        node2.setLoc(200);
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("Java");
        node2.setLanguageSet(set2);

        FileNode node3 = new FileNode("file3.py");
        node3.setLoc(150);
        Set<String> set3 = new LinkedHashSet<>();
        set3.add("Python");
        node3.setLanguageSet(set3);

        nodeContainer.put("file1", node1);
        nodeContainer.put("file2", node2);
        nodeContainer.put("file3", node3);

        Map<String, List<FileNode>> sortedMap = sorter.sortNodeByLang(nodeContainer, root);

        assertEquals(2, sortedMap.size());
        
        // Java should be first because rooted total is higher
        String firstLang = sortedMap.keySet().iterator().next();
        assertEquals("Java", firstLang);

        List<FileNode> javaList = sortedMap.get("Java");
        assertEquals(2, javaList.size());
        assertEquals(200, javaList.get(0).getLoc()); // Java nodes sorted internally
        assertEquals(50, javaList.get(1).getLoc());

        List<FileNode> pythonList = sortedMap.get("Python");
        assertEquals(1, pythonList.size());
        assertEquals(150, pythonList.get(0).getLoc());
    }
}
