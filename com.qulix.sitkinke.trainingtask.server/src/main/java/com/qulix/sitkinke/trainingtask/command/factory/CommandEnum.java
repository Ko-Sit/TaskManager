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
public enum CommandEnum {
    ADDEMPLOYEE,
    SHOWEMPLOYEES,
    GOTOADDEMPLOYEE,
    GOTOADDTASK,
    SHOWTASKS,
    ADDTASK,
    DELETEEMPLOYEE,
    GOTOMODIFYEMPLOYEE,
    MODIFYEMPLOYEE,
    DELETETASK,
    GOTOMODIFYTASK,
    MODIFYTASK,
    SHOWPROJECTS,
    GOTOADDPROJECT,
    DELETEPROJECT,
    ADDPROJECT,
    GOTOADDTEMPTASK,
    ADDTEMPTASK,
    DELETETEMPTASK,
    GOTOMODIFYTEMPTASK,
    MODIFYTEMPTASK,
    GOTOMODIFYPROJECT,
    MODIFYPROJECT,
    DELETETASKFROMPROJECT,
    GOTOADDTASKFROMPROJECT,
    ADDTASKFROMPROJECT,
    GOTOMODIFYTASKFROMPROJECT,
    MODIFYTASKFROMPROJECT,
    CANCELADDPROJECT,
    CANCELMODIFYPROJECT,
    CANCELTASKINMODIFYPROJECT,
    CANCELTASKINADDPROJECT,
    GOTOMENU;

    public ActionCommand getCurrentCommand() {
        switch (this) {
            case ADDEMPLOYEE:
                return new AddEmployeeCommand();

            case SHOWEMPLOYEES:
                return new ShowEmployeesCommand();

            case GOTOADDEMPLOYEE:
                return new GoToAddEmployeesCommand();

            case GOTOADDTASK:
                return new GoToAddTasksCommand();

            case SHOWTASKS:
                return new ShowTasksCommand();

            case ADDTASK:
                return new AddTaskCommand();

            case DELETEEMPLOYEE:
                return new DeleteEmployeeCommand();

            case GOTOMODIFYEMPLOYEE:
                return new GoToModifyEmployeeCommand();

            case MODIFYEMPLOYEE:
                return new ModifyEmployeeCommand();

            case DELETETASK:
                return new DeleteTaskCommand();

            case GOTOMODIFYTASK:
                return new GoToModifyTaskCommand();

            case MODIFYTASK:
                return new ModifyTaskCommand();

            case SHOWPROJECTS:
                return new ShowProjectsCommand();

            case GOTOADDPROJECT:
                return new GoToAddProjectCommand();

            case DELETEPROJECT:
                return new DeleteProjectCommand();

            case ADDPROJECT:
                return new AddProjectCommand();

            case GOTOADDTEMPTASK:
                return new GoToAddTempTaskCommand();

            case ADDTEMPTASK:
                return new AddTempTaskCommand();

            case DELETETEMPTASK:
                return new DeleteTempTaskCommand();

            case GOTOMODIFYTEMPTASK:
                return new GoToModifyTempTaskCommand();

            case MODIFYTEMPTASK:
                return new ModifyTempTaskCommand();

            case GOTOMODIFYPROJECT:
                return new GoToModifyProjectCommand();

            case MODIFYPROJECT:
                return new ModifyProjectCommand();

            case DELETETASKFROMPROJECT:
                return new DeleteTaskFromProjectCommand();

            case GOTOADDTASKFROMPROJECT:
                return new GoToAddTaskFromProjectCommand();

            case ADDTASKFROMPROJECT:
                return new AddTaskFromProjectCommand();

            case GOTOMODIFYTASKFROMPROJECT:
                return new GoToModifyTaskFromProjectCommand();

            case MODIFYTASKFROMPROJECT:
                return new ModifyTaskFromProjectCommand();

            case CANCELADDPROJECT:
                return new CancelAddProjectCommand();

            case CANCELMODIFYPROJECT:
                return new CancelModifyProjectCommand();

            case CANCELTASKINMODIFYPROJECT:
                return new CancelTaskInModifyProjectCommand();

            case CANCELTASKINADDPROJECT:
                return new CancelTaskInAddProjectCommand();

            case GOTOMENU:
                return new GoToMenuCommand();

            default:
                return new EmptyCommand();
        }
    }
}