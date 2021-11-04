<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPRINT</title>
    </head>
    <body>
        <c:forEach var="sprint" items="${requestScope.PROJECT.sprints}">
            <p>${sprint.name}</p>
            <p>${sprint.duration}</p>
<!--            <a href="update-project?project_id=${sprint.id}">Update</a>
            <a href="delete-project?project_id=${sprint.id}">Delete</a>
            <a href="sprint?project_id=${project.id}">Sprint</a>-->
            <a href="task?project_id=${project.id}">Task</a>
        </c:forEach>
        <div>
            <a href="create-sprint">Create Sprint</a>
        </div>
        <a href="/Project/">Home</a> 
    </body>
</html>
