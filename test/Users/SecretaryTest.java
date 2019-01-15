/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Other.Medicine;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class SecretaryTest {
     Secretary realSec = new Secretary();
    public SecretaryTest() {
        realSec.setID("TESTSEC");
        realSec.setPassword("TEST");
        realSec.saveSecretary(realSec);
    }






    /**
     * Test of update method, of class Secretary.
     * Also testing observer pattern here
     */
    @Test
    public void testUpdate() {
        
        Medicine med = new Medicine();

        med.setMedicineID("MTESTMED");
        med.addObserrver(realSec);
        med.saveMedicine(med);
        med.setQuantity(0);
        med.notifyObserver();
        for (int i = 0; i < realSec.getNotis().size(); i++) {
            if (realSec.getNotis().get(i).contains(med.getMedicineID())) {
                assertTrue(realSec.getNotis().get(i).contains(med.getMedicineID()));
            }
            
        }
        med.setQuantity(150);
        med.notifyObserver();
            assertFalse(realSec.getNotis().contains(med.getMedicineID()));
        
        
        
        
    }

    /**
     * Test of getSecretary method, of class Secretary.
     */
    @Test
    public void testGetSecretary() {
        String expectedId = realSec.getID();
        Secretary actualId = realSec.getSecretary(realSec.getID());
        assertEquals(expectedId,actualId.getID());
        
    }
    
        /**
     * Test of removeSecretary method, of class Secretary.
     */
    @Test
    public void testRemoveSecretary() {
        realSec.removeSecretary(realSec);
        Secretary getSec =realSec.getSecretary(realSec.ID);
        assertEquals(null, getSec.ID);
        
    }
    
}
