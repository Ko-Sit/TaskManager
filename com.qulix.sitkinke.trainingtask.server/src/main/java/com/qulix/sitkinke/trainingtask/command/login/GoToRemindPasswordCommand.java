package com.qulix.sitkinke.trainingtask.command.login;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 07.07.2017.
 */
public class GoToRemindPasswordCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        page = ConfigurationManager.getProperty(PathConfigs.REMIND_PASSWORD);
        return page;
    }
}
