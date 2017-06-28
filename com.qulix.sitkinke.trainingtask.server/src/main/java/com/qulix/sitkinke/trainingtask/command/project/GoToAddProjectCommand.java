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
 * Created by upsit on 16.06.2017.
 */
public class GoToAddProjectCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        ProjectDAO projectDAO = new ProjectDAO();
        int id_project = projectDAO.getNextId();

        List<Task> tasks = projectDAO.getProjectTasks(id_project);

        request.setAttribute(Parameters.PROJECT_TASKS, tasks);

        HttpSession session = request.getSession();
        session.setAttribute(Attributes.ID_GENERATED, id_project);
        session.setAttribute(Attributes.PROJECT_NAME, "");
        session.setAttribute(Attributes.PROJECT_ABBREVIATION, "");
        session.setAttribute(Attributes.PROJECT_DESCRIPTION, "");

        page = ConfigurationManager.getProperty(PathConfigs.ADD_PROJECT_PAGE);
        return page;
    }
}
