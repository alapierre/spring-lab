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
        <title>Starter Template for Bootstrap</title>
    </head>

    <body>

        <%@include file="../jspf/navi.jspf" %>
        
        <div class="container">

            <div class="starter-template">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Dodaj użytkownika</h3>
                    </div>
                    <div class="panel-body">
                        
                        <c:url value="/admin/user/save" var="action"/>
                        
                        <form:form commandName="user" action="${action}">

                            <spring:bind path="login">
                                <div class="control-group form-group ${status.error ? 'has-error' : '' }">
                                    <label class="control-label" for="login">Login</label> <form:errors path="login" cssClass="has-error"/>
                                    <form:input class="form-control" path="login" placeholder="Wpisz login"/>
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
                            <input class="btn btn-warning" type="button" value="Anuluj" onclick="location.href = '<c:url value="/admin/user/list"/> '"/> 
                        </form:form>
                    </div>
                </div>

            </div>

        </div><!-- /.container -->
        <%@include file="../jspf/footer.jspf" %>
    </body>
</html>
