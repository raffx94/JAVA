<%-- 
    Document   : error
    Created on : 2018-01-12, 16:25:01
    Author     : Rafał
--%>

<%@page import="model.WrongArgumentsException"%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String err = (String) request.getAttribute("error");
            
            out.println(err + " " );

        %>
    </body>
</html>
