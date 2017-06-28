package com.qulix.sitkinke.trainingtask.resource;

import java.util.ResourceBundle;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class ConfigurationManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    // класс извлекает информацию из файла config. properties
    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}