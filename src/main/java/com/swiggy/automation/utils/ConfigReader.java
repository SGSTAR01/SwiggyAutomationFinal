package com.swiggy.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.swiggy.automation.constants.FrameworkConstants;

public class ConfigReader {
    private static Properties properties;

    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config properties file");
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadConfig();
        }
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key, int defaultValue) {
        String val = getProperty(key);
        if (val == null || val.isEmpty()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        String val = getProperty(key);
        if (val == null || val.isEmpty()) {
            return defaultValue;
        }
        return Boolean.parseBoolean(val);
    }
}
