package com.qulix.sitkinke.trainingtask.command.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

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
        int id_employee = Integer.valueOf(request.getParameter(Parameters.ID));
        employeeDAO.delete(id_employee);

        employees = employeeDAO.getAll();
        request.setAttribute(Parameters.EMPLOYEE_LIST, employees);

        page = ConfigurationManager.getProperty(PathConfigs.SHOW_EMPLOYEES_PAGE);
        return page;
    }
}
