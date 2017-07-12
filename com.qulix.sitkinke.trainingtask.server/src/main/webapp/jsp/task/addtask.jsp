<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <script type="text/javascript" src="../../js/datavalidator.js"></script>
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
        <input type="text" name="name" value="" maxlength="100" required/>
    </div>
    <div class="field">
        <label>Duration (h)</label>
        <input type="number" name="duration" id="duration" value="" min="1" max="100000"  required/>
    </div>
    <div class="field">
        <label>Start Date</label>
        <input type="date" name="startdate" id="startdate" value="" onclick="setMax()" required/>
    </div>
    <div class="field">
        <label>End Date</label>
        <input type="date" name="enddate" id="enddate" value="" onclick="setMin()" required/>
    </div>
    <div class="field">
        <label>State</label>
        <select name="state" id="state" title="State" required onclick="validateState()">
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
    <button type="submit" name="command" value="addtask" onclick="validateDuration()">Save Task</button>

    <button type="submit" name="command" value="showtasks" formnovalidate>Cancel</button>
</form>
</body>
</html>
