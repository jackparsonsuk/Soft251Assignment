<%-- 
    Document   : DoctorPanel
    Created on : 11-Jan-2019, 18:28:17
    Author     : Jack
--%>

<%@page import="Users.Patient"%>
<%@page import="Users.Doctor"%>
<%@page import="Other.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
        Comments:
        <%
        ArrayList<String> comments = realDoc.getFeedback();
        for (int i = 0; i < comments.size(); i++) {
                %>
                <%=comments.get(i)%>
                <%
            }
        
        %>


        <h2>Upcomming approved appointments</h2>


        <form action="DoctorServlet">
            <select name="SelectedAp">
            <%
             Appointment ap = new Appointment();
            ArrayList<Appointment> aps = ap.readAppointment();
             for(int i = 0; i < aps.size(); i++){
                if (ap.getAppointment(aps.get(i).getAppointmentID()).getDoc().getID().equals(session.getAttribute("ID"))) {
                        if (aps.get(i).getApproved() == true) {
                                
                            
                        %>
                        <option value="<%=ap.getAppointment(aps.get(i).getAppointmentID()).getAppointmentID()%>"> <%=ap.getAppointment(aps.get(i).getAppointmentID()).getPat().getID() %></option>
                        
                        
                        
                        
                        <%
                    }
                }
             }
            
            
            
            
            
            %>
            
            </select>
            <Input type="Submit" value="View Appointment">
        </form>
        <h2>Create new medicine</h2>
        
        <form action="DoctorServlet">
            <input type ="text" name="MedName">
            <input type="text" name="Dosage">
            <input type="Submit" value="Create Medicine">
        </form>
                        <form action="DoctorServlet" >

            <select name="Patient">
                <%          Patient p = new Patient();
                            ArrayList<Patient> pats = p.readPatient();
                    for (int i = 0; i < pats.size(); i++) {
                        %>
                        <option value="<%=pats.get(i).getID()%>"> <%=pats.get(i).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                
            </select>
                <input type="Date" name="dateOfAp">
        <input type="submit" value="Propose Appointment"/>
        
                </form>
        
        
    </body>
</html>
