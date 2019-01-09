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
                <form action="
                      
        PatientServlet" >
        <%=session.getAttribute("ID")%>
            <select name="Doctors">
                <%          Doctor d = new Doctor();
                            ArrayList<Doctor> docs = d.readDoctor();
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

                    ArrayList<Doctor> newDocs = d.readDoctor();
                    for (int i = 0; i < newDocs.size(); i++) {
                        %>
                        <option value="<%=newDocs.get(i).getID()%>"> <%=newDocs.get(i).getID()%> <%=newDocs.get(i).viewRating()%> </option>
                        <%
                            
                        }
                System.out.println("Rating");
                
                
                %>
            
             </select>
                <input type="Text" name="Rating">
                <input type="submit" value="Rate"/>
        </form>
                <h2>Your appointments</h2>
                <table>
                    <%
                        Appointment tempAP = new Appointment();
                        ArrayList<Appointment> aps = tempAP.readAppointment();
                        for (int i = 0; i < aps.size(); i++) {
                            if (aps.get(i).getPat().getID().equals(session.getAttribute("ID"))) {
                                    
                                
                        %>
                    <th>
                        <%= aps.get(i).getDoc().getID()%>
                    </th>
                    <td>
                        <%= aps.get(i).getPat().getID() %>
                        
                    </td>
                    <%
                        }
                            }
                        %>
                    
                    
                </table>

                        
                        
                        <h2> Review your doctor!</h2>
                        <form action="PatientServlet">
            
             <select name="ReviewDoc">
                <%

                    for (int i = 0; i < newDocs.size(); i++) {
                        %>
                        <option value="<%=newDocs.get(i).getID()%>"> <%=newDocs.get(i).getID()%> </option>
                        <%
                            
                        }

                
                
                %>

             </select>
                <input type="Text"  name="Review">
                <input type="submit" value="Review"/>
        </form>
                        
                        
                        
                        
    </body>
</html>
