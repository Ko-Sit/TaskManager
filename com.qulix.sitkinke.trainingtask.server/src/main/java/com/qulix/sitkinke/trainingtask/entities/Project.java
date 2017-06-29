package com.qulix.sitkinke.trainingtask.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class that describes {@link Project}.
 *
 * @author sitkin
 */
public class Project extends Entity {

    private String name;
    private String abbreviation;
    private String description;
    private List<Task> taskList;

    /**
     * Instantiates a new Project.
     */
    public Project() {

    }

    /**
     * Instantiates a new Employee.
     *
     * @param name the name
     * @param abbreviation the abbreviation
     * @param description the description
     */
    public Project(String name, String abbreviation, String description) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
        this.taskList = new ArrayList<>();
    }

    /**
     * Gets project name.
     *
     * @return the project name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets project name.
     *
     * @param name the project name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets project abbreviation.
     *
     * @return the project abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets project abbreviation.
     *
     * @param abbreviation the project abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Gets project description.
     *
     * @return the project description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets project description.
     *
     * @param description the project description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets project taskList.
     *
     * @return the project taskList
     */
    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * Sets project taskList.
     *
     * @param taskList the project task list
     */
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Returns a string representation of the object {@link Project}.
     *
     * @return the project string representation
     */
    @Override
    public String toString() {
        return "Project{" +
            "id = " + getId() +
            ", name = '" + name + '\'' +
            ", abbreviation = '" + abbreviation + '\'' +
            ", description = " + description + '}';
    }
}
