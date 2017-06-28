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
 *
 * Created by upsit on 23.06.2017.
 */
public class CancelTaskInModifyProjectCommand implements ActionCommand {

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
        System.out.println(tasks);
        request.setAttribute(Parameters.PROJECT_TASKS, tasks);

        session.setAttribute(Attributes.PROJECT_ID, id_project);
        session.setAttribute(Attributes.PROJECT_NAME, projectName);
        session.setAttribute(Attributes.PROJECT_ABBREVIATION, projectAbbreviation);
        session.setAttribute(Attributes.PROJECT_DESCRIPTION, projectDescription);

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_PROJECT_PAGE);
        return page;
    }
}
