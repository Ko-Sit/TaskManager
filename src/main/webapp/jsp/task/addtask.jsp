<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Add Task</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="idgenerated" scope="request" type="java.lang.Integer"/>
    <div class="field">
        <label>ID</label>
        <input type="number" name="id" value="${idgenerated}" readonly/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" name="name" value="" required/>
    </div>
    <div class="field">
        <label>Duration</label>
        <input type="number" name="duration" value="" required/>
    </div>
    <div class="field">
        <label>Start Date</label>
        <input type="date" name="startdate" value="" required/>
    </div>
    <div class="field">
        <label>End Date</label>
        <input type="date" name="enddate" value="" required/>
    </div>
    <div class="field">
        <label>State</label>
        <select name="state" title="State" required>
            <option>NOTSTARTED</option>
            <option>INPROGRESS</option>
            <option>COMPLETED</option>
            <option>POSTPONED</option>
        </select>
    </div>
    <div class="field">
        <label>Project name</label>
        <select name="projectname" tabindex="1" title="title" required>
            <jsp:useBean id="projects" scope="request" type="java.util.List"/>
            <c:forEach var="project" items="${projects}">
                <option>${project.id}. ${project.abbreviation} ${project.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="field">
        <label>Employees</label>
        <select name="select2" multiple="multiple" tabindex="1" title="title" required>
            <jsp:useBean id="employees" scope="request" type="java.util.List"/>
            <c:forEach var="employee" items="${employees}">
                <option>${employee.id}. ${employee.surname} ${employee.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" name="command" value="addtask">Save Task</button>

    <button type="submit" name="command" value="showtasks" formnovalidate>Cancel</button>
</form>
</body>
</html>
