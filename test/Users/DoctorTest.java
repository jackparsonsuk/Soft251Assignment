/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class DoctorTest {
    Doctor realDoc = new Doctor();
    public DoctorTest() {
                
        realDoc.setID("DTEST");
        realDoc.setPassword("TEST");
        realDoc.saveDoctor(realDoc);
    }
        /**
     * Test of calculateRating method, of class Doctor.
     */
    @Test
    public void testCalculateRating() {
        
        
        Double expectedRating = 6d;
        Double actualRating;

        realDoc.calculateRating(10d);
        realDoc.calculateRating(2d);
        actualRating =realDoc.getRating();
        Assert.assertEquals(expectedRating,actualRating);
    }
    


    /**
     * Test of addFeedback method, of class Doctor.
     */
    @Test
    public void testAddFeedback() {
        String expectedString = "Good Work";
        realDoc.addFeedback(expectedString, realDoc);
        ArrayList<String> feedback = realDoc.getFeedback();
        Assert.assertEquals(feedback.get(0), expectedString);
    }


    /**
     * Test of getDoctor method, of class Doctor.
     */
    @Test
    public void testGetDoctor() {
        Doctor getDoc = realDoc.getDoctor(realDoc.ID);
        String expectedId = realDoc.getID();
        Assert.assertEquals(getDoc.ID,expectedId);
    }
        /**
     * Test of removeDoctor method, of class Doctor.
     */
    @Test
    public void testRemoveDoctor() {
        realDoc.removeDoctor(realDoc);
        Doctor getDoc = realDoc.getDoctor(realDoc.ID);
        Assert.assertEquals(null, getDoc.ID);
    }

    
}
