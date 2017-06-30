package com.qulix.sitkinke.trainingtask.command.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that deletes task from add project page.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class DeleteTempTaskCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute(Attributes.PROJECT_ID);
        String projectName = request.getParameter(Parameters.LINK_NAME);
        String projectAbbreviation = request.getParameter(Parameters.LINK_ABBREVIATION);
        String projectDescription = request.getParameter(Parameters.LINK_DESCRIPTION);

        List<Task> tasks;
        TaskDAO taskDAO = new TaskDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        int id_task = Integer.valueOf(request.getParameter(Parameters.ID));
        taskDAO.delete(id_task);

        projectDAO.deleteProjectTask(id_task);

        tasks = projectDAO.getProjectTasks(id_project);
        request.setAttribute(Parameters.TASK_LIST, tasks);

        request.setAttribute(Parameters.PROJECT_TASKS, tasks);

        request.setAttribute(Attributes.ID_GENERATED, id_project);
        request.setAttribute(Attributes.PROJECT_NAME, projectName);
        request.setAttribute(Attributes.PROJECT_ABBREVIATION, projectAbbreviation);
        request.setAttribute(Attributes.PROJECT_DESCRIPTION, projectDescription);

        page = ConfigurationManager.getProperty(PathConfigs.ADD_PROJECT_PAGE);
        return page;
    }
}
