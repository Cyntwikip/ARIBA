/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.ElectricReadingBean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ElectricReadingDAOInterface {
    public boolean addElectricReadingToRoom (ElectricReadingBean electric);
    public ArrayList<ElectricReadingBean> getAllElectricBills();
    //public ArrayList<ElectricReadingBean> getAllElectricReadingsByDate(Date from, Date to);
    public boolean editElectricReading(ElectricReadingBean electric);
    public ElectricReadingBean getElectricReadingsByElectricBillID(int ebillID);
    public ElectricReadingBean getElectricReadingByMonth(java.sql.Date date);


}
