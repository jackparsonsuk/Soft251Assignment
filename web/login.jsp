<%-- 
    Document   : login
    Created on : 05-Jan-2019, 12:37:58
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        

        <form action="Login">
                    What are you:
            <select name="userType">
                <option value="D">Doctor</option>
                <option value="P">Patient</option>
                <option value="A">Admin</option>
                <option value="S">Secretary</option>
                
            </select><br>
            Enter ID: <input type="text" name="id"><br>
            Enter Password: <input type="text" name="pword"><br>
            <input type="submit" value="login">
            
        </form>
    </body>
</html>
