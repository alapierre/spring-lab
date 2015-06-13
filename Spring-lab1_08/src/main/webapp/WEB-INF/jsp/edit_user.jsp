<%-- 
    Document   : edit_user
    Created on : 2015-06-13, 11:44:22
    Author     : Adrian Lapierre <adrian@soft-project.pl>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bike Shop :: Dane użytkownika</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <style>
        .error {color: red}
    </style>
    <body>
        <div class="container">
            
            <form:form commandName="user" action="save">
                Login:<br/> <form:errors path="login" cssClass="error"/> <br/>
                <form:input path="login"/><br/>
                Hasło:<br/>
                <form:input path="password"/><form:errors path="password" cssClass="error"/> <br/>
                
                <br/><form:button>Zapisz</form:button> 
                <input type="button" value="Anuluj" onclick="location.href='display-customers.htm'"/> 
            </form:form>
        </div>
    </body>
</html>
