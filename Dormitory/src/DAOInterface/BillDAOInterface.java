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
    
    public ArrayList<BillBean> getAllBills();
    public ArrayList<BillBean> getAllBillsByRoomID(int bill_roomID);
    public ArrayList<BillBean> getAllBillsByDateRead (Date from, Date to);
    
    
}
