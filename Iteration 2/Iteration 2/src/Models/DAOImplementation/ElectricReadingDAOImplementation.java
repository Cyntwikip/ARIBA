/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.ElectricReadingBean;
import Models.Beans.WaterReadingBean;
import Models.Connector.Connector;
import Models.DAOInterface.ElectricReadingDAOInterface;
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
public class ElectricReadingDAOImplementation implements ElectricReadingDAOInterface {

    @Override
    public boolean addElectricReadingToRoom(ElectricReadingBean electric) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into electricreading (electric_billID, currentKW, priceperKW, price, dateRead) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, electric.getElectric_billID());
            ps.setFloat(2, electric.getCurrentKW());
            ps.setFloat(3, electric.getPriceperKW());
            ps.setFloat(4, electric.getPrice());
            ps.setDate(5, electric.getDateRead());
            ps.executeUpdate();
            connection.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(WaterDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editElectricReading(ElectricReadingBean electric, int electricID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update electricreading set currentKW =?, "
                    + "priceperKW = ?, price = ?, dateRead = ?"
                    + "where electric_billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, electric.getCurrentKW());
            ps.setFloat(2, electric.getPriceperKW());
            ps.setFloat(3, electric.getPrice());
            ps.setDate(4, electric.getDateRead());
            ps.setInt(5, electricID);
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean editElectricReadingByPrice(float price, int electricID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update electricreading set price = ? "
                    + "where electric_billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, price);
            ps.setFloat(2, electricID);
            ps.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
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

            while (resultSet.next()) {
                electricID = resultSet.getInt("electric_billID");
                currentKW = resultSet.getFloat("currentKW");
                priceperKW = resultSet.getFloat("priceperKW");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");

                bean = new ElectricReadingBean();

                bean.setCurrentKW(currentKW);
                bean.setElectric_billID(electricID);
                bean.setPriceperKW(priceperKW);
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
    public ArrayList<ElectricReadingBean> getAllElectricReadingByDate(Date from, Date to) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from electricreading where dateRead"
                    + "BETWEEN '" + from + "' and '" + to + "'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ElectricReadingBean bean = new ElectricReadingBean();
            ArrayList<ElectricReadingBean> list = new ArrayList<ElectricReadingBean>();

            int electricID;
            float currentKW, priceperKW, price;
            Date dateRead;

            while (resultSet.next()) {
                electricID = resultSet.getInt("electric_billID");
                currentKW = resultSet.getFloat("currentKW");
                priceperKW = resultSet.getFloat("priceperKW");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");

                bean = new ElectricReadingBean();

                bean.setCurrentKW(currentKW);
                bean.setElectric_billID(electricID);
                bean.setPriceperKW(priceperKW);
                bean.setPrice(price);
                bean.setDateRead(dateRead);

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
    public ElectricReadingBean getElectricReadingByBillID(int billID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from electricreading where electric_billID =" + billID + " order by electric_billID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ElectricReadingBean bean = new ElectricReadingBean();

            int electricID;
            float currentKW, priceperKW, price;
            Date dateRead;

            while (resultSet.next()) {
                electricID = resultSet.getInt("electric_billID");
                currentKW = resultSet.getFloat("currentKW");
                priceperKW = resultSet.getFloat("priceperKW");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");

                bean.setCurrentKW(currentKW);
                bean.setElectric_billID(electricID);
                bean.setPriceperKW(priceperKW);
                bean.setPrice(price);
                bean.setDateRead(dateRead);

                connection.close();
                return bean;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ElectricReadingBean> getAllElectricReadingforThisMonth(int roomCount) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from electricreading where dateRead >= (NOW() - INTERVAL 1 MONTH) order by electric_billID DESC limit " + roomCount;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ElectricReadingBean bean = new ElectricReadingBean();
            ArrayList<ElectricReadingBean> list = new ArrayList<ElectricReadingBean>();

            int electric_billID;
            float currentKW, priceperKW, price;
            Date dateRead;

            while (resultSet.next()) {
                electric_billID = resultSet.getInt("electric_billID");
                currentKW = resultSet.getFloat("currentKW");
                priceperKW = resultSet.getFloat("priceperKW");
                price = resultSet.getFloat("price");
                dateRead = resultSet.getDate("dateRead");

                bean = new ElectricReadingBean();

                bean.setCurrentKW(currentKW);
                bean.setDateRead(dateRead);
                bean.setElectric_billID(electric_billID);
                bean.setPrice(price);
                bean.setPriceperKW(priceperKW);

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
