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
public class Review {
    Doctor doc;
    Patient pat;
    String Message;
    public Review(){

    }
    public Review(Doctor doc, Patient pat, String Message){
        this.doc = doc;
        this.pat = pat;
        this.Message = Message;
    }
    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
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
   public void SaveReview(Review inReview){
       
       ArrayList<Review> cur = readReview();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack Parsons/Desktop/Netbeansout/Reviews.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        cur.add(inReview);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
   }
   public ArrayList<Review> readReview(){
       ArrayList<Review> reviews = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack Parsons/Desktop/Netbeansout/Reviews.ser");
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
    
}
