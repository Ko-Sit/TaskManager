package com.qulix.sitkinke.trainingtask.command.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 22.06.2017.
 */
public class CancelAddProjectCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Project> projects;
        ProjectDAO projectDAO = new ProjectDAO();
        int id_project = Integer.valueOf(request.getParameter(Parameters.ID));
        projectDAO.deleteTasksByIdProject(id_project);

        projects = projectDAO.getAll();
        request.setAttribute(Parameters.PROJECT_LIST, projects);

        page = ConfigurationManager.getProperty(PathConfigs.SHOW_PROJECTS_PAGE);
        return page;
    }
}
