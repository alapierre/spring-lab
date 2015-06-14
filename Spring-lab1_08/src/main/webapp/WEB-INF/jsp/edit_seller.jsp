<%-- 
    Document   : edit_seller
    Created on : 2015-06-13, 11:44:22
    Author     : ja :D
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="../jspf/head.jspf" %>
        <title>Dodaj sprzedawce :: Bike Shop</title>
    </head>

    <body>
        <%@include file="../jspf/navi.jspf" %>
        <div class="container">
                        <div class="starter-template">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Dodaj sprzedawce</h3>
                    </div>
                    <div class="panel-body">
                        
                        <c:url value="/admin/seller/save" var="action"/>

                        <form:form commandName="seller" action="${action}">
                            <form:hidden path="id"/>
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
                            <input class="btn btn-warning" type="button" value="Anuluj" onclick="location.href = '<c:url value="/admin/seller/list"/>'"/> 
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
            <%@include file="../jspf/footer.jspf" %>
        </body>
</html>
