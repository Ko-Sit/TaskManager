package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * Created by upsit on 19.06.2017.
 */
public class GoToAddTaskFromProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute("projectid");
        String projectName = request.getParameter("name");
        String projectAbbreviation = request.getParameter("abbreviation");
        String projectDescription = request.getParameter("description");

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute("employees", employees);

        TaskDAO taskDAO = new TaskDAO();
        int id = taskDAO.getNextId();
        request.setAttribute("idgenerated", id);

        Project project = new Project(projectName, projectAbbreviation, projectDescription);
        project.setId(id_project);

        request.setAttribute("currentproject", project);

        session.setAttribute("projectname", projectName);
        session.setAttribute("projectabbr", projectAbbreviation);
        session.setAttribute("projectdescr", projectDescription);

        page = ConfigurationManager.getProperty("path.page.addtaskfromproject");
        return page;
    }
}
