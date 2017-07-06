package com.qulix.sitkinke.trainingtask.command.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.enums.UserType;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 06.07.2017.
 */
public class LoginCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        UserType type;
        HttpSession session = request.getSession();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        if (employeeDAO.isAuthorized(login, password)) {
            Employee employee = employeeDAO.getByLogin(login);
            System.out.println(employee);
            type = employee.getUserType();
            session.setAttribute(Attributes.USER_TYPE, type);
            page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);
        }
        else {
            type = UserType.GUEST;
            session.setAttribute(Attributes.USER_TYPE, type);
            request.setAttribute("errorLoginMessage", "Invalid login data!");
            page = ConfigurationManager.getProperty(PathConfigs.LOGIN_PAGE);
        }

        return page;
    }
}
