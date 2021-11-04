<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Project</title>
    </head>
    <body>
        <form action="" method="POST" >
            <div>
                Name: <input type="text" id="txtName" name="name" value="${requestScope.PROJECT.name}">             
            </div>
            <div>
                Language: <input type="text" id="txtLanguage" name="language" value="${requestScope.PROJECT.language}">             
            </div>
            <div>
                <button type="submit">Update</button>                           
            </div>
        </form>
        <a href="/Project/">Home</a> 
    </body>
</html>
