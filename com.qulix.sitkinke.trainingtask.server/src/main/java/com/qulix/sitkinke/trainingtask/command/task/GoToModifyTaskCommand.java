package com.qulix.sitkinke.trainingtask.command.task;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that redirects page to modify task.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class GoToModifyTaskCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_task = Integer.valueOf(request.getParameter(Parameters.ID));
        TaskDAO taskDAO = new TaskDAO();
        Task task = taskDAO.getById(id_task);
        request.setAttribute(Parameters.SELECTED_TASK, task);

        List<Employee> taskExecutors = task.getEmployeeList();
        List<Integer> taskExecutorsID = new ArrayList<>();
        for (Employee employee : taskExecutors) {
            taskExecutorsID.add(employee.getId());
        }
        request.setAttribute(Parameters.TASK_EXECUTORS_ID, taskExecutorsID);

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute(Parameters.EMPLOYEE_LIST, employees);

        List<Project> projects;
        ProjectDAO projectDAO = new ProjectDAO();
        projects = projectDAO.getAll();
        request.setAttribute(Parameters.PROJECT_LIST, projects);

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_TASK_PAGE);
        return page;
    }
}
