package com.qulix.sitkinke.trainingtask.main;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.enums.State;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * Created by upsit on 12.06.2017.
 */
public class TestConnection {

    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        List<Task> taskList = taskDAO.getAll();
        Project project = projectDAO.getById(2);
        project.setId(3);
        project.setDescription("AUTOCREATED");
        project.setTaskList(taskList);
        project.getTaskList().get(0).setId(424);
        project.getTaskList().get(1).setId(444);
        project.getTaskList().get(2).setId(544);
        project.getTaskList().get(3).setId(464);
        project.getTaskList().get(4).setId(447);
        project.getTaskList().get(5).setId(448);
        project.getTaskList().get(6).setId(441);
        projectDAO.addProject(project);

    }

}














