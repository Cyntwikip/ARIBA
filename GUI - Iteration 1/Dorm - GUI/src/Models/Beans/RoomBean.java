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
public class RoomBean {
    
    private int roomID;
    private float currentKW;
    private float currentcubicmeter;

    public float getCurrentKW() {
        return currentKW;
    }

    public float getCurrentcubicmeter() {
        return currentcubicmeter;
    }

    public int getRoomID() {
        return roomID;
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
}
