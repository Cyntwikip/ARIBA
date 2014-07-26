/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.ElectricReadingBean;
import Models.Connector.Connector;
import Models.DAOInterface.ElectricReadingDAOInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ElectricReadingDAOImplementation implements ElectricReadingDAOInterface {


    @Override
    public boolean addElectricReadingToRoom(ElectricReadingBean electric, int bill_roomID) {
            
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into electricreading (electric_billID, currentKW, priceperKW, price, dateRead) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bill_roomID);
            ps.setFloat(2, electric.getCurrentKW());
            ps.setFloat(3, electric.getPriceperKW());
            ps.setFloat(4, electric.getPrice());
            ps.setDate(5, electric.getDateRead());
            ps.executeUpdate();
            connection.close();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public ArrayList<ElectricReadingBean> getAllElectricReading() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from electricreading";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            ElectricReadingBean bean = new ElectricReadingBean();
            ArrayList<ElectricReadingBean> list = new ArrayList<ElectricReadingBean>();
        
            int electricID;
            float currentKW, priceperKW, price;
            Date dateRead;
            
            while(resultSet.next()) {
                electricID = resultSet.getInt("electric_billID");
                currentKW = resultSet.getFloat("currentKW");
                priceperKW = resultSet.getFloat("priceperKW");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");
                
                bean = new ElectricReadingBean();
                
                bean.setElectric_billID(electricID);
                bean.setCurrentKW(currentKW);
                bean.setPriceperKW(priceperKW);
                bean.setPrice(price);
                bean.setDateRead(dateRead);
                
                list.add(bean);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
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
