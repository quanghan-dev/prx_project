<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME Page</title>
    </head>
    <body>
        <c:forEach var="project" items="${requestScope.COMPANY.projects}">
            <p>${project.name}</p>
            <p>${project.language}</p>
            <a href="update-project?project_id=${project.id}">Update</a>
            <a href="delete-project?project_id=${project.id}">Delete</a>
            <a href="sprint?project_id=${project.id}">Sprint</a>
        </c:forEach>
        <div>
            <a href="create-project">Create Project</a>
        </div>
        <a href="/Project/">Home</a> 
    </body>
</html>
