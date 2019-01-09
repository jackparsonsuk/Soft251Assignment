<%-- 
    Document   : PatientPanel
    Created on : 08-Jan-2019, 12:49:05
    Author     : Jack
--%>

<%@page import="java.util.UUID"%>
<%@page import="Users.Patient"%>
<%@page import="Other.Appointment"%>
<%@page import="Users.Secretary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Users.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Paitent</h1>
        
        
        <h2>Doctors</h2>
                <form action="<% 
        
        String drId = request.getParameter("Doctors");
        Doctor d = new Doctor();
        Patient p = new Patient();
        ArrayList<Doctor> docs = d.readDoctor();
        ArrayList<Patient> pats = p.readPatient();
        Appointment ap = new Appointment();
            for(int x = 0; x<docs.size(); x++){
                if (docs.get(x).getID().equals(drId)) {
                        ap.setDoc(docs.get(x));
                    }
            }
            
            for(int x = 0; x<pats.size(); x++){
                if (pats.get(x).getID().equals(session.getAttribute("ID"))) {
                        
                        ap.setPat(pats.get(x));
                    }
            }
            String uniqueID = UUID.randomUUID().toString();
            ap.setAppointmentID(uniqueID);
            ap.SaveAppointment(ap);
        
        
        
        
        
        
            %>" method="POST">
        <%=session.getAttribute("ID")%>
            <select name="Doctors">
                <%
                    for (int i = 0; i < docs.size(); i++) {
                        %>
                        <option value="<%=docs.get(i).getID()%>"> <%=docs.get(i).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                
            </select>
        <input type="submit" value="Create Appointment"/>
        
                </form>
        <h2> Rate your doctor</h2>
        <form action="PatientServlet">
            
             <select name="RateDoc">
                <%
                    for (int i = 0; i < docs.size(); i++) {
                        %>
                        <option value="<%=docs.get(i).getID()%>"> <%=docs.get(i).getID()%> <%=docs.get(i).viewRating()%> </option>
                        <%
                            
                        }
                
                
                
                %>
            
             </select>
                <input type="Text" name="Rating">
                <input type="submit" value="Rate"/>
        </form>

    </body>
</html>
