<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Add Task</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="idgenerated" scope="request" type="java.lang.Integer"/>
    <input type="number" name="id" value="${idgenerated}" placeholder="id" readonly/>
    <input type="text" name="name" value="" placeholder="name"/>
    <input type="text" name="abbreviation" value="" placeholder="abbreviation"/>
    <input type="text" name="description" value="" placeholder="description"/>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Duration</th>
            <th>StartDate</th>
            <th>EndDate</th>
            <th>State</th>
            <th>Delete</th>
            <th>Modify</th>
        </tr>

        <jsp:useBean id="projecttasks" scope="request" type="java.util.List"/>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.id}</td>
                <td>${task.name}</td>
                <td>${task.duration}</td>
                <td>${task.startDate}</td>
                <td>${task.endDate}</td>
                <!-- todo add employees -->
                <td>${task.state}</td>
                <td><a href="controller?command=deletetask&id=${task.id}">Delete</a></td>
                <td><a href="controller?command=gotomodifytask&id=${task.id}">Modify</a></td>
            </tr>
        </c:forEach>
    </table>
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="gotoaddtask"/>
        <input type="submit" value="Add Task">
    </form>
    <br>
    <input type="hidden" name="command" value="addproject" />
    <input type="submit" value="Save"/>
</form>
<a href="controller?command=showprojects">Cancel</a>
</body>
</html>
