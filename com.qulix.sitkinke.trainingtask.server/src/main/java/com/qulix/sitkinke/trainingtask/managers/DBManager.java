package com.qulix.sitkinke.trainingtask.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manager class that provides access to database.
 *
 * @author sitkin
 */
public class DBManager {

    private static DBManager instance;

    /**
     * Instantiates a new DBManager.
     *
     */
    private DBManager() {

    }

    /**
     * Gets DBManager instance.
     *
     *@return the instance
     */
    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * Returns database connection of resources by provided key.
     *
     * @return the connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("jdbcDriver not found!");
        }

        Connection connection =  DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/database", "sa", "");
        //Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:D:\\IdeaProjects\\maanager\\db/db", "ke", "qwe123");
        return connection;
    }
}
