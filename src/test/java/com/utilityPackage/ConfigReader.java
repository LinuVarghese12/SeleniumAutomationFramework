package com.utilityPackage;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static final Properties props = new Properties();

    static {
        try (InputStream in = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {                                   //Loads config.properites
            if (in == null) throw new RuntimeException("config.properties not found");         //If the file is missing or can’t be read, it fails fast by throwing a RuntimeException.
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static int getInt(String key) {
        String val = props.getProperty(key);
        if (val == null) throw new RuntimeException(key + " not defined");
        return Integer.parseInt(val);
    }
}
