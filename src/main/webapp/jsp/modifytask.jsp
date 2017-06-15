<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Modify Task</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="selectedtask" scope="request" type="com.qulix.sitkinke.trainingtask.entities.Task"/>
    <input type="number" name="id" value="${selectedtask.id}" placeholder="id" readonly/>
    <input type="text" name="name" value="${selectedtask.name}" placeholder="name"/>
    <input type="number" name="duration" value="${selectedtask.duration}" placeholder="duration"/>
    <input type="date" name="startdate" value="${selectedtask.startDate}" placeholder="startdate"/>
    <input type="date" name="enddate" value="${selectedtask.endDate}" placeholder="enddate"/>
    <select name="state" title="State">
        <option>NOTSTARTED</option>
        <option>INPROGRESS</option>
        <option>COMPLETED</option>
        <option>POSTPONED</option>
    </select>

    <select name="select2" multiple="multiple" tabindex="1" title="title">
        <jsp:useBean id="employees" scope="request" type="java.util.List"/>
        <c:forEach var="employee" items="${employees}">
            <option>${employee.id}. ${employee.surname} ${employee.name}</option>
        </c:forEach>
    </select>

    <input type="hidden" name="command" value="modifytask"/>
    <input type="submit" value="Modify"/>
</form>
<a href="controller?command=showtasks">Cancel</a>
</body>
</html>
