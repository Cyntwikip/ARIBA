/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

/**
 *
 * @author User
 */
public class GuardianBean {
    
    private int guardianID;
    private String fname;
    private String lname;
    private int contact;

    public int getContact() {
        return contact;
    }

    public String getFname() {
        return fname;
    }

    public int getGuardianID() {
        return guardianID;
    }

    public String getLname() {
        return lname;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setGuardianID(int guardianID) {
        this.guardianID = guardianID;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
