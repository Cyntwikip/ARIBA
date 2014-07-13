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
    private float currentcubicmeter;
    private float pricepercubicmeter;
    private float price;
    private Date dateRead;

    public float getCurrentcubicmeter() {
        return currentcubicmeter;
    }

    public Date getDateRead() {
        return dateRead;
    }

    public float getPrice() {
        return price;
    }

    public float getPricepercubicmeter() {
        return pricepercubicmeter;
    }

    public int getWater_billID() {
        return water_billID;
    }

    public void setCurrentcubicmeter(float currentcubicmeter) {
        this.currentcubicmeter = currentcubicmeter;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPricepercubicmeter(float pricepercubicmeter) {
        this.pricepercubicmeter = pricepercubicmeter;
    }

    public void setWater_billID(int water_billID) {
        this.water_billID = water_billID;
    }
    
    
}
