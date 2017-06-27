package com.qulix.sitkinke.trainingtask.command.employee;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class DeleteEmployeeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Employee> employees;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        int id_employee = Integer.valueOf(request.getParameter("id"));
        employeeDAO.delete(id_employee);

        employees = employeeDAO.getAll();
        request.setAttribute("employees", employees);

        page = ConfigurationManager.getProperty("path.page.showemployees");
        return page;
    }
}
