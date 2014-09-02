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
import java.util.Calendar;
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
            String query = "insert into room (status) values(?)";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, room.getStatus());
            ps.setString(1, room.getStatus());
            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    @Override
    public boolean assignTenanttoRoom(TenantBean tenant, RoomBean room, ContractBean contract) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            Calendar startdate = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(startdate.getTime().getTime());
            
            String query = "insert into tenantroom (tr_tenantID, tr_roomID, startDate) values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, tenant.getTenantID());
            ps.setInt(2, room.getRoomID());
            ps.setDate(3, startDate);
            ps.executeUpdate();
            connection.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public ArrayList<RoomBean> getAllRooms() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from room";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            RoomBean bean = new RoomBean();
            ArrayList<RoomBean> list = new ArrayList<RoomBean>();

            int roomID;
            String roomstatus;
            //String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt("roomID");
                roomstatus = resultSet.getString("status");
                //roomprice = resultSet.getDouble("roomprice");
                //status = resultSet.getString("status");

                bean = new RoomBean();

                bean.setStatus(roomstatus);
                bean.setRoomID(roomID);

                //bean.setRoomprice(roomprice);
                //bean.setStatus(status);

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
    public RoomBean getRoomByRoomID(int roomID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from room where roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roomID);
            ResultSet resultSet = ps.executeQuery();

            RoomBean bean = new RoomBean();
            ArrayList<RoomBean> list = new ArrayList<RoomBean>();

            int currroomID;
            String curroomstatus;
            //String status;

            while (resultSet.next()) {
                currroomID = resultSet.getInt("roomID");
                curroomstatus = resultSet.getString("status");
                //status = resultSet.getString("status");

                bean.setStatus(curroomstatus);
                bean.setRoomID(roomID);
                //bean.setStatus(status);

            }
            connection.close();
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public RoomBean getTenantRoom(int tenantID) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenantroom where tr_tenantID = ? order by endDate desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tenantID);
            ResultSet resultSet = ps.executeQuery();

            RoomBean bean = new RoomBean();

            int roomID;

            while (resultSet.next()) {
                roomID = resultSet.getInt("tr_roomID");
                bean.setRoomID(roomID);
            }

            connection.close();
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<RoomBean> viewAvailbleRooms() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "SELECT tr_roomID, count(tr_tenantID) as count FROM dormitory.tenantroom group by tr_roomID";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<RoomBean> list = new ArrayList<>();
            RoomBean bean = new RoomBean();

            int roomID;
            String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt("tr_roomID");
                status = resultSet.getString("status");
                //currentKW = resultSet.getFloat("currentKW");
                //currentcubicmeter = resultSet.getFloat("currentcubicmeter");

                bean = new RoomBean();

                bean.setRoomID(roomID);
                bean.setStatus(status);
                //bean.setCurrentKW(currentKW);
                //bean.setCurrentcubicmeter(currentcubicmeter);

                list.add(bean);
            }

            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int checkRoomCount(int roomID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "SELECT tr_roomID, count(tr_tenantID) as count FROM dormitory.tenantroom where tr_roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roomID);
            ResultSet resultSet = ps.executeQuery();

            int count = 0;
            float currentKW, currentcubicmeter;

            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }

            connection.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

    @Override
    public boolean removeTenantToRoom(int tenantID, int roomID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "delete from tenantroom where tr_tenantID = ? and tr_roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            //Calendar enddate = Calendar.getInstance();
            //java.sql.Date endDate = new java.sql.Date(enddate.getTime().getTime());
            
            ps.setInt(1, tenantID);
            ps.setInt(2, roomID);
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean setUnoccupied(RoomBean room) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update room set status = ? where roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, "Unoccupied");
            ps.setInt(2, room.getRoomID());
            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean setOccupied(RoomBean room) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update room set status = ? where roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, "Occupied");
            ps.setInt(2, room.getRoomID());
            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<RoomBean> getRoomByStatus(String status) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from room where status = ?";
            PreparedStatement ps = connection.prepareStatement(query);           
            ps.setString(1, status);
            ResultSet resultSet = ps.executeQuery();
            
            RoomBean room = new RoomBean();
            ArrayList<RoomBean> list = new ArrayList<>();
            
            int roomID;
            String beanstatus;
            
            while(resultSet.next()){
                roomID = resultSet.getInt("roomID");
                beanstatus = resultSet.getString("status");
                
                room.setRoomID(roomID);
                room.setStatus(beanstatus);
                
                list.add(room);
                      
            }
            connection.close();
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    

}
