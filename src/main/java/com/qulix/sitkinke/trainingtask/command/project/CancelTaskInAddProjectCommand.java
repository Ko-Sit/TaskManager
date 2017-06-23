package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * Created by upsit on 23.06.2017.
 */
public class CancelTaskInAddProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        ProjectDAO projectDAO = new ProjectDAO();

        HttpSession session = request.getSession();
        int id_project = (Integer) session.getAttribute("projectid");
        String projectName = (String) session.getAttribute("projectname");
        String projectAbbreviation = (String) session.getAttribute("projectabbr");
        String projectDescription = (String) session.getAttribute("projectdescr");

        List<Task> tasks = projectDAO.getProjectTasks(id_project);
        System.out.println(tasks);
        request.setAttribute("projecttasks", tasks);

        session.setAttribute("projectid", id_project);
        session.setAttribute("projectname", projectName);
        session.setAttribute("projectabbr", projectAbbreviation);
        session.setAttribute("projectdescr", projectDescription);

        page = ConfigurationManager.getProperty("path.page.addproject");
        return page;
    }
}
