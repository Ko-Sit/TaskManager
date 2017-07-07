package com.qulix.sitkinke.trainingtask.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qulix.sitkinke.trainingtask.command.factory.CommandType;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.constants.UserCommandGrant;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.enums.UserType;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 06.07.2017.
 */
@WebFilter(urlPatterns = {"/controller"})
public class SecutityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = req.getSession();
            UserType type = (UserType) session.getAttribute(Attributes.USER_TYPE);
            if (type == UserType.USER) {
                String action = request.getParameter(Parameters.COMMAND);
                CommandType commandType = CommandType.valueOf(action.toUpperCase());

                if (UserCommandGrant.getInstance().getGrant().contains(commandType)) {
                    EmployeeDAO employeeDAO = new EmployeeDAO();
                    String login = (String) session.getAttribute(Parameters.LOGIN);
                    Employee employee = employeeDAO.getByLogin(login);
                    if (commandType.equals(commandType.GOTOMODIFYEMPLOYEE)) {
                        int id_employee = Integer.valueOf(request.getParameter(Parameters.ID));
                        if (id_employee == employee.getId()) {
                            chain.doFilter(request, response);
                            return;
                        }
                        else {
                            req.setAttribute(Attributes.EXCEPTION, "You are not allowed to do this!");
                            RequestDispatcher dispatcher = request.
                                getServletContext().getRequestDispatcher(ConfigurationManager.getProperty(PathConfigs.ERROR_PAGE));
                            dispatcher.forward(req, resp);
                            return;
                        }
                    }
                }
                else {
                    req.setAttribute(Attributes.EXCEPTION, "You are not allowed to do this!");
                    RequestDispatcher dispatcher = request.
                        getServletContext().getRequestDispatcher(ConfigurationManager.getProperty(PathConfigs.ERROR_PAGE));
                    dispatcher.forward(req, resp);
                    return;
                }
            }

            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
