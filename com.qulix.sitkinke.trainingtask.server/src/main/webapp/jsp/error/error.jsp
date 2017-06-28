<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Error</title>
</head>
<body>
    <form name="loginForm" method="POST" action="controller">
        <jsp:useBean id="exception" scope="request" type="java.lang.String"/>
        ${exception}
        <br><button type="submit" name="command" value="gotomenu">To Menu</button>
    </form>
</body>
</html>
