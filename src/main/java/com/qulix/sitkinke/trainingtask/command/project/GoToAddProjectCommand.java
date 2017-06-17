package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
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
        int id = projectDAO.getNextId();
        request.setAttribute("idgenerated", id);
        //todo empty list or not??
        List<Task> tasks = new ArrayList<>();
        request.setAttribute("projecttasks", tasks);

        page = ConfigurationManager.getProperty("path.page.addproject");
        return page;
    }
}
