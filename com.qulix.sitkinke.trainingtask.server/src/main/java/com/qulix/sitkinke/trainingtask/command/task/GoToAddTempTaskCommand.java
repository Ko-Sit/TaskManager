package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
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

        int id_project = Integer.valueOf(request.getParameter(Parameters.ID));
        String name = request.getParameter(Parameters.PROJECT_NAME);
        String abbreviation = request.getParameter(Parameters.PROJECT_ABBREVIATION);
        String description = request.getParameter(Parameters.PROJECT_DESCRIPTION);

        HttpSession session = request.getSession();
        session.setAttribute(Attributes.PROJECT_ID, id_project);
        session.setAttribute(Attributes.PROJECT_NAME, name);
        session.setAttribute(Attributes.PROJECT_ABBREVIATION, abbreviation);
        session.setAttribute(Attributes.PROJECT_DESCRIPTION, description);

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute(Parameters.EMPLOYEE_LIST, employees);

        TaskDAO taskDAO = new TaskDAO();
        int id = taskDAO.getNextId();
        request.setAttribute(Parameters.ID_GENERATED, id);

        Project project = new Project(name, abbreviation, description);
        project.setId(id_project);

        request.setAttribute(Parameters.CURRENT_PROJECT, project);

        page = ConfigurationManager.getProperty(PathConfigs.ADD_TEMP_TASK_PAGE);
        return page;
    }
}
