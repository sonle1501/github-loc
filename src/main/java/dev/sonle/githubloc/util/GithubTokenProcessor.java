package dev.sonle.githubloc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GithubTokenProcessor {

  public static String getToken() { // if this function cannot get, continue the process without token
    try (InputStream inputStream =
        GithubTokenProcessor.class.getClassLoader().getResourceAsStream("token.properties")) {
      if (inputStream == null) {
        System.out.println("there is no github token");
        return null;
      }
      Properties props = new Properties();
      props.load(inputStream);
      String token = props.getProperty("FINE_GRAINED_TOKEN");
      if (token != null && !token.trim().isEmpty()) {
        return token;
      }
    }
    catch (IOException e) {
      System.out.println("there is no github token");
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(GithubTokenProcessor.getToken());
  }
}
