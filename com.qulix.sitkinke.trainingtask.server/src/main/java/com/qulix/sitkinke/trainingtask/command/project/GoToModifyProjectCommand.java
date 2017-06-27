package com.qulix.sitkinke.trainingtask.command.project;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.containters.ProjectContainer;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * Created by upsit on 19.06.2017.
 */
public class GoToModifyProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_project = Integer.valueOf(request.getParameter("id"));
        ProjectDAO projectDAO = new ProjectDAO();
        Project project = projectDAO.getById(id_project);

        ProjectContainer.put(project);

        List<Task> tasks = project.getTaskList();
        request.setAttribute("projecttasks", tasks);

        HttpSession session = request.getSession();
        session.setAttribute("projectid", id_project);
        session.setAttribute("projectname", project.getName());
        session.setAttribute("projectabbr", project.getAbbreviation());
        session.setAttribute("projectdescr", project.getDescription());

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_PROJECT_PAGE);
        return page;
    }
}
