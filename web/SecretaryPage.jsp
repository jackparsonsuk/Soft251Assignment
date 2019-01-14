<%-- 
    Document   : SecretaryPage
    Created on : 07-Jan-2019, 12:44:43
    Author     : Jack
--%>

<%@page import="Other.Medicine"%>
<%@page import="Other.Notification"%>
<%@page import="Other.Appointment"%>
<%@page import="Users.Secretary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Users.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Secretary</title>
    </head>
    <body style="text-align: center">
               <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp"> Home</a>
            <a class="navbar-brand" href="login.jsp"> Login</a>

            
        </nav>
  <% 
        Secretary sec = new Secretary();
        Secretary realSec = sec.getSecretary(session.getAttribute("ID").toString());
        System.out.println(realSec.getID());
        System.out.println(session.getAttribute("ID").toString());
        
        
        %>
        <h1>Secretary</h1>
        
        <h2> Approve a patient</h2>
        <form action="Secretary">
            
             Pick Patient:<select name="unApproved">
        <% 
            Patient p = new Patient();
            ArrayList<Patient> pats = p.readPatient();

            for(int i = 0; i< pats.size(); i++){
                if (pats.get(i).isApproved()== false) {
                %>

                    <option value="<%=pats.get(i).getID()%>"> <%= pats.get(i).getID()%> </option>

            
            <%
                
 
                    }

            }
        
        %>
        </select><br>  
        
        <input type="submit" value="Approve"/>
        </form>
        
        
                <h2> Approve an Appointment</h2>
        <form action="Secretary" >
            
             Pick appointment:<select name="unAppoinments">
        <% 
            Appointment ap = new Appointment();
                ArrayList<Appointment> apss =ap.readAppointment();
            for(int u = 0; u< apss.size(); u++){
                if (apss.get(u).getApproved()== false) {
                %>

                    <option value="<%=apss.get(u).getAppointmentID()%>"> <%= apss.get(u).getDoc().getID()%>  + <%= apss.get(u).getPat().getID()%></option>

            
            <%
                
 
                    }

            }
        
        %>
        </select> <br> 
        
        <input type="submit" value="Approve"/>
        </form>
        <h2> Terminate account</h2>
                <form action="Secretary" >
            
             Select Patient:<select name="wantsTermination">
        <% 
            ArrayList<Patient> ps = p.readPatient();
            for(int f = 0; f< ps.size(); f++){
                if (ps.get(f).getWantsTermination()== true) {
                %>

                <option value="<%=ps.get(f).getID()%>"> <%= ps.get(f).getID()%></option>

            
            <%
                
 
                    }

            }
        
        %>
        </select><br>  
        
        <input type="submit" value="Remove"/>
        </form>
        
        
        
        <h2> Stock medicine</h2>
                </form>
                <form action="Secretary" >
            
             Select Medicine:<select name="restockMed">
        <% 
            Medicine m = new Medicine();
            ArrayList<Medicine> meds = m.readMedicine();
            for(int g = 0; g< meds.size(); g++){
                if (meds.get(g).getQuantity() <5) {
                        
                    
                %>

                <option style="color: red;" value="<%=meds.get(g).getMedicineID()%>"> <%= meds.get(g).getMedicineID()%> Stock: <%= meds.get(g).getQuantity()%></option>

            
            <%
                
            }else{
                    %>
                    
                    <option value="<%=meds.get(g).getMedicineID()%>"> <%= meds.get(g).getMedicineID()%> Stock: <%= meds.get(g).getQuantity()%></option>
                    <%
                }


            }
        
        %>
        </select> <br> 
        
        <input type="submit" value="Restock"/>
        </form>
        
        
        
        
        
        
            
            <h3>Your notifications</h3>
            <%

            ArrayList<String> notes = realSec.getNotis();
            
            for(int y = 0; y<notes.size(); y++){
                
            
            %>
            
            
            <h4><%=realSec.getNotis().get(y).toString()%></h4>

            
            <%
         
            }
            
            %>

        
    </body> 
</html>
