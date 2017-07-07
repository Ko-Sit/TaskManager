package com.qulix.sitkinke.trainingtask.constants;

import java.util.ArrayList;
import java.util.List;

import com.qulix.sitkinke.trainingtask.command.factory.CommandType;

/**
 * Class that stores the available user command.
 *
 * @author sitkin
 */
public class UserCommandGrant {
    private List<CommandType> grant = new ArrayList<>();
    private static UserCommandGrant instance;

    private UserCommandGrant() {
        grant.add(CommandType.GOTOMODIFYEMPLOYEE);
        grant.add(CommandType.MODIFYEMPLOYEE);
        grant.add(CommandType.GOTOMENU);
        grant.add(CommandType.SHOWEMPLOYEES);
        grant.add(CommandType.SHOWPROJECTS);
        grant.add(CommandType.SHOWTASKS);
        grant.add(CommandType.LOGIN);
        grant.add(CommandType.GOTOREMINDPASSWORD);
        grant.add(CommandType.REMINDPASSWORD);
    }

    public static synchronized UserCommandGrant getInstance() {
        if (instance == null) {
            instance = new UserCommandGrant();
        }
        return instance;
    }

    public List<CommandType> getGrant() {
        return grant;
    }
}
