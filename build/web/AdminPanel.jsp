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
        <form action="<% 
        String drId = request.getParameter("Doctors");
        Doctor d = new Doctor();
        ArrayList<Doctor> docs = d.readDoctor();
            for(int x = 0; x<docs.size(); x++){
                if (docs.get(x).getID().equals(drId)) {
                        d.removeDoctor(docs.get(x));
                    }
            }
        
        
        
        
        
        
            %>" method="POST">
        
            <select name="Doctors">
                <%
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
        <form action="<% 
        String secId = request.getParameter("Secs");
        Secretary s = new Secretary();
        ArrayList<Secretary> secs = s.readSecretary();
            for(int z = 0; z<secs.size(); z++){
                if (secs.get(z).getID().equals(secId)) {
                        s.removeSecretary(secs.get(z));
                    }
            }
        
        
        
        
        
        
            %>" method="POST">
        
            <select name="Secs">
                <%
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
                <form action="
                      <% String dID = request.getParameter("DocRating"); 
                      for(int z = 0; z<docs.size(); z++)
                      
                       if (docs.get(z).getID().equals(dID)) {
                           docs.get(z).calculateRating(5d);
                        request.setAttribute("Rating", docs.get(z).viewRating());
                    }
                      
                      %>
                      
                      
                      
                      
                      
                      
                      ">
                    
                    <select name="DocRating">
                <%
                    for (int i = 0; i < docs.size(); i++) {
                        %>
                        <option value="<%=docs.get(i).getID()%>"> <%=docs.get(i).getID()%> </option>
                        
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                
            </select>
                    <input type="submit" value="Remove"/>
                    
                    
                    
                </form>
        <%= request.getAttribute("Rating") %>
    </body>
</html>
