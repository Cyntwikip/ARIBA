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
    private float priceperKW;
    private float price;
    private Date dateRead;

    public float getCurrentKW() {
        return currentKW;
    }

    public Date getDateRead() {
        return dateRead;
    }

    public int getElectric_billID() {
        return electric_billID;
    }

    public float getPrice() {
        return price;
    }

    public float getPriceperKW() {
        return priceperKW;
    }

    public void setCurrentKW(float currentKW) {
        this.currentKW = currentKW;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    public void setElectric_billID(int electric_billID) {
        this.electric_billID = electric_billID;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPriceperKW(float priceperKW) {
        this.priceperKW = priceperKW;
    }
    
    
    
}
