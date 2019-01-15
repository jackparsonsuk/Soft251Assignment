/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Users.Doctor;
import Users.Patient;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class AppointmentTest {
    Appointment ap  = new Appointment();
    Doctor doc = new Doctor();
    Patient pat = new Patient();
    public AppointmentTest() {
        ap.setAppointmentID("TESTAP");
        doc.setID("TESTDOC");
        pat.setID("TESTPAT");
        ap.setDoc(doc);
        ap.setPat(pat);
        ap.SaveAppointment(ap);
    }

  

    /**
     * Test of SaveAppointment method, of class Appointment.
     */
    @Test
    public void testSaveAppointment() {
        Boolean aprove = Boolean.TRUE;
        ap.setApproved(Boolean.TRUE);
        ap.SaveAppointment(ap);
        Appointment updatedAp = ap.getAppointment(ap.getAppointmentID());
        assertEquals(aprove,updatedAp.getApproved());
    
    }


    /**
     * Test of getAppointment method, of class Appointment.
     */
    @Test
    public void testGetAppointment() {
        Appointment getAp = ap.getAppointment(ap.AppointmentID);
        String expectedId = ap.getAppointmentID();
        assertEquals(expectedId, getAp.getAppointmentID());
        
    }
    
}
