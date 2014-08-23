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
    
    public boolean addWaterReadingToRoom (WaterReadingBean water, int roomID);
    public ArrayList<WaterReadingBean> getAllWaterBills();
    public ArrayList<WaterReadingBean> getAllWaterReadingsByDate(Date from, Date to);
    public boolean editWaterReading(WaterReadingBean water, int waterID);
    public boolean editWaterReadingByPrice(float price, int waterID);
    public WaterReadingBean getWaterReadingsByBillID(int billID);
    public ArrayList<WaterReadingBean> getWaterReadingforThisMonth(int roomCount);
    
}
