package com.qulix.sitkinke.trainingtask.dao;

import com.qulix.sitkinke.trainingtask.constants.SqlRequests;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.enums.State;
import com.qulix.sitkinke.trainingtask.managers.DBManager;
import com.qulix.sitkinke.trainingtask.managers.DBUtility;

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

    public void addTask(Task task){
        addTaskExecutors(task.getId(), task.getEmployeeList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.ADD_TASK)){
            preparedStatement.setString(1, task.getName());
            preparedStatement.setInt(2, task.getDuration());
            preparedStatement.setDate(3, new java.sql.Date(task.getStartDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(task.getEndDate().getTime()));
            preparedStatement.setString(5, task.getState().toString().toUpperCase());
            preparedStatement.setString(6, task.getProjectName());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add task");
            e.printStackTrace();
        }
    }

    private void addTaskExecutors(int id_task, List<Employee> employeeList) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.ADD_TASK_EXECUTORS)){
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.MODIFY_TASK)){
            preparedStatement.setString(1, task.getName());
            preparedStatement.setInt(2, task.getDuration());
            preparedStatement.setDate(3, new java.sql.Date(task.getStartDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(task.getEndDate().getTime()));
            preparedStatement.setString(5, task.getState().toString());
            preparedStatement.setString(6, task.getProjectName());
            preparedStatement.setInt(7, task.getId());
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

    public void modifyProjectNameInTask(String projectAbbreviation, int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.MODIFY_PROJECT_ABBR)){
                preparedStatement.setString(1, projectAbbreviation);
                preparedStatement.setInt(2, id_task);
                preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred modify task project abbr");
            e.printStackTrace();
        }
    }

    public void deleteTask(int id) {
        deleteTaskExecutors(id);
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_TASK)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete task");
            e.printStackTrace();
        }
        DBUtility.resetAutoIncrement(SqlRequests.RESET_TASKS_AUTO_INCREMENT + getNextId());
    }

    public List<Integer> getTasksByProjectAbbr(String projectAbbr){
        List<Integer> taskList = new ArrayList<>();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_TASKS_BY_PROJECT_ABBR)){
            preparedStatement.setString(1, projectAbbr);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                taskList.add(resultSet.getInt(1));
            }
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get tasks by project abbr");
            e.printStackTrace();
        }
        return taskList;
    }

    public void deleteTasksByProjectAbbr(String projectAbbr) {
        List<Integer> taskList = getTasksByProjectAbbr(projectAbbr);
        for (Integer id_task: taskList){
            deleteTaskExecutors(id_task);
        }
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_TASKS_BY_PROJECT_ABBR)){
            preparedStatement.setString(1, projectAbbr);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete tasks by project abbr");
            e.printStackTrace();
        }
    }

    private void deleteTaskExecutors(int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_TASK_EXECUTORS)){
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_TASKS_BY_ID)){
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_ALL_TASKS);
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

    public List<Employee> getTaskExecutors(int id_task){
        List<Employee> employeeList = new ArrayList<>();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_TASK_EXECUTORS)){
            preparedStatement.setInt(1, id_task);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = employeeDAO.getById(resultSet.getInt(1));
                employeeList.add(employee);
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get task executors");
            e.printStackTrace();
            return null;
        }
        return employeeList;
    }

    public int getNextId(){
        int id;
        int id_next;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_NEXT_TASK_ID);
            ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next())
                id = resultSet.getInt(1);
            else {
                DBUtility.resetAutoIncrement(SqlRequests.RESET_TASKS_AUTO_INCREMENT + 1);
                System.out.println("resetting");
                return 1;
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get next id tasks");
            e.printStackTrace();
            return -1;
        }
        id_next = id + 1;
        return id_next;
    }

    private Task buildTask(ResultSet resultSet) throws SQLException {
        int id_task = resultSet.getInt(1);
        String name = resultSet.getString(2);
        int duration = resultSet.getInt(3);
        Date startDate = resultSet.getDate(4);
        Date endDate = resultSet.getDate(5);
        State state = State.valueOf(resultSet.getString(6).toUpperCase());
        String projectName = resultSet.getString(7);
        List<Employee> employees = getTaskExecutors(id_task);

        Task task = new Task(name, duration, startDate, endDate, state, projectName);
        task.setId(id_task);
        task.setEmployeeList(employees);
        return task;
    }

}
