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

    /**
     *Medicine Constructor 
     * notifies the observers that there is no stock
     * Sets the quantity to 0
     */
    public void Medicine(){
        notifyObserver();
    quantity = 0;

    }

    /**
     *Gets the Medicine ID
     * @return
     */
    public String getMedicineID() {
        
        return MedicineID;
    }

    /**
     * Sets the Medicine ID
     * @param MedicineID
     */
    public void setMedicineID(String MedicineID) {
        this.MedicineID = MedicineID;
    }

    /**
     * Gets the quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *Sets the Quantity<br>
     * Updates observers
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyObserver();

    }

    /**
     *Gets the dosage
     * @return
     */
    public String getDosage() {
        return dosage;
    }

    /**
     *Sets the dosage
     * @param dosage
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }


    /**
     *Gets a specific medicine based on the ID passed in<br>
     * Medicine ID is passed in<br>
     * The arrayList Is searched<br>
     * If the ID's match<br>
     * The medicine is returned
     * @param id
     * @return
     */
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
    
    /**
     *Adds an observer to the observer list<br>
     * Then saves the Medicine
     * @param s
     */
    public void addObserrver(Secretary s) {
        observers.add(s);
        Medicine m = new Medicine();
        m.saveMedicine(this);
    }

    /**
     *Removes an observer from the Observer List<br>
     * Checks through the array and removes the instance of observer in the list
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        int idx = observers.indexOf(o);
        if(idx >0) observers.remove(o);
        Medicine m = new Medicine();
        m.saveMedicine(this);
    }

    /**
     *Notifies all observers of a change of state<br>
     * Checks through all of the observers in the list and calls there update method<br>
     * The method passes through the current quantity and the current ID
     */
    @Override
    public void notifyObserver() {
        for (Secretary s: observers) {
            System.out.println("Updating" + s.getID());
            s.update(quantity, MedicineID);
        }
    }

    /**
     *Saving the medicine<br>
     * The medicine that you want to save is passed in<br>
     * Then the current ArrayList is read out and saved<br>
     * Next a check is done to see if the medicine is already in the array, if it is then it is removed<br>
     * Then the most up to date medicine is added<br>
     * Then it is saved to the file
     * @param m
     */
    public void saveMedicine(Medicine m){
        ArrayList<Medicine> cur = readMedicine();
        try(FileOutputStream fileOut = new FileOutputStream("Medicines.ser")){
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

    /**
     *gets a list of all the medicine<br>
     * Creates a list of medicine and then populates it with the medicine in the file
     * Returns the list
     * 
     * 
     * @return
     */
    public ArrayList<Medicine> readMedicine(){
        ArrayList<Medicine> meds = new ArrayList<>();
         try{
        FileInputStream fileIn = new FileInputStream("Medicines.ser");
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

    /**
     *
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
