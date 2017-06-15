package com.qulix.sitkinke.trainingtask.dao;

import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.managers.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by upsit on 12.06.2017.
 */
public class EmployeeDAO{

    public static final String SQL_QUERY_ADD_EMPLOYEE = "INSERT INTO EMPLOYEES (NAME, SURNAME, PATRONYMIC, POSITION) VALUES (?, ?, ?, ?)";
    public static final String SQL_QUERY_MODIFY_EMPLOYEE = "UPDATE EMPLOYEES SET NAME = ?, SURNAME = ?, PATRONYMIC = ?, POSITION = ? WHERE ID = ?";
    public static final String SQL_QUERY_DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE ID = ?";
    public static final String SQL_QUERY_GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEES";
    public static final String SQL_QUERY_GET_BY_ID = "SELECT * FROM EMPLOYEES WHERE ID = ?";
    public static final String SQL_QUERY_DELETE_EMPLOYEE_TASKS = "DELETE FROM REFLIST_EMPL WHERE ID_EMPLOYEE = ?";
    public static final String SQL_QUERY_GET_NEXT_ID = "SELECT ID FROM EMPLOYEES ORDER BY ID DESC LIMIT 1";

    public void addEmployee(Employee employee) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_EMPLOYEE)){
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPatronymic());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add employee");
            e.printStackTrace();
        }
    }

    public void modifyEmployee(Employee employee) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_MODIFY_EMPLOYEE)){
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPatronymic());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during modify employee");
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        deleteEmployeeTasks(id);
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_EMPLOYEE)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete employee");
            e.printStackTrace();
        }
    }

    private void deleteEmployeeTasks(int id_employee){
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_EMPLOYEE_TASKS)){
            preparedStatement.setInt(1, id_employee);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete employee tasks");
            e.printStackTrace();
        }
    }

    public Employee getById(int id){
        Employee employee;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                employee = buildEmployee(resultSet);
            else
                return null;

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get by id employee");
            e.printStackTrace();
            return null;
        }
        return employee;
    }

    public List<Employee> getAll(){
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Employee employee = buildEmployee(resultSet);
                employeeList.add(employee);
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get all employees");
            e.printStackTrace();
            return null;
        }
        return employeeList;
    }

    public int getNextId(){
        int id;
        int id_next;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_NEXT_ID);
            ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next())
                id = resultSet.getInt(1);
            else
                return 0;

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get next id employees");
            e.printStackTrace();
            return -1;
        }
        id_next = id + 1;
        return id_next;
    }

    private Employee buildEmployee(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String surname = resultSet.getString(3);
        String patronymic = resultSet.getString(4);
        String position = resultSet.getString(5);

        Employee employee = new Employee(name, surname, patronymic, position);
        employee.setId(id);
        return employee;
    }

}
