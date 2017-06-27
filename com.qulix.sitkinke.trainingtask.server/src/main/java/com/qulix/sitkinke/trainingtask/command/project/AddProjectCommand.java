package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 18.06.2017.
 */
public class AddProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id_project = Integer.valueOf(request.getParameter(Parameters.ID));
        String name = request.getParameter(Parameters.PROJECT_NAME);
        String abbreviation = request.getParameter(Parameters.PROJECT_ABBREVIATION);
        String description = request.getParameter(Parameters.PROJECT_DESCRIPTION);

        TaskDAO taskDAO = new TaskDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        List<Task> tasks = projectDAO.getProjectTasks(id_project);
        for (Task task: tasks){
            task.setProjectName(abbreviation);
            taskDAO.modify(task);
        }
        Project project = new Project(name, abbreviation, description);
        project.setId(id_project);
        project.setTaskList(tasks);
        projectDAO.add(project);

        List<Project> projects;
        projects = projectDAO.getAll();
        request.setAttribute(Parameters.PROJECT_LIST, projects);
        page = ConfigurationManager.getProperty(PathConfigs.SHOW_PROJECTS_PAGE);
        return page;
    }
}
