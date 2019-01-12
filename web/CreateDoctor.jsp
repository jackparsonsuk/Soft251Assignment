<%-- 
    Document   : CreateDoctor
    Created on : 05-Jan-2019, 15:16:02
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
        <h1>Create Doctor</h1>
        
        
         <form action="NewUser">
              
            <table border= "0">
                <tbody>
                    <tr>
                        <tr>
                        <td>ID: </td>
                        <td><input type="string" name="ID" value="" size="25"></td>
                    </tr>
                    
                    <tr>
                        <td>Password: </td>
                        <td><input type="string" name="Pass" value="" size="25"></td>
                    </tr>
                    <tr>
                        <td>First name: </td>
                        <td><input type="text" name="first" 
                                   value="" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Last name: </td>
                        <td><input type="string" name="Last" value="" size="25"></td>
                    </tr>
                    <tr>
                        <td>Address: </td>
                        <td><input type="string" name="address" value="" size="25"></td>
                    </tr>
                    
                    <tr>
                        <td>Date of birth: </td>
                        <td><input type="text" name="dob" 
                                   value="DD/MM/YYYY" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Gender: </td>
                        <td><input type="string" name="Gender" value="" size="25"></td>
                    </tr>
                </tbody>
            </table>
            
            <input type="reset" value="Clear" />
            
            <input type="submit" value="Submit" />
        </form>

    </body>
</html>
