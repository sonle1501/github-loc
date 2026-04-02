package dev.sonle.githubloc.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserInfoFetchingTest {

    @Test
    void testFetchRepoNamesSuccess() throws IOException, InterruptedException {
        UserInfoFetching fetcher = spy(new UserInfoFetching());

        String jsonResponse = "[{\"name\": \"repo1\"}, {\"name\": \"repo2\"}]";
        HttpResponse<String> mockResponse = mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn(jsonResponse);

        doReturn(mockResponse).when(fetcher).getResponse("user");

        List<String> repos = fetcher.fetchRepoNames("user");

        assertNotNull(repos);
        assertEquals(2, repos.size());
        assertEquals("repo1", repos.get(0));
        assertEquals("repo2", repos.get(1));
    }

    @Test
    void testFetchRepoNamesInvalidJson() throws IOException, InterruptedException {
        UserInfoFetching fetcher = spy(new UserInfoFetching());

        String jsonResponse = "{\"invalid_format\": \"not_array\"}";
        HttpResponse<String> mockResponse = mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn(jsonResponse);

        doReturn(mockResponse).when(fetcher).getResponse("user");

        List<String> repos = fetcher.fetchRepoNames("user");

        assertNull(repos); // As per method implementation, returns null if not an array
    }

    @Test
    void testFetchRepoNamesParsingError() throws IOException, InterruptedException {
        UserInfoFetching fetcher = spy(new UserInfoFetching());

        String malformedJson = "[{\"name\": \"repo1\"}";
        HttpResponse<String> mockResponse = mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn(malformedJson);

        doReturn(mockResponse).when(fetcher).getResponse("user");

        List<String> repos = fetcher.fetchRepoNames("user");

        assertNull(repos);
    }

    @Test
    void testFetchRepoNamesIoException() throws IOException, InterruptedException {
        UserInfoFetching fetcher = spy(new UserInfoFetching());

        doThrow(new IOException("Simulate network issue")).when(fetcher).getResponse("user");

        List<String> repos = fetcher.fetchRepoNames("user");

        assertNull(repos);
    }
}
