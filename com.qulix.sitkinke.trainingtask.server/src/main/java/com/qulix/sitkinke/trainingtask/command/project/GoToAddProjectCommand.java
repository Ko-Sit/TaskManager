package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

        request.setAttribute("projecttasks", tasks);

        HttpSession session = request.getSession();
        session.setAttribute("idgenerated", id_project);
        session.setAttribute("projectname", "");
        session.setAttribute("projectabbr", "");
        session.setAttribute("projectdescr", "");

        page = ConfigurationManager.getProperty(PathConfigs.ADD_PROJECT_PAGE);
        return page;
    }
}
