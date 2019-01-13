/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Observe.Observable;
import Observe.Observer;
import Users.Secretary;
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
public class Medicine implements Observable,  java.io.Serializable {
    String MedicineID;
    int quantity;
    String dosage;
    ArrayList<Secretary> observers = new ArrayList<Secretary>();
    public void Medicine(){
        notifyObserver();
    quantity = 0;

    }

    public String getMedicineID() {
        
        return MedicineID;
    }

    public void setMedicineID(String MedicineID) {
        this.MedicineID = MedicineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyObserver();
        //Update();
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    public void Update(){
        if (this.quantity == 5 || this.quantity == 0) {
            Notification n = new Other.Notification(this.MedicineID+ " Has low stock ", this.MedicineID);
            n.SaveNotification(n);
        }
    }
    public Medicine getMedicine(String id){
        Medicine m = new Medicine();
        ArrayList<Medicine> meds = m.readMedicine();
        for (int i = 0; i < meds.size(); i++) {
            if (meds.get(i).getMedicineID().equals(id)) {
                return meds.get(i);
            }
        }
        return m;
    }
    


    public void addObserrver(Secretary s) {
        observers.add(s);
        Medicine m = new Medicine();
        m.saveMedicine(this);
    }

    @Override
    public void removeObserver(Observer o) {
        int idx = observers.indexOf(o);
        if(idx >0) observers.remove(o);
        Medicine m = new Medicine();
        m.saveMedicine(this);
    }

    @Override
    public void notifyObserver() {
        for (Secretary s: observers) {
            System.out.println("Updating" + s.getID());
            s.update(quantity, MedicineID);
        }
    }
    public void saveMedicine(Medicine m){
        ArrayList<Medicine> cur = readMedicine();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Medicines.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i).getMedicineID().equals(m.getMedicineID())) {
                    cur.remove(i);
                }
            }
        cur.add(m);
        outs.writeObject(cur);
        outs.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    public ArrayList<Medicine> readMedicine(){
        ArrayList<Medicine> meds = new ArrayList<>();
         try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack/Desktop/Netbeansout/Medicines.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        meds = (ArrayList<Medicine>)ins.readObject();
        fileIn.close();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return meds;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return meds;
      }
        return meds;
    } 

    @Override
    public void registerObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
