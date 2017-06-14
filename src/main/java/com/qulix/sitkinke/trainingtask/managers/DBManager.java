package com.qulix.sitkinke.trainingtask.managers;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * Created by upsit on 12.06.2017.
 */
public class DBManager {
    private static DBManager instance;

    private DBManager() {

    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("jdbcDriver not found!");
        }
        return DriverManager.getConnection(
               "jdbc:hsqldb:file:D:\\hsqldb-2.4.0\\/db", "ke", "qwe123");
    }

}
