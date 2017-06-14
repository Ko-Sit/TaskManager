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
    <link rel="stylesheet" href="../css/style.css">
    <title>Main</title>

</head>
<body>
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="showprojects" />
        <input type="submit" value="Projects">
    </form>
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="showtasks" />
        <input type="submit" value="Tasks">
    </form>
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="showemployees" />
        <input type="submit" value="Employees">
    </form>

</body>
</html>
