<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME Page</title>
    </head>
    <body>
        <c:forEach var="project" items="${requestScope.PROJECTS}">
            <p>${project.name}</p>
            <p>${project.language}</p>
            <c:forEach var="sprint" items="${project.sprints}">
                <p>${sprint.name}</p>
            </c:forEach>
        </c:forEach>
    </body>
</html>
