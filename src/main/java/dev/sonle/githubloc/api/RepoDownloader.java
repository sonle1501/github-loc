package dev.sonle.githubloc.api;

import dev.sonle.githubloc.filesystem.SizeFormatter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import lombok.extern.slf4j.Slf4j;

import dev.sonle.githubloc.exception.ErrorCode;
import dev.sonle.githubloc.exception.GithubLocException;

@Slf4j
public class RepoDownloader {

    public long downloadRepo(Path location, String userName, String repoName) {
        try {
            HttpResponse<InputStream> response = getResponse(userName, repoName);
            try (InputStream repoContent = response.body()) {
                long downloadedSize = locateRepo(location, repoContent);
                return downloadedSize;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new GithubLocException(ErrorCode.INTERRUPTED, "Repository download was interrupted", e);
        } catch (IOException e) {
            throw new GithubLocException(ErrorCode.REPO_DOWNLOAD_FAILED, "I/O error during download", e);
        }
    }

    private HttpResponse<InputStream> makeRequest(String url, String bearerToken)
            throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(
                        HttpClient.Redirect.ALWAYS) // must follow the redirect (instead, recieve 307 status code)
                .build();

        HttpRequest.Builder requestBuilder =
                HttpRequest.newBuilder(URI.create(url)).GET().header("Accept", "application/vnd.github+json");

        if (bearerToken != null) { // if using token
            requestBuilder.header("Authorization", String.format("Bearer %s", bearerToken));
        }
        return client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofInputStream());
    }

    public HttpResponse<InputStream> getResponse(String userName, String repoName)
            throws IOException, InterruptedException {
        String repoUrl = getRepoUrl(userName, repoName);
        String bearerToken = getbearerToken();
        HttpResponse<InputStream> response = makeRequest(repoUrl, bearerToken);
        int statusCode = response.statusCode();
        if (statusCode == 200) {
            return response;
        }
        if (bearerToken != null && (statusCode == 401 || statusCode == 403)) { // 401 (unauthorized) 403 (Forbidden)
            response = makeRequest(repoUrl, null);
            if (response.statusCode() == 200) return response;
        }
        throw new GithubLocException(ErrorCode.REPO_DOWNLOAD_FAILED, "GitHub API rejected the request with HTTP status code : " + response.statusCode());
    }

    private String getRepoUrl(String userName, String repoName) {
        return "https://api.github.com/repos/" + userName + "/" + repoName + "/zipball";
    }

    private String getbearerToken() {
        return GithubTokenProcessor.getToken();
    }

    private long locateRepo(Path location, InputStream repoContent) throws IOException {
        long bytesCopied = Files.copy(repoContent, location, StandardCopyOption.REPLACE_EXISTING);
        log.info("Successfully saved ~{} at {}", new SizeFormatter().convertSize(bytesCopied), location);
        return bytesCopied;
    }

    public static void main(String[] args) {
        RepoDownloader downloader = new RepoDownloader();
        downloader.downloadRepo(Paths.get("storage/repos/github-loc"), "sonle1501", "github-loc");
        log.info("Initialized RepoDownloader for testing. {}", downloader);
    }
}
