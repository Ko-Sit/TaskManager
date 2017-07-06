<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>Modify Employee</title>
</head>
<body>
<form name="loginForm" method="POST" action="controller">
    <jsp:useBean id="selectedemployee" scope="request" type="com.qulix.sitkinke.trainingtask.entities.Employee"/>
    <div class="field">
        <label>ID</label>
        <input type="number" value="${selectedemployee.id}" name="id" readonly/>
    </div>
    <div class="field">
        <label>Surname</label>
        <input type="text" value="${selectedemployee.surname}" maxlength="30" name="surname" required/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" value="${selectedemployee.name}" maxlength="30" name="name" required>
    </div>
    <div class="field">
        <label>Patronymic</label>
        <input type="text" value="${selectedemployee.patronymic}" maxlength="30" name="patronymic" required/>
    </div>
    <div class="field">
        <label>Position</label>
        <input type="text" value="${selectedemployee.position}" name="position" required/>
    </div>
    <div class="field">
        <label>Email</label>
        <input type="text" name="login" value="${selectedemployee.email}" required/>
    </div>
    <div class="field">
        <label>Password</label>
        <input type="password" name="password" value="${selectedemployee.password}" required/>
    </div>
    <div class="field">
        <label>User type</label>
        <select name="usertype" id="usertype" title="usertype" required>
            <option>USER</option>
            <option>ADMINISTRATOR</option>
        </select>
    </div>
    <button type="submit" name="command" value="modifyemployee">Save Employee</button>

    <button type="submit" name="command" value="showemployees" formnovalidate>Cancel</button>
</form>
</body>
</html>
