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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bike Shop :: Lista pozycji zamówienia</title>
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

            <div class="starter-template">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Edytuj pozycję zamówienia</h3>
                    </div>
                    <div class="panel-body">
                        <form:form commandName="item" action="${pageContext.request.contextPath}/orders/item-save">
                            <form:hidden path="id" />
                            <form:hidden path="order.id" />
                            <form:hidden path="product.id" />
                            <spring:bind path="quantity">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }" >
                                    <label class="control-label" for="quantity">Ilość <form:errors path="quantity" cssClass="error-text"/></label> 
                                    <form:input class="form-control" path="quantity" placeholder="Podaj ilość"/>
                                </div>
                            </spring:bind>

                            <spring:bind path="price">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="price">Cena</label> <form:errors path="price" cssClass="has-error"/>
                                    <form:input class="form-control" path="price" placeholder="Podaj cenę"/>
                                </div>
                            </spring:bind>

                            <br/>
                            <form:button class="btn btn-default">Zapisz</form:button> 
                            <input class="btn btn-warning" type="button" value="Anuluj" onclick="location.href = '${pageContext.request.contextPath}/orders/item-list/${item.id}'"/> 
                        </form:form>
                    </div>
                </div>

            </div>

        </div><!-- /.container -->
    </body>
</html>
