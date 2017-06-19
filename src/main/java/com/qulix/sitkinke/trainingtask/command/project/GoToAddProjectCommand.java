package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
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
        request.setAttribute("idgenerated", id_project);

        List<Task> tasks = projectDAO.getProjectTasks(id_project);
        request.setAttribute("projecttasks", tasks);

        request.setAttribute("projectname", "");
        request.setAttribute("projectabbr", "");
        request.setAttribute("projectdescr", "");

        page = ConfigurationManager.getProperty("path.page.addproject");
        return page;
    }
}
