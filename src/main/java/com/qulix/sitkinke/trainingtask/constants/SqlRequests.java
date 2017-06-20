package com.qulix.sitkinke.trainingtask.constants;

/**
 *
 * Created by upsit on 20.06.2017.
 */
public class SqlRequests {

    public static final String ADD_EMPLOYEE = "INSERT INTO EMPLOYEES (NAME, SURNAME, PATRONYMIC, POSITION) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEES";
    public static final String GET_BY_ID = "SELECT * FROM EMPLOYEES WHERE ID = ?";
    public static final String GET_NEXT_ID = "SELECT ID FROM EMPLOYEES ORDER BY ID DESC LIMIT 1";
    public static final String MODIFY_EMPLOYEE = "UPDATE EMPLOYEES SET NAME = ?, SURNAME = ?, PATRONYMIC = ?, POSITION = ? WHERE ID = ?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE ID = ?";
    public static final String DELETE_EMPLOYEE_TASKS = "DELETE FROM REFLIST_EMPL WHERE ID_EMPLOYEE = ?";
    public static final String RESET_EMPLOYEES_AUTO_INCREMENT = "ALTER TABLE EMPLOYEES ALTER COLUMN ID RESTART WITH ";

    

    private SqlRequests() {}
}
