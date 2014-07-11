/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Beans.BillBean;
import DAOInterface.BillDAOInterface;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BillDAOImplementation implements BillDAOInterface {

    @Override
    public boolean addBill(BillBean bill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BillBean> getAllBills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BillBean> getAllBillsByRoomID(int bill_roomID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BillBean> getAllBillsByDateRead(Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
