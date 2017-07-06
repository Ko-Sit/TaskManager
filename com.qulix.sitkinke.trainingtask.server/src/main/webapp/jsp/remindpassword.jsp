<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <title>Remind pass</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <div class="field">
        <label>Email</label>
        <input type="text" name="login" value="buck@gmail.com" required/>
    </div>
    <button type="submit" name="command" value="remindpassword">Remind password</button>
</form>
</body>
</html>
