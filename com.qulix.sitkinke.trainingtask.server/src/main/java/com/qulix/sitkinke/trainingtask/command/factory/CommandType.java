package com.qulix.sitkinke.trainingtask.command.factory;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.command.EmptyCommand;
import com.qulix.sitkinke.trainingtask.command.employee.AddEmployeeCommand;
import com.qulix.sitkinke.trainingtask.command.employee.DeleteEmployeeCommand;
import com.qulix.sitkinke.trainingtask.command.employee.GoToAddEmployeesCommand;
import com.qulix.sitkinke.trainingtask.command.employee.GoToModifyEmployeeCommand;
import com.qulix.sitkinke.trainingtask.command.employee.ModifyEmployeeCommand;
import com.qulix.sitkinke.trainingtask.command.employee.ShowEmployeesCommand;
import com.qulix.sitkinke.trainingtask.command.menu.GoToMenuCommand;
import com.qulix.sitkinke.trainingtask.command.project.AddProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.CancelAddProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.CancelModifyProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.CancelTaskInAddProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.CancelTaskInModifyProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.DeleteProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.GoToAddProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.GoToModifyProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.ModifyProjectCommand;
import com.qulix.sitkinke.trainingtask.command.project.ShowProjectsCommand;
import com.qulix.sitkinke.trainingtask.command.task.AddTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.AddTaskFromProjectCommand;
import com.qulix.sitkinke.trainingtask.command.task.AddTempTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.DeleteTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.DeleteTaskFromProjectCommand;
import com.qulix.sitkinke.trainingtask.command.task.DeleteTempTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.GoToAddTaskFromProjectCommand;
import com.qulix.sitkinke.trainingtask.command.task.GoToAddTasksCommand;
import com.qulix.sitkinke.trainingtask.command.task.GoToAddTempTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.GoToModifyTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.GoToModifyTaskFromProjectCommand;
import com.qulix.sitkinke.trainingtask.command.task.GoToModifyTempTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.ModifyTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.ModifyTaskFromProjectCommand;
import com.qulix.sitkinke.trainingtask.command.task.ModifyTempTaskCommand;
import com.qulix.sitkinke.trainingtask.command.task.ShowTasksCommand;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public enum CommandType {
    ADDEMPLOYEE (new AddEmployeeCommand()),
    SHOWEMPLOYEES (new ShowEmployeesCommand()),
    GOTOADDEMPLOYEE (new GoToAddEmployeesCommand()),
    GOTOADDTASK (new GoToAddTasksCommand()),
    SHOWTASKS (new ShowTasksCommand()),
    ADDTASK (new AddTaskCommand()),
    DELETEEMPLOYEE (new DeleteEmployeeCommand()),
    GOTOMODIFYEMPLOYEE (new GoToModifyEmployeeCommand()),
    MODIFYEMPLOYEE (new ModifyEmployeeCommand()),
    DELETETASK (new DeleteTaskCommand()),
    GOTOMODIFYTASK (new GoToModifyTaskCommand()),
    MODIFYTASK (new ModifyTaskCommand()),
    SHOWPROJECTS (new ShowProjectsCommand()),
    GOTOADDPROJECT (new GoToAddProjectCommand()),
    DELETEPROJECT (new DeleteProjectCommand()),
    ADDPROJECT (new AddProjectCommand()),
    GOTOADDTEMPTASK (new GoToAddTempTaskCommand()),
    ADDTEMPTASK (new AddTempTaskCommand()),
    DELETETEMPTASK (new DeleteTempTaskCommand()),
    GOTOMODIFYTEMPTASK (new GoToModifyTempTaskCommand()),
    MODIFYTEMPTASK (new ModifyTempTaskCommand()),
    GOTOMODIFYPROJECT (new GoToModifyProjectCommand()),
    MODIFYPROJECT (new ModifyProjectCommand()),
    DELETETASKFROMPROJECT (new DeleteTaskFromProjectCommand()),
    GOTOADDTASKFROMPROJECT (new GoToAddTaskFromProjectCommand()),
    ADDTASKFROMPROJECT (new AddTaskFromProjectCommand()),
    GOTOMODIFYTASKFROMPROJECT (new GoToModifyTaskFromProjectCommand()),
    MODIFYTASKFROMPROJECT (new ModifyTaskFromProjectCommand()),
    CANCELADDPROJECT (new CancelAddProjectCommand()),
    CANCELMODIFYPROJECT (new CancelModifyProjectCommand()),
    CANCELTASKINMODIFYPROJECT (new CancelTaskInModifyProjectCommand()),
    CANCELTASKINADDPROJECT (new CancelTaskInAddProjectCommand()),
    GOTOMENU (new GoToMenuCommand());

    CommandType (ActionCommand command) {
        this.command = command;
    }

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}