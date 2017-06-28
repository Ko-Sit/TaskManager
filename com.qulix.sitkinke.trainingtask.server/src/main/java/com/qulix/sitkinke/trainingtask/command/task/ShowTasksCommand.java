package com.qulix.sitkinke.trainingtask.command.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class ShowTasksCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Task> tasks;
        TaskDAO taskDAO = new TaskDAO();
        tasks = taskDAO.getAll();
        request.setAttribute(Parameters.TASK_LIST, tasks);

        page = ConfigurationManager.getProperty(PathConfigs.SHOW_TASKS_PAGE);
        return page;
    }
}
