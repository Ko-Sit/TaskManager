<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Employees</title>
</head>
<body>
<style>
    body {
    background-color: #E5E7E9;
    color: #606468;
    font-family: 'Open Sans', Arial, sans-serif;
    font-size: 14px;
    line-height: 1.5em;
    }
</style>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Patronymic</th>
        <th>Position</th>
    </tr>

    <jsp:useBean id="employees" scope="request" type="java.util.List"/>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.patronymic}</td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>