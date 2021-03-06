package com.qulix.sitkinke.trainingtask.command.factory;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.command.EmptyCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;

/**
 * Class that defines the next executed command.
 *
 * @author sitkin
 */
public class ActionFactory {

    /**
     * Sets next command to execute
     *
     * @param request the request
     * @return command the next command
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        // извлечение имени команды из запроса
        String action = request.getParameter(Parameters.COMMAND);
        if (action == null || action.isEmpty()) {
            // если команда не задана в текущем запросе
            System.out.println("Action is empty or null.");
            return current;
        }
        // получение объекта, соответствующего команде
        try {
            CommandType commandType = CommandType.valueOf(action.toUpperCase());

            current = commandType.getCurrentCommand();
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return current;
    }
}