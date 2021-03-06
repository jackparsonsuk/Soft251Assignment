/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Other.Medicine;
import Users.Patient;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jack
 */
@WebServlet(name = "Secretary", urlPatterns = {"/Secretary"})
public class Secretary extends HttpServlet {


    /**
     * The Secretary Servlet runs behind the Secretary Panel<br>
     * First the servlet can approve a patient account<br>
     * It can also approve an appointment<br>
     * It can also terminate the account of a user that wants termintation<br>
     * And finally it can restock the selected medicine
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String sid = request.getParameter("unApproved");
            String apoints = request.getParameter("unAppoinments");
            String wantsR= request.getParameter("wantsTermination");
            String restock = request.getParameter("restockMed");

        if (!(sid == null)) {
                  Patient p  = new Patient();
         ArrayList<Patient> pats =p.readPatient();
         Users.Secretary sec = new Users.Secretary();
         Patient realP = p.getPaitent(sid);
        sec.approvePatientAccount(realP);
        p.savePatient(realP); 
        }
        
                

        if (!(apoints == null)) {
            Other.Appointment ap = new Other.Appointment();
            
            Other.Appointment realAp = ap.getAppointment(apoints);
            Users.Secretary sec = new Users.Secretary();
            sec.createAppoitment(realAp);
            ap.SaveAppointment(realAp);
        } 
        
        if (!(wantsR==null)) {
            Patient p = new Patient();
            Patient realP = p.getPaitent(wantsR);
            realP.setApproved(false);
            realP.setWantsTermination(false);
            p.savePatient(realP);
        }
        if (!(restock==null)) {
            Medicine m = new Medicine();
            m = m.getMedicine(restock);
            int quantitiy = m.getQuantity();
            quantitiy += 100;
            m.setQuantity(quantitiy);
            m.saveMedicine(m);
            
            
        }
        
response.sendRedirect("SecretaryPage.jsp");
         
        
        
    }




}
