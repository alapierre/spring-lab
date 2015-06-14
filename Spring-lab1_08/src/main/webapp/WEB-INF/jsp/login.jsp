<%-- 
    Document   : login
    Created on : 2015-06-14, 14:36:06
    Author     : Adrian Lapierre <adrian@soft-project.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <%@include file="../jspf/head.jspf" %>
        <link href="<c:url value="/resources/login.css"/> " rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <div class="login-container">
                <div id="output"></div>
                <div class="avatar"></div>
                <div class="form-box">
                    <form action="<c:url value="/j_spring_security_check"/>" method="POST">
                        <input name="j_username" type="text" placeholder="username">
                        <input name="j_password" type="password" placeholder="password">
                        <button class="btn btn-info btn-block login" type="submit">Login</button>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="../jspf/footer.jspf" %>

    </body>

</html>

