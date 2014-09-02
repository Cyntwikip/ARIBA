/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.Beans;

/**
 *
 * @author User
 */
public class RoomBillBean {
    
    private int roomID, waterreadingID, electricreadingID, dbillID;
    private double surcharge;
    private java.sql.Date datePaid, dateRead;
    private String status;

    /**
     * @return the roomID
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * @param roomID the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * @return the waterreadingID
     */
    public int getWaterreadingID() {
        return waterreadingID;
    }

    /**
     * @param waterreadingID the waterreadingID to set
     */
    public void setWaterreadingID(int waterreadingID) {
        this.waterreadingID = waterreadingID;
    }

    /**
     * @return the electricreadingID
     */
    public int getElectricreadingID() {
        return electricreadingID;
    }

    /**
     * @param electricreadingID the electricreadingID to set
     */
    public void setElectricreadingID(int electricreadingID) {
        this.electricreadingID = electricreadingID;
    }

    /**
     * @return the dbillID
     */
    public int getDbillID() {
        return dbillID;
    }

    /**
     * @param dbillID the dbillID to set
     */
    public void setDbillID(int dbillID) {
        this.dbillID = dbillID;
    }

    /**
     * @return the surcharge
     */
    public double getSurcharge() {
        return surcharge;
    }

    /**
     * @param surcharge the surcharge to set
     */
    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    /**
     * @return the datePaid
     */
    public java.sql.Date getDatePaid() {
        return datePaid;
    }

    /**
     * @param datePaid the datePaid to set
     */
    public void setDatePaid(java.sql.Date datePaid) {
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
    public java.sql.Date getDateRead() {
        return dateRead;
    }

    /**
     * @param dateRead the dateRead to set
     */
    public void setDateRead(java.sql.Date dateRead) {
        this.dateRead = dateRead;
    }

    
    
    
}
