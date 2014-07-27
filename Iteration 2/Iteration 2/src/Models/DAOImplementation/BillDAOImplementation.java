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
            String query = "insert into bill (bill_roomID, price, paidRent, paidWater, paidElectric) value (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bill.getBill_roomID());
            ps.setDouble(2, bill.getPrice());
            ps.setBoolean(3, bill.getpaidRent());
            ps.setBoolean(4, bill.getPaidWater());
            ps.setBoolean(5, bill.getpaidElectric());
            
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
            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from bill";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            BillBean bean = new BillBean();
            ArrayList<BillBean> list = new ArrayList<BillBean>();
            
            int billID, bill_roomID;
            double price;
            boolean paidRent, paidWater, paidElectric;
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPrice(price);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 

    
    
    }

    @Override
    public boolean editBill(BillBean bill, int billID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update bill set bill_roomID = ?, "
                    + "price = ?, paidRent = ?, paidWater= ?, paidElectric = ?"
                    + "where billID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bill.getBill_roomID());
            ps.setDouble(2, bill.getPrice());
            ps.setBoolean(3, bill.getpaidRent());
            ps.setBoolean(4, bill.getPaidWater());
            ps.setBoolean(5, bill.getpaidElectric());
            ps.setInt(6, billID);
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;


    }

    @Override
    public ArrayList<BillBean> getAllPaidRoom() { 
            try{
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
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }

    @Override
    public ArrayList<BillBean> getAllPaidBillByRoom() {
            try{
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
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }

    @Override
    public ArrayList<BillBean> getAllPaidRoomByWater() {
            try{
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
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }

    @Override
    public ArrayList<BillBean> getAllPaidRoomByElectric() {
            try{
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
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }

    @Override
    public ArrayList<BillBean> getAllNotPaidRoomsByWater() {
            try{
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
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 

    }

    @Override
    public ArrayList<BillBean> getAllNotPaidRoomsByRent() {
            try{
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
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 

    }

    @Override
    public ArrayList<BillBean> getAllNotPaidRoomsByElectric() {
            try{
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
            
            while(resultSet.next()){
                billID = resultSet.getInt("billID");
                bill_roomID = resultSet.getInt("bill_roomID");
                price = resultSet.getDouble("price");
                paidRent = resultSet.getBoolean("paidRent");
                paidWater = resultSet.getBoolean("paidWater");
                paidElectric = resultSet.getBoolean("paidElectric");
                
                bean = new BillBean();
                
                bean.setBillID(billID);
                bean.setBill_roomID(bill_roomID);
                bean.setPaidElectric(paidElectric);
                bean.setPaidRent(paidRent);
                bean.setPaidWater(paidWater);
                bean.setPrice(price);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 

    }
    
}
