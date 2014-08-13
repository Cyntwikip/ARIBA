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
    public boolean addWaterReadingToRoom(WaterReadingBean water, int billID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into waterreading (water_billID, currentcubicpermeter, pricepercubicmeter, price, dateRead) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, billID);
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

            while (resultSet.next()) {
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
            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WaterDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

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
            float currentcubicmeter, pricepercubicmeter, price;
            Date dateRead;

            while (resultSet.next()) {
                water_billID = resultSet.getInt("electric_billID");
                currentcubicmeter = resultSet.getFloat("currentcubicmeter");
                pricepercubicmeter = resultSet.getFloat("pricepercubicmeter");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");

                bean = new WaterReadingBean();

                bean.setCurrentcubicmeter(currentcubicmeter);
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

    @Override
    public boolean editWaterReading(WaterReadingBean water, int waterID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update waterreading set currentcubicpermeter =?, "
                    + "pricepercubicmeter = ?, price = ?, dateRead = ?"
                    + "where water_billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, water.getCurrentcubicmeter());
            ps.setFloat(2, water.getPricepercubicmeter());
            ps.setFloat(3, water.getPrice());
            ps.setDate(4, water.getDateRead());
            ps.setInt(5, waterID);
            ps.executeUpdate();
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean editWaterReadingByPrice(float price, int waterID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update waterreading set price = ? "
                    + "where water_billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, price);
            ps.setFloat(2, waterID);
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public boolean computeWaterReading(WaterReadingBean water, int billID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WaterReadingBean getWaterReadingsByBillID(int billID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from waterreading where water_billID =" + billID + " order by water_billID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            WaterReadingBean bean = new WaterReadingBean();

            int waterID;
            float currentcubicmeter, pricepercubicmeter, price;
            Date dateRead;

            while (resultSet.next()) {
                waterID = resultSet.getInt("water_billID");
                currentcubicmeter = resultSet.getFloat("currentcubicpermeter");
                pricepercubicmeter = resultSet.getFloat("pricepercubicmeter");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");

                bean.setWater_billID(waterID);
                bean.setCurrentcubicmeter(currentcubicmeter);
                bean.setPricepercubicmeter(pricepercubicmeter);
                bean.setPrice(price);
                bean.setDateRead(dateRead);

                return bean;
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<WaterReadingBean> getWaterReadingforThisMonth(int roomCount) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from waterreading where dateRead >= (NOW() - INTERVAL 1 MONTH) order by water_billID DESC limit " + roomCount;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            WaterReadingBean bean = new WaterReadingBean();
            ArrayList<WaterReadingBean> list = new ArrayList<WaterReadingBean>();

            int water_billID;
            float currentcubicpermeter, pricepercubicmeter, price;
            Date dateRead;

            while (resultSet.next()) {
                water_billID = resultSet.getInt("water_billID");
                currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
                pricepercubicmeter = resultSet.getFloat("pricepercubicmeter");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");

                bean = new WaterReadingBean();

                bean.setCurrentcubicmeter(currentcubicpermeter);
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

}
