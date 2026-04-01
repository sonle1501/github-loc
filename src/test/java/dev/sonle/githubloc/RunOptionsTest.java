package dev.sonle.githubloc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import dev.sonle.githubloc.RunOptions.Mode;
import dev.sonle.githubloc.RunOptions.Action;
import dev.sonle.githubloc.RunOptions.SortArgument;;


public class RunOptionsTest {
    @Test
    void testParseLocalMode(){
        String args[] = {"local", "ghloc"};
        RunOptions options = RunOptions.parse(args);
        assertTrue(options.getMode().equals(Mode.LOCAL));
    }

    @Test
    void testParseRepoMode(){
        String args[] = {"sonle1501/github-loc"};
        RunOptions options = RunOptions.parse(args);
        assertTrue(options.getMode().equals(Mode.REPO));
    }

    @Test
    void testParseUserMode(){
        String args[] = {"sonle1501"};
        RunOptions options = RunOptions.parse(args);
        assertTrue(options.
            getMode().equals(Mode.USER));
    }
    @Test
    void testParseSortAction(){
        String args[] = {"sonle1501/github-loc", "-a", "sort"};
        RunOptions options = RunOptions.parse(args);
        assertAll(() -> options.getAction().equals(Action.SORT),
                  () -> options.getSortArgument().equals(SortArgument.ALL));
        
    }
    @Test
    void testParseSortArgument(){
        String args[] = {"sonle1501/github-loc", "-a", "sort", "bylang"};
        RunOptions options = RunOptions.parse(args);
        assertAll(() -> options.getAction().equals(Action.SORT),
                  () -> options.getSortArgument().equals(SortArgument.BYLANG));
        
    }

    @Test
    void testDefaultAction(){
        String args[] = {"sonle1501/github-loc"};
        RunOptions options = RunOptions.parse(args);
        assertAll(() -> options.getAction().equals(Action.DEFAULT));
        
    }

    @Test
    void testParseJsonAction(){
        String args[] = {"sonle1501/github-loc"};
        RunOptions options = RunOptions.parse(args);
        assertAll(() -> options.getAction().equals(Action.JSON));
        
    }

    @Test
    void testNoArgs() {
        String args[] = {};
        RunOptions options = RunOptions.parse(args);
        assertAll(()-> options.getMode().equals(Mode.REPO),
                  () -> options.getAction().equals(Action.DEFAULT));
    }

    @Test
    void testEmptyArgs() {
        String args[] = {""};
        assertThrows(IllegalArgumentException.class, ()->RunOptions.parse(args));
    }

    @Test
    void testWrongSplit() {
        String args[] = {"son/le/github"};
        assertThrows(IllegalArgumentException.class, ()->RunOptions.parse(args));
    }
}
