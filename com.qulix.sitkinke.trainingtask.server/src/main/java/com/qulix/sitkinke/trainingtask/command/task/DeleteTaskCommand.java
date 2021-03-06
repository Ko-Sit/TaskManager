package com.qulix.sitkinke.trainingtask.command.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that deletes task.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class DeleteTaskCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Task> tasks;
        TaskDAO taskDAO = new TaskDAO();
        int id_task = Integer.valueOf(request.getParameter(Parameters.ID));
        taskDAO.delete(id_task);

        tasks = taskDAO.getAll();
        request.setAttribute(Parameters.TASK_LIST, tasks);

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.deleteProjectTask(id_task);

        page = ConfigurationManager.getProperty(PathConfigs.SHOW_TASKS_PAGE);
        return page;
    }
}
