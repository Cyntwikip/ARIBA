/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.WaterReadingBean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface WaterReadingDAOInterface {
    
    public boolean addWaterReadingToRoom (WaterReadingBean water, int bill_roomID);
    public ArrayList<WaterReadingBean> getAllWaterBills();
    public ArrayList<WaterReadingBean> getAllWaterReadingsByDate(Date dateread);
    public void editWaterReading(Date dateread);
    public void editElectricReadingByPrice(float price, int waterID);
    public void computeWaterReading(WaterReadingBean water, int billID);
}
