package com.qulix.sitkinke.trainingtask.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.command.factory.ActionFactory;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.exceptions.DaoException;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        // определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
    /*
     * вызов реализованного метода execute() и передача параметров
     * классу-обработчику конкретной команды
     */
        try {
            page = command.execute(request);
        } catch (DaoException d) {
            request.setAttribute(Attributes.EXCEPTION, d.getMessage());
            page = ConfigurationManager.getProperty(PathConfigs.ERROR_PAGE);
        }
        // метод возвращает страницу ответа
        // page = null; // поэкспериментировать!
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        }
        else {
            // установка страницы c cообщением об ошибке
            page = ConfigurationManager.getProperty(PathConfigs.INDEX_PAGE);
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
