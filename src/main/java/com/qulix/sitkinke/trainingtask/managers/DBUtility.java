package com.qulix.sitkinke.trainingtask.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * Created by upsit on 16.06.2017.
 */
public class DBUtility {

    public static void resetAutoIncrement(String query) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            //preparedStatement.setString(1, tableName);
            //preparedStatement.setInt(1, id_next);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during reset autoincrement");
            e.printStackTrace();
        }
    }
}
