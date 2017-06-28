package com.qulix.sitkinke.trainingtask.managers;

import java.util.ArrayList;
import java.util.List;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class ParseManager {

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

    public static Project getTaskProject(String string) {
        String[] parts = string.split("\\.");
        string = parts[0];

        ProjectDAO projectDAO = new ProjectDAO();
        Project project = projectDAO.getById(Integer.valueOf(string));

        return project;
    }

    public static Project getFictiveProject(String string) {
        String[] parts = string.split("[. ]");        //regex "dot and space"
        int id_project = Integer.valueOf(parts[0]);
        String name = parts[2];

        Project project = new Project();
        project.setId(id_project);
        project.setName(name);

        return project;
    }
}
