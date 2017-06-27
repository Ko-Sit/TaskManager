package com.qulix.sitkinke.trainingtask.command.employee;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class GoToModifyEmployeeCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_employee = Integer.valueOf(request.getParameter("id"));
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getById(id_employee);
        request.setAttribute("selectedemployee", employee);

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_EMPLOYEE_PAGE);
        return page;
    }
}
