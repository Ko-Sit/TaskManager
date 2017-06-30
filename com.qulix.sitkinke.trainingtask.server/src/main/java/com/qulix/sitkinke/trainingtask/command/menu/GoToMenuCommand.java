package com.qulix.sitkinke.trainingtask.command.menu;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that redirects page to main menu.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class GoToMenuCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);

        return page;
    }
}
