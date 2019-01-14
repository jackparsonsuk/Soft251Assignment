<%-- 
    Document   : PatientPanel
    Created on : 08-Jan-2019, 12:49:05
    Author     : Jack
--%>

<%@page import="Other.Medicine"%>
<%@page import="Other.Review"%>
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
        <title>Paitent</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body style="text-align: center">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp"> Home</a>
            <a class="navbar-brand" href="login.jsp"> Login</a>

            
        </nav>
        <h1>Paitent</h1>
        
        
        <h2>Create Appointment</h2>
                <form action="PatientServlet" >

            Doctor:<select name="Doctors">
                <%          Doctor d = new Doctor();
                            ArrayList<Doctor> docs = d.readDoctor();
                    for (int i = 0; i < docs.size(); i++) {
                        %>
                        <option value="<%=docs.get(i).getID()%>"> <%=docs.get(i).getID()%> </option>
                        <%
                            
                        }
                
                
                
                %>
                
                
                
                
            </select><br>
                Date:<input type="Date" name="dateOfAp"><br>
        <input type="submit" value="Create Appointment"/>
        
                </form>
                
                <h2>Doctors ratings</h2>
                
                
                                <table class="table">
                    <tr>
                        <th>
                            Doctor
                        </th>
                        <th>
                            Rating
                        </th>

                        
                    </tr>
                    
                   
                         <%
                    
                   Review r = new Review();
                    for (int i = 0; i < docs.size(); i++) {
                            
                       
                        %>
                         <tr>
                        <th> <%=docs.get(i).getID()%> </th>
                        <th> <%=docs.get(i).viewRating()%> </th>
                       
                        </th><br>
                             </tr>
                        
                        <%
                            
                        }
                
                
                
                %>
                        
                        
                   
                    
                    
                </table>
        <h2> Rate your doctor</h2>
        <form action="PatientServlet">
            
             Doctor:<select name="RateDoc">
                <%

                    ArrayList<Doctor> newDocs = d.readDoctor();
                    for (int i = 0; i < newDocs.size(); i++) {
                        %>
                        <option value="<%=newDocs.get(i).getID()%>"> <%=newDocs.get(i).getID()%>  </option>
                        <%
                            
                        }
                System.out.println("Rating");
                
                
                %>
            
             </select><br>
                Rating: <input type="number" min="1" max="10" value="1" name="Rating">/10 <br>
                <input type="submit" value="Rate"/>
        </form>
                <h2>Your appointments</h2>
                <table class="table">
                     <tr>
                        <th>
                            Doctor
                        </th>
                        <th>
                            Patient
                        </th>
                        <th>
                            Date Of appointment
                        </th>

                        
                    </tr>
                    
                    
                    <%
                        Appointment tempAP = new Appointment();
                        ArrayList<Appointment> aps = tempAP.readAppointment();
                        for (int i = 0; i < aps.size(); i++) {
                            if (aps.get(i).getPat().getID().equals(session.getAttribute("ID"))) {
                                    
                                
                        %>
                        <tr>
                    <th>
                        <%= aps.get(i).getDoc().getID()%>
                    </th>
                    <th>
                        <%= aps.get(i).getPat().getID() %>
                        
                    </th>
                    <th>
                        <%= aps.get(i).getDateOfAp()%>
                        
                    </th>
                        </tr>
                    <%
                        }
                            }
                        %>
                    
                    
                </table>
                        
                        <h2> Your prescriptions</h2>
                         <table class="table">
                     <tr>
                        <th>
                            Medicine ID
                        </th>
                        <th>
                            Dosage
                        </th>
    

                        
                    </tr>
                        <%
                        
                        Patient p = new Patient();
                        Patient realP = p.getPaitent(session.getAttribute("ID").toString());
                        ArrayList<Medicine> meds = new ArrayList<Medicine>();
                        meds = realP.viewPrescription();
                        for(int z = 0; z<meds.size(); z++){

                        %>
                        
                         <tr>
                             <th>
                        <%=meds.get(z).getMedicineID()%>
                             </th>
                             <th>
                        <%=meds.get(z).getDosage()%>
                        
                             </th>
                        
                         </tr>
                        
                        <%
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
                <br>
                <form action="PatientServlet">
                    <input type="submit" name="terminate" value="Request account termination">
                </form>
                
                        
                        
                        
                        
    </body>
</html>
