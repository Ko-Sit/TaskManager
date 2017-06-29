package com.qulix.sitkinke.trainingtask.containters;

import com.qulix.sitkinke.trainingtask.entities.Project;

/**
 * Container that saves the project condition.
 *
 * @author sitkin
 */
public class ProjectContainer {

    private static Project savedProject;

    /**
     * Gets project entity.
     *
     * @return the project entity
     */
    public static Project get() {
        return savedProject;
    }

    /**
     * Sets project entity.
     *
     * @param project the project entity
     */
    public static void put(Project project) {
        savedProject = project;
    }

    /**
     * Clears project entity.
     *
     */
    public static void clear() {
        savedProject = null;
    }
}
