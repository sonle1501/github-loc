package dev.sonle.githubloc.execution;

import static org.junit.jupiter.api.Assertions.*;

import dev.sonle.githubloc.execution.CliParser;
import dev.sonle.githubloc.execution.RunConfig;
import dev.sonle.githubloc.exception.GithubLocException;
import dev.sonle.githubloc.exception.ErrorCode;
import org.junit.jupiter.api.Test;

public class CliParserTest {

    @Test
    void testParseLocalMode(){
        String args[] = {"local", "ghloc"};
        RunConfig config = CliParser.parse(args);
        assertEquals(RunConfig.Mode.LOCAL, config.getMode());
        assertEquals("ghloc", config.getRepoName());
        assertEquals(RunConfig.Action.DEFAULT, config.getAction());
    }

    @Test
    void testParseRepoMode(){
        String args[] = {"sonle1501/github-loc"};
        RunConfig config = CliParser.parse(args);
        assertEquals(RunConfig.Mode.REPO, config.getMode());
        assertEquals("sonle1501", config.getUserName());
        assertEquals("github-loc", config.getRepoName());
        assertEquals(RunConfig.Action.DEFAULT, config.getAction());
    }

    @Test
    void testParseUserMode(){
        String args[] = {"sonle1501"};
        RunConfig config = CliParser.parse(args);
        assertEquals(RunConfig.Mode.USER, config.getMode());
        assertEquals("sonle1501", config.getUserName());
        assertNull(config.getRepoName());
    }

    @Test
    void testParseSortAction(){
        String args[] = {"sonle1501/github-loc", "-a", "sort"};
        RunConfig config = CliParser.parse(args);
        assertAll(
            () -> assertEquals(RunConfig.Action.SORT, config.getAction()),
            () -> assertEquals(RunConfig.SortArgument.ALL, config.getSortArgument())
        );
    }

    @Test
    void testParseSortArgument(){
        String args[] = {"sonle1501/github-loc", "-a", "sort", "bylang"};
        RunConfig config = CliParser.parse(args);
        assertAll(
            () -> assertEquals(RunConfig.Action.SORT, config.getAction()),
            () -> assertEquals(RunConfig.SortArgument.BYLANG, config.getSortArgument())
        );
    }

    @Test
    void testParseJsonAction(){
        String args[] = {"sonle1501/github-loc", "-a", "json"};
        RunConfig config = CliParser.parse(args);
        assertEquals(RunConfig.Action.JSON, config.getAction());
    }

    @Test
    void testNoArgs() {
        String args[] = {};
        RunConfig config = CliParser.parse(args);
        assertEquals(RunConfig.Mode.DEFAULT, config.getMode());
    }

    @Test
    void testWrongSplit() {
        String args[] = {"son/le/github"};
        GithubLocException exception = assertThrows(GithubLocException.class, ()->CliParser.parse(args));
        assertEquals(ErrorCode.INVALID_INPUT, exception.getErrorCode());
    }
}
