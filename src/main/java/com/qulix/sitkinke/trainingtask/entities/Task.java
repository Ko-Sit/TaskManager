package com.qulix.sitkinke.trainingtask.entities;

import com.qulix.sitkinke.trainingtask.enums.State;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by upsit on 09.06.2017.
 */
public class Task {
    private int id;
    private String name;
    private int duration;
    private Date startDate;
    private Date endDate;
    private State state;
    private String projectName;
    private List<Employee> employeeList;

    public Task() {
    }

    public Task(String name, int duration, Date startDate, Date endDate, State state, String projectName) {
        this.name = name;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.projectName = projectName;
        this.employeeList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", state=" + state +
                '}';
    }
}
