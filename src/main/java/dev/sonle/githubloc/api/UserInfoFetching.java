package dev.sonle.githubloc.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;

@Slf4j
public class UserInfoFetching {
    private final ObjectMapper mapper;

    public UserInfoFetching(){
        mapper = new ObjectMapper();
    }

    public List<String> fetchRepoNames(String userName) {
        List<String> repos = new ArrayList<>();
        try {
            HttpResponse<String> response = getResponse(userName);
            if (response.statusCode() == 404) {
                throw new GithubLocException(ErrorCode.GITHUB_API_ERROR, "Github user '" + userName + "' not found.");
            } else if (response.statusCode() == 403) {
                throw new GithubLocException(ErrorCode.UNEXPECTED_ERROR, "Rate limited by GitHub API. Please try again later.");
            } else if (response.statusCode() != 200) {
                throw new GithubLocException(ErrorCode.UNEXPECTED_ERROR, "Unexpected HTTP status: " + response.statusCode());
            }

            JsonNode rootNode = mapper.readTree(response.body());

            if (!rootNode.isArray()) {
                throw new GithubLocException(ErrorCode.JSON_PROCESSING_ERROR, "Unexpected GitHub API payload while fetching Github user info");
            }

            for (JsonNode repoNode : rootNode) {
                repos.add(repoNode.get("name").asString());
            }

            if (repos.isEmpty()) {
                throw new GithubLocException(ErrorCode.UNEXPECTED_ERROR, "User '" + userName + "' has 0 public repositories.");
            }

            return repos;

        } catch (JacksonException e) {
            throw new GithubLocException(ErrorCode.JSON_PROCESSING_ERROR, "Failed to parse repository data from Github while fetching Github user info", e);
        } catch (IOException e) {
            throw new GithubLocException(ErrorCode.UNEXPECTED_ERROR, "Network error occurred while fetching Github user info", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new GithubLocException(ErrorCode.INTERRUPTED, "Github user info fetch operation was interrupted", e);
        }
    }

    private HttpResponse<String> makeRequest(String url, String bearerToken) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS) // must follow the redirect (instead, recieve 307 status
                // code)
                .build();

        HttpRequest.Builder requestBuilder =
                HttpRequest.newBuilder(URI.create(url)).GET().header("Accept", "application/vnd.github+json");

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
            if (response.statusCode() == 200) return response;
        }
        throw new GithubLocException(ErrorCode.UNEXPECTED_ERROR, "Github API rejected the request with HTTP status code : " + response.statusCode());
    }

    private String getUserAPI(String userName) {
        return "https://api.github.com/users/" + userName + "/repos?per_page=100"; // max 100 repos per user
    }

    private String getbearerToken() {
        return GithubTokenProcessor.getToken();
    }

    public static void main(String[] args) {
        UserInfoFetching fetcher = new UserInfoFetching();
        try {
            log.info(
                    "Testing UserInfoFetching (fetching repos for sonle1501): {}", fetcher.fetchRepoNames("sonle1501"));
        } catch (Exception e) {
            log.error("Failed to fetch: {}", e.getMessage());
        }
    }
}
