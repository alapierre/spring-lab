<%-- 
    Document   : seller-list
    Created on : 2015-06-14, 11:19:08
    Author     : S108_8
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jspf/head.jspf" %>
        <title>Lista sprzedawców :: Bike Shop</title>
    </head>
    
    <body>
        
        <%@include file="../jspf/navi.jspf" %>

        <div class="container">

            <table class="table">
                <th>Login</th>
                <th>E-mail</th>
                <th>Nnumer tel.</th>
                <th>Aktywny</th>
                <th>*</th>
                <c:forEach var="seller" items="${sellers}">
                    <tr>
                        <td>${seller.user.login}</td>
                        <td>${seller.email}</td>
                        <td>${seller.numberPhone}</td>
                        <td>${seller.user.active}</td>
                        <td><a href="<c:url value="/admin/seller/edit/${seller.user.login}"/>">Edytuj</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>