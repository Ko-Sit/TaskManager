package com.qulix.sitkinke.trainingtask.dao;

import com.qulix.sitkinke.trainingtask.constants.SqlRequests;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.managers.DBManager;
import com.qulix.sitkinke.trainingtask.managers.DBUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by upsit on 12.06.2017.
 */
public class ProjectDAO {

    public void addProject(Project project) {
        //addProjectTasks(project.getId(), project.getTaskList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.ADD_PROJECT)){
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getAbbreviation());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add project");
            e.printStackTrace();
        }
    }

    private void addProjectTasks(int id_project, List<Task> taskList) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.ADD_PROJECT_TASKS)){
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.ADD_PROJECT_TASKS)){
            preparedStatement.setInt(1, id_project);
            preparedStatement.setInt(2, id_task);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during add project task");
            e.printStackTrace();
        }
    }

    public void modifyProject(Project project) {
        //modifyProjectTasks(project.getId(), project.getTaskList());
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.MODIFY_PROJECT)){
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_PROJECT)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete project");
            e.printStackTrace();
        }
        DBUtility.resetAutoIncrement(SqlRequests.RESET_PROJECTS_AUTO_INCREMENT + getNextId());
    }

    private void deleteProjectTasks(int id_project) {
        TaskDAO taskDAO = new TaskDAO();
        Project project = getById(id_project);
        String projectAbbr = project.getAbbreviation();
        taskDAO.deleteTasksByProjectAbbr(projectAbbr);
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_PROJECT_TASKS_BY_ID_PROJECT)){
            preparedStatement.setInt(1, id_project);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete task executors");
            e.printStackTrace();
        }
    }

    public void deleteProjectTask(int id_task) {
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.DELETE_PROJECT_TASK_BY_ID_TASK)){
            preparedStatement.setInt(1, id_task);
            preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during delete task executors");
            e.printStackTrace();
        }
    }

    public void deleteTasksByIdProject(int id_project) {
        int id_task;
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = getProjectTasks(id_project);
        for (Task task: tasks){
            id_task = task.getId();
            deleteProjectTask(id_task);
            taskDAO.deleteTask(id_task);
        }
    }

    public Project getById(int id){
        Project project;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_PROJECTS_BY_ID)){
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_ALL_PROJECTS);
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

    public List<Task> getProjectTasks(int id_project){
        List<Task> taskList = new ArrayList<>();
        TaskDAO taskDAO = new TaskDAO();
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_PROJECT_TASKS)){
            preparedStatement.setInt(1, id_project);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Task task = taskDAO.getById(resultSet.getInt(1));
                taskList.add(task);
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get project tasks");
            e.printStackTrace();
            return null;
        }
        return taskList;
    }

    public int getNextId(){
        int id;
        int id_next;
        try(Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlRequests.GET_NEXT_PROJECT_ID);
            ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next())
                id = resultSet.getInt(1);
            else {
                DBUtility.resetAutoIncrement(SqlRequests.RESET_PROJECTS_AUTO_INCREMENT + 1);
                return 1;
            }

        }  catch (SQLException e) {
            System.out.println("SQL exception occurred during get next id project");
            e.printStackTrace();
            return -1;
        }
        id_next = id + 1;
        return id_next;
    }

    private Project buildProject(ResultSet resultSet) throws SQLException {
        int id_project = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String abbreviation = resultSet.getString(3);
        String description = resultSet.getString(4);
        List<Task> tasks = getProjectTasks(id_project);

        Project project = new Project(name, abbreviation, description);
        project.setId(id_project);
        project.setTaskList(tasks);
        return project;
    }

}
