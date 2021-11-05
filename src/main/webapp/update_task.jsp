<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Task</title>
    </head>
    <body>
        <form action="" method="POST" >
            <div>
                Name: <input type="text" id="txtName" name="name" value="${requestScope.TASK.name}">             
            </div>
            <div>
                Duration <input type="text" id="txtDuration" name="duration" value="${requestScope.TASK.duration}">             
            </div>
            <div>
                Status <input type="text" id="txtStatus" name="status" value="${requestScope.TASK.status}">             
            </div>
            <div>
                <button type="submit">Update</button>                           
            </div>
        </form>
        <c:url var="Task" value="task">
            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>         
        </c:url>
        <a href="${Task}">Back To Task</a>
    </body>
</html>
