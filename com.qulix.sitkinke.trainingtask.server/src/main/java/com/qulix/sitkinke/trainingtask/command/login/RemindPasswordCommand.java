package com.qulix.sitkinke.trainingtask.command.login;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.managers.EmailManager;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that reminds password.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class RemindPasswordCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String email = request.getParameter(Parameters.LOGIN);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getByLogin(email);
        if (employee != null) {
            String password = employee.getPassword();

            try {
                EmailManager.send(email, password);
            }
            catch (MessagingException e) {
                e.printStackTrace();
                System.out.println("Error during send password to email.");
            }
            request.setAttribute(Parameters.MESSAGE, "Password was sent to email!");
        }
        else {
            request.setAttribute(Parameters.ERROR_LOGIN_MESSAGE, "No such email registered!");
        }
        page = ConfigurationManager.getProperty(PathConfigs.LOGIN_PAGE);
        return page;
    }
}
