/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.ElectricReadingBean;
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
    public boolean addElectricReadingToRoom(ElectricReadingBean electric) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into electricreading (currentKW, datePaid, status) values (?, ?, ?,)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, electric.getCurrentKW());
            ps.setDate(2, electric.getDatePaid());
            ps.setString(3, electric.getStatus());
            ps.executeUpdate();
            connection.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public ArrayList<ElectricReadingBean> getAllElectricBills() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from electricreading";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ElectricReadingBean bean = new ElectricReadingBean();
            ArrayList<ElectricReadingBean> list = new ArrayList<ElectricReadingBean>();

            int electric_billID;
            float currentKW;
            Date datePaid;
            String status;

            while (resultSet.next()) {
                electric_billID = resultSet.getInt("electric_billID");
                currentKW = resultSet.getFloat("currentKW");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                bean = new ElectricReadingBean();

                bean.setElectric_billID(electric_billID);
                bean.setCurrentKW(currentKW);
                bean.setDatePaid(datePaid);
                bean.setStatus(status);

                list.add(bean);
            }
            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    /*
     @Override
     public ArrayList<ElectricReadingBean> getAllElectricReadingsByDate(Date from, Date to) {
     try {
     Connector c = new Connector();
     Connection connection = c.getConnection();
     String query = "select * from electricreading where dateRead"
     + "BETWEEN '" + from + "' and '" + to + "'";
     PreparedStatement ps = connection.prepareStatement(query);
     ResultSet resultSet = ps.executeQuery();

     ElectricReadingBean bean = new ElectricReadingBean();
     ArrayList<ElectricReadingBean> list = new ArrayList<ElectricReadingBean>();

     int electric_billID;
     float currentKW, pricepercubicmeter, price;
     Date dateRead;

     while (resultSet.next()) {
     electric_billID = resultSet.getInt("electric_billID");
     currentKW = resultSet.getFloat("currentKW");
     pricepercubicmeter = resultSet.getFloat("pricepercubicmeter");
     price = resultSet.getFloat("price");
     dateRead = resultSet.getDate("dateRead");

     bean = new ElectricReadingBean();

     bean.setCurrentKW(currentKW);
     bean.setDateRead(dateRead);
     bean.setElectric_billID(electric_billID);
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
    public boolean editElectricReading(ElectricReadingBean electric) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update electricreading set currentKW =?, "
                    + "datePaid = ?, status = ?"
                    + "where electric_billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, electric.getCurrentKW());
            ps.setDate(2, electric.getDatePaid());
            ps.setString(3, electric.getStatus());
            ps.setInt(4, electric.getElectric_billID());
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ElectricReadingBean getElectricReadingsByElectricBillID(int ebillID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from electricreading where electric_billID = ? order by electric_billID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, ebillID);
            ResultSet resultSet = ps.executeQuery();
            
            ElectricReadingBean bean = new ElectricReadingBean();

            int electric_billID;
            float currentKW;
            Date datePaid;
            String status;

            while (resultSet.next()) {
                electric_billID = resultSet.getInt("electric_billID");
                currentKW = resultSet.getFloat("currentKW");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                bean.setElectric_billID(electric_billID);
                bean.setCurrentKW(currentKW);
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
