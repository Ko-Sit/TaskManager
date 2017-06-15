package com.qulix.sitkinke.trainingtask.managers;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;

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

        EmployeeDAO employeeDAO = new EmployeeDAO();
        for(Integer id: employees_id) {
            employees.add(employeeDAO.getById(id));
        }
        System.out.println(employees);
        return employees;
    }
}
