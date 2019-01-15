/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Users.Secretary;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class MedicineTest {
    Medicine med = new Medicine();
    Secretary sec= new Secretary();
    
    public MedicineTest() {
    
        med.setMedicineID("MTEST");
        med.setQuantity(50);
        med.saveMedicine(med);
        
    }

  
    @Test
    public void testAddObserrver() {
        med.addObserrver(sec);

        assertEquals(med.observers.size(), 1);
        
    }


    /**
     * Test of notifyObserver method, of class Medicine.
     */

        /**
     * Test of removeObserver method, of class Medicine.
     */
    @Test
    public void testRemoveObserver() {
        med.removeObserver(sec);
        
        
        assertEquals(med.observers.size(), 0);
    }


    /**
     * Test of saveMedicine method, of class Medicine.
     */
    @Test
    public void testSaveMedicine() {
        String expectedDosage ="TESTDOSAGE";
        med.setDosage("TESTDOSAGE");
        med.saveMedicine(med);
        Medicine updateMed = med.getMedicine(med.getMedicineID());
        assertEquals(expectedDosage, updateMed.getDosage());
    }




}
