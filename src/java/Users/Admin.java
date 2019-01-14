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
    
    /**
     *Empty Constructor
     */
    public Admin(){
        
    }

    /**
     * Constructor for the admin
     * @param ID
     * @param Password
     * @param firstName
     * @param lastName
     * @param address
     * @param DOB
     * @param gender
     */
    public Admin(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;
    

    }
    

    
    /**
     * Saving Admin<br>
     * The Admin that you want to save is passed in<br>
     * Then the current ArrayList is read out and saved<br>
     * Next a check is done to see if the Admin is already in the array, if it is then it is removed<br>
     * Then the most up to date Admin is added<br>
     * Then it is saved to the file<br>
     * @param inAdmin
     */
    public void saveAdmin(Admin inAdmin){
        String output = "Admin.ser";
        ArrayList<Admin> cur = readAdmin();
        try(FileOutputStream fileOut = new FileOutputStream(output)){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        cur.add(inAdmin);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    
    /**
     * Gets a list of all the Admin<br>
     * Creates a list of Admin and then populates it with the medicine in the file<br>
     * Returns the list
     * @return
     */
    public ArrayList<Admin> readAdmin(){
    ArrayList<Admin> admins = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("Admin.ser");
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
