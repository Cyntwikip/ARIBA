/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.Beans;

/**
 *
 * @author adrian
 */
public class DormBillBean {
    private int dbill_ID;
    private float waterconsumption;
    private float electconsumption;
    private double waterprice;
    private double electprice;
    private java.sql.Date dateRead;

    /**
     * @return the waterconsumption
     */
    public float getWaterconsumption() {
        return waterconsumption;
    }

    /**
     * @param waterconsumption the waterconsumption to set
     */
    public void setWaterconsumption(float waterconsumption) {
        this.waterconsumption = waterconsumption;
    }

    /**
     * @return the electconsumption
     */
    public float getElectconsumption() {
        return electconsumption;
    }

    /**
     * @param electconsumption the electconsumption to set
     */
    public void setElectconsumption(float electconsumption) {
        this.electconsumption = electconsumption;
    }

    /**
     * @return the waterprice
     */
    public double getWaterprice() {
        return waterprice;
    }

    /**
     * @param waterprice the waterprice to set
     */
    public void setWaterprice(double waterprice) {
        this.waterprice = waterprice;
    }

    /**
     * @return the electprice
     */
    public double getElectprice() {
        return electprice;
    }

    /**
     * @param electprice the electprice to set
     */
    public void setElectprice(double electprice) {
        this.electprice = electprice;
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

    /**
     * @return the dbill_ID
     */
    public int getDbill_ID() {
        return dbill_ID;
    }

    /**
     * @param dbill_ID the dbill_ID to set
     */
    public void setDbill_ID(int dbill_ID) {
        this.dbill_ID = dbill_ID;
    }
    
}
