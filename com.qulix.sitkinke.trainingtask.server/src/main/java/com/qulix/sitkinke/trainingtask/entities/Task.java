package com.qulix.sitkinke.trainingtask.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qulix.sitkinke.trainingtask.enums.State;

/**
 * Entity class that describes {@link Task}.
 *
 * @author sitkin
 */
public class Task extends Entity {

    private String name;
    private int duration;
    private Date startDate;
    private Date endDate;
    private State state;
    private String projectName;
    private List<Employee> employeeList;

    /**
     * Instantiates a new Task.
     */
    public Task() {

    }

    /**
     * Instantiates a new Task.
     *
     * @param name the name
     * @param duration the duration
     * @param startDate the startDate
     * @param endDate the endDate
     * @param state the state
     * @param projectName the project name
     */
    public Task(String name, int duration, Date startDate, Date endDate, State state, String projectName) {
        this.name = name;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.projectName = projectName;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Gets task name.
     *
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets task name.
     *
     * @param name the task name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets task duration.
     *
     * @return the task duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets task duration.
     *
     * @param duration the task duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets task start date.
     *
     * @return the task start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets task start date.
     *
     * @param startDate the task start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets task end date.
     *
     * @return the task end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets task end date.
     *
     * @param endDate the task end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets task state.
     *
     * @return the task state
     */
    public State getState() {
        return state;
    }

    /**
     * Sets task state.
     *
     * @param state the task state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets task project name.
     *
     * @return the task project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets task project name.
     *
     * @param projectName the task project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Gets task employee list.
     *
     * @return the task employee list
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Sets task employee list.
     *
     * @param employeeList the task employee list
     */
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + getId() +
            ", name='" + name + '\'' +
            ", duration=" + duration +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", state=" + state +
            '}';
    }
}
