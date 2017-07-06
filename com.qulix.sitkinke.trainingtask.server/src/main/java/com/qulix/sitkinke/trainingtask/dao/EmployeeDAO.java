package com.qulix.sitkinke.trainingtask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.qulix.sitkinke.trainingtask.constants.ColumnNames;
import com.qulix.sitkinke.trainingtask.constants.SqlRequests;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.enums.UserType;
import com.qulix.sitkinke.trainingtask.exceptions.DaoException;
import com.qulix.sitkinke.trainingtask.managers.DBManager;
import com.qulix.sitkinke.trainingtask.managers.DBUtility;

/**
 * The DAO realisation for {@link Employee}.
 *
 * @author sitkin
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
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getPassword());
            preparedStatement.setString(7, employee.getUserType().toString());
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
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getPassword());
            preparedStatement.setString(7, employee.getUserType().toString());
            preparedStatement.setInt(8, employee.getId());
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

    /**
     * Deletes employee tasks.
     *
     * @param id_employee the employee id
     */
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

    /**
     * Builds employee entity.
     *
     * @param resultSet the resultSet with employee attributes
     * @return employee the new entity employee
     */
    private Employee buildEmployee(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ColumnNames.ID);
        String name = resultSet.getString(ColumnNames.EMPLOYEE_NAME);
        String surname = resultSet.getString(ColumnNames.EMPLOYEE_SURNAME);
        String patronymic = resultSet.getString(ColumnNames.EMPLOYEE_PATRONYMIC);
        String position = resultSet.getString(ColumnNames.EMPLOYEE_POSITION);
        String email = resultSet.getString(ColumnNames.EMPLOYEE_EMAIL);
        String password = resultSet.getString(ColumnNames.EMPLOYEE_PASSWORD);
        UserType userType = UserType.valueOf(resultSet.getString(ColumnNames.EMPLOYEE_USERTYPE).toUpperCase());

        Employee employee = new Employee(name, surname, patronymic, position, email, password, userType);
        employee.setId(id);
        return employee;
    }

    public boolean isAuthorized(String login, String password) {
        boolean isLogIn = false;
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.CHECK_AUTHORIZATION)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                    System.out.println(resultSet.getString(2));
                    isLogIn = true;
                }
            }
        }
        catch (SQLException e) {
            throw new DaoException("SQL exception occurred during check authorized employee", e);
        }
        return isLogIn;
    }

    public Employee getByLogin(String login) {
        Employee employee;
        try (Connection connection = DBManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_EMPLOYEE_BY_EMAIL)) {
            preparedStatement.setString(1, login);
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
            throw new DaoException("SQL exception occurred during get by email employee", e);
        }

        return employee;
    }
}
