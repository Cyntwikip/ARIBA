/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.BillBean;
import Models.Beans.RoomBean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface BillDAOInterface {
    
    // do something here
    public boolean addBill (BillBean bill);
    public boolean editBill(BillBean bill, int billID);
    public BillBean getBillsByRoomID(int roomID);
    public ArrayList<BillBean> getAllBills();
    public ArrayList<BillBean> getAllPaidRoom();
    public ArrayList<BillBean> getAllPaidBillByRent();
    public ArrayList<BillBean> getAllPaidRoomByWater();
    public ArrayList<BillBean> getAllPaidRoomByElectric();
    public ArrayList<BillBean> getAllNotPaidRoomsByWater();
    public ArrayList<BillBean> getAllNotPaidRoomsByRent();
    public ArrayList<BillBean> getAllNotPaidRoomsByElectric();
    
}
