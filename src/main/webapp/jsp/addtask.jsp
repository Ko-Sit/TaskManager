<%--
  Created by IntelliJ IDEA.
  User: upsit
  Date: 14.06.2017
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Add Task</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <input type="number" name="id" value="" placeholder="id"/>
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
    <input type="hidden" name="command" value="addtask" />
    <input type="submit" value="Add"/>
</form>
<a href="controller?command=showtasks">Back to list</a>
</body>
</html>
