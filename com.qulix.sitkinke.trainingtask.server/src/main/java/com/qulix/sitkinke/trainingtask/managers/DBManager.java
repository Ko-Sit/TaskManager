package com.qulix.sitkinke.trainingtask.managers;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
/**
 * Manager class that provides access to database.
 *
 * @author sitkin
 */
public class DBManager {

    private static DBManager instance;
    private BasicDataSource dataSource;

    /**
     * Instantiates a new DBManager.
     *
     */
    private DBManager() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost:9001/database");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(20);
        dataSource.setMaxOpenPreparedStatements(180);
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
        return this.dataSource.getConnection();
    }
}
