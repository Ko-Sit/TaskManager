package com.qulix.sitkinke.trainingtask.constants;

/**
 * Class that stores the sql requests.
 *
 * @author sitkin
 */
public class SqlRequests {

    // employee requests
    public static final String ADD_EMPLOYEE = "INSERT INTO EMPLOYEES (NAME, SURNAME, PATRONYMIC, POSITION, EMAIL, PASSWORD, USERTYPE) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEES";
    public static final String GET_EMPLOYEES_BY_ID = "SELECT * FROM EMPLOYEES WHERE ID = ?";
    public static final String GET_EMPLOYEE_BY_EMAIL = "SELECT * FROM EMPLOYEES WHERE EMAIL = ?";
    public static final String GET_NEXT_EMPLOYEE_ID = "SELECT ID FROM EMPLOYEES ORDER BY ID DESC LIMIT 1";
    public static final String MODIFY_EMPLOYEE = "UPDATE EMPLOYEES SET NAME = ?, SURNAME = ?, PATRONYMIC = ?, POSITION = ?, EMAIL = ?, PASSWORD = ?, USERTYPE = ? WHERE ID = ?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE ID = ?";
    public static final String DELETE_EMPLOYEE_TASKS = "DELETE FROM REFLIST_EMPL WHERE ID_EMPLOYEE = ?";
    public static final String RESET_EMPLOYEES_AUTO_INCREMENT = "ALTER TABLE EMPLOYEES ALTER COLUMN ID RESTART WITH ";
    public static final String CHECK_AUTHORIZATION = "SELECT EMAIL, PASSWORD FROM EMPLOYEES WHERE EMAIL = ? AND PASSWORD = ?";

    // task requests
    public static final String ADD_TASK = "INSERT INTO TASKS (NAME, DURATION, STARTDATE, ENDDATE, STATE, PROJECTNAME) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String ADD_TASK_EXECUTORS = "INSERT INTO REFLIST_EMPL (ID_EMPLOYEE, ID_TASK) VALUES (?, ?)";
    public static final String GET_ALL_TASKS = "SELECT * FROM TASKS";
    public static final String GET_TASKS_BY_ID = "SELECT * FROM TASKS WHERE ID = ?";
    public static final String GET_NEXT_TASK_ID = "SELECT ID FROM TASKS ORDER BY ID DESC LIMIT 1";
    public static final String GET_TASKS_BY_PROJECT_ABBR = "SELECT ID FROM TASKS WHERE PROJECTNAME = ?";
    public static final String GET_TASK_EXECUTORS = "SELECT ID_EMPLOYEE FROM REFLIST_EMPL WHERE ID_TASK = ?";
    public static final String MODIFY_TASK = "UPDATE TASKS SET NAME = ?, DURATION = ?, STARTDATE = ?, ENDDATE = ?, STATE = ?, PROJECTNAME = ? WHERE ID = ?";
    public static final String MODIFY_PROJECT_ABBR = "UPDATE TASKS SET PROJECTNAME = ? WHERE ID = ?";
    public static final String DELETE_TASK = "DELETE FROM TASKS WHERE ID = ?";
    public static final String DELETE_TASK_EXECUTORS = "DELETE FROM REFLIST_EMPL WHERE ID_TASK = ?";
    public static final String DELETE_TASKS_BY_PROJECT_ABBR = "DELETE FROM TASKS WHERE TASKS.PROJECTNAME = ?";
    public static final String RESET_TASKS_AUTO_INCREMENT = "ALTER TABLE TASKS ALTER COLUMN ID RESTART WITH ";

    //project requests
    public static final String ADD_PROJECT = "INSERT INTO PROJECTS (NAME, ABBREVIATION, DESCRIPTION) VALUES (?, ?, ?)";
    public static final String ADD_PROJECT_TASKS = "INSERT INTO REFLIST_PROJ (ID_PROJECT, ID_TASK) VALUES (?, ?)";
    public static final String GET_PROJECT_TASKS = "SELECT ID_TASK FROM REFLIST_PROJ WHERE ID_PROJECT = ?";
    public static final String GET_PROJECTS_BY_ID = "SELECT * FROM PROJECTS WHERE ID = ?";
    public static final String GET_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    public static final String GET_NEXT_PROJECT_ID = "SELECT ID FROM PROJECTS ORDER BY ID DESC LIMIT 1";
    public static final String MODIFY_PROJECT = "UPDATE PROJECTS SET NAME = ?, ABBREVIATION = ?, DESCRIPTION = ? WHERE ID = ?";
    public static final String DELETE_PROJECT = "DELETE FROM PROJECTS WHERE ID = ?";
    public static final String DELETE_PROJECT_TASKS_BY_ID_PROJECT = "DELETE FROM REFLIST_PROJ WHERE ID_PROJECT = ?";
    public static final String DELETE_PROJECT_TASK_BY_ID_TASK = "DELETE FROM REFLIST_PROJ WHERE ID_TASK = ?";
    public static final String RESET_PROJECTS_AUTO_INCREMENT = "ALTER TABLE PROJECTS ALTER COLUMN ID RESTART WITH ";

    /**
     * Instantiates a new SqlRequests.
     */
    private SqlRequests() {
    }
}
