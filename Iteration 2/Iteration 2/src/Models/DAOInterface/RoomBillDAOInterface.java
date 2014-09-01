/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.RoomBillBean;
import Models.Beans.RoomBean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface RoomBillDAOInterface {
    
    // do something here
    public boolean addRoomBill (RoomBillBean roombill);
    public boolean editRoomBill(RoomBillBean roombill);
    public ArrayList<RoomBillBean> getRoomBillsByRoomID(int roomID);
    public ArrayList<RoomBillBean> getAllBills();
    public ArrayList<RoomBillBean> getAllPaidRooms();
    public ArrayList<RoomBillBean> getAllNotPaidRooms();
    
}
