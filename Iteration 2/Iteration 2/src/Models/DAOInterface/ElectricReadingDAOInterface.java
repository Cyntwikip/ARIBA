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
    public boolean addElectricReadingToRoom (ElectricReadingBean electric, int bill_roomID);
    public boolean editElectricReading(ElectricReadingBean electric, int electricID);
    public boolean editElectricReadingByPrice(float price, int electricID);
    public ArrayList<ElectricReadingBean> getAllElectricReading();
    public ArrayList<ElectricReadingBean> getAllElectricReadingByDate(Date from, Date to);
    public boolean computeElectricReading(ElectricReadingBean electric, int electricID);
    public ElectricReadingBean getElectricReadingByBillID(int billID);


}
