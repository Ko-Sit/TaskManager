<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../../css/style.css">
    <script type="text/javascript" src="../../js/loadprojectfields.js"></script>
    <title>Add Project</title>
</head>
<body>
<form name="addProjectForm" method="POST" action="controller">
    <jsp:useBean id="idgenerated" scope="session" type="java.lang.Integer"/>
    <jsp:useBean id="projectname" scope="session" type="java.lang.String"/>
    <jsp:useBean id="projectabbr" scope="session" type="java.lang.String"/>
    <jsp:useBean id="projectdescr" scope="session" type="java.lang.String"/>
    <div class="field">
        <label>ID</label>
        <input type="number" name="id" value="${idgenerated}" readonly/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" name="name" id="name" value="${projectname}" maxlength="30" required/>
    </div>
    <div class="field">
        <label>Abbreviation</label>
        <input type="text" name="abbreviation" id="abbr" value="${projectabbr}" maxlength="30" required/>
    </div>
    <div class="field">
        <label>Description</label>
        <input type="text" name="description" id="descr" value="${projectdescr}" maxlength="100" required/>
    </div>
    <h1>Task List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Duration</th>
            <th>StartDate</th>
            <th>EndDate</th>
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
                <td>
                    <c:forEach var="employee" items="${task.employeeList}">
                        ${employee.name} ${employee.surname} ${employee.patronymic} <br>
                    </c:forEach>
                </td>
                <td>${task.state}</td>
                <td>
                    <a id="deletelink" href="controller?command=deletetemptask&id=${task.id}" onclick="load('deletelink')">Delete</a>
                </td>
                <td><a id="modifylink" href="controller?command=gotomodifytemptask&id=${task.id}" onclick="load('modifylink')">Modify</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit" name="command" value="gotoaddtemptask">Add task</button>

    <button type="submit" name="command" value="addproject">Save Project</button>

    <button type="submit" name="command" value="canceladdproject" formnovalidate>Cancel</button>
</form>
</body>
</html>
