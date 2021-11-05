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
                Duration: <input type="text" id="txtLanguage" name="duration">             
            </div>
            <div>
                <button type="submit">Create</button>                           
            </div>
        </form>
        <a href="/Project/">Home</a> 
    </body>
</html>
