package com.qulix.sitkinke.trainingtask.command.login;

import javax.mail.*;
import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.managers.EmailManager;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 06.07.2017.
 */
public class RemindPasswordCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String email = request.getParameter("login");
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getByLogin(email);
        String password = employee.getPassword();

        try {
            EmailManager.send(email, password);
        }
        catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error during send password to email.");
        }
        request.setAttribute("message", "Password was sent to email!");
        page = ConfigurationManager.getProperty(PathConfigs.LOGIN_PAGE);
        return page;
    }
}
