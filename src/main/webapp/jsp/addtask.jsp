<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Add Task</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="idgenerated" scope="request" type="java.lang.Integer"/>
    <input type="number" name="id" value="${idgenerated}" placeholder="id" readonly/>
    <input type="text" name="name" value="" placeholder="name"/>
    <input type="number" name="duration" value="" placeholder="duration"/>
    <input type="date" name="startdate" value="" placeholder="startdate"/>
    <input type="date" name="enddate" value="" placeholder="enddate"/>
    <select name="state" title="State">
        <option>NOTSTARTED</option>
        <option>INPROGRESS</option>
        <option>COMPLETED</option>
        <option>POSTPONED</option>
    </select>

    <select name="select2" multiple="multiple" tabindex="1" title="title">
        <jsp:useBean id="employees" scope="request" type="java.util.List"/>
        <c:forEach var="employee" items="${employees}">
            <option>${employee.id}. ${employee.surname} ${employee.name}</option>
        </c:forEach>
    </select>

    <input type="hidden" name="command" value="addtask" />
    <input type="submit" value="Save"/>
</form>
<a href="controller?command=showtasks">Cancel</a>
</body>
</html>
