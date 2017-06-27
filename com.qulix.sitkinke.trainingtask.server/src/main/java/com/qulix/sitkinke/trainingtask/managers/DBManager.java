package com.qulix.sitkinke.trainingtask.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        long start = System.currentTimeMillis();

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("jdbcDriver not found!");
        }

        //Connection connection =  DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/database", "sa", "");
        Connection connection =  DriverManager.getConnection("jdbc:hsqldb:file:D:\\IdeaProjects\\maanager\\db/db", "ke", "qwe123");
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        return connection;
    }

}
