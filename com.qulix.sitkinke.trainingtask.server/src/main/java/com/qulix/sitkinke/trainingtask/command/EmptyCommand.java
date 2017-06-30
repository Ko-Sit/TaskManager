package com.qulix.sitkinke.trainingtask.command;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that redirects request to main page in case
 * of errors or direct access to the controller.
 *
 * @author sitkin
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);
        return page;
    }
}
