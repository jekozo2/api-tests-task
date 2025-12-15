package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static enums.Constants.DEV_APPLICATION_PROPERTIES_FILE_PATH;
import static enums.Constants.TEST_APPLICATION_PROPERTIES_FILE_PATH;

@Slf4j
public class Helper {

    private static final String env;
    private static Properties INSTANCE;

    static {
        env = System.getProperty("env",
                System.getenv("ENVIRONMENT") != null ?
                        System.getenv("ENVIRONMENT") : "dev");
    }

    public static Properties getInstance() {
        if (INSTANCE == null) {
            return loadProperties();
        }
        return INSTANCE;
    }

    /**
     * The method returns loaded properties located on a particular file path
     *
     * @return the loaded properties
     */
    private static Properties loadProperties() {
        Properties properties = new Properties();

        String path = null;
        if (env.equals("dev")) {
            path = DEV_APPLICATION_PROPERTIES_FILE_PATH.getValue();
        } else if (env.equals("test")) {
            path = TEST_APPLICATION_PROPERTIES_FILE_PATH.getValue();
        } else {
            throw new IllegalArgumentException(String.format("Illegal environment: %s", env));
        }

        try {
            FileInputStream fis = new FileInputStream(path);

            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load properties " + e);

        }

        return properties;
    }
}
