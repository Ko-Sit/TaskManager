package com.qulix.sitkinke.trainingtask.command;

import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by upsit on 15.06.2017.
 */
public class DeleteTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Task> tasks;
        TaskDAO taskDAO = new TaskDAO();
        int id_task = Integer.valueOf(request.getParameter("id"));
        taskDAO.deleteTask(id_task);

        tasks = taskDAO.getAll();
        request.setAttribute("tasks", tasks);

        page = ConfigurationManager.getProperty("path.page.showtasks");
        return page;
    }
}
