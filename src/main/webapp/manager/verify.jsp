<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Code</title>
    </head>
    <body>
        <h1>A verify code sent to your email. Check it out.</h1>
        
        <form action="/Project/verify" method="POST">
            <input type="number" name="code"/>
            <button type="submit">Submit</button>
        </form>
        <c:if test="${requestScope.ERROR != null}">
            <p>Wrong code</p>
        </c:if>
    </body>
</html>
