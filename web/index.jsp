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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP Page</title>
        <%@page import="Users.*"%>
        <%@page import="Serverlets.*"%>
        <%@page import="java.io.*"%>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp"> Home</a>
            <a class="navbar-brand" href="login.jsp"> Login</a>

            
        </nav>
       
        
        <h1>Home</h1>
        <table class="table">
            <th><a href="CreateDoctor.jsp"><button>Create User</button></a></th>
            <th><a href="login.jsp"><button>Login</button></a></th>
        </table>
        

    </body>
</html>
