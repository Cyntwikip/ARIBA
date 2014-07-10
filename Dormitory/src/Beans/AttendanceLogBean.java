/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class AttendanceLogBean {
    
    private int logID;
    private int log_tenantID;
    private boolean isIn;
    private Timestamp timeLogged;

    public int getLogID() {
        return logID;
    }

    public int getLog_tenantID() {
        return log_tenantID;
    }

    public Timestamp getTimeLogged() {
        return timeLogged;
    }

    public boolean getIsIn() {
        return isIn;
    }

    public void setIsIn(boolean isIn) {
        this.isIn = isIn;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public void setLog_tenantID(int log_tenantID) {
        this.log_tenantID = log_tenantID;
    }

    public void setTimeLogged(Timestamp timeLogged) {
        this.timeLogged = timeLogged;
    }
    
    
    
}
