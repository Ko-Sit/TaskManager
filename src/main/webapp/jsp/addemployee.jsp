<%--
  Created by IntelliJ IDEA.
  User: upsit
  Date: 14.06.2017
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Add Employee</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addemployee" />
    <input type="number" name="id" value="" placeholder="id"/>
    <input type="text" name="surname" value="" placeholder="surname"/>
    <input type="text" name="name" value="" placeholder="name"/>
    <input type="text" name="patronymic" value="" placeholder="patronymic"/>
    <input type="text" name="position" value="" placeholder="position"/>
    <input type="submit" value="Add"/>
</form>
<a href="controller?command=showemployees">Back to list</a>
</body>
</html>
