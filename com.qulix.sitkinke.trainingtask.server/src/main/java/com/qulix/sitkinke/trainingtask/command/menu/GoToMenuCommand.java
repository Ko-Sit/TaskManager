package com.qulix.sitkinke.trainingtask.command.menu;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by upsit on 23.06.2017.
 */
public class GoToMenuCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);

        return page;
    }
}
