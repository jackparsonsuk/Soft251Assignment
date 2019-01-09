<%-- 
    Document   : SecretaryPage
    Created on : 07-Jan-2019, 12:44:43
    Author     : Jack
--%>

<%@page import="Other.Appointment"%>
<%@page import="Users.Secretary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Users.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       

        <h1>Secretary</h1>
        
        <h2> Approve a patient</h2>
        <form action="Secretary">
            
             <select name="unApproved">
        <% 
            Patient p = new Patient();
            ArrayList<Patient> pats = p.readPatient();

            for(int i = 0; i< pats.size(); i++){
                if (pats.get(i).isApproved()== false) {
                %>

                    <option value="<%=pats.get(i).getID()%>"> <%= pats.get(i).getID()%> </option>

            
            <%
                
 
                    }

            }
        
        %>
        </select>  
        
        <input type="submit" value="Approve"/>
        </form>
        
        
                <h2> Approve an Appointment</h2>
        <form action="Secretary" >
            
             <select name="unAppoinments">
        <% 
            Appointment ap = new Appointment();
                ArrayList<Appointment> apss =ap.readAppointment();
            for(int u = 0; u< apss.size(); u++){
                if (apss.get(u).getApproved()== false) {
                %>

                    <option value="<%=apss.get(u).getAppointmentID()%>"> <%= apss.get(u).getDoc().getID()%>  + <%= apss.get(u).getPat().getID()%></option>

            
            <%
                
 
                    }

            }
        
        %>
        </select>  
        
        <input type="submit" value="Approve"/>
        </form>
        
        <h2> 

        
    </body> 
</html>
