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
    ArrayList<String> feedback = new ArrayList<String>();

    /**
     * Empty constructor
     */
    public Doctor(){
        
    }

    /**
     *
     * Constructor for creating a Doctor
     * 
     * 
     * @param ID
     * @param Password
     * @param firstName
     * @param lastName
     * @param address
     * @param DOB
     * @param gender
     */
    public Doctor(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;
    

    }

    /**
     * Gets the rating of the doctor
     * @return
     */
    public Double getRating() {
        return Rating;
    }

    /**
     *  Sets the rating
     * @param Rating
     */
    public void setRating(Double Rating) {
        this.Rating = Rating;
    }



    /**
     * Returns all feedback about the doctor in An ArrayList of Strings
     * @return
     */
    public ArrayList<String> getFeedback() {
        return feedback;
    }

    /**
     *  Sets the feedback, passing in an arrayList of strings
     * @param feedback
     */
    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }


    /**
     * Calculates the rating of the doctor<br>
     * First passing in the rating<br>
     * Next increasing the number of ratings by one<br>
     * Calculate<br>
     * Then save the doctor, with the new rating
     * @param rating
     */
    public void calculateRating(Double rating){
    numberOfRating++;
    Rating  = Rating +((rating - Rating) / numberOfRating);
    saveDoctor(this);

    }

    /**
     * Returns the rating
     * @return
     */
    public double viewRating(){
    return Rating;
    }
    
    /**
     * Adds feedback to the ArrayList of strings<br>
     * First the old feedback list is read out<br>
     * Then the new feedback is added<br>
     * Then the new feedback is set<br>
     * Then the doctor is saved<br>
     * 
     * @param inFeedback
     * @param doc
     */
    public void addFeedback(String inFeedback, Doctor doc){
        ArrayList<String> oldFeed = doc.getFeedback();
        oldFeed.add(inFeedback);
        doc.setFeedback(oldFeed);
        doc.saveDoctor(doc);
        
    }
    
    /**
     * Saving Doctor<br>
     * The Doctor that you want to save is passed in<br>
     * Then the current ArrayList is read out and saved<br>
     * Next a check is done to see if the Doctor is already in the array, if it is then it is removed<br>
     * Then the most up to date Doctor is added<br>
     * Then it is saved to the file<br>
     * @param inDoctor
     */
    public void saveDoctor(Doctor inDoctor){
        ArrayList<Doctor> cur = readDoctor();
        try(FileOutputStream fileOut = new FileOutputStream("Doctors.ser")){
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
    
    /**
     * Gets a list of all the Doctors<br>
     * Creates a list of Doctors and then populates it with the medicine in the file<br>
     * Returns the list
     * @return
     */
    public ArrayList<Doctor> readDoctor(){
    ArrayList<Doctor> doctors = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("Doctors.ser");
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

    /**
     *Removes a doctor from the array<br>
     * The doctor that is being removed is passed in<br>
     * Then a list of current doctors is read out<br>
     * All of the doctors are searched through and if they match, that instance will be removed<br>
     * Then the doctor is saved
     * @param inDoc
     */
    public void removeDoctor(Doctor inDoc){
        ArrayList<Doctor> doctors = readDoctor();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getID().equals(inDoc.getID())) {
                doctors.remove(i);
                   
            }
        }
    
        try(FileOutputStream fileOut = new FileOutputStream("Doctors.ser")){
                    ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        
                    outs.writeObject(doctors);
                    fileOut.close();
                    outs.close();
        
                    }   
                        catch(IOException io){
                        io.printStackTrace();
                    }
        
        
    }

    /**
     * Get a specific Doctor based on the ID<br>
     * ID is passed in<br>
     * A new arrayList is created based on all of the Doctors<br>
     * Then all of the Doctors are searched to see if the ID is there<br>
     * if it is, the Doctor is returned
     * @param doctorID
     * @return
     */
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
         
         
        
    

    
    

