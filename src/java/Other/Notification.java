/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Users.Secretary;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Jack
 */
public class Notification implements java.io.Serializable{
    Secretary s = new Secretary();
    ArrayList<Secretary> allSecs = s.readSecretary();
    String noteId;
    String note;
    String thingId;

    public ArrayList<Secretary> getAllSecs() {
        return allSecs;
    }

    public void setAllSecs(ArrayList<Secretary> allSecs) {
        this.allSecs = allSecs;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getThingId() {
        return thingId;
    }

    public void setThingId(String thingId) {
        this.thingId = thingId;
    }
    public Notification(){
        
    }
    public Notification(String Note, String ID){
        note = Note;
        thingId = ID;
        UUID uuid = UUID.randomUUID();
        noteId = uuid.toString();
    }
    public void removeFromNoti(Secretary se){
        allSecs.remove(s);
    }
    
    
    public void SaveNotification(Notification n){
        
         ArrayList<Notification> cur = readNotifications();
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Jack/Desktop/Netbeansout/Notifications.ser")){
        ObjectOutputStream outs = new ObjectOutputStream(fileOut);
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i).getNoteId().equals(n.getNoteId())) {
                    cur.remove(i);
                }
            }
        cur.add(n);
        outs.writeObject(cur);
        outs.close();
        fileOut.close();
        
        }
        catch(IOException i){
            i.printStackTrace();
        }
        
    }
    public ArrayList<Notification> readNotifications(){
         ArrayList<Notification> notis = new ArrayList<>();
    
    try{
        FileInputStream fileIn = new FileInputStream("C:/Users/Jack/Desktop/Netbeansout/Notifications.ser");
        ObjectInputStream ins = new ObjectInputStream(fileIn);
        notis = (ArrayList<Notification>)ins.readObject();
        fileIn.close();
        ins.close();
    }
    catch(IOException i){
    i.printStackTrace();
    return notis;
    }
    catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return notis;
      }
        return notis;
    }
}
