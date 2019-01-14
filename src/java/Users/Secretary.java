/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Observe.Observable;
import Observe.Observer;
import Other.Appointment;
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
public class Secretary extends User implements Observer {

    ArrayList<String> Notis = new ArrayList<String>();

    /**
     * Empty constructor
     */
    public Secretary(){
           
        }

    /**
     *Constructor for creating a Secretary
     * @param ID
     * @param Password
     * @param firstName
     * @param lastName
     * @param address
     * @param DOB
     * @param gender
     */
    public Secretary(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;


    

    }

    /**
     * gets all of the notifications
     * @return
     */
    public ArrayList<String> getNotis() {
        return Notis;
    }

    /**
     * Sets the notification array
     * @param Notis
     */
    public void setNotis(ArrayList<String> Notis) {
        this.Notis = Notis;
    }
    
    /**
     * Sets the appointment approved varabile to true
     * @param ap
     */
    public void createAppoitment(Appointment ap){
        ap.setApproved(Boolean.TRUE);
    }


    /**
     * Approves the patient account passed in
     * @param pat
     */
    public void approvePatientAccount(Patient pat){
        pat.setApproved(true);
    }


    /**
     * Removes a secretary<hr>
     * Checks through an array of secretrays<hr>
     * If any of them match the ID<hr>
     * Remove them from the array<hr>
     * Then save
     * @param sec
     */
    public void removeSecretary(Secretary sec){
             ArrayList<Secretary> secs = readSecretary();
        for (int i = 0; i < secs.size(); i++) {
            if (secs.get(i).getID().equals(sec.getID())) {
                secs.remove(i);
                   
            }
        }
    
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Secretarys.ser")){
                    ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        
                    outs.writeObject(secs);
                    outs.close();
        
                    }   
                        catch(IOException io){
                        io.printStackTrace();
                    }
    }
    
    /**
     * Saving Secretary<br>
     * The Secretary that you want to save is passed in<br>
     * Then the current ArrayList is read out and saved<br>
     * Next a check is done to see if the Secretary is already in the array, if it is then it is removed<br>
     * Then the most up to date Secretary is added<br>
     * Then it is saved to the file<br>
     * @param inPatient
     * @param inSecretary
     */
    public void saveSecretary(Secretary inSecretary){
        ArrayList<Secretary> cur = readSecretary();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Secretarys.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
        for (int i = 0; i < cur.size(); i++) {
               if (cur.get(i).getID().equals(inSecretary.getID())) {
                    cur.remove(i);
                } 
            }
        cur.add(inSecretary);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    
    /**
     * Gets a list of all the Secretary<br>
     * Creates a list of Secretary and then populates it with the Secretary in the file<br>
     * Returns the list
     * @return
     */
    public ArrayList<Secretary> readSecretary(){
    ArrayList<Secretary> secretarys = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack/Desktop/Netbeansout/Secretarys.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        secretarys = (ArrayList<Secretary>)ins.readObject();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return secretarys;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return secretarys;
      }
        return secretarys;
    }

    /**
     * The update method is ran when an observable changes state<br>
     * First there is a check to see if the ID starts with M, to see if it is a medicine<br>
     * Then if the stock is less than 100<br>
     * An arraylist is created and populated from the current notifications<br>
     * Then a new notification is created and added to the array<br>
     * Then the secretary is saved<br><br>
     * If there is more than 100 stock<br>
     * There is a check to see if there are any notifications with the ID in it<br>
     * If there is, that notifitcation is removed
     * @param stock
     * @param ID
     */
    @Override
    public void update(int stock, String ID) {
        if (ID.startsWith("M")) {
            if (stock<100) {
                

                
              ArrayList<String> cur = this.getNotis();
              cur.add(ID  + " Has low stock");
              this.setNotis(cur);
              Secretary s = new Secretary();
              s.saveSecretary(this);
              System.out.println("Updated Secretary" + this.ID);
              System.out.println("Current notes" + this.getNotis().get(0));
                            System.out.println("Current notes" + this.getNotis().get(0));
              
            
        }
            else{
                ArrayList<String> cur = this.getNotis();
                for (int i = 0; i < cur.size(); i++) {
                    if (cur.get(i).contains(ID)) {
                        cur.remove(i);
                        Secretary s = new Secretary();
                        s.saveSecretary(this);
                    }
                }
            }
        }

    }

    /**
     * Get a specific Secretary based on the ID<br>
     * ID is passed in<br>
     * A new arrayList is created based on all of the Secretarys<br>
     * Then all of the Secretarys are searched to see if the ID is there<br>
     * if it is, the Secretary is returned
     * @param ID
     * @return
     */
    public Secretary getSecretary(String ID){
          Secretary s = new Secretary();
     ArrayList<Secretary> secs = s.readSecretary();
            for(int x = 0; x<secs.size(); x++){
                if (secs.get(x).getID().equals(ID)) {
                    System.out.println("FOUND DOCTOR -----------------------------------------------------------------");
                        return secs.get(x);
                        
                    }
                }
                System.out.println("NO DOCTOR FOUND -----------------------------------------------------------------");
               
              return s;
            }
    }


    
    
    
    

