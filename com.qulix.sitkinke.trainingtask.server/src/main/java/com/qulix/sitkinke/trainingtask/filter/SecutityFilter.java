package com.qulix.sitkinke.trainingtask.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

//            HttpSession session = req.getSession();
//            UserType type = (UserType) session.getAttribute(Attributes.USER_TYPE);
//            if (type == null) {
//                type = UserType.GUEST;
//                session.setAttribute(Attributes.USER_TYPE, type);
//                request.setAttribute("errorLoginMessage", "Log in please!");
//                RequestDispatcher dispatcher = request.
//                    getServletContext().getRequestDispatcher(ConfigurationManager.getProperty(PathConfigs.LOGIN_PAGE));
//                dispatcher.forward(req, resp);
//                return;
//            }

            //todo check user rights
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
