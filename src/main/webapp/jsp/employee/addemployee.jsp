<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Add Employee</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="idgenerated" scope="request" type="java.lang.Integer"/>
    <div class="field">
        <label>ID</label>
        <input type="number" name="id" value="${idgenerated}" disabled/>
    </div>
    <div class="field">
        <label>Surname</label>
        <input type="text" name="surname" value="" />
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" name="name" value="" />
    </div>
    <div class="field">
        <label>Patronymic</label>
        <input type="text" name="patronymic" value="" />
    </div>
    <div class="field">
        <label>Position</label>
        <input type="text" name="position" value="" />
    </div>
    <button type="submit" name="command" value="addemployee">Add task</button>

    <button type="submit" name="command" value="showemployees">Cancel</button>

</form>

</body>
</html>
