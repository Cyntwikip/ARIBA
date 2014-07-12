/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.BillBean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface BillDAOInterface {
    
    // do something here
    public boolean addBill (BillBean bill);
    public void editBill(BillBean bill, int billID);
    public ArrayList<BillBean> getAllBills();
    public ArrayList<BillBean> getAllPaidRoom(int roomID);
    public ArrayList<BillBean> getAllPaidBillByRoom();
    public ArrayList<BillBean> getAllPaidRoomByWater();
    public ArrayList<BillBean> getAllPaidRoomByElectric();
    public ArrayList<BillBean> getAllNotPaidRoomsByWater();
    public ArrayList<BillBean> getAllNotPaidRoomsByRent();
    public ArrayList<BillBean> getAllNotPaidRoomsByElectric();
    
}
