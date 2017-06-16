package com.qulix.sitkinke.trainingtask.managers;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class ParseManager {
    public static List<Employee> getEmployeeList(String[] selectedEmployees){
        String[] parts;
        List<Integer> employees_id = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        for (String string : selectedEmployees){
            parts = string.split("\\.");
            string = parts[0];
            employees_id.add(Integer.valueOf(string));
        }
        // todo make one cycle
        EmployeeDAO employeeDAO = new EmployeeDAO();
        for(Integer id: employees_id) {
            employees.add(employeeDAO.getById(id));
        }
        System.out.println(employees);
        return employees;
    }

    public static String getProjectName(String string){
        String[] parts = string.split("\\.");
        string = parts[0];

        ProjectDAO projectDAO = new ProjectDAO();
        Project project = projectDAO.getById(Integer.valueOf(string));

        return project.getName();
    }
}
