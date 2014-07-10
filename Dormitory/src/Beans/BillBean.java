/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

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
    
}
