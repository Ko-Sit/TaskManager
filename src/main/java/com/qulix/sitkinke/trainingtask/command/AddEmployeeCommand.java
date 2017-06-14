package com.qulix.sitkinke.trainingtask.command;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class AddEmployeeCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id = Integer.valueOf(request.getParameter("id"));
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String patronymic = request.getParameter("patronymic");
        String position = request.getParameter("position");

        Employee employee = new Employee(id, surname, name, patronymic, position);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employee);

        page = ConfigurationManager.getProperty("path.page.addemployee");
        return page;
    }
}
