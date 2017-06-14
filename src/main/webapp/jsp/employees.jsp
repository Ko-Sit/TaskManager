<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
     <link rel="stylesheet" href="../css/style.css">
    <title>Employees</title>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Patronymic</th>
        <th>Position</th>
    </tr>

    <jsp:useBean id="employees" scope="request" type="java.util.List"/>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.patronymic}</td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>
</table>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="gotoaddemployee"/>
    <input type="submit" value="Add Employee">
</form>

</body>
</html>