/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

/**
 *  
 * @author Jack
 */
public abstract class User implements java.io.Serializable{

    /**
     * Gets the ID
     * @return
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the ID
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets the Password
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets the password
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Gets the First Name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the first name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *Sets the address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the Date Of Birth
     * @return
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * Sets the Date Of Birth
     * @param DOB
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * Gets the gender
     * @return
     */
    public String isGender() {
        return gender;
    }

    /**
     * Sets the gender
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    String ID;
    String Password;
    String firstName;
    String lastName;
    String address;
    String DOB;
    String gender;
}

