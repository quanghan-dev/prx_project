<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Code</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    
    <body>
        <h1 class="mt-5 mb-3 text-center mx-auto">A verify code is sent to your email. Check it out.</h1>
        
        <div class="container mt-5 mb-2 d-flex justify-content-center">
            <form action="/Project/verify" method="POST" style="width: 300px;">
                <div class="row">
                    <div class="col-sm-12 mb-2">
                        <div class="form-group">
                            <input class="form-control inputlg" type="number" name="code" placeholder="Code""> 
                        </div>
                    </div>
                </div>

                <div>
                    <button type="submit" class="btn btn-primary btn-block confirm-button">Submit</button>                           
                </div>
            </form>
        </div>
        
        <c:if test="${requestScope.ERROR != null}">
            <p class="mt-5 mb-3 text-center mx-auto">Wrong code</p>
        </c:if>
    </body>
</html>
