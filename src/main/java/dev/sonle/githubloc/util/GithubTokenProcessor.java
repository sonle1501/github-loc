package dev.sonle.githubloc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GithubTokenProcessor {

  public static String getToken() {
    try (InputStream inputStream =
        GithubTokenProcessor.class.getClassLoader().getResourceAsStream("token.properties")) {
      if (inputStream == null) {
        return null;
      }
      Properties props = new Properties();
      props.load(inputStream);
      String token = props.getProperty("FINE_GRAINED_TOKEN");
      if (token != null && !token.trim().isEmpty()) {
        return token;
      }
    } catch (IOException e) {
      // return null, proceed without extrating token
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(GithubTokenProcessor.getToken());
  }
}
