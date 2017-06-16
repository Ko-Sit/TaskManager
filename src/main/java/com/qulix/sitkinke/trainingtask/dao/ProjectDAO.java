package com.qulix.sitkinke.trainingtask.dao;

import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.managers.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by upsit on 12.06.2017.
 */
public class ProjectDAO {

    public static final String SQL_QUERY_ADD_PROJECT = "INSERT INTO PROJECTS (ID, NAME, ABBREVIATION, DESCRIPTION) VALUES (?, ?, ?, ?)";
    public static final String SQL_QUERY_MODIFY_PROJECT = "UPDATE PROJECTS SET NAME = ?, ABBREVIATION = ?, DESCRIPTION = ? WHERE ID = ?";
    public static final String SQL_QUERY_DELETE_PROJECT = "DELETE FROM PROJECTS WHERE ID = ?";
    public static final String SQL_QUERY_GET_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    public static final String SQL_QUERY_GET_BY_ID = "SELECT * FROM PROJECTS WHERE ID = ?";
    public static final String SQL_QUERY_ADD_PROJECT_TASKS = "INSERT INTO REFLIST_PROJ (ID_PROJECT, ID_TASK) VALUES (?, ?)";
    public static final String SQL_QUERY_DELETE_PROJECT_TASKS_BY_ID_PROJECT_ = "DELETE FROM REFLIST_PROJ WHERE ID_PROJECT = ?";
    public static final String SQL_QUERY_DELETE_PROJECT_TASK_BY_ID_TASK = "DELETE FROM REFLIST_PROJ WHERE ID_TASK = ?";
    public static final String SQL_QUERY_GET_NEXT_ID = "SELECT ID FROM PROJECTS ORDER BY ID DESC LIMIT 1";

    public void addProject(Project project) {
        addProjectTasks(project.getId(), project.getTaskList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_PROJECT)){
            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getAbbreviation());
            preparedStatement.setString(4, project.getDescription());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add project");
            e.printStackTrace();
        }
    }

    private void addProjectTasks(int id_project, List<Task> taskList) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_PROJECT_TASKS)){
            for (Task task : taskList) {
                int id_task = task.getId();
                preparedStatement.setInt(1, id_project);
                preparedStatement.setInt(2, id_task);
                preparedStatement.executeUpdate();
            }
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add project tasks");
            e.printStackTrace();
        }
    }

    public void addProjectTask(int id_project, int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_PROJECT_TASKS)){
            preparedStatement.setInt(1, id_project);
            preparedStatement.setInt(2, id_task);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add project task");
            e.printStackTrace();
        }
    }

    public void modifyProject(Project project) {
        modifyProjectTasks(project.getId(), project.getTaskList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_MODIFY_PROJECT)){
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getAbbreviation());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setInt(4, project.getId());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during modify project");
            e.printStackTrace();
        }
    }

    private void modifyProjectTasks(int id_project, List<Task> taskList) {
        deleteProjectTasks(id_project);
        addProjectTasks(id_project, taskList);
    }

    public void modifyProjectTask(int id_project, int id_task) {
        deleteProjectTask(id_task);
        addProjectTask(id_project, id_task);
    }

    public void deleteProject(int id) {
        deleteProjectTasks(id);
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_PROJECT)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete project");
            e.printStackTrace();
        }
    }

    private void deleteProjectTasks(int id_project) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_PROJECT_TASKS_BY_ID_PROJECT_)){
            preparedStatement.setInt(1, id_project);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete task executors");
            e.printStackTrace();
        }
    }

    public void deleteProjectTask(int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_PROJECT_TASK_BY_ID_TASK)){
            preparedStatement.setInt(1, id_task);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete task executors");
            e.printStackTrace();
        }
    }

    public Project getById(int id){
        Project project;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                project = buildProject(resultSet);
            else
                return null;

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get by id project");
            e.printStackTrace();
            return null;
        }
        return project;
    }

    public List<Project> getAll(){
        List<Project> projectList = new ArrayList<>();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ALL_PROJECTS);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Project project = buildProject(resultSet);
                projectList.add(project);
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get all projects");
            e.printStackTrace();
            return null;
        }
        return projectList;
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
            System.out.println("SQL exception occurred during get next id project");
            e.printStackTrace();
            return -1;
        }
        id_next = id + 1;
        return id_next;
    }

    private Project buildProject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String abbreviation = resultSet.getString(3);
        String description = resultSet.getString(4);

        return new Project(id, name, abbreviation, description);
    }

}
