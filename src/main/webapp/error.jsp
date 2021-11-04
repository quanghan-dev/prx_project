<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR Page</title>
    </head>
    <body>
        <h1>ERROR PAGE</h1>
        <h2>
            <font color="red">
            </font>
            ${requestScope.ERROR}
        </h2>
        <a href="home.jsp">Back to HOME Page</a>
    </body>
</html>
