<%-- 
    Document   : edit_client
    Created on : 2015-06-14, 09:20:33
    Author     : S108_11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="../jspf/head.jspf" %>
        <title>Starter Template for Bootstrap</title>
    </head>

    <body>

        <%@include file="../jspf/navi.jspf" %>
    
        <div class="container">

            <div class="starter-template">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Dodaj klienta</h3>
                    </div>
                    <div class="panel-body">
                        
                        <c:url value="/admin/client/save" var="action"/>
                        
                        <form:form commandName="client" action="${action}">

                            <spring:bind path="name">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="name">Imię</label> <form:errors path="name" cssClass="has-error"/>
                                    <form:input class="form-control" path="name" placeholder="Wpisz imię"/>
                                </div>
                            </spring:bind>
                       
                            <spring:bind path="lastName">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="lastName">Nazwisko</label> <form:errors path="lastName" cssClass="has-error"/>
                                    <form:input class="form-control" path="lastName" placeholder="Wpisz nazwisko"/>
                                </div>
                            </spring:bind>
                       
                            <spring:bind path="street">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="street">Ulica</label> <form:errors path="street" cssClass="has-error"/>
                                    <form:input class="form-control" path="street" placeholder="Wpisz nazwę ulicy"/>
                                </div>
                            </spring:bind>
                            
                            <spring:bind path="city">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="city">Miasto</label> <form:errors path="city" cssClass="has-error"/>
                                    <form:input class="form-control" path="city" placeholder="Wpisz nazwę miasta"/>
                                </div>
                            </spring:bind>
                            
                            <spring:bind path="postCode">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="postCode">Kod pocztowy</label> <form:errors path="postCode" cssClass="has-error"/>
                                    <form:input class="form-control" path="postCode" placeholder="Wpisz kod pocztowy w formacie XX-XXXX"/>
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
        <!-- /.container -->
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
