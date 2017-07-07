package com.qulix.sitkinke.trainingtask.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Utility class that resets autoincrement in hsql database.
 *
 * @author sitkin
 */
public class DBUtility {

    /**
     * Resets table autoincrement.
     *
     * @param query the query
     */
    public static void resetAutoIncrement(String query) {
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("SQL exception occurred during reset autoincrement");
            e.printStackTrace();
        }
    }
}
