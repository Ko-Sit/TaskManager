package com.qulix.sitkinke.trainingtask.containters;

import java.util.HashMap;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.command.employee.*;
import com.qulix.sitkinke.trainingtask.command.project.*;
import com.qulix.sitkinke.trainingtask.command.factory.*;
import com.qulix.sitkinke.trainingtask.command.task.*;
import com.qulix.sitkinke.trainingtask.command.menu.*;

/**
 *
 * Created by upsit on 28.06.2017.
 */
public class CommandManager {

    private static CommandManager instance;
    private static HashMap<CommandType, ActionCommand> commandContainer;

    private CommandManager() {
        commandContainer = new HashMap<>();
        commandContainer.put(CommandType.ADDEMPLOYEE, new AddEmployeeCommand());
        commandContainer.put(CommandType.SHOWEMPLOYEES, new ShowEmployeesCommand());
        commandContainer.put(CommandType.GOTOADDEMPLOYEE, new GoToAddEmployeesCommand());
        commandContainer.put(CommandType.GOTOADDTASK, new GoToAddTasksCommand());
        commandContainer.put(CommandType.SHOWTASKS, new ShowTasksCommand());
        commandContainer.put(CommandType.ADDTASK, new AddTaskCommand());
        commandContainer.put(CommandType.DELETEEMPLOYEE, new DeleteEmployeeCommand());
        commandContainer.put(CommandType.GOTOMODIFYEMPLOYEE, new GoToModifyEmployeeCommand());
        commandContainer.put(CommandType.MODIFYEMPLOYEE, new ModifyEmployeeCommand());
        commandContainer.put(CommandType.DELETETASK, new DeleteTaskCommand());
        commandContainer.put(CommandType.GOTOMODIFYTASK, new GoToModifyTaskCommand());
        commandContainer.put(CommandType.MODIFYTASK, new ModifyTaskCommand());
        commandContainer.put(CommandType.SHOWPROJECTS, new ShowProjectsCommand());
        commandContainer.put(CommandType.GOTOADDPROJECT, new GoToAddProjectCommand());
        commandContainer.put(CommandType.DELETEPROJECT, new DeleteProjectCommand());
        commandContainer.put(CommandType.ADDPROJECT, new AddProjectCommand());
        commandContainer.put(CommandType.GOTOADDTEMPTASK, new GoToAddTempTaskCommand());
        commandContainer.put(CommandType.ADDTEMPTASK, new AddTempTaskCommand());
        commandContainer.put(CommandType.DELETETEMPTASK, new DeleteTempTaskCommand());
        commandContainer.put(CommandType.GOTOMODIFYTEMPTASK, new GoToModifyTempTaskCommand());
        commandContainer.put(CommandType.MODIFYTEMPTASK, new ModifyTempTaskCommand());
        commandContainer.put(CommandType.GOTOMODIFYPROJECT, new GoToModifyProjectCommand());
        commandContainer.put(CommandType.MODIFYPROJECT, new ModifyProjectCommand());
        commandContainer.put(CommandType.DELETETASKFROMPROJECT, new DeleteTaskFromProjectCommand());
        commandContainer.put(CommandType.GOTOADDTASKFROMPROJECT, new GoToAddTaskFromProjectCommand());
        commandContainer.put(CommandType.ADDTASKFROMPROJECT, new AddTaskFromProjectCommand());
        commandContainer.put(CommandType.GOTOMODIFYTASKFROMPROJECT, new GoToModifyTaskFromProjectCommand());
        commandContainer.put(CommandType.MODIFYTASKFROMPROJECT, new ModifyTaskFromProjectCommand());
        commandContainer.put(CommandType.CANCELADDPROJECT, new CancelAddProjectCommand());
        commandContainer.put(CommandType.CANCELMODIFYPROJECT, new CancelModifyProjectCommand());
        commandContainer.put(CommandType.CANCELTASKINMODIFYPROJECT, new CancelTaskInModifyProjectCommand());
        commandContainer.put(CommandType.CANCELTASKINADDPROJECT, new CancelTaskInAddProjectCommand());
        commandContainer.put(CommandType.GOTOMENU, new GoToMenuCommand());

    }

    public static synchronized CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public ActionCommand getCommand(CommandType commandEnum) {
        return commandContainer.get(commandEnum);
    }
}
