<%-- 
    Document   : AdminPanel
    Created on : 07-Jan-2019, 15:54:21
    Author     : Jack
--%>

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
        <h1>Hello World!</h1>
        <h2> Remove a Doctor</h2>
        <form action="AdminServlet" >
        
            <select name="Doctors">
                <%
                    Doctor d = new Doctor();
                    ArrayList<Doctor> docs = d.readDoctor();
                    for (int i = 0; i < docs.size(); i++) {
                        %>
                        <option value="<%=docs.get(i).getID()%>"> <%=docs.get(i).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                
            </select>
        <input type="submit" value="Remove"/>
        
    </form>
        <h2> Remove a Secretary</h2>
        <form action="AdminServlet">
        
            <select name="Secs">
                <%
                    Secretary sec = new Secretary();
                    ArrayList<Secretary> secs = sec.readSecretary();
                    for (int v = 0; v < secs.size(); v++) {
                        %>
                        <option value="<%=secs.get(v).getID()%>"> <%=secs.get(v).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                a
            </select>
        <input type="submit" value="Remove"/>
        
    </form>
                <form action="AdminServlet">
                    
                    <select name="DocRating">
                <%
                    for (int i = 0; i < docs.size(); i++) {
                        %>
                        <option value="<%=docs.get(i).getID()%>"> <%=docs.get(i).getID()%> </option>
                        
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                
            </select>
                    <input type="submit" value="Rating?"/>
                    
                    
                    
                </form>
        <%= request.getAttribute("Rating") %>
    </body>
</html>
