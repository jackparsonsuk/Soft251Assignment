/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Users.Doctor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Jack Parsons
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    /**
     * This servlet does many things.<br>
     * First the serverlet, can remove a doctor<br>
     * This happens when a doctor is selcted<br>
     * Then a new instance of a doctor is created and the doctor is removed<br><br>
     * Next the servlet can remove a secretary in the same way it can remove a doctor<br><br>
     * It also can get the doctors rating and set an attribute of it.<br><br>
     * Finally the servlet can create a new feedback file for a doctor<br>
     * It first gets the feedback that has been passed in, and the current doctor ID.<br>
     * Then the feedback is created and saved 
     * 
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                      String drId = request.getParameter("Doctors");
                      String secId = request.getParameter("Secs");
                      String dID = request.getParameter("DocRating"); 
                      String docFeed = request.getParameter("Docs");
        
        //Remove a doctor
        if (!(drId==null) ) {
                    Doctor d = new Doctor();
                    Doctor realDoc = d.getDoctor(drId);
                    d.removeDoctor(realDoc);
                  
            }
        
        //Remove a secretary
        if (!(secId == null)) {
           Users.Secretary s = new Users.Secretary();
        ArrayList<Users.Secretary> secs = s.readSecretary();
            for(int z = 0; z<secs.size(); z++){
                if (secs.get(z).getID().equals(secId)) {
                        s.removeSecretary(secs.get(z));
                    }
            } 
        }
        
        //Output a doctors rating
                    if (!(dID==null)) {
                        Doctor d = new Doctor();
                        Doctor realDoc = d.getDoctor(dID);

                        request.setAttribute("Rating", realDoc.viewRating());
                    }
                    
                    
                    //Give feedback on a doctor
                    
                    
                    if (!(docFeed==null)) {
                            String Feedb = request.getParameter("feedDoc");
                            Doctor d = new Doctor();
                            Doctor realDoc = d.getDoctor(docFeed);
                            realDoc.addFeedback(Feedb, realDoc);
                        }
                    
                response.sendRedirect("AdminPanel.jsp");
        }
                       
                
        
        






}
