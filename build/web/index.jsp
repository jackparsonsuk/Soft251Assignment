<%-- 
    Document   : index
    Created on : 04-Jan-2019, 17:47:09
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@page import="Users.*"%>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Doctor doc = new Doctor();
            doc.setFirstName("Harry");
        %>
        
        Doctors name: <%= doc.getFirstName() %>
    </body>
</html>
