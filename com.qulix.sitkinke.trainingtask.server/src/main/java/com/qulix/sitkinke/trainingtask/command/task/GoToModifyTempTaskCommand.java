package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
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

        int id_task = Integer.valueOf(request.getParameter(Parameters.ID));
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getById(id_task);
        request.setAttribute(Parameters.SELECTED_TASK, task);

        String projectName = request.getParameter(Parameters.LINK_NAME);
        String projectAbbreviation = request.getParameter(Parameters.LINK_ABBREVIATION);
        String projectDescription = request.getParameter(Parameters.LINK_DESCRIPTION);

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute(Parameters.EMPLOYEE_LIST, employees);

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute(Attributes.PROJECT_ID);
        session.setAttribute(Attributes.PROJECT_NAME, projectName);
        session.setAttribute(Attributes.PROJECT_ABBREVIATION, projectAbbreviation);
        session.setAttribute(Attributes.PROJECT_DESCRIPTION, projectDescription);

        Project project = new Project(projectName, projectAbbreviation, projectDescription);
        project.setId(id_project);

        request.setAttribute(Parameters.CURRENT_PROJECT, project);

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_TEMP_TASK_PAGE);
        return page;
    }
}
