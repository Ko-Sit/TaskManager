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
    <input type="number" name="id" value="${idgenerated}" placeholder="id" disabled/>
    <input type="text" name="surname" value="" placeholder="surname"/>
    <input type="text" name="name" value="" placeholder="name"/>
    <input type="text" name="patronymic" value="" placeholder="patronymic"/>
    <input type="text" name="position" value="" placeholder="position"/>
    <button type="submit" name="command" value="addemployee">Add task</button>

    <button type="submit" name="command" value="showemployees">Cancel</button>
</form>

</body>
</html>
