<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <form action="" method="POST" >
            <div>
                Name: <input type="text" id="txtName" name="name">             
            </div>
            <div>
                Duration: <input type="text" id="txtDuration" name="duration">             
            </div>
            <div>
                Status <input type="text" id="txtStatus" name="status">             
            </div>
            <input type="hidden" value="${requestScope.PROJECT_ID}" name="project_id"/>
            <input type="hidden" value="${requestScope.SPRINT_ID}" name="sprint_id"/>
            <div>
                <button type="submit">Create</button>                  
            </div>
        </form>
        <c:url var="Task" value="task">
            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>         
        </c:url>
        <a href="${Task}">Back To Task</a>
    </body>
</html>
