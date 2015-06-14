<%-- 
    Document   : add_seller
    Created on : 2015-06-13, 11:44:22
    Author     : ja :D
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">


        <title>Dodaj sellera :: bike shop</title>

        <!-- Bootstrap core CSS -->
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
                        <h3 class="panel-title">Dodaj sprzedawce</h3>
                    </div>
                    <div class="panel-body">
                        <form:form commandName="seller" action="save">

                            <spring:bind path="login">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="login">Login</label> <form:errors path="login" cssClass="has-error"/>
                                    <form:input class="form-control" path="login" placeholder="Wpisz login"/>
                                </div>
                            </spring:bind>
                            
                           <spring:bind path="email">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }" >
                                    <label class="control-label" for="email">Email <form:errors path="email" cssClass="error-text"/></label> 
                                    <form:input class="form-control" path="email" placeholder="Wpisz adres e-mail"/>
                                </div>
                            </spring:bind>

                           <spring:bind path="numberPhone">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }" >
                                    <label class="control-label" for="numberPhone">Numer telefonu <form:errors path="numberPhone" cssClass="error-text"/></label> 
                                    <form:input class="form-control" path="numberPhone" placeholder="Wpisz numer telefonu"/>
                                </div>
                            </spring:bind>
                            
                            <spring:bind path="password">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }" >
                                    <label class="control-label" for="password">Hasło <form:errors path="password" cssClass="error-text"/></label> 
                                    <form:input class="form-control" path="password" placeholder="Wpisz hasło"/>
                                </div>
                            </spring:bind>
                            
                            <br/>
                            <form:button class="btn btn-default">Zapisz</form:button> 
                            <input class="btn btn-warning" type="button" value="Anuluj" onclick="location.href = 'list'"/> 
                        </form:form>
                    </div>
                </div>

            </div>
        </div>
            
        </body>
</html>
