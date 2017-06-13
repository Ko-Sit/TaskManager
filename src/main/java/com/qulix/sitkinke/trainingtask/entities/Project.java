package com.qulix.sitkinke.trainingtask.entities;

import java.util.List;

/**
 *
 * Created by upsit on 09.06.2017.
 */
public class Project {
    private int id;
    private String name;
    private String abbreviation;
    private String description;
    private List<Task> taskList;

    public Project() {

    }

    public Project(int id, String name, String abbreviation, String description) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", abbreviation = '" + abbreviation + '\'' +
                ", description = " + description +'}';
    }
}
