package com.qulix.sitkinke.trainingtask.command.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 19.06.2017.
 */
public class GoToAddTaskFromProjectCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute(Attributes.PROJECT_ID);
        String projectName = request.getParameter(Parameters.PROJECT_NAME);
        String projectAbbreviation = request.getParameter(Parameters.PROJECT_ABBREVIATION);
        String projectDescription = request.getParameter(Parameters.PROJECT_DESCRIPTION);

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute(Parameters.EMPLOYEE_LIST, employees);

        TaskDAO taskDAO = new TaskDAO();
        int id = taskDAO.getNextId();
        request.setAttribute(Parameters.ID_GENERATED, id);

        Project project = new Project(projectName, projectAbbreviation, projectDescription);
        project.setId(id_project);

        request.setAttribute(Parameters.CURRENT_PROJECT, project);

        session.setAttribute(Attributes.PROJECT_NAME, projectName);
        session.setAttribute(Attributes.PROJECT_ABBREVIATION, projectAbbreviation);
        session.setAttribute(Attributes.PROJECT_DESCRIPTION, projectDescription);

        page = ConfigurationManager.getProperty(PathConfigs.ADD_TASK_FROM_PROJECT_PAGE);
        return page;
    }
}
