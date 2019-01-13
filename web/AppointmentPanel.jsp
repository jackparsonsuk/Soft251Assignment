<%-- 
    Document   : AppointmentPanel
    Created on : 12-Jan-2019, 13:02:27
    Author     : Jack
--%>

<%@page import="Other.Medicine"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Other.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
        
        <h2> Prescribe Medicine</h2>
        <form action="AppointmentServlet">
        
                        <Select name="selectMedicine">
            <%
                Medicine m = new Medicine();
                ArrayList<Medicine> meds = m.readMedicine();
                for(int i = 0; i<meds.size(); i++){
                    
                
            %>
               Select Medicine:     

            
               <option value="<%=meds.get(i).getMedicineID()%>"><%=meds.get(i).getMedicineID()%>,  Quantity: <%=meds.get(i).getQuantity()%> </option>
            

            
            <%
            }    
            %><br><br>
            </select>
            Select Dosage:<input type="text" name="Dosage"><br><br>
            Select Quantity:<input type="text" name="Quant">
            <input type="Submit" value="Prescribe">
            
            
            
        </form>
        
        
        
    </body>
</html>
