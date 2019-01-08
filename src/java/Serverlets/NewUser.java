/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import Users.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jack
 */
@WebServlet(name = "NewUser", urlPatterns = {"/NewUser"})
public class NewUser extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            String firstName = request.getParameter("first");
            String id = request.getParameter("ID");
            String pass = request.getParameter("Pass");
            String lastName = request.getParameter("Last");
            String address = request.getParameter("address");
            String DOB = request.getParameter("dob");
            String gender = request.getParameter("Gender");
            
            if (id.charAt(0) == 'D') {
            Doctor doc = new Doctor(id,pass,firstName,lastName,address,DOB,gender);
             doc.saveDoctor(doc);
            }
            if (id.charAt(0) == 'A') {
            Admin admin = new Admin(id,pass,firstName,lastName,address,DOB,gender);
             admin.saveAdmin(admin);
            }
            if (id.charAt(0) == 'P') {
            Patient pat = new Patient(id,pass,firstName,lastName,address,DOB,gender);
             pat.savePatient(pat);
            }
            if (id.charAt(0) == 'S') {
            Users.Secretary sec = new Users.Secretary(id,pass,firstName,lastName,address,DOB,gender);
             sec.saveSecretary(sec);
            }
            
             
             
             


            response.sendRedirect("CreateDoctor.jsp");
//            HttpSession session = request.getSession();
//            
//            session.setAttribute("Dingus", savedDoc.get(1).getDoctorID());
//            session.setAttribute("Bangus", pass);
//            session.setAttribute("Angus", savedDoc.get(0).getAddress());
    }
    


  

}
