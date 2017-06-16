package com.qulix.sitkinke.trainingtask.command;

import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 16.06.2017.
 */
public class ShowProjectsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Project> projects;
        ProjectDAO projectDAO = new ProjectDAO();
        projects = projectDAO.getAll();
        request.setAttribute("projects", projects);

        page = ConfigurationManager.getProperty("path.page.showprojects");
        return page;
    }
}
