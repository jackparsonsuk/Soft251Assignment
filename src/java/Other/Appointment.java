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
import java.util.Date;

/**
 *
 * @author Jack
 */
public class Appointment implements java.io.Serializable{
        String AppointmentID;
    Doctor doc;
    Patient pat;
    ArrayList<String> notes = new ArrayList<String>();
    Boolean approved = false;
    String dateOfAp;

    /**
     *  Returns the date of the appointment
     * @return
     */
    public String getDateOfAp() {
        return dateOfAp;
    }

    /**
     *Sets the date of the appointment
     * @param dateOfAp
     */
    public void setDateOfAp(String dateOfAp) {
        this.dateOfAp = dateOfAp;
    }

    /**
     *Appointment Constructor<br>
     * Passes in the doctor and the patient for the appointment
     * @param doc
     * @param pat
     */
    public Appointment(Doctor doc, Patient pat){
        this.doc = doc;
        this.pat = pat;

    }

    /**
     *Empty constructor
     */
    public Appointment(){
    
    }

    /**
     *Gets the appointment ID
     * @return
     */
    public String getAppointmentID() {
        return AppointmentID;
    }

    /**
     *Sets the Appointment ID
     * @param AppointmentID
     */
    public void setAppointmentID(String AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    /**
     *Returns the doctor
     * @return
     */
    public Doctor getDoc() {
        return doc;
    }

    /**
     *Sets the doctor
     * @param doc
     */
    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    /**
     *Gets the Patient
     * @return
     */
    public Patient getPat() {
        return pat;
    }

    /**
     *Sets the Patient
     * @param pat
     */
    public void setPat(Patient pat) {
        this.pat = pat;
    }

    /**
     *Returns an arraylist of all notes made in the appointment
     * @return
     */
    public ArrayList<String> getNotes() {
        return notes;
    }

    /**
     *Sets the Notes
     * @param notes
     */
    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    /**
     *Gets weather the appointment has been approved
     * @return
     */
    public Boolean getApproved() {
        return approved;
    }

    /**
     *Sets the approved status
     * @param approved
     */
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    
    /**
     *Saving the Appointment<br>
     * The Appointment that you want to save is passed in<br>
     * Then the current ArrayList is read out and saved<br>
     * Next a check is done to see if the Appointment is already in the array, if it is then it is removed<br>
     * Then the most up to date Appointment is added<br>
     * Then it is saved to the file<br>
     * @param ap
     */
    public void SaveAppointment(Appointment ap){
        
         ArrayList<Appointment> cur = readAppointment();
        try(FileOutputStream fileOut = new FileOutputStream("Appointments.ser")){
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

    /**
     *gets a list of all the Appointments<br>
     * Creates a list of Appointments and then populates it with the Appointments in the file<br>
     * Returns the list
     * @return
     */
    public ArrayList<Appointment> readAppointment(){
    ArrayList<Appointment> appointments = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("Appointments.ser");
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

    /**
     * Get a specific appointment based on the ID<br>
     * ID is passed in<br>
     * A new arrayList is created based on all of the appointments<br>
     * Then all of the appointments are searched to see if the ID is there<br>
     * if it is, the appointment is returned
     * 
     * @param AppointmentID
     * @return
     */
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
