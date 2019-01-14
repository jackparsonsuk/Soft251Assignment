/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Users.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jack Parsons
 */
public class Review implements java.io.Serializable{
    Doctor doc;
    Patient pat;
    String Message;

    /**
     * Empty Review Constructor
     *
     */
    public Review(){

    }

    /**
     *Review Constructor
     * Passing in, doctor, patient and the message.
     * @param doc
     * @param pat
     * @param Message
     */
    public Review(Doctor doc, Patient pat, String Message){
        this.doc = doc;
        this.pat = pat;
        this.Message = Message;
    }

    /**
     * Gets the message
     * @return
     */
    public String getMessage() {
        return Message;
    }

    /**
     * Sets the message
     * @param Message
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }
   
    /**
     * Gets the Doctor
     * @return
     */
    public Doctor getDoc() {
        return doc;
    }

    /**
     * Sets the Doctor
     * @param doc
     */
    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    /**
     * Gets the Patienet
     * @return
     */
    public Patient getPat() {
        return pat;
    }

    /**
     *Sets the patient
     * @param pat
     */
    public void setPat(Patient pat) {
        this.pat = pat;
    }

    /**
     * Saving the Review
     * The Review that you want to save is passed in
     * Then the current ArrayList is read out and saved
     * Next a check is done to see if the Review is already in the array, if it is, then it is removed
     * Then the most up to date Review is added
     * Then it is saved to the file
     * @param inReview
     */
    public void SaveReview(Review inReview){
       
       ArrayList<Review> cur = readReview();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Reviews.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        cur.add(inReview);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
   }

    /**
     * Gets a list of all the Reviews
     * Creates a list of Reviews and then populates it with the medicine in the file
     * Returns the list
     * @return
     */
    public ArrayList<Review> readReview(){
       ArrayList<Review> reviews = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack/Desktop/Netbeansout/Reviews.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        reviews = (ArrayList<Review>)ins.readObject();
        fileIn.close();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return reviews;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return reviews;
      }
        return reviews;
   }
   
    /**
     * Gets a list of reviews for a specific doctor
     * Doctor ID is passed in
     * The arrayList Is searched
     * If the ID's match
     * The List of Reviews is returned
     * @param doctorID
     * @return
     */
    public ArrayList<Review> getDoctorReview(String doctorID){
       ArrayList<Review> allRev = readReview();
       ArrayList<Review> docReview = new ArrayList<Review>();
       
       for (int i = 0; i < allRev.size(); i++) {
           if (allRev.get(i).getDoc().getID().equals(doctorID)) {
           docReview.add(allRev.get(i));
           }
       }
       
       return docReview;
   }
    
}
