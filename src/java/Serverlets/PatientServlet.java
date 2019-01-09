/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Users.Doctor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        
        if (!ratingId.equals("")) {
            Doctor d = new Doctor();
            d = d.getDoctor(ratingId);
            double ratings = Double.parseDouble(rat);
            d.calculateRating(ratings);
            
        }
    }


}
