<%-- 
    Document   : AppointmentPanel
    Created on : 12-Jan-2019, 13:02:27
    Author     : Jack
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Other.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
        <%
       
        Appointment ap = new Appointment();
        String ID = session.getAttribute("curAppointment").toString();
        Appointment realAp = ap.getAppointment(ID);
        
        
        %>


        
        
        
        <h2> <%=realAp.getPat().getID()%>'S History</h2>
        
        <%
        ArrayList<Appointment> aps = ap.readAppointment();
        for (int i = 0; i < aps.size(); i++) {
                if (aps.get(i).getPat().getID().equals(realAp.getPat().getID())) {
                        %>
                        ID: <%=aps.get(i).getAppointmentID()%><br>
                        Doctor: <%=aps.get(i).getDoc().getID()%><br>
                        <%
                        
                        
                                
                            
                            for(int z = 0; z<aps.get(i).getNotes().size(); z++){
                            
                            
                        %>
                        Notes: <%=aps.get(i).getNotes().get(z)%><br>
                        
                        <%
                        }
                          
                        }
                        %>
                        <hr>
                        
                        <%
                    }
            
        
        
        %>
        
        <h2>Make notes</h2>
        <form action="AppointmentServlet">
            <input type="text" name="note">
            <input type="submit" value="Add note">
        </form>
        
        
    </body>
</html>
