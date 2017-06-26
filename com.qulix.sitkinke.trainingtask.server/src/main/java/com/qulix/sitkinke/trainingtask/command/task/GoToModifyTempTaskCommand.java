package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
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
public class GoToModifyTempTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_task = Integer.valueOf(request.getParameter("id"));
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getById(id_task);
        request.setAttribute("selectedtask", task);

        String projectName = request.getParameter("name");
        String projectAbbreviation = request.getParameter("abbr");
        String projectDescription = request.getParameter("descr");

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute("employees", employees);

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute("projectid");
        session.setAttribute("projectname", projectName);
        session.setAttribute("projectabbr", projectAbbreviation);
        session.setAttribute("projectdescr", projectDescription);

        Project project = new Project(projectName, projectAbbreviation, projectDescription);
        project.setId(id_project);

        request.setAttribute("currentproject", project);

        page = ConfigurationManager.getProperty("path.page.modifytemptask");
        return page;
    }
}