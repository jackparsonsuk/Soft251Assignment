/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class PatientTest {
    Patient realPat = new Patient();
    
    public PatientTest() {
    realPat.setID("TESTPAT");
    realPat.setPassword("TEST");
    realPat.savePatient(realPat);
    }

    /**
     * Test of savePatient method, of class Patient.
     */
    @Test
    public void testSavePatient() {
        String expectedPassword = "ChangedPassword";
        realPat.setPassword(expectedPassword);
        realPat.savePatient(realPat);
        Patient gottenPat = realPat.getPaitent("TESTPAT");
        Assert.assertEquals(expectedPassword, gottenPat.getPassword());
        
    }

    /**
     * Test of getPaitent method, of class Patient.
     */
    @Test
    public void testGetPaitent() {
        Patient getPat = realPat.getPaitent(realPat.getID());
        String expectedId = realPat.getID();
        Assert.assertEquals(getPat.ID, expectedId);
    }
    
}
