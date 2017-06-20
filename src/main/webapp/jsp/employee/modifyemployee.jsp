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
    <div class="field">
        <label>ID</label>
        <input type="number" value="${selectedemployee.id}" name="id"  readonly/>
    </div>
    <div class="field">
        <label>Surname</label>
        <input type="text" value="${selectedemployee.surname}" name="surname" />
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" value="${selectedemployee.name}" name="name" />
    </div>
    <div class="field">
        <label>Patronymic</label>
        <input type="text" value="${selectedemployee.patronymic}" name="patronymic" />
    </div>
    <div class="field">
        <label>Position</label>
        <input type="text" value="${selectedemployee.position}" name="position" />
    </div>
    <button type="submit" name="command" value="modifyemployee">Modify</button>

    <button type="submit" name="command" value="showemployees">Cancel</button>
</form>
</body>
</html>
