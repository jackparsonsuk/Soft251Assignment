/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;
import Other.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack
 */
public class Doctor extends User implements java.io.Serializable{

    Double Rating = 0d;
    int numberOfRating = 0;
    public Doctor(){
        
    }
    public Doctor(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;
    

    }


    
    
    public void viewAppoitments(){
    
    
    }
    
    public void prescribeMedicine(Patient pat){
    
    }
    public void createMedicine(Medicine med){
    
    }
    public void orderMedicine(Medicine med){
    
    }
    public void calculateRating(Double rating){
    numberOfRating++;
    Rating  = Rating +((rating - Rating) / numberOfRating);
    saveDoctor(this);

    }
    public double viewRating(){
    return Rating;
    }
    
    
    
    
    
     public void saveDoctor(Doctor inDoctor){
        ArrayList<Doctor> cur = readDoctor();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack Parsons/Desktop/Netbeansout/Doctors.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        
            for (int i = 0; i < cur.size(); i++) {
               if (cur.get(i).getID().equals(inDoctor.getID())) {
                    cur.remove(i);
                } 
            }
        cur.add(inDoctor);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    
     
     
    public ArrayList<Doctor> readDoctor(){
    ArrayList<Doctor> doctors = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack Parsons/Desktop/Netbeansout/Doctors.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        doctors = (ArrayList<Doctor>)ins.readObject();
        fileIn.close();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return doctors;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return doctors;
      }
        return doctors;
    }
    public void removeDoctor(Doctor inDoc){
        ArrayList<Doctor> doctors = readDoctor();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getID().equals(inDoc.getID())) {
                doctors.remove(i);
                   
            }
        }
    
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack Parsons/Desktop/Netbeansout/Doctors.ser")){
                    ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        
                    outs.writeObject(doctors);
                    fileOut.close();
                    outs.close();
        
                    }   
                        catch(IOException io){
                        io.printStackTrace();
                    }
        
        
    }
    public Doctor getDoctor(String doctorID){
        Doctor d = new Doctor();
     ArrayList<Doctor> docs = d.readDoctor();
            for(int x = 0; x<docs.size(); x++){
                if (docs.get(x).getID().equals(doctorID)) {
                    System.out.println("FOUND DOCTOR -----------------------------------------------------------------");
                        return docs.get(x);
                        
                    }
                }
                System.out.println("NO DOCTOR FOUND -----------------------------------------------------------------");
                Doctor doc = new Doctor();
              return doc;
            }
    
  
    }
         
         
        
    

    
    

