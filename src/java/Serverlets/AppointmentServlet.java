/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Other.Appointment;
import Other.Medicine;
import Users.Patient;
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
@WebServlet(name = "AppointmentServlet", urlPatterns = {"/AppointmentServlet"})
public class AppointmentServlet extends HttpServlet {

    /**
     *
     * The servlet behind the appointment panel<br>
     * First this servlet has the ability to add notes to the current appointment<br>
     * To do this, first the all of the notes from the current appointment get retrived<br>
     * Then the note is added to the array<br>
     * Next the array of notes is set back to the appointment<br>
     * Then the appointment is saved<br><br>
     * It also has the ability to assign medicine to a patient<br>
     * This happens by a list of the patients current prescriptions<br>
     * Then adding a dosage<br>
     * Next, the quantity is taken away, and if the quantity goes under 0, the medicine is not assigned<br>
     * If not, the medicine is assigned.
     * 
     * 
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String note = request.getParameter("note");
            HttpSession session = request.getSession();
            String curAppointment = session.getAttribute("curAppointment").toString();
            String selectedMed = request.getParameter("selectMedicine");
            Appointment ap = new Appointment();
            Appointment realAp = ap.getAppointment(curAppointment);
            
            if (!(note==(null))) {
            ArrayList<String> curNotes = realAp.getNotes();
            curNotes.add(note);
            realAp.setNotes(curNotes);
            ap.SaveAppointment(realAp);
            System.out.println(note);
            }
            if (!(selectedMed==(null))) {
                Patient p =realAp.getPat();
                ArrayList<Medicine> presc = p.viewPrescription();
                Medicine med = new Medicine();
                med = med.getMedicine(selectedMed);
                med.setDosage(request.getParameter("Dosage"));
                presc.add(med);
                p.setPrescription(presc);
                p.savePatient(p);
                
                Medicine realMed = med.getMedicine(selectedMed);
                int quantity = Integer.parseInt(request.getParameter("Quant"));
                int currentQuant = realMed.getQuantity();
                int curQuant = (currentQuant-quantity);
                if (curQuant<0) {
                            response.sendRedirect("AppointmentPanel.jsp");

                }else{
                realMed.setQuantity(curQuant);
                realMed.saveMedicine(realMed);  
                }
                
            
            }
            response.sendRedirect("AppointmentPanel.jsp");
            
            
    }


}
