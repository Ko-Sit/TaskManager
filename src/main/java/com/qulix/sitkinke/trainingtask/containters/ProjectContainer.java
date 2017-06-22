package com.qulix.sitkinke.trainingtask.containters;

import com.qulix.sitkinke.trainingtask.entities.Project;

/**
 *
 * Created by upsit on 22.06.2017.
 */
public class ProjectContainer {

    public static Project savedProject;

    public static void put(Project project) {
        savedProject = project;
    }

    public static Project get(){
        return savedProject;
    }

    public static void clear(){
        savedProject = null;
    }
}
