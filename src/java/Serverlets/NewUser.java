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
            
            }
             Doctor doc = new Doctor(id,pass,firstName,lastName,address,DOB,gender);
             ArrayList<Doctor> Docs = new ArrayList<>();
            Docs.add(doc);
             ser(Docs);
             
            ArrayList<Doctor> savedDoc = unSer();
            response.sendRedirect("welcome.jsp");
            HttpSession session = request.getSession();
            
            session.setAttribute("Dingus", savedDoc.get(1).getDoctorID());
            session.setAttribute("Bangus", pass);
            session.setAttribute("Angus", savedDoc.get(0).getAddress());
    }
    
    
    public void ser(ArrayList<Doctor> inDoc){
    ArrayList<Doctor> cur = unSer();
            try{
            try (FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Doctors.ser")) {
                ObjectOutputStream outs = new ObjectOutputStream(fileOut);
                
                cur.add(inDoc.get(0));
                outs.writeObject(cur);
                outs.close();
            }
            }
            catch(IOException i){
            i.printStackTrace();
            }
    }
    
    public ArrayList<Doctor> unSer(){
        ArrayList<Doctor> docs = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream("C:/Users/Jack/Desktop/Netbeansout/Doctors.ser");
            ObjectInputStream ins = new ObjectInputStream(fileIn);
            docs =   (ArrayList<Doctor>) ins.readObject();
        }
          catch (IOException i) {
         i.printStackTrace();
         return docs;
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return docs;
      }
      
     return docs;   
    }

  

}
