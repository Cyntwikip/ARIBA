/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.Beans;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author User
 */
public class TenantBean {
    
    private int tenantID;
    private String fname;
    private String lname;
    private String image;
    private String contact;
    private String email;
    private String gender;
    private String address;
    private String school;
    private String degree;
    private int expectedyearofgrad;
    private String status;
    private Date birthday;
    private Blob blobimage;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
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

    public String getImage() {
        return image;
    }

    public String getLname() {
        return lname;
    }

    public String getSchool() {
        return school;
    }

    public String getStatus() {
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

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Blob getBlobimage() {
        return blobimage;
    }

    public void setBlobimage(Blob blobimage) {
        this.blobimage = blobimage;
    }
    
}
