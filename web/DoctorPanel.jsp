<%-- 
    Document   : DoctorPanel
    Created on : 11-Jan-2019, 18:28:17
    Author     : Jack
--%>

<%@page import="Users.Doctor"%>
<%@page import="Other.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor</title>
    </head>
    <body>
        <h1>Doctor</h1>

        <% 
        Doctor doc = new Doctor();
        Doctor realDoc = doc.getDoctor(session.getAttribute("ID").toString());
        
        
        
        %>
        Welcome <%=realDoc.getID()%><br>
        Current Rating: <%=realDoc.getRating() %><br>
        Comments:<%=realDoc.getFeedback().get(0) %>

        <h2>Upcomming appointments</h2>

        <%
            Appointment ap = new Appointment();
            ArrayList<Appointment> aps = ap.readAppointment();
            for(int i = 0; i < aps.size(); i++){
                if (ap.getAppointment(aps.get(i).getAppointmentID()).getDoc().getID().equals(session.getAttribute("ID"))) {
                        %>
                        
                        

                        <%=aps.get(i).getApproved()%>
                        <%=aps.get(i).getPat().getID()%><br>
                       
                                
                        
                        <%
                    }
            
            }
         
        
        %>

        <form action="DoctorServlet">
            <select name="SelectedAp">
            <%
             for(int i = 0; i < aps.size(); i++){
                if (ap.getAppointment(aps.get(i).getAppointmentID()).getDoc().getID().equals(session.getAttribute("ID"))) {

                        %>
                        <option value="<%=ap.getAppointment(aps.get(i).getAppointmentID()).getAppointmentID()%>"> <%=ap.getAppointment(aps.get(i).getAppointmentID()).getPat().getID() %></option>
                        
                        
                        
                        
                        <%
                }
             }
            
            
            
            
            
            %>
            
            </select>
            <Input type="Submit" value="View Appointment">
        </form>
        <h2>Create new medicine</h2>
    </body>
</html>
