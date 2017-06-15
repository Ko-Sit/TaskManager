package com.qulix.sitkinke.trainingtask.main;

import com.qulix.sitkinke.trainingtask.dao.EmployeeDAO;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class TestNext {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        int id = employeeDAO.getNextId();
        System.out.println(id);

    }
}
