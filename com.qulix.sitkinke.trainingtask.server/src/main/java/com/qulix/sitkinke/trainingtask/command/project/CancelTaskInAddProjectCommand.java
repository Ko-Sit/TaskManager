package com.qulix.sitkinke.trainingtask.command.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that cancels adding task in add project page.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class CancelTaskInAddProjectCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        ProjectDAO projectDAO = new ProjectDAO();

        HttpSession session = request.getSession();
        int id_project = (Integer) session.getAttribute(Attributes.PROJECT_ID);
        String projectName = (String) session.getAttribute(Attributes.PROJECT_NAME);
        String projectAbbreviation = (String) session.getAttribute(Attributes.PROJECT_ABBREVIATION);
        String projectDescription = (String) session.getAttribute(Attributes.PROJECT_DESCRIPTION);

        List<Task> tasks = projectDAO.getProjectTasks(id_project);

        request.setAttribute(Parameters.PROJECT_TASKS, tasks);

        session.setAttribute(Attributes.ID_GENERATED, id_project);
        session.setAttribute(Attributes.PROJECT_NAME, projectName);
        session.setAttribute(Attributes.PROJECT_ABBREVIATION, projectAbbreviation);
        session.setAttribute(Attributes.PROJECT_DESCRIPTION, projectDescription);

        page = ConfigurationManager.getProperty(PathConfigs.ADD_PROJECT_PAGE);
        return page;
    }
}
