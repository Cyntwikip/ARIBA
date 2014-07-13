/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.sql.Blob;

/**
 *
 * @author User
 */
public class TenantBean {
    
    private int tenantID;
    private String fname;
    private String lname;
    private Blob image;
    private Long contact;
    private String gender;
    private String address;
    private String school;
    private String degree;
    private int expectedyearofgrad;
    private boolean status;

    public String getAddress() {
        return address;
    }

    public Long getContact() {
        return contact;
    }

    public int getExpectedyearofgrad() {
        return expectedyearofgrad;
    }

    public String getFname() {
        return fname;
    }

    public String getGender() {
        return gender;
    }

    public Blob getImage() {
        return image;
    }

    public String getLname() {
        return lname;
    }

    public String getSchool() {
        return school;
    }

    public boolean getStatus() {
        return status;
    }

    public int getTenantID() {
        return tenantID;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public void setExpectedyearofgrad(int expectedyearofgrad) {
        this.expectedyearofgrad = expectedyearofgrad;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }
    
    
    
}
