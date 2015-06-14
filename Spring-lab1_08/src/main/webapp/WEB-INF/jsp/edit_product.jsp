<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


        <title>Starter Template for Bootstrap</title>

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
                        <h3 class="panel-title">Dodaj produkt</h3>
                    </div>
                    <div class="panel-body">
                        
                        <c:url value="/admin/product/save" var="action"/>
                        
                        <form:form commandName="product" action="${action}">
                            
                            <spring:bind path="id">
                                <form:hidden path="id" />
                            </spring:bind>
                            
                            <spring:bind path="name">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="name">Nazwa</label> <form:errors path="name" cssClass="has-error"/>
                                    <form:input class="form-control" path="name" placeholder="Wpisz nazwę produktu"/>
                                </div>
                            </spring:bind>
                       
                            <spring:bind path="category.id">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }" >
                                    <label class="control-label" for="category">Kategoria <form:errors path="category" cssClass="error-text"/></label><br/>
                                     <form:select  class="form-control" path="category.id">
                                        <form:option label="-- wybierz --" value=""/>
                                        <form:options itemLabel="name" itemValue="id" items="${categories}"/>
                                    </form:select>
                                </div>
                            </spring:bind>
                            
                            <spring:bind path="price">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }" >
                                    <label class="control-label" for="price">Cena <form:errors path="price" cssClass="error-text"/></label> 
                                    <form:input class="form-control" path="price" placeholder="Wprowadź cenę"/>
                                </div>
                            </spring:bind>
                            
                            <br/>
                            <form:button class="btn btn-default">Zapisz</form:button> 
                            <input class="btn btn-warning" type="button" value="Anuluj" onclick="location.href = 'list'"/> 
                        </form:form>
                    </div>
                </div>

            </div>

        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="../../dist/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
