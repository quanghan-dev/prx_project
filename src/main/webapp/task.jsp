<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>

    <body>
        <div class="mt-5 mb-3 mx-auto" style="width: 120px;">
            <c:url var="CreateTask" value="create-task">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>               
            </c:url>
            <a class="btn btn-primary" href="${CreateTask}" role="button">Create Task</a>
        </div>

        <table class="table table-bordered table-striped table-responsive-stack w-75 mx-auto"  id="tableOne">
            <thead class="thead-dark">
                <tr>
                    <th>Task Name</th>
                    <th>Duration</th>
                    <th>Status</th>
                    <th>Employees</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="task" items="${requestScope.SPRINT.tasks}">
                    <tr class="row100 body">
                        <td class="cell100 column1">${task.name}</td>
                        <td class="cell100 column2">${task.duration}</td>
                        <td class="cell100 column2">${task.status}</td>

                        <c:url var="Employee" value="employee">
                            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                            <c:param name="task_id" value="${task.id}"/>        
                        </c:url>
                        <td class="cell100 column3"><a href="${Employee}">Employees</a></td>


                        <c:url var="UpdateTask" value="update-task">
                            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                            <c:param name="task_id" value="${task.id}"/> 
                        </c:url>
                        <td class="cell100 column3"><a href="${UpdateTask}">Update</a></td>

                        <c:url var="DeleteTask" value="delete-task">
                            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
                            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>  
                            <c:param name="task_id" value="${task.id}"/> 
                        </c:url>
                        <td class="cell100 column5"><a href="${DeleteTask}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h6 class="text-center">
            <c:url var="Sprint" value="sprint">
                <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>      
            </c:url>
            <a href="${Sprint}">Home</a>
        </h6>
    </body>
</html>