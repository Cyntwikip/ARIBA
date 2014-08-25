/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.BillBean;
import Models.Beans.RoomBean;
import Models.Connector.Connector;
import Models.DAOInterface.BillDAOInterface;
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
public class BillDAOImplementation implements BillDAOInterface {

    @Override
    public boolean addBill(BillBean bill) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into bill (bill_roomID, price, paidRent, paidWater, paidElectric, totalelectricityconsumption, totalwaterconsumption, roomprice) "
                    + "value (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bill.getBill_roomID());
            ps.setDouble(2, bill.getPrice());
            ps.setBoolean(3, bill.getpaidRent());
            ps.setBoolean(4, bill.getPaidWater());
            ps.setBoolean(5, bill.getpaidElectric());
            ps.setFloat(6, bill.getTotalelectricityconsumption());
            ps.setFloat(7, bill.getTotalwaterconsumption());
            ps.setFloat(8, bill.getRoomprice());

            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<BillBean> getAllBills() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from bill order by billID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float roomprice, totalwaterconsumption, totalelectricityconsumption;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                roomprice = resultSet.getFloat("roomprice");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPrice(price);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);

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
    public boolean editBill(BillBean bill, int billID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update bill set bill_roomID = ?, paidRent = ?, paidWater= ?, paidElectric = ?, price = ?, totalelectricityconsumption = ?, totalwaterconsumption = ?, roomprice = ? where billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bill.getBill_roomID());
            ps.setBoolean(2, bill.getpaidRent());
            ps.setBoolean(3, bill.getPaidWater());
            ps.setBoolean(4, bill.getpaidElectric());
            ps.setDouble(5, bill.getPrice());
            ps.setFloat(6, bill.getTotalelectricityconsumption());
            ps.setFloat(7, bill.getTotalwaterconsumption());
            ps.setFloat(8, bill.getRoomprice());
            ps.setInt(9, billID);
            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<BillBean> getAllPaidRoom() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentKW, currentcubicmeter "
                    + "from bill, room where paidRent = 1 AND paidWater = 1 AND paidElectric = 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalwaterconsumption, totalelectricityconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);

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
    public ArrayList<BillBean> getAllPaidBillByRent() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentKW, currentcubicmeter "
                    + "from bill, room where paidRent = 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalwaterconsumption, totalelectricityconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);
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
    public ArrayList<BillBean> getAllPaidRoomByWater() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentKW, currentcubicmeter "
                    + "from bill, room where paidWater = 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalelectricityconsumption, totalwaterconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);
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
    public ArrayList<BillBean> getAllPaidRoomByElectric() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentKW, currentcubicmeter "
                    + "from bill, room where paidElectric = 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalelectricityconsumption, totalwaterconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);
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
    public ArrayList<BillBean> getAllNotPaidRoomsByWater() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentKW, currentcubicmeter "
                    + "from bill, room where paidWater = 0";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalwaterconsumption, totalelectricityconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);
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
    public ArrayList<BillBean> getAllNotPaidRoomsByRent() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentKW, currentcubicmeter "
                    + "from bill, room where paidRent = 0";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalwaterconsumption, totalelectricityconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);

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
    public ArrayList<BillBean> getAllNotPaidRoomsByElectric() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentKW, currentcubicmeter "
                    + "from bill, room where paidElectric = 0";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalwaterconsumption, totalelectricityconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);

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
    public BillBean getBillsByRoomID(int roomID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from bill where bill_roomID = ? order by billID DESC";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roomID);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalelectricityconsumption, totalwaterconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprice");

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPrice(price);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setRoomprice(roomprice);
                bean.setTotalelectricityconsumption(totalelectricityconsumption);
                bean.setTotalwaterconsumption(totalwaterconsumption);
                connection.close();

                return bean;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public ArrayList<BillBean> getAllNotPaidAll(int roomCount) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from bill where paidElectric = 0 and paidWater=0 and paidRent=0 order by billID desc limit " + roomCount;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();

            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            float totalwaterconsumption, totalelectricityconsumption, roomprice;

            while (resultSet.next()) {
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                totalwaterconsumption = resultSet.getFloat("totalwaterconsumption");
                totalelectricityconsumption = resultSet.getFloat("totalelectricityconsumption");
                roomprice = resultSet.getFloat("roomprce");

                bean = new BillBean();

                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);

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
    public boolean addElectricReadingToRoom(ElectricReadingBean electric) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into electricreading (electric_billID, currentKW, priceperKW, price, dateRead) values ( ?, ?, ?, ?, ?)";
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

            while (resultSet.next()) {
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
            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
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
                    + "where electricID = ?";
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

    @Override
    public ElectricReadingBean getElectricReadingByBillID(int billID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from electricreading where electric_billID = " + billID + " order by electric_billID desc";
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

                bean.setElectric_billID(electricID);
                bean.setCurrentKW(currentKW);
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
