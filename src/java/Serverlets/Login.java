 package Serverlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Users.Admin;
import Users.Doctor;
import Users.Patient;
import Users.Secretary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.mail.Session;
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
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * The Login servlet runs behind the Login Panel<br>
     * It has many repeating parts, depending on what the ID starts with (A,S,D,P), it will pick the right section<br>
     * For example, if the user is a patient, there ID will start with P, so the code will go through the Patient section<br>
     * Within here, first, the user name and password are checked to see if they match (And in patient, to see if it is approved)<br>
     * And if they are all true, the user will be redirected to the right area.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String UsernameCheck;
      String PasswordCheck;
        HttpSession session = request.getSession();

        String pass = request.getParameter("pword");
        String userType = request.getParameter("userType");
        String uname = userType+ request.getParameter("id").toUpperCase();
        System.out.println("Logged in with user: " + uname);

        if (uname.startsWith("A")) {
            
            ArrayList<Admin> a = new ArrayList<>();
            Admin ad  = new Admin();
            a = ad.readAdmin();
            
            for (int i = 0; i < a.size(); i++) {
                UsernameCheck = a.get(i).getID();
                PasswordCheck = a.get(i).getPassword();
                if (uname.equals(UsernameCheck.toUpperCase()) && pass.equals(PasswordCheck)) {
                     
                     session.setAttribute("ID", UsernameCheck);
                    response.sendRedirect("AdminPanel.jsp");
                    
                    }


            }
            
        }
        if (uname.startsWith("S")) {
            
            ArrayList<Secretary> a = new ArrayList<>();
            Secretary se  = new Secretary();
            a = se.readSecretary();
            
            for (int i = 0; i < a.size(); i++) {
                UsernameCheck = a.get(i).getID();
                PasswordCheck = a.get(i).getPassword();
                if (uname.equals(UsernameCheck.toUpperCase()) && pass.equals(PasswordCheck)) {
                    session.setAttribute("ID", UsernameCheck);
                    response.sendRedirect("SecretaryPage.jsp");
                    }

                
            }
            
        }if (uname.startsWith("D")) {
            
            ArrayList<Doctor> d = new ArrayList<>();
            Doctor doc  = new Doctor();
            d = doc.readDoctor();
            
            for (int i = 0; i < d.size(); i++) {
                UsernameCheck = d.get(i).getID();
                PasswordCheck = d.get(i).getPassword();
                if (uname.equals(UsernameCheck.toUpperCase()) && pass.equals(PasswordCheck)) {
                    session.setAttribute("ID", UsernameCheck);
                    response.sendRedirect("DoctorPanel.jsp");
                    }

                
                
            }
            
        }
        
        if (uname.startsWith("P")) {
            System.out.println("Paitent");
            ArrayList<Patient> p = new ArrayList<>();
            Patient pa  = new Patient();
            p = pa.readPatient();
            
            for (int i = 0; i < p.size(); i++) {
                UsernameCheck = p.get(i).getID();
                PasswordCheck = p.get(i).getPassword();
                if (uname.equals(UsernameCheck.toUpperCase()) && pass.equals(PasswordCheck) && p.get(i).isApproved() == true) {
                    session.setAttribute("ID", UsernameCheck);
                    System.out.println("Logged in");
                    response.sendRedirect("PatientPanel.jsp");
                    }

                
                
            }
            
        }


        
    }
    private void patientLogIn(){
        
    }

}
