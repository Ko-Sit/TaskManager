package com.qulix.sitkinke.trainingtask.command.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.enums.UserType;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that modifies employee.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class ModifyEmployeeCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id = Integer.valueOf(request.getParameter(Parameters.ID));
        String surname = request.getParameter(Parameters.EMPLOYEE_SURNAME);
        String name = request.getParameter(Parameters.EMPLOYEE_NAME);
        String patronymic = request.getParameter(Parameters.EMPLOYEE_PATRONYMIC);
        String position = request.getParameter(Parameters.EMPLOYEE_POSITION);
        String email = request.getParameter(Parameters.EMPLOYEE_EMAIL);
        String password = request.getParameter(Parameters.EMPLOYEE_PASSWORD);
        UserType userType = UserType.valueOf(request.getParameter(Parameters.EMPLOYEE_USERTYPE).toUpperCase());

        Employee employee = new Employee(surname, name, patronymic, position, email, password, userType);
        employee.setId(id);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.modify(employee);

        List<Employee> employees;
        employees = employeeDAO.getAll();
        request.setAttribute(Parameters.EMPLOYEE_LIST, employees);

        page = ConfigurationManager.getProperty(PathConfigs.SHOW_EMPLOYEES_PAGE);
        return page;
    }
}
