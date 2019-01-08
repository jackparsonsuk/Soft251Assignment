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
        <form action="<% 
        String sid = request.getParameter("unApproved");
        Patient p  = new Patient();
         ArrayList<Patient> pats =p.readPatient();
         Secretary sec = new Secretary();
                for(int x = 0; x <pats.size(); x++){
                    if (pats.get(x).getID().equals(sid)) {
                            sec.approvePatientAccount(pats.get(x));
                            p.savePatient(pats.get(x));
                        }
                }
                
        
        %>
              "method="POST">
            
             <select name="unApproved">
        <% 

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
        <form action="<% 
        String apoints = request.getParameter("unAppoinments");
        Appointment ap = new Appointment();
         ArrayList<Appointment> aps =ap.readAppointment();

                for(int x = 0; x <aps.size(); x++){
                    if (aps.get(x).getAppointmentID().equals(apoints)) {
                            sec.createAppoitment(aps.get(x));
                            aps.get(x).SaveAppointment(aps.get(x));
                        }
                }
                
        
        %>
              "method="POST">
            
             <select name="unAppoinments">
        <% 
                ArrayList<Appointment> apss =ap.readAppointment();
            for(int u = 0; u< apss.size(); u++){
                if (apss.get(u).getApproved()== false) {
                %>

                    <option value="<%=apss.get(u).getAppointmentID()%>"> <%= apss.get(u).getApproved()%> </option>

            
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
