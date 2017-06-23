package com.qulix.sitkinke.trainingtask.command;

import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
 /* в случае ошибки или прямого обращения к контроллеру
  * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.main");
        return page;
    }
}
