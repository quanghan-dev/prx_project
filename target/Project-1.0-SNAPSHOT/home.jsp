<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>


    <body class="bg-white">

        <div class="mt-5 mb-3 mx-auto" style="width: 150px;">
            <a class="btn btn-primary" href="create-project" role="button">Create Project</a>
        </div>

        <table class="table table-bordered table-striped table-responsive-stack w-75 mx-auto"  id="tableOne">
            <thead class="thead-dark">
                <tr>
                    <th>Project Name</th>
                    <th>Language</th>
                    <th>Sprints</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="project" items="${requestScope.COMPANY.projects}">
                    <tr class="row100 body">
                        <td class="cell100 column1">${project.name}</td>
                        <td class="cell100 column2">${project.language}</td>
                        <td class="cell100 column3"><a href="sprint?project_id=${project.id}">View</a></td>
                        <td class="cell100 column4"><a href="update-project?project_id=${project.id}">Update</a></td>
                        <td class="cell100 column5"><a href="delete-project?project_id=${project.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
