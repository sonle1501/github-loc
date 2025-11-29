package dev.sonle.githubloc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dev.sonle.githubloc.RunOptions.Action;
import dev.sonle.githubloc.RunOptions.SortBy;
import dev.sonle.githubloc.RunOptions.SortOrder;

public class RunOptionsTest {

    // default option is not static
    // @Test
    // void testParseDefault() {
    //     String[] args = {};
    //     RunOptions options = RunOptions.parse(args);
    //     assertNotNull(options);
    //     assertEquals("megumin1501", options.getUserName());
    //     assertEquals("Monty_Hall_Simulation", options.getRepoName());
    //     assertEquals(Action.ALL, options.getAction());
    // }

    @Test
    void testParseRepo() {
        String[] args = {"user/repo"};
        RunOptions options = RunOptions.parse(args);
        assertEquals("user", options.getUserName());
        assertEquals("repo", options.getRepoName());
    }

    @Test
    void testParseInvalidRepo() {
        String[] args = {"invalid-repo"};
        assertThrows(IllegalArgumentException.class, () -> RunOptions.parse(args));
    }

    @Test
    void testParseAction() {
        String[] args = {"user/repo", "--action", "JSON"};
        RunOptions options = RunOptions.parse(args);
        assertEquals(Action.JSON, options.getAction());

        args = new String[]{"user/repo", "-a", "DOWNLOAD"};
        options = RunOptions.parse(args);
        assertEquals(Action.DOWNLOAD, options.getAction());
    }

    @Test
    void testParseInvalidAction() {
        String[] args = {"user/repo", "--action", "INVALID"};
        assertThrows(IllegalArgumentException.class, () -> RunOptions.parse(args));
    }

    // sort funtion is not available
    
    // @Test
    // void testParseSort() {
    //     String[] args = {"user/repo", "--sort", "LOC"};
    //     RunOptions options = RunOptions.parse(args);
    //     assertEquals(SortBy.LOC, options.getSortBy());

    //     args = new String[]{"user/repo", "-s", "SIZE"};
    //     options = RunOptions.parse(args);
    //     assertEquals(SortBy.SIZE, options.getSortBy());
    // }

    // @Test
    // void testParseInvalidSort() {
    //     String[] args = {"user/repo", "--sort", "INVALID"};
    //     assertThrows(IllegalArgumentException.class, () -> RunOptions.parse(args));
    // }

    // @Test
    // void testParseOrder() {
    //     String[] args = {"user/repo", "--order", "DESC"};
    //     RunOptions options = RunOptions.parse(args);
    //     assertEquals(SortOrder.DESC, options.getSortOrder());

    //     args = new String[]{"user/repo", "-o", "ASC"};
    //     options = RunOptions.parse(args);
    //     assertEquals(SortOrder.ASC, options.getSortOrder());
    // }

    // @Test
    // void testParseInvalidOrder() {
    //     String[] args = {"user/repo", "--order", "INVALID"};
    //     assertThrows(IllegalArgumentException.class, () -> RunOptions.parse(args));
    // }
}
