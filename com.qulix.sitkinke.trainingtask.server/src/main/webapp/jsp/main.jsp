<%--
  Created by IntelliJ IDEA.
  User: upsit
  Date: 13.06.2017
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <title>Main</title>
</head>
<body>
<h1>Main menu</h1>
<form name="loginForm" method="POST" action="controller">
    <button type="submit" name="command" value="showprojects">Projects</button>
</form>
<form name="loginForm" method="POST" action="controller">
    <button type="submit" name="command" value="showtasks">Tasks</button>
</form>
<form name="loginForm" method="POST" action="controller">
    <button type="submit" name="command" value="showemployees">Employees</button>
</form>

</body>
</html>
