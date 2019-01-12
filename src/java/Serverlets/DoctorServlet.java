/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Other.Appointment;
import java.io.IOException;
import java.io.PrintWriter;
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
         HttpSession session = request.getSession();
         Appointment ap = new Appointment();
         Appointment realAp = ap.getAppointment(curAppointment);
         String id = realAp.getAppointmentID();
         
           if (!(curAppointment==null) ) {
               System.out.println(id.toString() + "-----------------------------");
               session.setAttribute("curAppointment", id.toString());
               response.sendRedirect("AppointmentPanel.jsp");
           }
        

    }




}
