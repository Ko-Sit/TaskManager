package com.qulix.sitkinke.trainingtask.command.login;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that redirects page to remind password page.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class GoToRemindPasswordCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        page = ConfigurationManager.getProperty(PathConfigs.REMIND_PASSWORD);
        return page;
    }
}
