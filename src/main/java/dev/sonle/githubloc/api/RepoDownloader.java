package dev.sonle.githubloc.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import dev.sonle.githubloc.util.GithubTokenProcessor;

public class RepoDownloader {
  
  public void downloadRepo(Path location, String userName, String repoName){
    try{
      HttpResponse<InputStream> response = getResponse(userName, repoName);
      try (InputStream repoContent = response.body()){
        locateRepo(location, repoContent);
      }
    }
    catch(IOException | InterruptedException e){
        throw new RepoDownloadException("Failed to download repo", e);
    }
  }

  private HttpResponse<InputStream> makeRequest(String url, String bearerToken) throws IOException, InterruptedException{
    HttpClient client =
        HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS) // must follow the redirect (instead, recieve 307 status code)
            .build();
    
    HttpRequest.Builder requestBuilder =
        HttpRequest.newBuilder(URI.create(url)).GET().header("Accept", "application/vnd.github+json");

    if (bearerToken != null) {    // if using token
      requestBuilder.header("Authorization", String.format("Bearer %s", bearerToken));
    }
    return client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofInputStream());
  }

  public HttpResponse<InputStream> getResponse(String userName, String repoName) throws IOException, InterruptedException {
    String repoUrl = getRepoUrl(userName, repoName);
    String bearerToken = getbearerToken();
    HttpResponse<InputStream> response = makeRequest(repoUrl, bearerToken);
    int statusCode = response.statusCode();
    if (statusCode==200){
      return response;
    }
    if (bearerToken != null && (statusCode == 401 || statusCode == 403)) { // 401 (unauthorized) 403 (Forbidden)
      response = makeRequest(repoUrl, null);
      if (response.statusCode() == 200)
        return response;
    }
    throw new IOException("GitHub API rejected the request with HTTP status code : " + response.statusCode());
  }

  private String getRepoUrl(String userName, String repoName){
    return "https://api.github.com/repos/" + userName + "/" + repoName + "/zipball"; 
  }

  private String getbearerToken(){
    return GithubTokenProcessor.getToken();
  }

  private void locateRepo(Path location, InputStream repoContent) throws IOException {
    long bytesCopied =
        Files.copy(repoContent, location, StandardCopyOption.REPLACE_EXISTING);
    System.out.println("Successfully saved ~" + bytesCopied / 1000 + "KB at " + location);
  }

  public class RepoDownloadException extends RuntimeException {
    public RepoDownloadException(String message, Throwable cause) {
        super(message, cause);
    }
  } 
}
