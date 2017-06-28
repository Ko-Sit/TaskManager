<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../../css/style.css">
    <title>Employees</title>
</head>
<body>
<h1>Employee List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Patronymic</th>
        <th>Position</th>
        <th>Delete</th>
        <th>Modify</th>
    </tr>

    <jsp:useBean id="employees" scope="request" type="java.util.List"/>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.patronymic}</td>
            <td>${employee.position}</td>
            <td><a href="controller?command=deleteemployee&id=${employee.id}">Delete</a></td>
            <td><a href="controller?command=gotomodifyemployee&id=${employee.id}">Modify</a></td>
        </tr>
    </c:forEach>
</table>
<form name="loginForm" method="POST" action="controller">
    <button type="submit" name="command" value="gotoaddemployee">Add Employee</button>

    <button type="submit" name="command" value="gotomenu">Back</button>
</form>

</body>
</html>