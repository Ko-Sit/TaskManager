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
        <input type="text" value="${selectedemployee.surname}" maxlength="100" name="surname" required/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" value="${selectedemployee.name}" maxlength="100" name="name" required>
    </div>
    <div class="field">
        <label>Patronymic</label>
        <input type="text" value="${selectedemployee.patronymic}" maxlength="100" name="patronymic" required/>
    </div>
    <div class="field">
        <label>Position</label>
        <input type="text" value="${selectedemployee.position}" maxlength="100" name="position" required/>
    </div>
    <div class="field">
        <label>Email</label>
        <input type="text" name="login" value="${selectedemployee.email}" maxlength="100" required/>
    </div>
    <div class="field">
        <label>Password</label>
        <input type="password" name="password" value="${selectedemployee.password}" maxlength="100" required/>
    </div>
    <jsp:useBean id="grant" scope="request" type="com.qulix.sitkinke.trainingtask.enums.UserType"/>
    <div class="field">
        <label>User type</label>
        <select name="usertype" id="usertype" title="usertype" onclick="validateUserType()" required>
            <option>USER</option>
            <option <c:if test='${"USER".equals(grant.toString())}'>disabled</c:if>>ADMINISTRATOR</option>
        </select>
    </div>
    <br>
    ${message}
    <br>
    <button type="submit" name="command" value="modifyemployee">Save Employee</button>

    <button type="submit" name="command" value="showemployees" formnovalidate>Cancel</button>
</form>
</body>
</html>
