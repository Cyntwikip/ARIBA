/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.WaterReadingBean;
import Models.Connector.Connector;
import Models.DAOInterface.WaterReadingDAOInterface;
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
public class WaterDAOImplementation implements WaterReadingDAOInterface {

    @Override
    public boolean addWaterReadingToRoom(WaterReadingBean water, int bill_roomID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into waterreading (water_billID, currentcubicpermeter, pricepercubicmeter, price, dateRead) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bill_roomID);
            ps.setFloat(2, water.getCurrentcubicmeter());
            ps.setFloat(3, water.getPricepercubicmeter());
            ps.setFloat(4, water.getPrice());
            ps.setDate(5, water.getDateRead());
            ps.executeUpdate();
            connection.close();
            
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(WaterDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    @Override
    public ArrayList<WaterReadingBean> getAllWaterBills() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from waterreading";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            WaterReadingBean bean = new WaterReadingBean();
            ArrayList<WaterReadingBean> list = new ArrayList<WaterReadingBean>();
            
            int waterID;
            float currentcubicpermeter, pricepercubicmeter, price;
            Date dateRead;
            
            while(resultSet.next()) {
                waterID = resultSet.getInt("water_billID");
                currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
                pricepercubicmeter = resultSet.getFloat("pricepercubicmeter");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");
                
                bean = new WaterReadingBean();
                
                bean.setWater_billID(waterID);
                bean.setCurrentcubicmeter(currentcubicpermeter);
                bean.setPricepercubicmeter(pricepercubicmeter);
                bean.setPrice(price);
                bean.setDateRead(dateRead);
                
                list.add(bean);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WaterDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public ArrayList<WaterReadingBean> getAllWaterReadingsByDate(Date dateread) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editWaterReading(Date dateread) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editWaterReadingByPrice(float price, int waterID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean computeWaterReading(WaterReadingBean water, int billID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

        
}
