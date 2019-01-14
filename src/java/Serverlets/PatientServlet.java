/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Other.Appointment;
import Other.Review;
import Users.Doctor;
import Users.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jack Parsons
 */
@WebServlet(name = "PatientServlet", urlPatterns = {"/PatientServlet"})
public class PatientServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ratingId = request.getParameter("RateDoc");
        String rat = request.getParameter("Rating");
          String drId = request.getParameter("Doctors");
          HttpSession session = request.getSession();
          String patId = session.getAttribute("ID").toString();
          String RviewDoc = request.getParameter("ReviewDoc");
          String Rview = request.getParameter("Review");
          String terminate = request.getParameter("terminate");
          String dateOfAp = request.getParameter("dateOfAp");
  
        
        if (!(ratingId == null)) {
            Doctor d = new Doctor();
            d = d.getDoctor(ratingId);
            double ratings = Double.parseDouble(rat);
            d.calculateRating(ratings);
            
        }
        
        
        if (!(terminate == null)) {
            Patient p = new Patient();
            Patient realP = p.getPaitent(patId);
            realP.setWantsTermination(Boolean.TRUE);
            p.savePatient(realP);
        }
        
        if ((!(drId == null)) && (!(patId == null))) {
            
        
        
               
        Doctor d = new Doctor();
        Patient p = new Patient();
        ArrayList<Doctor> docs = d.readDoctor();
        Doctor realDoc = new Doctor();
         Patient realPat = new Patient();

                realDoc = d.getDoctor(drId);
       
         realPat = p.getPaitent(patId);
            
                
               
        Appointment ap = new Appointment(realDoc,realPat);
        ap.setDateOfAp(dateOfAp);
        
                    
            String uniqueID = UUID.randomUUID().toString();
           ap.setAppointmentID(uniqueID);

            ap.SaveAppointment(ap);
        System.out.println("MADE Appointment");
        response.sendRedirect("PatientPanel.jsp");
    }
        
        
        if (!(RviewDoc == null)) {
            Review r = new Review();
            Doctor d = new Doctor();
            Doctor rDoctor = d.getDoctor(RviewDoc);
            r.setDoc(rDoctor);
            Patient p = new Patient();
            Patient rPatient = p.getPaitent(patId);
            r.setPat(rPatient);
            r.setMessage(Rview);
            r.SaveReview(r);
            
            
        }
    }


}
