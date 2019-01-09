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
public class Admin extends User{
    
    public Admin(){
        
    }
    public Admin(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;
    

    }
    
    
    
    
    public void addDoctor(Doctor doc){
    
    }
    public void addSecretary(Secretary sec){
    
    }
    public void provideFeedback(Doctor doc){
    }
    
    public void saveAdmin(Admin inAdmin){
        ArrayList<Admin> cur = readAdmin();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack Parsons/Desktop/Netbeansout/Admin.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        cur.add(inAdmin);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    
    public ArrayList<Admin> readAdmin(){
    ArrayList<Admin> admins = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack Parsons/Desktop/Netbeansout/Admin.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        admins = (ArrayList<Admin>)ins.readObject();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return admins;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return admins;
      }
        return admins;
    }
}
