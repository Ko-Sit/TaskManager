package com.qulix.sitkinke.trainingtask.command.factory;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.command.EmptyCommand;
import com.qulix.sitkinke.trainingtask.containters.CommandManager;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        // извлечение имени команды из запроса
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            // если команда не задана в текущем запросе
            System.out.println("Action is empty or null.");
            return current;
        }
        // получение объекта, соответствующего команде
        try {
            CommandType commandType = CommandType.valueOf(action.toUpperCase());

            //current = currentEnum.getCurrentCommand();
            current = CommandManager.getInstance().getCommand(commandType);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return current;
    }
}