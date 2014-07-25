/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.ContractBean;
import Models.Beans.RoomBean;
import Models.Beans.TenantBean;
import Models.Connector.Connector;
import Models.DAOInterface.RoomDAOInterface;
import java.sql.Connection;
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
public class RoomDAOImplementation implements RoomDAOInterface {

    @Override
    public boolean addRoom(RoomBean room) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into room (currentKW, currentcubicmeter) values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, room.getStatus());
            ps.setFloat(1, room.getCurrentKW());
            ps.setFloat(2, room.getCurrentcubicmeter());
            ps.executeUpdate();
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editRoom(RoomBean room, int roomID) {
        
            try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            
            String query = "update room set currentKW = ?, currentcubicmeter = ? where roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, room.getStatus());
            ps.setFloat(1, room.getCurrentKW());
            ps.setFloat(2, room.getCurrentcubicmeter());
            ps.setInt(3, roomID);
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return false;
    
    }


    @Override
    public boolean assignTenanttoRoom(TenantBean tenant, RoomBean room, ContractBean contract) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            
            String query = "insert into tenantroom (tr_tenantID, tr_roomID, startDate, endDate) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
                        
            ps.setInt(1, tenant.getTenantID());
            ps.setInt(2, room.getRoomID());
            ps.setDate(3, contract.getEffectivedate());
            ps.setDate(4, contract.getExpirydate());
            ps.executeUpdate();
            connection.close();
            
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    /*
    @Override
    public ArrayList<RoomBean> getAllCurrentKW() {
 
                try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from room";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet resultSet = ps.executeQuery();
            
            RoomBean bean = new RoomBean();
            ArrayList<RoomBean> list = new ArrayList<RoomBean>();
            
            int roomID;
            float currentKW, currentcubicmeter;
            //String currStatus;
            
            while(resultSet.next()){
                roomID = resultSet.getInt("roomID");
                currentKW = resultSet.getFloat("currentKW");
                currentcubicmeter = resultSet.getFloat("currentcubicmeter");
                //currStatus = resultSet.getString("status");
                
                bean.setCurrentKW(currentKW);
                bean.setCurrentcubicmeter(currentcubicmeter);
                bean.setRoomID(roomID);
                //bean.setStatus(currStatus);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
    @Override
    public ArrayList<RoomBean> getCurrentKWbyRoom(int roomID) {  
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from room";
            PreparedStatement ps = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @Override
    public ArrayList<RoomBean> getAllCubicMeter(int roomID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomBean getCubicMeter(int roomBean) {
 
                try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, currentcubicmeter from room where roomID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roomBean);
            ResultSet resultSet = ps.executeQuery();
            
            RoomBean bean = new RoomBean();
            
            int roomID;
            float currentKW, currentcubicmeter;
            String currStatus;
            
            while(resultSet.next()){
                roomID = resultSet.getInt("roomID");
                currentKW = resultSet.getFloat("currentKW");
                currentcubicmeter = resultSet.getFloat("currentcubicmeter");
                //currStatus = resultSet.getString("status");
                
                bean.setCurrentKW(currentKW);
                bean.setCurrentcubicmeter(currentcubicmeter);
                bean.setRoomID(roomID);
                //bean.setStatus(currStatus);
                
             }
            return bean;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<RoomBean> getAllUnoccupiedRooms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RoomBean> getAllOccupiedRooms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    @Override
    public ArrayList<RoomBean> getAllRooms() {
              try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from room";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            RoomBean bean = new RoomBean();
            ArrayList<RoomBean> list = new ArrayList<RoomBean>();
            
            int roomID;
            float currentKW, currentcubicmeter;
            //String status;
            
            while(resultSet.next()){
                roomID = resultSet.getInt("roomID");
                currentKW = resultSet.getFloat("currentKW");
                currentcubicmeter = resultSet.getFloat("currentcubicmeter");
                //status = resultSet.getString("status");
                
                bean = new RoomBean();
                
                bean.setCurrentKW(currentKW);
                bean.setCurrentcubicmeter(currentcubicmeter);
                bean.setRoomID(roomID);
                //bean.setStatus(status);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    
    }

    @Override
    public RoomBean getRoomByRoomID(int roomID) {
        try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from room where roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roomID);
            ResultSet resultSet = ps.executeQuery();
            
            RoomBean bean = new RoomBean();
            ArrayList<RoomBean> list = new ArrayList<RoomBean>();
            
            int currroomID;
            float currentKW, currentcubicmeter;
            //String status;
            
            while(resultSet.next()){
                currroomID = resultSet.getInt("roomID");
                currentKW = resultSet.getFloat("currentKW");
                currentcubicmeter = resultSet.getFloat("currentcubicmeter");
                //status = resultSet.getString("status");
                
                bean.setCurrentKW(currentKW);
                bean.setCurrentcubicmeter(currentcubicmeter);
                bean.setRoomID(roomID);
                //bean.setStatus(status);
                
                
             }
            return bean;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    
    }

    
}
