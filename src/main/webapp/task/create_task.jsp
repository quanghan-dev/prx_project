<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>

    <body>
        <div class="container mt-5 mb-2 d-flex justify-content-center">
            <div class="card px-1 py-4" style="width: 300px;">
                <div class="card-body">
                    <h6 class="card-title mb-4">Create new Task</h6>

                    <form action="" method="POST" >
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <input class="form-control inputlg" type="text" id="txtName" name="name" placeholder="Name"> 
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-12 mb-4">
                                <select class="form-control" id="txtDuration" name="duration">
                                    <option>11/2021 - 12/2021</option>
                                    <option>11/2021 - 01/2022</option>
                                    <option>11/2021 - 02/2022</option>
                                    <option>11/2021 - 03/2022</option>
                                    <option>11/2021 - 04/2021</option>
                                    <option>11/2021 - 05/2022</option>
                                    <option>11/2021 - 06/2022</option>
                                    <option>11/2021 - 07/2022</option>
                                </select> 
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-12 mb-4">
                                <select class="form-control" id="txtStatus" name="status">
                                    <option>Not started</option>
                                    <option>On hold</option>
                                    <option>Ongoing</option>
                                </select> 
                            </div>
                        </div>
                        
                        <input type="hidden" value="${requestScope.PROJECT_ID}" name="project_id"/>
                        <input type="hidden" value="${requestScope.SPRINT_ID}" name="sprint_id"/>

                        <div>
                            <button type="submit" class="btn btn-primary btn-block confirm-button">Create</button>                           
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <c:url var="Task" value="task">
            <c:param name="project_id" value="${requestScope.PROJECT_ID}"/>
            <c:param name="sprint_id" value="${requestScope.SPRINT_ID}"/>         
        </c:url>
        <h6 class="text-center">
            <a href="${Task}">Back to Task</a>
        </h6>
    </body>
</html>
