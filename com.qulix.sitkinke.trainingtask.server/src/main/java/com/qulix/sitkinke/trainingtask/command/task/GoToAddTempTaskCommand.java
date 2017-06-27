package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
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
 * Created by upsit on 18.06.2017.
 */
public class GoToAddTempTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_project = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String abbreviation = request.getParameter("abbreviation");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        session.setAttribute("projectid", id_project);
        session.setAttribute("projectname", name);
        session.setAttribute("projectabbr", abbreviation);
        session.setAttribute("projectdescr", description);

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute("employees", employees);

        TaskDAO taskDAO = new TaskDAO();
        int id = taskDAO.getNextId();
        request.setAttribute("idgenerated", id);

        Project project = new Project(name, abbreviation, description);
        project.setId(id_project);

        request.setAttribute("currentproject", project);

        page = ConfigurationManager.getProperty(PathConfigs.ADD_TEMP_TASK_PAGE);
        return page;
    }
}
