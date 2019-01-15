/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Users.Doctor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class ReviewTest {
    Review re = new Review();
    Doctor doc = new Doctor();
    
    
    public ReviewTest() {
        doc.setID("TESTDOC");
        String message = "TESTMESSAGE";
        re.setDoc(doc);
        re.setMessage(message);
        re.SaveReview(re);
    }

   
    @Test
    public void testSaveReview() {
        String expectedMessage ="CHANGEDMESSAGE";
        re.setMessage(expectedMessage);
        re.SaveReview(re);
 
        assertEquals(expectedMessage, re.Message);
        
        
    }

    
}
