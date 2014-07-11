/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Beans.ElectricReadingBean;
import DAOInterface.ElectricReadingDAOInterface;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ElectricReadingDAOImplementation implements ElectricReadingDAOInterface {


    @Override
    public boolean addElectricReadingToRoom(ElectricReadingBean electric, int bill_roomID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ElectricReadingBean> getAllElectricReading() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ElectricReadingBean> getAllElectricReadingByRoomID(int bill_roomID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
