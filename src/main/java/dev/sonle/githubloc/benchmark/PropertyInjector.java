package dev.sonle.githubloc.benchmark;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyInjector {

    public static String injectFromFile(String resourcePath, String propertyKey, String defaultValue) {
        try (InputStream inputStream =
                PropertyInjector.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream != null) {
                Properties props = new Properties();
                props.load(inputStream);
                String propValue = props.getProperty(propertyKey);
                if (propValue != null && !propValue.trim().isEmpty()) {
                    return propValue.trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
