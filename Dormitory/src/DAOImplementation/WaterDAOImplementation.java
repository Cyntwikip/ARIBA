/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Beans.WaterReadingBean;
import DAOInterface.WaterReadingDAOInterface;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class WaterDAOImplementation implements WaterReadingDAOInterface {

    @Override
    public boolean addWaterReadingToRoom(WaterReadingBean water, int bill_roomID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<WaterReadingBean> getAllWaterBills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<WaterReadingBean> getAllWaterBillsByRoomID(int bill_roomID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
}
