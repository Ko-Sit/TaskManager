package com.qulix.sitkinke.trainingtask.command.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.containters.ProjectContainer;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 19.06.2017.
 */
public class GoToModifyProjectCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_project = Integer.valueOf(request.getParameter(Parameters.ID));
        ProjectDAO projectDAO = new ProjectDAO();
        Project project = projectDAO.getById(id_project);

        ProjectContainer.put(project);

        List<Task> tasks = project.getTaskList();
        request.setAttribute(Parameters.PROJECT_TASKS, tasks);

        HttpSession session = request.getSession();
        session.setAttribute(Attributes.PROJECT_ID, id_project);
        session.setAttribute(Attributes.PROJECT_NAME, project.getName());
        session.setAttribute(Attributes.PROJECT_ABBREVIATION, project.getAbbreviation());
        session.setAttribute(Attributes.PROJECT_DESCRIPTION, project.getDescription());

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_PROJECT_PAGE);
        return page;
    }
}
