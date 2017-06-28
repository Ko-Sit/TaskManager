package com.qulix.sitkinke.trainingtask.command;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
 /* в случае ошибки или прямого обращения к контроллеру
  * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);
        return page;
    }
}
