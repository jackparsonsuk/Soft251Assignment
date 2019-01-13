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
                realMed.setQuantity(curQuant);
                realMed.saveMedicine(realMed);
            
            }
            
            
            
    }


}
