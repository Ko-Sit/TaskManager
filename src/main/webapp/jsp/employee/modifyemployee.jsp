<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Modify Employee</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="selectedemployee" scope="request" type="com.qulix.sitkinke.trainingtask.entities.Employee"/>
    <input type="number" value="${selectedemployee.id}" name="id" placeholder="id" readonly/>
    <input type="text" value="${selectedemployee.surname}" name="surname" placeholder="surname"/>
    <input type="text" value="${selectedemployee.name}" name="name" placeholder="name"/>
    <input type="text" value="${selectedemployee.patronymic}" name="patronymic" placeholder="patronymic"/>
    <input type="text" value="${selectedemployee.position}" name="position" placeholder="position"/>
    <button type="submit" name="command" value="modifyemployee">Modify</button>

    <button type="submit" name="command" value="showemployees">Cancel</button>
</form>
</body>
</html>
