package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.enums.State;
import com.qulix.sitkinke.trainingtask.managers.ParseManager;
import com.qulix.sitkinke.trainingtask.managers.SQLDateConverter;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by upsit on 14.06.2017.
 */
public class AddTaskCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_task = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        int duration = Integer.valueOf(request.getParameter("duration"));
        Date startDate = SQLDateConverter.getDate(request.getParameter("startdate"));
        Date endDate = SQLDateConverter.getDate(request.getParameter("enddate"));
        State state = State.valueOf(request.getParameter("state"));
        Project project = ParseManager.getTaskProject(request.getParameter("projectname"));
        int id_project = project.getId();
        String projectName = project.getName();
        List<Employee> employees = ParseManager.getEmployeeList(request.getParameterValues("select2"));

        Task task = new Task(name, duration, startDate, endDate, state, projectName);
        task.setId(id_task);
        task.setEmployeeList(employees);
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.addTask(task);

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.addProjectTask(id_project, id_task);

        // page addtask requires attribute employees
        List<Task> tasks;
        tasks = taskDAO.getAll();
        request.setAttribute("tasks", tasks);

        page = ConfigurationManager.getProperty("path.page.showtasks");
        return page;
    }
}
