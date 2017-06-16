package com.qulix.sitkinke.trainingtask.command.factory;

import com.qulix.sitkinke.trainingtask.command.*;

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
    },
    GOTOADDTASK {
        {
            this.command = new GoToAddTasksCommand();
        }
    },
    SHOWTASKS {
        {
            this.command = new ShowTasksCommand();
        }
    },
    ADDTASK {
        {
            this.command = new AddTaskCommand();
        }
    },
    DELETEEMPLOYEE{
        {
            this.command = new DeleteEmployeeCommand();
        }
    },
    GOTOMODIFYEMPLOYEE{
        {
            this.command = new GoToModifyEmployeeCommand();
        }
    },
    MODIFYEMPLOYEE{
        {
            this.command = new ModifyEmployeeCommand();
        }
    },
    DELETETASK{
        {
            this.command = new DeleteTaskCommand();
        }
    },
    GOTOMODIFYTASK{
        {
            this.command = new GoToModifyTaskCommand();
        }
    },
    MODIFYTASK{
        {
            this.command = new ModifyTaskCommand();
        }
    },
    SHOWPROJECTS{
        {
            this.command = new ShowProjectsCommand();
        }
    },
    GOTOADDPROJECT{
        {
            this.command = new GoToAddProjectCommand();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}