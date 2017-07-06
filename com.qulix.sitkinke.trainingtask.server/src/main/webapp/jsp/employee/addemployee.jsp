<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Add Employee</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="idgenerated" scope="request" type="java.lang.Integer"/>
    <div class="field">
        <label>ID</label>
        <input type="number" name="id" value="${idgenerated}" readonly/>
    </div>
    <div class="field">
        <label>Surname</label>
        <input type="text" name="surname" value="" maxlength="30" required/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" name="name" value="" maxlength="30" required/>
    </div>
    <div class="field">
        <label>Patronymic</label>
        <input type="text" name="patronymic" value="" maxlength="30" required/>
    </div>
    <div class="field">
        <label>Position</label>
        <input type="text" name="position" value="" required/>
    </div>
    <div class="field">
        <label>Email</label>
        <input type="text" name="login" value="" required/>
    </div>
    <div class="field">
        <label>Password</label>
        <input type="password" name="password" value="" required/>
    </div>
    <div class="field">
        <label>User type</label>
        <select name="usertype" id="usertype" title="usertype" required>
            <option>USER</option>
            <option>ADMINISTRATOR</option>
        </select>
    </div>
    <button type="submit" name="command" value="addemployee">Save task</button>

    <button type="submit" name="command" value="showemployees" formnovalidate>Cancel</button>

</form>

</body>
</html>
