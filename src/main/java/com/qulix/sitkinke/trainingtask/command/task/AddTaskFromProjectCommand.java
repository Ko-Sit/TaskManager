package com.qulix.sitkinke.trainingtask.command.task;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;
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

        int id_task = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        int duration = Integer.valueOf(request.getParameter("duration"));
        Date startDate = SQLDateConverter.getDate(request.getParameter("startdate"));
        Date endDate = SQLDateConverter.getDate(request.getParameter("enddate"));
        State state = State.valueOf(request.getParameter("state"));

        HttpSession session = request.getSession();
        int id_project = (int) session.getAttribute("projectid");
        String projectName = (String) session.getAttribute("projectname");
        String projectAbbreviation = (String) session.getAttribute("projectabbr");
        String projectDescription = (String) session.getAttribute("projectdescr");

        List<Employee> employees = ParseManager.getEmployeeList(request.getParameterValues("select2"));

        Task task = new Task(name, duration, startDate, endDate, state, projectAbbreviation);
        task.setId(id_task);
        task.setEmployeeList(employees);

        TaskDAO taskDAO = new TaskDAO();
        taskDAO.addTask(task);

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.addProjectTask(id_project, id_task);

        request.setAttribute("idgenerated", id_project);

        List<Task> tasks = projectDAO.getProjectTasks(id_project);

        for (Task tempTask: tasks) {
            taskDAO.modifyProjectNameInTask(projectAbbreviation, tempTask.getId());
        }
        tasks = projectDAO.getProjectTasks(id_project);

        request.setAttribute("projecttasks", tasks);

        request.setAttribute("projectname", projectName);
        request.setAttribute("projectabbr", projectAbbreviation);
        request.setAttribute("projectdescr", projectDescription);

        page = ConfigurationManager.getProperty("path.page.modifyproject");
        return page;
    }
}
