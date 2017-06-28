package com.qulix.sitkinke.trainingtask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qulix.sitkinke.trainingtask.constants.ColumnNames;
import com.qulix.sitkinke.trainingtask.constants.SqlRequests;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.exceptions.DaoException;
import com.qulix.sitkinke.trainingtask.managers.DBManager;
import com.qulix.sitkinke.trainingtask.managers.DBUtility;

/**
 *
 * Created by upsit on 12.06.2017.
 */
public class EmployeeDAO implements IDao<Employee> {

    @Override
    public void add(Employee employee) {
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.ADD_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPatronymic());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during add employee", e);
        }
    }

    @Override
    public void modify(Employee employee) {
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.MODIFY_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPatronymic());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during modify employee", e);
        }
    }

    @Override
    public void delete(int id) {
        deleteEmployeeTasks(id);
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during delete employee", e);
        }
        finally {
            DBUtility.resetAutoIncrement(SqlRequests.RESET_EMPLOYEES_AUTO_INCREMENT + getNextId());
        }
    }

    private void deleteEmployeeTasks(int id_employee) {
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_EMPLOYEE_TASKS)) {
            preparedStatement.setInt(1, id_employee);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during delete employee tasks", e);
        }
    }

    @Override
    public Employee getById(int id) {
        Employee employee;
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_EMPLOYEES_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employee = buildEmployee(resultSet);
                }
                else {
                    return null;
                }
            }
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during get by id employee", e);
        }

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_ALL_EMPLOYEES);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = buildEmployee(resultSet);
                employeeList.add(employee);
            }
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during get all employees", e);
        }
        return employeeList;
    }

    @Override
    public int getNextId() {
        int id;
        int id_next;
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_NEXT_EMPLOYEE_ID);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                id = resultSet.getInt(ColumnNames.ID);
            }
            else {
                DBUtility.resetAutoIncrement(SqlRequests.RESET_EMPLOYEES_AUTO_INCREMENT + 1);
                return 1;
            }
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during get next id employees", e);
        }
        id_next = id + 1;
        return id_next;
    }

    private Employee buildEmployee(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ColumnNames.ID);
        String name = resultSet.getString(ColumnNames.EMPLOYEE_NAME);
        String surname = resultSet.getString(ColumnNames.EMPLOYEE_SURNAME);
        String patronymic = resultSet.getString(ColumnNames.EMPLOYEE_PATRONYMIC);
        String position = resultSet.getString(ColumnNames.EMPLOYEE_POSITION);

        Employee employee = new Employee(name, surname, patronymic, position);
        employee.setId(id);
        return employee;
    }

}
