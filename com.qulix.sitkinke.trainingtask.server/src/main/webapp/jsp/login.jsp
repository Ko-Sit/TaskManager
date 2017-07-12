<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
    <title>Login</title>
</head>
<body>
<h1>Login page</h1>
<form name="loginForm" method="POST" action="controller">
    <div class="field">
        <label>Email</label>
        <input type="text" name="login" value="buck@gmail.com" maxlength="100" required/>
    </div>
    <div class="field">
        <label>Password</label>
        <input type="password" name="password" value="123" maxlength="100" required/>
    </div>

    <button type="submit" name="command" value="login">Login</button>
    <br>
    ${message}
    <br>
    ${errorLoginMessage}
    <br>
    <button type="submit" name="command" value="gotoremindpassword">Forgot password</button>

</form>
</body>
</html>
