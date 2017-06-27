package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
import com.qulix.sitkinke.trainingtask.constants.Attributes;
import com.qulix.sitkinke.trainingtask.constants.Parameters;
import com.qulix.sitkinke.trainingtask.constants.PathConfigs;
import com.qulix.sitkinke.trainingtask.dao.ProjectDAO;
import com.qulix.sitkinke.trainingtask.dao.TaskDAO;
import com.qulix.sitkinke.trainingtask.entities.Employee;
import com.qulix.sitkinke.trainingtask.entities.Task;
import com.qulix.sitkinke.trainingtask.enums.State;
import com.qulix.sitkinke.trainingtask.managers.ParseManager;
import com.qulix.sitkinke.trainingtask.managers.SQLDateConverter;
import com.qulix.sitkinke.trainingtask.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by upsit on 19.06.2017.
 */
public class AddTaskFromProjectCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_task = Integer.valueOf(request.getParameter(Parameters.ID));
        String name = request.getParameter(Parameters.TASK_NAME);
        int duration = Integer.valueOf(request.getParameter(Parameters.TASK_DURATION));
        Date startDate = SQLDateConverter.getDate(request.getParameter(Parameters.TASK_STARTDATE));
        Date endDate = SQLDateConverter.getDate(request.getParameter(Parameters.TASK_ENDDATE));
        State state = State.valueOf(request.getParameter(Parameters.TASK_STATE));

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute(Attributes.PROJECT_ID);
        String projectName = (String) session.getAttribute(Attributes.PROJECT_NAME);
        String projectAbbreviation = (String) session.getAttribute(Attributes.PROJECT_ABBREVIATION);
        String projectDescription = (String) session.getAttribute(Attributes.PROJECT_DESCRIPTION);

        List<Employee> employees = ParseManager.getEmployeeList(request.getParameterValues(Parameters.TASK_EMPLOYEES));

        Task task = new Task(name, duration, startDate, endDate, state, projectAbbreviation);
        task.setId(id_task);
        task.setEmployeeList(employees);

        TaskDAO taskDAO = new TaskDAO();
        taskDAO.add(task);

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.addProjectTask(id_project, id_task);

        request.setAttribute(Parameters.ID_GENERATED, id_project);

        List<Task> tasks = projectDAO.getProjectTasks(id_project);

        for (Task tempTask: tasks) {
            taskDAO.modifyProjectNameInTask(projectAbbreviation, tempTask.getId());
        }
        tasks = projectDAO.getProjectTasks(id_project);

        request.setAttribute(Parameters.PROJECT_TASKS, tasks);

        request.setAttribute(Attributes.PROJECT_NAME, projectName);
        request.setAttribute(Attributes.PROJECT_ABBREVIATION, projectAbbreviation);
        request.setAttribute(Attributes.PROJECT_DESCRIPTION, projectDescription);

        page = ConfigurationManager.getProperty(PathConfigs.MODIFY_PROJECT_PAGE);
        return page;
    }
}
