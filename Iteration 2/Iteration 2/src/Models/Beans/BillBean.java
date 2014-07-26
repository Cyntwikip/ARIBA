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
public class BillBean {
    
    private int billID;
    private int bill_roomID;
    private double price;
    private boolean paidRent;
    private boolean paidWater;
    private boolean paidElectric;

    public int getBillID() {
        return billID;
    }

    public int getBill_roomID() {
        return bill_roomID;
    }

    public double getPrice() {
        return price;
    }
    
    public boolean getpaidRent(){
        return paidRent;
    }
    
    public boolean getPaidWater(){
        return paidWater;
    }
    
    public boolean getpaidElectric(){
        return paidElectric;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setBill_roomID(int bill_roomID) {
        this.bill_roomID = bill_roomID;
    }

    public void setPaidElectric(boolean paidElectric) {
        this.paidElectric = paidElectric;
    }

    public void setPaidRent(boolean paidRent) {
        this.paidRent = paidRent;
    }

    public void setPaidWater(boolean paidWater) {
        this.paidWater = paidWater;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
