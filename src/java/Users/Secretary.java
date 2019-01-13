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
import Other.Notification;
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
        public Secretary(){
           
        }
    public Secretary(String ID, String Password, String firstName, String lastName, String address, String DOB, String gender){
    this.ID = ID;
    this.Password = Password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.DOB = DOB;
    this.gender = gender;
    Medicine m = new Medicine();
//    ArrayList<Medicine> ms = m.readMedicine();
//        for (int i = 0; i < ms.size(); i++) {
//            ms.get(i).registerObserver(this);
//        }
    

    }

    public ArrayList<String> getNotis() {
        return Notis;
    }

    public void setNotis(ArrayList<String> Notis) {
        this.Notis = Notis;
    }
    
    
    public void createAppoitment(Appointment ap){
        ap.setApproved(Boolean.TRUE);
    }
    public void orderMedicine(Medicine med){
    
    }
    public void stockMedicine(Medicine med){
    
    }
    public void approvePatientAccount(Patient pat){
        pat.setApproved(true);
    }
    public void removePatient(Patient pat){
        
    }
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

    @Override
    public void update(int stock, String ID) {
        if (ID.startsWith("M")) {
                
              ArrayList<String> cur = this.getNotis();
              cur.add(ID  + " Has low stock");
              this.setNotis(cur);
              Secretary s = new Secretary();
              s.saveSecretary(this);
              System.out.println("Updated Secretary" + this.ID);
              System.out.println("Current notes" + this.getNotis().get(0));
                            System.out.println("Current notes" + this.getNotis().get(1));
              
            
        }

    }
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


    
    
    
    

