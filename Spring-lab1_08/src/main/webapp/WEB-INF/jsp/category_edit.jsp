<%-- 
    Document   : edit_user
    Created on : 2015-06-13, 11:44:22
    Author     : Adrian Lapierre <adrian@soft-project.pl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="../jspf/head.jspf" %>
        <title>Bike Shop :: Dodawanie/Edycja kategorii</title>
    </head>

    <body>

        <%@include file="../jspf/navi.jspf" %>

        <div class="container">

            <div class="starter-template">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Dodaj kategorię</h3>
                    </div>
                    <div class="panel-body">
                        <form:form commandName="category" action="save">

                            <spring:bind path="name">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="name">Nazwa</label> <form:errors path="name" cssClass="has-error"/>
                                    <form:input class="form-control" path="name" placeholder="Wpisz nazwę"/>
                                </div>
                            </spring:bind>
                            
                            <spring:bind path="parent.id">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="parent.id">Kategoria nadrzędna</label> <form:errors path="parent.id" cssClass="has-error"/>
                                    <form:select class="form-control" path="parent.id" items="${categories}" />
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
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
