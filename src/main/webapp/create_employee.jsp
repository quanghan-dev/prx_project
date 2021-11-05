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
            <input type="hidden" value="${requestScope.PROJECT_ID}" name="project_id"/>
            <input type="hidden" value="${requestScope.SPRINT_ID}" name="sprint_id"/>
            <div>
                <button type="submit">Create</button>                  
            </div>
        </form>
        <c:url var="Employee" value="employee">
            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>         
        </c:url>
        <a href="${Employee}">Back To Employee</a>
    </body>
</html>
