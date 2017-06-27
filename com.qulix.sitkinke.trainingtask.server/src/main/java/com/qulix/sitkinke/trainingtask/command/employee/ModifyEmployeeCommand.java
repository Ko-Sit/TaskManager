package com.qulix.sitkinke.trainingtask.command.employee;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class ModifyEmployeeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id = Integer.valueOf(request.getParameter("id"));
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String patronymic = request.getParameter("patronymic");
        String position = request.getParameter("position");

        Employee employee = new Employee(surname, name, patronymic, position);
        employee.setId(id);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.modify(employee);

        List<Employee> employees;
        employees = employeeDAO.getAll();
        request.setAttribute("employees", employees);

        page = ConfigurationManager.getProperty(PathConfigs.SHOW_EMPLOYEES_PAGE);
        return page;
    }
}
