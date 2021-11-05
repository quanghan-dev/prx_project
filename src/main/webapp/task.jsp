<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task</title>
    </head>
    <body>
        <c:forEach var="task" items="${requestScope.SPRINT.tasks}">
            <p>${task.name}</p>
            <p>${task.duration}</p>
            <p>${task.status}</p>

            <c:url var="UpdateTask" value="update-task">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                <c:param name="task_id" value="${task.id}"/> 
            </c:url>

            <a href="${UpdateTask}">Update</a>
            <c:url var="DeleteTask" value="delete-task">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                <c:param name="task_id" value="${task.id}"/> 
            </c:url>
            <a href="${DeleteTask}">Delete</a>

            <c:url var="Employee" value="employee">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                <c:param name="task_id" value="${task.id}"/>        
            </c:url>
            <a href="${Employee}">Employee</a>
            
        </c:forEach>
        <div>
            <c:url var="CreateTask" value="create-task">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>               
            </c:url>
            <a href="${CreateTask}" >Create Task</a>
        </div>
        <c:url var="Sprint" value="sprint">
            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>      
        </c:url>
        <a href="${Sprint}">Back To Sprint</a>
    </body>
</html>