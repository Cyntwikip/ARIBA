/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.ContractBean;
import Models.Beans.RoomBean;
import Models.Beans.TenantBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface RoomDAOInterface {
    
    public boolean addRoom(RoomBean room);
    public boolean editRoom(RoomBean room, int roomID);
    public boolean assignTenanttoRoom(TenantBean tenant, RoomBean room, ContractBean contract);
    public ArrayList<RoomBean> getAllRooms();
    public RoomBean getRoomByRoomID(int roomID);
    public RoomBean getTenantRoom(int tenantID);
    public int checkRoomCount(int roomID);
    //public ArrayList<RoomBean> getAllCurrentKW();
    //public ArrayList<RoomBean> getAllCubicMeter(int roomID);
    //public ArrayList<RoomBean> getCurrentKWbyRoom(int roomID);
    //public RoomBean getCubicMeter(int roomID);
    //public ArrayList<RoomBean> getAllUnoccupiedRooms();
    //public ArrayList<RoomBean> getAllOccupiedRooms();
    public ArrayList<RoomBean> viewAvailbleRooms();
}
