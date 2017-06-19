package com.qulix.sitkinke.trainingtask.dao;

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
    public static final String SQL_QUERY_ADD_TASK = "INSERT INTO TASKS (NAME, DURATION, STARTDATE, ENDDATE, STATE, PROJECTNAME) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SQL_QUERY_MODIFY_TASK = "UPDATE TASKS SET NAME = ?, DURATION = ?, STARTDATE = ?, ENDDATE = ?, STATE = ?, PROJECTNAME = ? WHERE ID = ?";
    public static final String SQL_QUERY_DELETE_TASK = "DELETE FROM TASKS WHERE ID = ?";
    public static final String SQL_QUERY_GET_ALL_TASKS = "SELECT * FROM TASKS";
    public static final String SQL_QUERY_GET_BY_ID = "SELECT * FROM TASKS WHERE ID = ?";
    public static final String SQL_QUERY_ADD_TASK_EXECUTORS = "INSERT INTO REFLIST_EMPL (ID_EMPLOYEE, ID_TASK) VALUES (?, ?)";
    public static final String SQL_QUERY_DELETE_TASK_EXECUTORS = "DELETE FROM REFLIST_EMPL WHERE ID_TASK = ?";
    public static final String SQL_QUERY_GET_NEXT_ID = "SELECT ID FROM TASKS ORDER BY ID DESC LIMIT 1";
    public static final String SQL_QUERY_GET_TASK_EXECUTORS = "SELECT ID_EMPLOYEE FROM REFLIST_EMPL WHERE ID_TASK = ?";
    public static final String SQL_QUERY_RESET_AUTO_INCREMENT = "ALTER TABLE TASKS ALTER COLUMN ID RESTART WITH ";
    public static final String SQL_QUERY_ADD_TEMP_TASK = "INSERT INTO PROJECT_TASKS_TEMP (ID_TASK) VALUES (?)";
    public static final String SQL_QUERY_GET_TEMP_TASKS = "SELECT ID_TASK FROM PROJECT_TASKS_TEMP";
    public static final String SQL_QUERY_DELETE_TEMP_TASK = "DELETE FROM PROJECT_TASKS_TEMP WHERE ID_TASK = ?";
    public static final String SQL_QUERY_DELETE_TEMP_TASKS = "DELETE FROM PROJECT_TASKS_TEMP";

    public void addTask(Task task){
        addTaskExecutors(task.getId(), task.getEmployeeList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_TASK)){
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
        DBUtility.resetAutoIncrement(SQL_QUERY_RESET_AUTO_INCREMENT + getNextId());
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

    public List<Employee> getTaskExecutors(int id_task){
        List<Employee> employeeList = new ArrayList<>();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_TASK_EXECUTORS)){
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

    public void addTempTaskRecord(int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_TEMP_TASK)){
            preparedStatement.setInt(1, id_task);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete temp task");
            e.printStackTrace();
        }
    }

    public List<Task> getTempTasks(){
        int id_task;
        List<Task> taskList = new ArrayList<>();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_TEMP_TASKS);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                id_task = resultSet.getInt(1);
                Task task = getById(id_task);
                taskList.add(task);
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get temp tasks");
            e.printStackTrace();
            return null;
        }
        return taskList;
    }

    public void deleteTempTask(int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_TEMP_TASK)){
            preparedStatement.setInt(1, id_task);
            preparedStatement.executeUpdate();
            deleteTask(id_task);
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete temp task");
            e.printStackTrace();
        }
    }

    public void deleteTempTasks() {
        //todo think in what cases clear table
        List<Task> tasks = getTempTasks();

        for (Task task : tasks){
            deleteTask(task.getId());
        }

        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_TEMP_TASKS)){
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete temp tasks");
            e.printStackTrace();
        }
    }

    public int getNextId(){
        int id;
        int id_next;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_NEXT_ID);
            ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next())
                id = resultSet.getInt(1);
            else {
                DBUtility.resetAutoIncrement(SQL_QUERY_RESET_AUTO_INCREMENT + 1);
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

    public  void resetAutoIncrement() {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_RESET_AUTO_INCREMENT + getNextId())){
            //preparedStatement.setString(1, tableName);
            //preparedStatement.setInt(1, getNextId());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during reset autoincrement");
            e.printStackTrace();
        }
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
