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
public class WaterReadingBean {
    private int water_billID;
    private int water_roomID;
    private float currentcubicpermeter;
    private Date dateRead;
    private Date datePaid;
    private String status;

    /**
     * @return the water_billID
     */
    public int getWater_billID() {
        return water_billID;
    }

    /**
     * @param water_billID the water_billID to set
     */
    public void setWater_billID(int water_billID) {
        this.water_billID = water_billID;
    }

    /**
     * @return the water_roomID
     */
    public int getWater_roomID() {
        return water_roomID;
    }

    /**
     * @param water_roomID the water_roomID to set
     */
    public void setWater_roomID(int water_roomID) {
        this.water_roomID = water_roomID;
    }

    /**
     * @return the currentcubicpermeter
     */
    public float getCurrentcubicpermeter() {
        return currentcubicpermeter;
    }

    /**
     * @param currentcubicpermeter the currentcubicpermeter to set
     */
    public void setCurrentcubicpermeter(float currentcubicpermeter) {
        this.currentcubicpermeter = currentcubicpermeter;
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
    
    
    
}
