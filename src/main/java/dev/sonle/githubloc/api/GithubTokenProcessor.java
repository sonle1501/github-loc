package dev.sonle.githubloc.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GithubTokenProcessor {

public static String getToken() {  // if this function cannot get, continue the process without token
    String token;

    // Priority 1: Check the Current Working Directory 
    token = getTokenFromFileSystem();
    if (token != null) {
      return token;
    }

    // Priority 2: Check the source
    token = getTokenFromResources();
    if (token != null) {
      return token;
    }

    System.out.println("fetching github api without token");
    return null;
  }

  private static String getTokenFromResources() {
    // place token.properties at "src/main/resources/" -> so at runtime we have : target/classes/token.properties
    // if place at "src/main/resources/config/token.properties" -> use getResourceAsStream("config/token.properties");
    try (InputStream inputStream = GithubTokenProcessor.class.getClassLoader().getResourceAsStream("token.properties")) {
      if (inputStream != null) {
        Properties props = new Properties();
        props.load(inputStream);
        String token = props.getProperty("FINE_GRAINED_TOKEN");
        
        if (token != null && !token.trim().isEmpty()) {
          return token.trim();
        }
      }
    } catch (IOException e) {
      // Silently catch and return null
    }
    return null;
  }

  private static String getTokenFromFileSystem() {
    Path tokenPath = Paths.get("token.properties");
    
    if (Files.exists(tokenPath)) {
      try (InputStream inputStream = new FileInputStream(tokenPath.toFile())) {
        Properties props = new Properties();
        props.load(inputStream);
        String token = props.getProperty("FINE_GRAINED_TOKEN");
        
        if (token != null && !token.trim().isEmpty()) {
          return token.trim();
        }
      } catch (IOException e) {
        // Silently catch and return null
      }
    }

    // more option : user can use .txt file
    Path txtTokenPath = Paths.get("token.txt");
    if (Files.exists(txtTokenPath)) {
      try {
        // Reads the entire file content as the token
        String token = Files.readString(txtTokenPath);
        if (token != null && !token.trim().isEmpty()) {
          return token.trim();
        }
      } catch (IOException e) {
        // Silently catch and return null
      }
    }

    return null;
  }

  public static void main(String[] args) {
    System.out.println(GithubTokenProcessor.getToken());
  }
}
