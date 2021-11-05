<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task</title>
    </head>
    <body>
        <c:forEach var="employee" items="${requestScope.TASK.employees}">

            <p>${employee.name}</p>

            <c:url var="UpdateEmployee" value="update-employee">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                <c:param name="task_id" value="${requestScope.TASK.id}"/>
                <c:param name="employee_id" value="${employee.id}"/> 
            </c:url>

            <a href="${UpdateEmployee}">Update</a>

            <c:url var="DeleteEmployee" value="delete-employee">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                <c:param name="task_id" value="${requestScope.TASK.id}"/> 
                <c:param name="employee_id" value="${employee.id}"/> 
            </c:url>
            <a href="${DeleteEmployee}">Delete</a>

        </c:forEach>
        <div>
            <c:url var="CreateEmployee" value="create-employee">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>               
                <c:param name="task_id" value="${requestScope.TASK.id}"/>               
            </c:url>
            <a href="${CreateEmployee}" >Create Employee</a>
        </div>
        <c:url var="Task" value="task">
            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>         
        </c:url>
        <a href="${Task}">Back To Task</a>
    </body>
</html>