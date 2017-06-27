package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
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
public class DeleteTaskFromProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String projectName = request.getParameter("name");
        String projectAbbreviation = request.getParameter("abbr");
        String projectDescription = request.getParameter("descr");

        TaskDAO taskDAO = new TaskDAO();
        int id_task = Integer.valueOf(request.getParameter("id"));
        taskDAO.delete(id_task);
        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.deleteProjectTask(id_task);

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute("projectid");

        List<Task> tasks = projectDAO.getProjectTasks(id_project);
        request.setAttribute("projecttasks", tasks);

        request.setAttribute("projectname", projectName);
        request.setAttribute("projectabbr", projectAbbreviation);
        request.setAttribute("projectdescr", projectDescription);

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_PROJECT_PAGE);
        return page;
    }
}
