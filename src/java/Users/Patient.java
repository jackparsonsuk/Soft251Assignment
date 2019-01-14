/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;



import Other.Medicine;
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
    Boolean wantsTermination = false;

    /**
     *Empty Constructor
     */
    public Patient(){
        
    }

    /**
     * returns wether the Patient wants their account terminated
     * @return
     */
    public Boolean getWantsTermination() {
        return wantsTermination;
    }

    /**
     * sets wether the Patient wants their account terminated
     * @param wantsTermination
     */
    public void setWantsTermination(Boolean wantsTermination) {
        this.wantsTermination = wantsTermination;
    }

    /**
     * Constructor to create a patient
     * @param ID
     * @param Password
     * @param firstName
     * @param lastName
     * @param address
     * @param DOB
     * @param gender
     */
    public Patient(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;
    
    

    }

    /**
     * Return weather the patient's account is approved
     * @return
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Set weather the patient is approved
     * @param approved
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
    
    boolean approved = false;
    ArrayList<Medicine> prescription = new ArrayList<Medicine>();


    /**
     * Set the precription array list
     * @param prescription
     */
    public void setPrescription(ArrayList<Medicine> prescription) {
        this.prescription = prescription;
        
    }
    
    /**
     * View all prescriptions, returns the medicine arrayList
     * @return
     */
    public ArrayList<Medicine> viewPrescription(){
            return prescription;
    }


   
    /**
     * Saving Patient<br>
     * The Patient that you want to save is passed in<br>
     * Then the current ArrayList is read out and saved<br>
     * Next a check is done to see if the Patient is already in the array, if it is then it is removed<br>
     * Then the most up to date Patient is added<br>
     * Then it is saved to the file<br>
     * @param inPatient
     */
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
    
    /**
     * Gets a list of all the Patient<br>
     * Creates a list of Patient and then populates it with the medicine in the file<br>
     * Returns the list
     * @return
     */
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

    /**
     * Get a specific Patient based on the ID<br>
     * ID is passed in<br>
     * A new arrayList is created based on all of the Patients<br>
     * Then all of the Patients are searched to see if the ID is there<br>
     * if it is, the Patient is returned
     * @param PaitentID
     * @return
     */
    public Patient getPaitent(String PaitentID){
        ArrayList<Patient> pats = readPatient();
        for(int x = 0; x<pats.size(); x++){
                if (pats.get(x).getID().equals(PaitentID)) {
                        
                        return pats.get(x);
                    }
            }
        Patient patE = new Patient();
        return patE;
    }
    
}
