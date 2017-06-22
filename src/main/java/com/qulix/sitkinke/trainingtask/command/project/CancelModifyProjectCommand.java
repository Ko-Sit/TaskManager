package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.containters.ProjectContainer;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 22.06.2017.
 */
public class CancelModifyProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Project> projects;
        ProjectDAO projectDAO = new ProjectDAO();
        int id_project = Integer.valueOf(request.getParameter("id"));
        projectDAO.deleteTasksByIdProject(id_project);
        projectDAO.deleteProject(id_project);

        TaskDAO taskDAO = new TaskDAO();
        Project project = ProjectContainer.get();
        projectDAO.addProject(project);

        int id_task;
        for (Task task: project.getTaskList()) {
            taskDAO.addTask(task);
            id_task = task.getId();
            projectDAO.addProjectTask(id_project, id_task);
        }

        ProjectContainer.clear();

        projects = projectDAO.getAll();
        request.setAttribute("projects", projects);

        page = ConfigurationManager.getProperty("path.page.showprojects");
        return page;
    }
}
