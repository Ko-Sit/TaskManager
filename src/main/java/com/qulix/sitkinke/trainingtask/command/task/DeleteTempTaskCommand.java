package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * Created by upsit on 19.06.2017.
 */
public class DeleteTempTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute("projectid");
        String projectName = (String) session.getAttribute("projectname");
        String projectAbbreviation = (String) session.getAttribute("projectabbr");
        String projectDescription = (String) session.getAttribute("projectdescr");

        List<Task> tasks;
        TaskDAO taskDAO = new TaskDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        int id_task = Integer.valueOf(request.getParameter("id"));
        taskDAO.deleteTask(id_task);

        projectDAO.deleteProjectTask(id_task);

        tasks = projectDAO.getProjectTasks(id_project);
        request.setAttribute("tasks", tasks);

        request.setAttribute("projecttasks", tasks);

        request.setAttribute("idgenerated", id_project);
        request.setAttribute("projectname", projectName);
        request.setAttribute("projectabbr", projectAbbreviation);
        request.setAttribute("projectdescr", projectDescription);

        page = ConfigurationManager.getProperty("path.page.addproject");
        return page;
    }
}
