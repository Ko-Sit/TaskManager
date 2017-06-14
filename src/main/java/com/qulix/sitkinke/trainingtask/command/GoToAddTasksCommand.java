package com.qulix.sitkinke.trainingtask.command;

import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class GoToAddTasksCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        page = ConfigurationManager.getProperty("path.page.addtask");
        return page;
    }
}
