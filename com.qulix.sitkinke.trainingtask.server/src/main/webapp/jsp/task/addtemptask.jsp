<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <script type="text/javascript" src="../../js/setdate.js"> </script>
    <title>Add Task</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="idgenerated" scope="request" type="java.lang.Integer"/>
    <div class="field">
        <label>ID</label>
        <input type="number" name="id" value="${idgenerated}"  readonly/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" name="name" value="" maxlength="30" required/>
    </div>
    <div class="field">
        <label>Duration</label>
        <input type="number" name="duration" value="" min="1" max="2147483647" required/>
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
        <select name="state" title="State" required>
            <option>NOTSTARTED</option>
            <option>INPROGRESS</option>
            <option>COMPLETED</option>
            <option>POSTPONED</option>
        </select>
    </div>
    <div class="field">
        <label>Project Name</label>
        <select name="projectname" tabindex="1" title="title" required>
            <jsp:useBean id="currentproject" scope="request" type="com.qulix.sitkinke.trainingtask.entities.Project"/>
            <option>${currentproject.id}. ${currentproject.abbreviation} ${currentproject.name}</option>
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

    <button type="submit" name="command" value="addtemptask">Save Task</button>

    <button type="submit" name="command" value="canceltaskinaddproject" formnovalidate>Cancel</button>
</form>
</body>
</html>