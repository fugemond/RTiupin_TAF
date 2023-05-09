package utility;

import com.google.common.base.Strings;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static java.util.Objects.*;

public class PropertiesLoader {

    private static final String PROPERTIES_FILE = "/properties/application.properties";
    private static final String TEST_DATA_FILE = "/properties/testdata.properties";
    private static final Properties PROPERTIES = getPropertiesInstance(PROPERTIES_FILE);

    private PropertiesLoader() {
        throw new IllegalStateException("Utility class");
    }

    @SneakyThrows(IOException.class)
    private static Properties getPropertiesInstance(String propertiesFile) {
        Properties instance = new Properties();
        try (
                InputStream resourceStream = PropertiesLoader.class.getResourceAsStream(propertiesFile);
                InputStreamReader inputStream = new InputStreamReader(resourceStream, StandardCharsets.UTF_8)
        ) {
            instance.load(inputStream);
        }
        String env = loadSystemPropertyOrDefault("env",instance.getProperty("env"));
        String propertyPath = String.format("/properties/%s/testData.properties", env);
        try (
                InputStream resourceStream = PropertiesLoader.class.getResourceAsStream(propertyPath);
                InputStreamReader inputStream = new InputStreamReader(resourceStream, StandardCharsets.UTF_8)
        ) {
            instance.load(inputStream);
        }
        return instance;
    }

    @SneakyThrows
    public static String tryGetPropertyOrDefault(String propertyName) {
        if (Strings.isNullOrEmpty(propertyName)) {
            throw new IllegalArgumentException("Provided property should not be Empty or Null");
        }

        String systemProperty = System.getProperty(propertyName);
        String applicationProperty = PROPERTIES.getProperty(propertyName);

        if (systemProperty != null) {
            return systemProperty;
        }
        return requireNonNullElse(applicationProperty,propertyName);
    }

    @SneakyThrows
    public static String tryGetPropertyOrDefault(String propertyName,String valueToReturn) {
        if (Strings.isNullOrEmpty(propertyName)) {
            throw new IllegalArgumentException("Provided property should not be Empty or Null");
        }

        String systemProperty = System.getProperty(propertyName);
        String applicationProperty = PROPERTIES.getProperty(propertyName);

        if (systemProperty != null) {
            return systemProperty;
        }
        return requireNonNullElse(applicationProperty,valueToReturn);
    }


    public static String loadSystemPropertyOrDefault(String propertyName, String defaultValue) {
        String propValue = System.getProperty(propertyName);
        return propValue != null ? propValue : defaultValue;
    }
}