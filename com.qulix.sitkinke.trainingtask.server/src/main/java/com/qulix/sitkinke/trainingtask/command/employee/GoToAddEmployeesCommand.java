package com.qulix.sitkinke.trainingtask.command.employee;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by upsit on 14.06.2017.
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
