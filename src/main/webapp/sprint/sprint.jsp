<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPRINT</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>

    <body>
        <h1 class="mt-5 mb-3 text-center mx-auto">Project【${requestScope.PROJECT.name}】- Sprint Page</h1>
        
        <div class="mt-2 mb-3 mx-auto" style="width: 120px;">
            <c:url var="CreateSprint" value="create-sprint">
                <c:param name="project_id" value="${requestScope.PROJECT.id}"/>
            </c:url>
            <a class="btn btn-primary" href="${CreateSprint}" role="button">Create Sprint</a>
        </div>

        <table class="table table-bordered table-striped table-responsive-stack w-75 mx-auto"  id="tableOne">
            <thead class="thead-dark">
                <tr>
                    <th>Sprint Name</th>
                    <th>Duration</th>
                    <th>Tasks</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sprint" items="${requestScope.PROJECT.sprints}">
                    <tr class="row100 body">
                        <td class="cell100 column1">${sprint.name}</td>
                        <td class="cell100 column2">${sprint.duration}</td>
                        <td class="cell100 column3">
                            <c:url var="Task" value="task">
                                <c:param name="project_id" value="${requestScope.PROJECT.id}"/>
                                <c:param name="sprint_id" value="${sprint.id}"/>
                            </c:url>
                            <a href="${Task}">View</a></td>
                        <td class="cell100 column4">
                            <c:url var="UpdateSprint" value="update-sprint">
                                <c:param name="project_id" value="${requestScope.PROJECT.id}"/>
                                <c:param name="sprint_id" value="${sprint.id}"/>
                            </c:url>
                            <a href="${UpdateSprint}">Update</a>
                        </td>
                        <td class="cell100 column5">
                            <c:url var="DeleteSprint" value="delete-sprint">
                                <c:param name="project_id" value="${requestScope.PROJECT.id}"/>
                                <c:param name="sprint_id" value="${sprint.id}"/>  
                            </c:url>
                            <a href="${DeleteSprint}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h6 class="text-center">
            <a href="/Project/project">Home</a>
        </h6>
    </body>
</html>
