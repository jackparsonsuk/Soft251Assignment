/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Users.Doctor;
import Users.Patient;
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
public class Appointment implements java.io.Serializable{
        String AppointmentID;
    Doctor doc;
    Patient pat;
    String notes;
    Boolean approved = false;

    public void Appointment(){
    
    }
    public void Appointment(Doctor doc, Patient pat){
        this.doc = doc;
        this.pat = pat;
    }
    public String getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(String AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    public void SaveAppointment(Appointment ap){
        
         ArrayList<Appointment> cur = readAppointment();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Appointments.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i).getAppointmentID().equals(ap.getAppointmentID())) {
                    cur.remove(i);
                }
            }
        cur.add(ap);
        outs.writeObject(cur);
        outs.close();
        fileOut.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
        
        
    }
    public ArrayList<Appointment> readAppointment(){
    ArrayList<Appointment> appointments = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack/Desktop/Netbeansout/Appointments.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        appointments = (ArrayList<Appointment>)ins.readObject();
        fileIn.close();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return appointments;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return appointments;
      }
        return appointments;
    }
    public Appointment getAppointment(String AppointmentID){
        ArrayList<Appointment> aps = new ArrayList<>();
        aps = readAppointment();
        Appointment realAp;
        for(int x = 0; x <aps.size(); x++){
                    if (aps.get(x).getAppointmentID().equals(AppointmentID)) {
                        realAp = aps.get(x);
                           return realAp;
                        }
                }
        Appointment apE = new Appointment();
        return apE;
        
    }
    
    
    
    
    
}
