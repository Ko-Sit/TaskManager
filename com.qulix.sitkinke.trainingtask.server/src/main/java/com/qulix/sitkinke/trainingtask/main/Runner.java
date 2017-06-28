package com.qulix.sitkinke.trainingtask.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

    public static void main(String[] args) {

        // Загружаем класс драйвера
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("НЕ удалось загрузить драйвер ДБ.");
            e.printStackTrace();
            System.exit(1);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                "jdbc:hsqldb:file:D:\\hsqldb-2.4.0\\/db", "ke", "qwe123");
        }
        catch (SQLException e) {
            System.err.println("НЕ удалось создать соединение.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            // добавляю записи в таблицу.
            Statement statement;
            String query;
            ResultSet resultSet;

            statement = connection.createStatement();
            query = "UPDATE TASKS SET NAME = 'ddk' WHERE ID = 5";
            resultSet = statement.executeQuery(query);
            // распечатываю
            while (resultSet.next()) {
                String str = resultSet.getString(1);
                System.out.println(str);
            }
            statement.close();

            // отключаюсь от БД
            statement = connection.createStatement();
            query = "SHUTDOWN";
            statement.execute(query);
            statement.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}