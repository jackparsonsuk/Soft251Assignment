/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jack
 */
public class Patient extends User{

     public Patient(){
        
    }
    public Patient(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;
    
    

    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
    
    boolean approved = false;
    //add in prescribed medicine, using a medicine array
    
    public void rateDoctor(int rating){
    
    }
    public void requestAppointment(){
        
        
        
        
    }
    

    
    
    public void viewPrescription(){
    
    }
    public void requestAccountTermination(){
    
    }
   
    
    
     public void savePatient(Patient inPatient){
        ArrayList<Patient> cur = readPatient();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Patients.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i).getID().equals(inPatient.getID())) {
                    cur.remove(i);
                }
            }
        cur.add(inPatient);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    
     
     
    public ArrayList<Patient> readPatient(){
    ArrayList<Patient> patients = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack/Desktop/Netbeansout/Patients.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        patients = (ArrayList<Patient>)ins.readObject();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return patients;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return patients;
      }
        return patients;
    }
    
}