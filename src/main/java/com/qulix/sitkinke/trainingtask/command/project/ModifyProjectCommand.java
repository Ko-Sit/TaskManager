package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 19.06.2017.
 */
public class ModifyProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id_project = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String abbreviation = request.getParameter("abbreviation");
        String description = request.getParameter("description");

        ProjectDAO projectDAO = new ProjectDAO();
        List<Task> taskList = projectDAO.getProjectTasks(id_project);
        Project project = new Project(name, abbreviation, description);
        project.setId(id_project);

        TaskDAO taskDAO = new TaskDAO();
        for (Task task: taskList) {
            task.setProjectName(abbreviation);
            taskDAO.modifyTask(task);
        }

        project.setTaskList(taskList);
        projectDAO.modifyProject(project);

        List<Project> projects;
        projects = projectDAO.getAll();
        request.setAttribute("projects", projects);

        page = ConfigurationManager.getProperty("path.page.showprojects");
        return page;
    }
}
