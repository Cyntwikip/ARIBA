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

            String query = "insert into waterreading (currentcubicpermeter, dateRead, datePaid, status) values ( ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, water.getCurrentcubicpermeter());
            ps.setDate(2, water.getDateRead());
            ps.setDate(3, water.getDatePaid());
            ps.setString(4, water.getStatus());
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

            int water_billID;
            float currentcubicpermeter;
            Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                water_billID = resultSet.getInt("water_billID");
                currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                bean = new WaterReadingBean();

                bean.setWater_billID(water_billID);
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
                    + " dateRead = ?, datePaid = ?, status = ?"
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

            int water_billID;
            float currentcubicpermeter;
            Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                water_billID = resultSet.getInt("water_billID");
                currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                bean.setWater_billID(water_billID);
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

    @Override
    public WaterReadingBean getWaterReadingByMonth(Date date) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from waterreading where month(?) = month(dateRead)and year(?) = year(dateRead)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, date);
            ps.setDate(2, date);
            ResultSet resultSet = ps.executeQuery();
            int water_billID;
            float currentcubicpermeter;
            Date dateRead, datePaid;
            String status;
            WaterReadingBean wbean = new WaterReadingBean();

            while (resultSet.next()) {

                water_billID = resultSet.getInt("water_billID");
                currentcubicpermeter = resultSet.getFloat("currentcubicpermeter");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                wbean.setWater_billID(water_billID);
                wbean.setCurrentcubicpermeter(currentcubicpermeter);
                wbean.setDateRead(dateRead);
                wbean.setDatePaid(datePaid);
                wbean.setStatus(status);

            }
            connection.close();

            return wbean;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public WaterReadingBean getWaterReadingByID(int roomid, int dbillid) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select water_billID, currentcubicpermeter, waterreading.dateRead, waterreading.datePaid, waterreading.status from waterreading, roombill, room, dormbill where roombill.roomID = ? and roombill.roomID = room.roomID and water_billID = waterreadingID and dbill_ID = ? and dbill_ID = dbillID";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roomid);
            ps.setInt(2, dbillid);
            ResultSet resultSet = ps.executeQuery();

            int water_billID;
            float currentcubicpermeter;
            Date dateRead, datePaid;
            String status;

            WaterReadingBean wbean = new WaterReadingBean();

            //System.out.println("hi");
            while (resultSet.next()) {
                water_billID = resultSet.getInt(1);
                currentcubicpermeter = resultSet.getFloat(2);
                dateRead = resultSet.getDate(3);
                datePaid = resultSet.getDate(4);
                status = resultSet.getString(5);

                wbean.setWater_billID(water_billID);
                wbean.setCurrentcubicpermeter(currentcubicpermeter);
                wbean.setDateRead(dateRead);
                wbean.setDatePaid(datePaid);
                wbean.setStatus(status);
            }
            connection.close();

            return wbean;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
