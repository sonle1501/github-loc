package dev.sonle.githubloc.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GithubTokenProcessorTest {

    @Test
    void testGetToken() {
        // Without an actual token.properties file with valid token in test resources,
        // it should return null or correctly parse.
        // We will just call the method to ensure it doesn't throw unexpected exceptions.
        String token = GithubTokenProcessor.getToken();
        
        // Either true or false, but it shouldn't crash.
        assertTrue(token == null || !token.isEmpty());
    }
}
