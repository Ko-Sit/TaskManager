package com.qulix.sitkinke.trainingtask.command.task;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Project;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.enums.State;
import com.qulix.sitkinke.trainingtask.managers.ParseManager;
import com.qulix.sitkinke.trainingtask.managers.SQLDateConverter;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

/**
 * Class that adds task.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class AddTaskCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_task = Integer.valueOf(request.getParameter(Parameters.ID));
        String name = request.getParameter(Parameters.TASK_NAME);
        int duration = Integer.valueOf(request.getParameter(Parameters.TASK_DURATION));
        Date startDate = SQLDateConverter.getDate(request.getParameter(Parameters.TASK_STARTDATE));
        Date endDate = SQLDateConverter.getDate(request.getParameter(Parameters.TASK_ENDDATE));
        State state = State.valueOf(request.getParameter(Parameters.TASK_STATE));
        Project project = ParseManager.getTaskProject(request.getParameter(Parameters.TASK_PROJECT_NAME));
        int id_project = project.getId();
        String projectAbbreviation = project.getAbbreviation();
        List<Employee> employees = ParseManager.getEmployeeList(request.getParameterValues(Parameters.TASK_EMPLOYEES));

        Task task = new Task(name, duration, startDate, endDate, state, projectAbbreviation);
        task.setId(id_task);
        task.setEmployeeList(employees);
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.add(task);

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.addProjectTask(id_project, id_task);

        List<Task> tasks;
        tasks = taskDAO.getAll();
        request.setAttribute(Parameters.TASK_LIST, tasks);

        page = ConfigurationManager.getProperty(PathConfigs.SHOW_TASKS_PAGE);
        return page;
    }
}
