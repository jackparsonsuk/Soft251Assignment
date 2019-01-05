/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;
import Other.*;

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
    this.doctorID = ID;
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

    }
    public double viewRating(){
    return Rating;
    }

    
    
}
