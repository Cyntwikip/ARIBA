/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Beans;

import java.sql.Date;

/**
 *
 * @author User
 */
public class ElectricReadingBean {

    private int electric_billID;
    private float currentKW;
    private Date dateRead;
    private Date datePaid;
    private String status;

    /**
     * @return the electric_billID
     */
    public int getElectric_billID() {
        return electric_billID;
    }

    /**
     * @param electric_billID the electric_billID to set
     */
    public void setElectric_billID(int electric_billID) {
        this.electric_billID = electric_billID;
    }

    /**
     * @return the currentKW
     */
    public float getCurrentKW() {
        return currentKW;
    }

    /**
     * @param currentKW the currentKW to set
     */
    public void setCurrentKW(float currentKW) {
        this.currentKW = currentKW;
    }

    /**
     * @return the datePaid
     */
    public Date getDatePaid() {
        return datePaid;
    }

    /**
     * @param datePaid the datePaid to set
     */
    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dateRead
     */
    public Date getDateRead() {
        return dateRead;
    }

    /**
     * @param dateRead the dateRead to set
     */
    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    

}
