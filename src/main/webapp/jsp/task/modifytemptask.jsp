<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Modify Task</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="selectedtask" scope="request" type="com.qulix.sitkinke.trainingtask.entities.Task"/>
    <div class="field">
        <label>ID</label>
        <input type="number" name="id" value="${selectedtask.id}" placeholder="id" readonly/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" name="name" value="${selectedtask.name}" placeholder="name"/>
    </div>
    <div class="field">
        <label>Duration</label>
        <input type="number" name="duration" value="${selectedtask.duration}" placeholder="duration"/>
    </div>
    <div class="field">
        <label>Start Date</label>
        <input type="date" name="startdate" value="${selectedtask.startDate}" placeholder="startdate"/>
    </div>
    <div class="field">
        <label>End Date</label>
        <input type="date" name="enddate" value="${selectedtask.endDate}" placeholder="enddate"/>
    </div>
    <div class="field">
        <label>State</label>
        <select name="state" title="State">
            <option>NOTSTARTED</option>
            <option>INPROGRESS</option>
            <option>COMPLETED</option>
            <option>POSTPONED</option>
        </select>
    </div>
    <div class="field">
        <label>Project Name</label>
        <select name="projectname" tabindex="1" title="title">
            <jsp:useBean id="currentproject" scope="request" type="com.qulix.sitkinke.trainingtask.entities.Project"/>
            <option>${currentproject.id}. ${currentproject.abbreviation} ${currentproject.name}</option>
        </select>
    </div>
    <div class="field">
        <label>Employees</label>
        <select name="select2" multiple="multiple" tabindex="1" title="title">
            <jsp:useBean id="employees" scope="request" type="java.util.List"/>
            <c:forEach var="employee" items="${employees}">
                <option>${employee.id}. ${employee.surname} ${employee.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" name="command" value="modifytemptask">Modify</button>

    <button type="submit" name="command" value="addproject">Cancel</button>
</form>
</body>
</html>
