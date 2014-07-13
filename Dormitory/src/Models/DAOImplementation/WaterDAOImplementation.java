/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.WaterReadingBean;
import Models.DAOInterface.WaterReadingDAOInterface;
import java.sql.Date;
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
    public ArrayList<WaterReadingBean> getAllWaterReadingsByDate(Date dateread) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editWaterReading(Date dateread) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editElectricReadingByPrice(float price, int waterID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void computeWaterReading(WaterReadingBean water, int billID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

        
}
