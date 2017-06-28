<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../../css/style.css">
    <title>Projects</title>
</head>
<body>
<h1>Project List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Abbreviation</th>
        <th>Description</th>
        <th>Delete</th>
        <th>Modify</th>
    </tr>

    <jsp:useBean id="projects" scope="request" type="java.util.List"/>
    <c:forEach var="project" items="${projects}">
        <tr>
            <td>${project.id}</td>
            <td>${project.name}</td>
            <td>${project.abbreviation}</td>
            <td>${project.description}</td>
            <td><a href="controller?command=deleteproject&id=${project.id}">Delete</a></td>
            <td><a href="controller?command=gotomodifyproject&id=${project.id}">Modify</a></td>
        </tr>
    </c:forEach>
</table>
<form name="loginForm" method="POST" action="controller">
    <button type="submit" name="command" value="gotoaddproject">Add Project</button>

    <button type="submit" name="command" value="gotomenu">Back</button>
</form>
</body>
</html>
