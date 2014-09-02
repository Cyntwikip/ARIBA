/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.WaterReadingBean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface WaterReadingDAOInterface {
    
    public boolean addWaterReadingToRoom (WaterReadingBean water);
    public ArrayList<WaterReadingBean> getAllWaterBills();
    public boolean editWaterReading(WaterReadingBean water);
    public WaterReadingBean getWaterReadingsByWaterBillID(int wbillID);
    public WaterReadingBean getWaterReadingByMonth(java.sql.Date date);
    
    
}
