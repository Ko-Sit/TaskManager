package com.qulix.sitkinke.trainingtask.main;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class TestIdGenerator {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        System.out.println(employeeDAO.getNextId());
    }
}
