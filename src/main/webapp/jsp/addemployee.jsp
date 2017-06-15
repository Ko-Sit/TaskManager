<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
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
    <input type="hidden" name="command" value="addemployee"/>
    <input type="submit" value="Save"/>
</form>
<a href="controller?command=showemployees">Cancel</a>
</body>
</html>
