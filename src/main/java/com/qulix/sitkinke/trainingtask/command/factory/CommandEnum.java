package com.qulix.sitkinke.trainingtask.command.factory;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.command.AddEmployeeCommand;
import com.qulix.sitkinke.trainingtask.command.GoToAddEmployeesCommand;
import com.qulix.sitkinke.trainingtask.command.ShowEmployeesCommand;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public enum CommandEnum {
    ADDEMPLOYEE {
        {
            this.command = new AddEmployeeCommand();
        }
    },
    SHOWEMPLOYEES {
        {
            this.command = new ShowEmployeesCommand();
        }
    },
    GOTOADDEMPLOYEE {
        {
            this.command = new GoToAddEmployeesCommand();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}