/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.RoomBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface RoomDAOInterface {
    
    public boolean addRoom(RoomBean room);
    public boolean editRoom(RoomBean room, int roomID);
    public boolean editRoomStatus(int roomID, String status);
    public boolean assignTenanttoRoom(int tenantID, RoomBean room);
    public ArrayList<RoomBean> getAllRooms();
    public ArrayList<RoomBean> getAllRoombyStatus(String status);
    public ArrayList<RoomBean> getAllCurrentKW();
    public ArrayList<RoomBean> getCurrentKWbyRoom(int roomID);
    public ArrayList<RoomBean> getAllCubicMeter(int roomID);
    public RoomBean getCubicMeter(int roomID);
    public ArrayList<RoomBean> getAllUnoccupiedRooms();
    public ArrayList<RoomBean> getAllOccupiedRooms();
}
