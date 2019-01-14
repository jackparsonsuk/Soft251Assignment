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
        <title>Login</title>
    </head>
    <body style="text-align: center">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp"> Home</a>
            <a class="navbar-brand" href="login.jsp"> Login</a>

            
        </nav>
        <h1>Login</h1>
        <div class="text-center">
        <form action="Login">
            <table style="margin: 0px auto;" >
                <tbody>
                    <tr>
                        <tr>
                        <td> Who are you: </td>
                        <td><select name="userType">
                <option value="D">Doctor</option>
                <option value="P">Patient</option>
                <option value="A">Admin</option>
                <option value="S">Secretary</option>
                
            </select></td>
                    </tr>
                    
                    <tr>
                        <td>Enter ID:  </td>
                        <td><input type="text" name="id" size="25"></td>
                    </tr>
                    <tr>
                        <td>Enter Password: </td>
                        <td> <input type="text" name="pword" size="25"></td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td><input type="submit" value="login"></td>
                    </tr>

                </tbody>
            </table>
        </div>


                   
            
            
            
           
            
        </form>
    </body>
</html>
