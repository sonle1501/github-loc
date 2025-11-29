package dev.sonle.githubloc.api;

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

import dev.sonle.githubloc.util.GithubTokenProcessor;

public class RepoDownloader {
  public static HttpResponse<InputStream> call(String userName, String repoName) {
    HttpClient client =
        HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS) // must follow the redirect (instead, recieve 307 status code)
            .build();

    String bearerToken = GithubTokenProcessor.getToken();
    
    String url = "https://api.github.com/repos/" + userName + "/" + repoName + "/zipball"; 
    // example "https://api.github.com/repos/cthing/locc4j/zipball";

    HttpRequest.Builder requestBuilder =
        HttpRequest.newBuilder(URI.create(url)).GET().header("Accept", "application/vnd.github+json");

    if (bearerToken != null) {    // if not using token
      requestBuilder.header("Authorization", String.format("Bearer %s", bearerToken));
    }

    try {
      HttpResponse<InputStream> response =
          client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofInputStream());

      if (response.statusCode() == 200) {
        return response;
      } else if ((response.statusCode() == 401 || response.statusCode() == 403) // 401 (unauthorized) 403 (Forbidden)
          && bearerToken != null) {
        System.out.println("Token invalid or access forbidden. Retrying without authentication...");
        HttpRequest retryRequest =
            HttpRequest.newBuilder(URI.create(url))
                .GET()
                .header("Accept", "application/vnd.github+json")
                .build();
        response = client.send(retryRequest, HttpResponse.BodyHandlers.ofInputStream());

        if (response.statusCode() == 200) {
          return response;
        }
      }

      System.err.println("Error: Received status code " + response.statusCode());
      return null;
    } catch (IOException | InterruptedException e) {
      System.err.println("Request failed: " + e.getMessage());
      Thread.currentThread().interrupt();
      return null;
    }
  }

  public static void locate(String target, String userName, String repoName) throws IOException {
    HttpResponse<InputStream> response = RepoDownloader.call(userName, repoName);
    InputStream repoContent = response.body();
    long bytesCopied =
        Files.copy(repoContent, Paths.get(target), StandardCopyOption.REPLACE_EXISTING);
    System.out.println("Successfully saved ~" + bytesCopied / 1000 + "KB at " + target);
  }
}
