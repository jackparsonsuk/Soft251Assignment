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
import java.util.ArrayList;
import java.util.UUID;
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

    /**
     * The Patient servlet runs behind the Patient Panel<br>
     * The first feature here is the ability to give a Doctor a rating<br>
     * This works by getting the doctor ID and parseing the rating given<br>
     * Then running the calculate rating function<br><br>
     * Next, the user has the ability to terminate their account<br>
     * If the button is pressed, the patient is retrived and the terminate boolean is set to true<br><br>
     * Next the user can create an appointment with a doctor, based on the doctor selected and the currently logged in user<br><br>
     * Finally the user can review a doctor, this works in the same way as giving a doctor a rating.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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
        response.sendRedirect("PatientPanel.jsp");
    }


}
