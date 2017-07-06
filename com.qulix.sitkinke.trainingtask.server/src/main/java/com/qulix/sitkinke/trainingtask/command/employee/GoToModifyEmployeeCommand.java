package com.qulix.sitkinke.trainingtask.command.employee;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that redirects page to modify employee page.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class GoToModifyEmployeeCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_employee = Integer.valueOf(request.getParameter(Parameters.ID));
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getById(id_employee);
        request.setAttribute(Parameters.SELECTED_EMPLOYEE, employee);
        System.out.println(employee.getEmail());
        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_EMPLOYEE_PAGE);
        return page;
    }
}
