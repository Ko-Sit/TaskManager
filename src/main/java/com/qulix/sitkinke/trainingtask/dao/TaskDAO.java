package com.qulix.sitkinke.trainingtask.dao;

import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.enums.State;
import com.qulix.sitkinke.trainingtask.managers.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by upsit on 12.06.2017.
 */
public class TaskDAO  {
    public static final String SQL_QUERY_ADD_TASK = "INSERT INTO TASKS (ID, NAME, DURATION, STARTDATE, ENDDATE, STATE) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SQL_QUERY_MODIFY_TASK = "UPDATE TASKS SET NAME = ?, DURATION = ?, STARTDATE = ?, ENDDATE = ?, STATE = ? WHERE ID = ?";
    public static final String SQL_QUERY_DELETE_TASK = "DELETE FROM TASKS WHERE ID = ?";
    public static final String SQL_QUERY_GET_ALL_TASKS = "SELECT * FROM TASKS";
    public static final String SQL_QUERY_GET_BY_ID = "SELECT * FROM TASKS WHERE ID = ?";
    public static final String SQL_QUERY_ADD_TASK_EXECUTORS = "INSERT INTO REFLIST_EMPL (ID_EMPLOYEE, ID_TASK) VALUES (?, ?)";
    public static final String SQL_QUERY_DELETE_TASK_EXECUTORS = "DELETE FROM REFLIST_EMPL WHERE ID_TASK = ?";

    public void addTask(Task task){
        addTaskExecutors(task.getId(), task.getEmployeeList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_TASK)){
            preparedStatement.setInt(1, task.getId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setInt(3, task.getDuration());
            preparedStatement.setDate(4, new java.sql.Date(task.getStartDate().getDate()));
            preparedStatement.setDate(5, new java.sql.Date(task.getEndDate().getDate()));
            preparedStatement.setString(6, task.getState().toString().toUpperCase());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add task");
            e.printStackTrace();
        }
    }

    private void addTaskExecutors(int id_task, List<Employee> employeeList) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_TASK_EXECUTORS)){
            for (Employee employee : employeeList) {
                int id_employee = employee.getId();
                preparedStatement.setInt(1, id_employee);
                preparedStatement.setInt(2, id_task);
                preparedStatement.executeUpdate();
            }
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add task executors");
            e.printStackTrace();
        }
    }

    public void modifyTask(Task task) {
        modifyTaskExecutors(task.getId(), task.getEmployeeList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_MODIFY_TASK)){
            preparedStatement.setString(1, task.getName());
            preparedStatement.setInt(2, task.getDuration());
            preparedStatement.setDate(3, new java.sql.Date(task.getStartDate().getDate()));
            preparedStatement.setDate(4, new java.sql.Date(task.getEndDate().getDate()));
            preparedStatement.setString(5, task.getState().toString());
            preparedStatement.setInt(6, task.getId());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during modify task");
            e.printStackTrace();
        }
    }

    private void modifyTaskExecutors(int id_task, List<Employee> employeeList) {
        deleteTaskExecutors(id_task);
        addTaskExecutors(id_task, employeeList);
    }


    public void deleteTask(int id) {
        deleteTaskExecutors(id);
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_TASK)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete task");
            e.printStackTrace();
        }
    }

    private void deleteTaskExecutors(int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_TASK_EXECUTORS)){
            preparedStatement.setInt(1, id_task);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete task executors");
            e.printStackTrace();
        }

    }

    public Task getById(int id){
        Task task;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                task = buildTask(resultSet);
            else
                return null;

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get by id task");
            e.printStackTrace();
            return null;
        }
        return task;
    }

    public List<Task> getAll(){
        List<Task> taskList = new ArrayList<>();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ALL_TASKS);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Task task = buildTask(resultSet);
                taskList.add(task);
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get all tasks");
            e.printStackTrace();
            return null;
        }
        return taskList;
    }

    private Task buildTask(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        int duration = resultSet.getInt(3);
        Date startDate = resultSet.getDate(4);
        Date endDate = resultSet.getDate(5);
        State state = State.valueOf(resultSet.getString(6).toUpperCase());

        return new Task(id, name, duration, startDate, endDate, state);
    }
}
