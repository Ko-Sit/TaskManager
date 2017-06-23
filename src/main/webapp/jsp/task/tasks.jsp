<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../../css/style.css">
    <title>Tasks</title>
</head>
<body>
<h1>Task List</h1>
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

    <jsp:useBean id="tasks" scope="request" type="java.util.List<com.qulix.sitkinke.trainingtask.entities.Task>"/>
    <c:forEach var="task" items="${tasks}">
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
            <td><a href="controller?command=deletetask&id=${task.id}">Delete</a></td>
            <td><a href="controller?command=gotomodifytask&id=${task.id}">Modify</a></td>
        </tr>
    </c:forEach>
</table>
<form name="loginForm" method="POST" action="controller">
    <button type="submit" name="command" value="gotoaddtask">Add Task</button>

    <button type="submit" name="command" value="gotomenu">Back</button>
</form>
</body>
</html>
