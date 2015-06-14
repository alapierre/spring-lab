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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bike Shop :: Lista sprzedawców</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    </head>
    
    <body>
        
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Bike Shop</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <br><br><br>
        
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
                        <td><a href="<c:url value="/seller/edit/${seller.user.login}"/>">Edytuj</a> </td>
                    </tr>
                </c:forEach>
            </table>



        </div>
    </body>
</html>