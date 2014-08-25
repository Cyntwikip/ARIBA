/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.Beans;

/**
 *
 * @author Danica
 */
public class AdminBean {
    
    private int adminID;
    private String fname;
    private String lname;
    private String username;
    private String password;

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
