package com.qulix.sitkinke.trainingtask.command;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class GoToAddTasksCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employees = employeeDAO.getAll();
        request.setAttribute("employees", employees);
        TaskDAO taskDAO = new TaskDAO();
        int id = taskDAO.getNextId();
        request.setAttribute("idgenerated", id);

        page = ConfigurationManager.getProperty("path.page.addtask");
        return page;
    }
}
