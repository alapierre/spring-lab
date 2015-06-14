<%-- 
    Document   : edit_user
    Created on : 2015-06-13, 11:44:22
    Author     : Adrian Lapierre <adrian@soft-project.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jspf/head.jspf" %>
        <title>Bike Shop :: Dane użytkownika</title>
    </head>
    
    <body>
        
        <%@include file="../jspf/navi.jspf" %>
        
        <div class="container">

            <table class="table">
                <th>Login</th>
                <th>Aktywny</th>
                <th>*</th>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.active}</td>
                        <td><a href="<c:url value="/user/add"/>">Edytuj</a> </td>
                    </tr>
                </c:forEach>
            </table>



        </div>
        
        <%@include file="../jspf/footer.jspf" %>
        
    </body>
    
    
    
</html>
