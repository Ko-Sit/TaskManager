package com.qulix.sitkinke.trainingtask.command.employee;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that redirects page to add employee page.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class GoToAddEmployeesCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        EmployeeDAO employeeDAO = new EmployeeDAO();
        int id = employeeDAO.getNextId();
        request.setAttribute(Parameters.ID_GENERATED, id);

        page = ConfigurationManager.getProperty(PathConfigs.ADD_EMPLOYEE_PAGE);
        return page;
    }
}
