package com.qulix.sitkinke.trainingtask.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by upsit on 09.06.2017.
 */
public class Project extends Entity {

    private String name;
    private String abbreviation;
    private String description;
    private List<Task> taskList;

    public Project() {

    }

    public Project(String name, String abbreviation, String description) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
        this.taskList = new ArrayList<>();
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
            "id = " + getId() +
            ", name = '" + name + '\'' +
            ", abbreviation = '" + abbreviation + '\'' +
            ", description = " + description + '}';
    }
}
