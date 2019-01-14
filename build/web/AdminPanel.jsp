<%-- 
    Document   : AdminPanel
    Created on : 07-Jan-2019, 15:54:21
    Author     : Jack
--%>

<%@page import="Other.Review"%>
<%@page import="Users.Secretary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Users.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    </head>
    <body style="text-align: center">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp"> Home</a>
            <a class="navbar-brand" href="login.jsp"> Login</a>

            
        </nav>
        <h1>Admin</h1>
        <h2> Remove a Doctor</h2>
        <form action="AdminServlet" >
        
            Pick doctor:<select name="Doctors">
                <%
                    Doctor d = new Doctor();
                    ArrayList<Doctor> docs = d.readDoctor();
                    for (int i = 0; i < docs.size(); i++) {
                        %>
                        <option value="<%=docs.get(i).getID()%>"> <%=docs.get(i).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                
            </select><br>
        <input type="submit" value="Remove"/>
        
    </form>
        <h2> Remove a Secretary</h2>
        <form action="AdminServlet">
        
            Pick secretary:<select name="Secs">
                <%
                    Secretary sec = new Secretary();
                    ArrayList<Secretary> secs = sec.readSecretary();
                    for (int v = 0; v < secs.size(); v++) {
                        %>
                        <option value="<%=secs.get(v).getID()%>"> <%=secs.get(v).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
            </select><br>
           
        <input type="submit" value="Remove"/>
        
    </form>
                 <h2> Doctors ratings</h2>
                <table class="table">
                    <tr>
                        <th>
                            Doctor
                        </th>
                        <th>
                            Rating
                        </th>
                        <th>
                            Feedback
                        </th> 
                        <th>
                            Comments
                        </th>
                        
                    </tr>
                    
                   
                         <%
                    
                   Review r = new Review();
                    for (int i = 0; i < docs.size(); i++) {
                            
                         ArrayList<Review> docR = r.getDoctorReview(docs.get(i).getID());
                        %>
                         <tr>
                        <th> <%=docs.get(i).getID()%> </th>
                        <th> <%=docs.get(i).viewRating()%> </th>
                        <th>
                            <%
                            for(int x = 0; x<docR.size(); x++){
                                %>
                                <%=docR.get(x).getMessage()%><br> 
                                <%
                            }
                            %>
                            
                        </th>
                        <th>
                            <%
                                for(int z = 0; z<docs.get(i).getFeedback().size();z++){
                                %>
                                <%=docs.get(i).getFeedback().get(z)%>
                                <%
                                }
                            %>
                        </th>
                         <br>
                             </tr>
                        
                        <%
                            
                        }
                
                
                
                %>
                        
                        
                   
                    
                    
                </table>
                
                <form action="AdminServlet">
                    <h2>Give feedback to doctor</h2>
            Select Doctor: <select name="Docs">
                <%

                    for (int l = 0; l < docs.size(); l++) {
                        %>
                        <option value="<%=docs.get(l).getID()%>"> <%=docs.get(l).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
            </select><br>
                Feedback:<input type="text" name="feedDoc"><br>
        <input type="submit" value="Give Feedback"/>
        
    </form>

               

    </body>
</html>
