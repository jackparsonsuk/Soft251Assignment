/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Other.Appointment;
import Other.Medicine;
import Other.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jack
 */
@WebServlet(name = "DoctorServlet", urlPatterns = {"/DoctorServlet"})
public class DoctorServlet extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String curAppointment = request.getParameter("SelectedAp");
         String medId = request.getParameter("MedName");
         String Dos = request.getParameter("Dosage");
         HttpSession session = request.getSession();
         Appointment ap = new Appointment();
         Appointment realAp = ap.getAppointment(curAppointment);
         String id = realAp.getAppointmentID();
         
           if (!(curAppointment==null) ) {
               System.out.println(id.toString() + "-----------------------------");
               session.setAttribute("curAppointment", id.toString());
               response.sendRedirect("AppointmentPanel.jsp");
           }
           if (!(medId == null)) {
            Medicine med = new Medicine();
            med.setMedicineID("M" + medId);
            med.setDosage(Dos);
            
            Users.Secretary s  = new Users.Secretary();
            ArrayList<Users.Secretary> secs = s.readSecretary();
               for (int i = 0; i < secs.size(); i++) {
                    med.addObserrver(secs.get(i));
               }
             System.out.println("Creeated Medicine" + medId);
             med.notifyObserver();
            med.saveMedicine(med);
          
            
        }
        

    }




}
