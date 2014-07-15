/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.ElectricReadingBean;
import Models.DAOInterface.ElectricReadingDAOInterface;
import java.sql.Date;
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
    public boolean editElectricReading(ElectricReadingBean electric, int electricID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editElectricReadingByPrice(float price, int electricID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ElectricReadingBean> getAllElectricReadingByDate(Date dateread) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean computeElectricReading(ElectricReadingBean electric, int electricID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
