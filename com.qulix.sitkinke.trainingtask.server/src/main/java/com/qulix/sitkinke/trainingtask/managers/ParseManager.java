package com.qulix.sitkinke.trainingtask.managers;

import java.util.ArrayList;
import java.util.List;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;

/**
 * Manager class that extracts and finds entities by id.
 *
 * @author sitkin
 */
public class ParseManager {

    /**
     * Gets employee list.
     *
     * @param selectedEmployees the selected employees
     * @return the employee list
     */
    public static List<Employee> getEmployeeList(String[] selectedEmployees) {
        String[] parts;
        List<Integer> employees_id = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        for (String string : selectedEmployees) {
            parts = string.split("\\.");
            string = parts[0];
            employees_id.add(Integer.valueOf(string));
        }
        // todo make one cycle
        EmployeeDAO employeeDAO = new EmployeeDAO();
        for (Integer id : employees_id) {
            employees.add(employeeDAO.getById(id));
        }

        return employees;
    }

    /**
     * Gets project name.
     *
     * @param string the string made of project parameters
     * @return the project
     */
    public static Project getTaskProject(String string) {
        String[] parts = string.split("\\.");
        string = parts[0];

        ProjectDAO projectDAO = new ProjectDAO();
        Project project = projectDAO.getById(Integer.valueOf(string));

        return project;
    }
}
