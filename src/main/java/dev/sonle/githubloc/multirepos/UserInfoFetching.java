package dev.sonle.githubloc.multirepos;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dev.sonle.githubloc.api.RepoDownloader;
import dev.sonle.githubloc.util.GithubTokenProcessor;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class UserInfoFetching {

    public List<String> fetchRepoNames(String userName) {
        List<String> repos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            HttpResponse<String> response = getResponse(userName);

            try {
                JsonNode rootNode = mapper.readTree(response.body());

                if (rootNode.isArray()) {
                    for (JsonNode repoNode : rootNode) {
                        repos.add(repoNode.get("name").asString());
                    }
                } else {
                    System.err.println("Failed to fetch repo names");
                    System.err.println("Response Body: " + response.body());
                    return null;
                }

            } catch (JacksonException e) {
                System.err.println("JSON parsing error while reading response");
                System.err.println("Error: " + e.getMessage());
                return null;
            }

        } catch (IOException e) {
            System.err.println("IO error while fetching response");
            System.err.println("Error: " + e.getMessage());
            return null;

        } catch (InterruptedException e) {
            System.err.println("Request was interrupted");
            Thread.currentThread().interrupt(); // good practice
            return null;
        }
        return repos;
    }

    private HttpResponse<String> makeRequest(String url, String bearerToken) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS) // must follow the redirect (instead, recieve 307 status
                                                             // code)
                .build();

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(URI.create(url)).GET().header("Accept",
                "application/vnd.github+json");

        if (bearerToken != null) { // if using token
            requestBuilder.header("Authorization", String.format("Bearer %s", bearerToken));
        }
        return client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getResponse(String userName) throws IOException, InterruptedException {
        String repoUrl = getUserAPI(userName);
        String bearerToken = getbearerToken();
        HttpResponse<String> response = makeRequest(repoUrl, bearerToken);
        int statusCode = response.statusCode();
        if (statusCode == 200) {
            return response;
        }
        if (bearerToken != null && (statusCode == 401 || statusCode == 403)) { // 401 (unauthorized) 403 (Forbidden)
            response = makeRequest(repoUrl, null);
            if (response.statusCode() == 200)
                return response;
        }
        throw new IOException("GitHub API rejected the request with HTTP status code : " + response.statusCode());
    }

    private String getUserAPI(String userName) {
        return "https://api.github.com/users/" + userName + "/repos?per_page=100"; // max 100 repos per user
    }

    private String getbearerToken() {
        return GithubTokenProcessor.getToken();
    }

    public class UserRepoDownloadException extends RuntimeException {
        public UserRepoDownloadException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) {
    }
}
