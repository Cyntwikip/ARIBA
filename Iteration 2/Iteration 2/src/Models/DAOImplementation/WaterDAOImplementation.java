/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.ElectricReadingBean;
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
    public boolean addWaterReadingToRoom(WaterReadingBean water) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into waterreading (water_roomID, currentcubicpermeter,dateRead, datePaid, status) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, water.getWater_roomID());
            ps.setFloat(2, water.getCurrentcubicpermeter());
            ps.setDate(3, water.getDateRead());
            ps.setDate(4, water.getDatePaid());
            ps.setString(5, water.getStatus());
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

            int water_billID, water_roomID;
            float currentcubicpermeter;
            Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                water_billID = resultSet.getInt("water_billID");
                water_roomID = resultSet.getInt("water_roomID");
                currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                bean = new WaterReadingBean();

                bean.setWater_billID(water_billID);
                bean.setWater_roomID(water_roomID);
                bean.setCurrentcubicpermeter(currentcubicpermeter);
                bean.setDateRead(dateRead);
                bean.setDatePaid(datePaid);
                bean.setStatus(status);

                list.add(bean);
            }
            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WaterDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    /*
     @Override
     public ArrayList<WaterReadingBean> getAllWaterReadingsByDate(Date from, Date to) {
     try {
     Connector c = new Connector();
     Connection connection = c.getConnection();
     String query = "select * from waterreading where dateRead"
     + "BETWEEN '" + from + "' and '" + to + "'";
     PreparedStatement ps = connection.prepareStatement(query);
     ResultSet resultSet = ps.executeQuery();

     WaterReadingBean bean = new WaterReadingBean();
     ArrayList<WaterReadingBean> list = new ArrayList<WaterReadingBean>();

     int water_billID;
     float currentcubicpermeter, pricepercubicmeter, price;
     Date dateRead;

     while (resultSet.next()) {
     water_billID = resultSet.getInt("electric_billID");
     currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
     pricepercubicmeter = resultSet.getFloat("pricepercubicmeter");
     price = resultSet.getFloat("price");
     dateRead = resultSet.getDate("dateRead");

     bean = new WaterReadingBean();

     bean.setCurrentcubicpermeter(currentcubicpermeter);
     bean.setDateRead(dateRead);
     bean.setWater_billID(water_billID);
     bean.setPrice(price);
     bean.setPricepercubicmeter(pricepercubicmeter);

     list.add(bean);
     }
     connection.close();
     return list;
     } catch (SQLException ex) {
     Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
     }

     return null;
     }
     */

    @Override
    public boolean editWaterReading(WaterReadingBean water) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update waterreading set currentcubicpermeter =?, "
                    + "dateRead = ?, datePaid = ?, status = ?"
                    + "where water_billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, water.getCurrentcubicpermeter());
            ps.setDate(2, water.getDateRead());
            ps.setDate(3, water.getDatePaid());
            ps.setString(4, water.getStatus());
            ps.setInt(5, water.getWater_billID());
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public WaterReadingBean getWaterReadingsByWaterBillID(int wbillID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from waterreading where water_billID = ? order by water_billID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, wbillID);
            ResultSet resultSet = ps.executeQuery();
            
            WaterReadingBean bean = new WaterReadingBean();

            int water_billID, water_roomID;
            float currentcubicpermeter;
            Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                water_billID = resultSet.getInt("water_billID");
                water_roomID = resultSet.getInt("water_roomID");
                currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                bean.setWater_billID(water_billID);
                bean.setWater_roomID(water_roomID);
                bean.setCurrentcubicpermeter(currentcubicpermeter);
                bean.setDateRead(dateRead);
                bean.setDatePaid(datePaid);
                bean.setStatus(status);
                
                return bean;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
