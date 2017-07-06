package com.qulix.sitkinke.trainingtask.entities;

import java.util.ArrayList;
import java.util.List;

import com.qulix.sitkinke.trainingtask.enums.UserType;

/**
 * Entity class that describes {@link Employee}.
 *
 * @author sitkin
 */
public class Employee extends Entity {

    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private List<Task> taskList;
    private String email;
    private String password;
    private UserType userType;

    /**
     * Instantiates a new Employee.
     */
    public Employee() {

    }

    /**
     * Instantiates a new Employee.
     *
     * @param surname the surname
     * @param name the name
     * @param patronymic the patronymic
     * @param position the position
     * @param email the email
     * @param password the password
     * @param userType the user type
     */
    public Employee(String surname, String name, String patronymic, String position, String email, String password, UserType userType) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.taskList = new ArrayList<>();
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    /**
     * Gets employee surname.
     *
     * @return the employee surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets employee surname.
     *
     * @param surname the employee surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets employee name.
     *
     * @return the employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets employee name.
     *
     * @param name the employee name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets employee patronymic.
     *
     * @return the employee patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Sets employee patronymic.
     *
     * @param patronymic the employee patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Gets employee position.
     *
     * @return the employee patronymic
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets employee position.
     *
     * @param position the employee position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets employee task list.
     *
     * @return the employee task list
     */
    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * Sets employee position.
     *
     * @param taskList the employee task list
     */
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Gets employee email.
     *
     * @return the employee email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets employee email.
     *
     * @param email the employee email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets employee password.
     *
     * @return the employee password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets employee password.
     *
     * @param password the employee password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets employee type.
     *
     * @return the employee type
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Sets employee type.
     *
     * @param userType the employee type
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Returns a string representation of the object {@link Employee}.
     *
     * @return the employee string representation
     */
    @Override
    public String toString() {
        return "Employee{" +
            "id = " + getId() +
            ", surname = '" + surname + '\'' +
            ", name = '" + name + '\'' +
            ", patronymic = '" + patronymic + '\'' +
            ", position = " + position + '}';
    }
}