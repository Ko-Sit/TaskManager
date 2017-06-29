package com.qulix.sitkinke.trainingtask.resource;

import java.util.ResourceBundle;

/**
 * Manager class that provides access to string resources by key.
 *
 * @author sitkin
 */
public class ConfigurationManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    /**
     * Instantiates a new Configuration Manager.
     *
     */
    private ConfigurationManager() {

    }

    /**
     * Returns string value of resources by provided key.
     *
     * @param key the key
     * @return the string
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}