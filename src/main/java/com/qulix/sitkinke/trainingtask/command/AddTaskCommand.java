package com.qulix.sitkinke.trainingtask.command;

import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.enums.State;
import com.qulix.sitkinke.trainingtask.managers.SQLDateConverter;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class AddTaskCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        int duration = Integer.valueOf(request.getParameter("duration"));
        Date startDate = SQLDateConverter.getDate(request.getParameter("startdate"));
        Date endDate = SQLDateConverter.getDate(request.getParameter("enddate"));
        State state = State.valueOf(request.getParameter("state"));

        Task task = new Task(id, name, duration, startDate, endDate, state);
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.addTask(task);

        page = ConfigurationManager.getProperty("path.page.addtask");
        return page;
    }
}
