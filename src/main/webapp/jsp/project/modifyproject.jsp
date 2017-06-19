<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Modify Project</title>
</head>
<body>
<form name="addProjectForm" method="POST" action="controller">
    <jsp:useBean id="projectid" scope="session" type="java.lang.Integer"/>
    <jsp:useBean id="projectname" scope="session" type="java.lang.String"/>
    <jsp:useBean id="projectabbr" scope="session" type="java.lang.String"/>
    <jsp:useBean id="projectdescr" scope="session" type="java.lang.String"/>
    <input type="number" name="id" value="${projectid}" placeholder="id" readonly/>
    <input type="text" name="name" value="${projectname}" placeholder="name"/>
    <input type="text" name="abbreviation" value="${projectabbr}" placeholder="abbreviation"/>
    <input type="text" name="description" value="${projectdescr}" placeholder="description"/>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>Task Name</th>
            <th>Duration</th>
            <th>StartDate</th>
            <th>EndDate</th>
            <th>Project Abbr</th>
            <th>Executors</th>
            <th>State</th>
            <th>Delete</th>
            <th>Modify</th>
        </tr>

        <jsp:useBean id="projecttasks" scope="request" type="java.util.List"/>
        <c:forEach var="task" items="${projecttasks}">
            <tr>
                <td>${task.id}</td>
                <td>${task.name}</td>
                <td>${task.duration}</td>
                <td>${task.startDate}</td>
                <td>${task.endDate}</td>
                <td>${task.projectName}</td>
                <td>
                    <c:forEach var="employee" items="${task.employeeList}">
                        ${employee.name} ${employee.surname} ${employee.patronymic} <br>
                    </c:forEach>
                </td>
                <td>${task.state}</td>
                <td><a href="controller?command=deletetaskfromproject&id=${task.id}">Delete</a></td>
                <td><a href="controller?command=gotomodifytaskfromproject&id=${task.id}">Modify</a></td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit" name="command" value="gotoaddtaskfromproject">Add task</button>
    <br>
    <button type="submit" name="command" value="modifyproject">Save</button>
</form>

<a href="controller?command=showprojects">Cancel</a>
</body>
</html>
