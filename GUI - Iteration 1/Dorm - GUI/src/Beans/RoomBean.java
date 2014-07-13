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
public class RoomBean {
    
    private int roomID;
    private float currentKW;
    private float currentcubicmeter;
    private String status;

    public float getCurrentKW() {
        return currentKW;
    }

    public float getCurrentcubicmeter() {
        return currentcubicmeter;
    }

    public int getRoomID() {
        return roomID;
    }
    
    public String getStatus() {
        return status;
    }

    public void setCurrentKW(float currentKW) {
        this.currentKW = currentKW;
    }

    public void setCurrentcubicmeter(float currentcubicmeter) {
        this.currentcubicmeter = currentcubicmeter;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
