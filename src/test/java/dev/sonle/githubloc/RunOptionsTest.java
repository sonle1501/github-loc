package dev.sonle.githubloc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dev.sonle.githubloc.RunOptions.Action;

public class RunOptionsTest {

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
}
