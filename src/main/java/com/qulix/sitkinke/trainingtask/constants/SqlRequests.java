package com.qulix.sitkinke.trainingtask.constants;

/**
 *
 * Created by upsit on 20.06.2017.
 */
public class SqlRequests {
    // employee requests
    public static final String ADD_EMPLOYEE = "INSERT INTO EMPLOYEES (NAME, SURNAME, PATRONYMIC, POSITION) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEES";
    public static final String GET_EMPLOYEES_BY_ID = "SELECT * FROM EMPLOYEES WHERE ID = ?";
    public static final String GET_NEXT_EMPLOYEE_ID = "SELECT ID FROM EMPLOYEES ORDER BY ID DESC LIMIT 1";
    public static final String MODIFY_EMPLOYEE = "UPDATE EMPLOYEES SET NAME = ?, SURNAME = ?, PATRONYMIC = ?, POSITION = ? WHERE ID = ?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE ID = ?";
    public static final String DELETE_EMPLOYEE_TASKS = "DELETE FROM REFLIST_EMPL WHERE ID_EMPLOYEE = ?";
    public static final String RESET_EMPLOYEES_AUTO_INCREMENT = "ALTER TABLE EMPLOYEES ALTER COLUMN ID RESTART WITH ";
    // task requests
    public static final String ADD_TASK = "INSERT INTO TASKS (NAME, DURATION, STARTDATE, ENDDATE, STATE, PROJECTNAME) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String ADD_TASK_EXECUTORS = "INSERT INTO REFLIST_EMPL (ID_EMPLOYEE, ID_TASK) VALUES (?, ?)";
    public static final String GET_ALL_TASKS = "SELECT * FROM TASKS";
    public static final String GET_TASKS_BY_ID = "SELECT * FROM TASKS WHERE ID = ?";
    public static final String GET_NEXT_TASK_ID = "SELECT ID FROM TASKS ORDER BY ID DESC LIMIT 1";
    public static final String GET_TASKS_BY_PROJECT_ABBR = "SELECT TASKS.ID FROM TASKS WHERE TASKS.PROJECTNAME = ?";
    public static final String GET_TASK_EXECUTORS = "SELECT ID_EMPLOYEE FROM REFLIST_EMPL WHERE ID_TASK = ?";
    public static final String MODIFY_TASK = "UPDATE TASKS SET NAME = ?, DURATION = ?, STARTDATE = ?, ENDDATE = ?, STATE = ?, PROJECTNAME = ? WHERE ID = ?";
    public static final String DELETE_TASK = "DELETE FROM TASKS WHERE ID = ?";
    public static final String DELETE_TASK_EXECUTORS = "DELETE FROM REFLIST_EMPL WHERE ID_TASK = ?";
    public static final String DELETE_TASKS_BY_PROJECT_ABBR = "DELETE FROM TASKS WHERE TASKS.PROJECTNAME = ?";
    public static final String RESET_TASKS_AUTO_INCREMENT = "ALTER TABLE TASKS ALTER COLUMN ID RESTART WITH ";
    //project requests



    private SqlRequests() {}
}
