/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.RoomBillBean;
import Models.Beans.RoomBean;
import Models.Connector.Connector;
import Models.DAOInterface.RoomBillDAOInterface;
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
public class RoomBillDAOImplementation implements RoomBillDAOInterface {

    @Override
    public boolean addRoomBill(RoomBillBean roombill) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into roombill (roomID, waterreadingID, electricreadingID, dbillID, surcharge,dateRead, datePaid, status)"
                    + "value (?, ?, ?, ?, ?, ?, ?,?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roombill.getRoomID());
            ps.setInt(2, roombill.getWaterreadingID());
            ps.setInt(3, roombill.getElectricreadingID());
            ps.setInt(4, roombill.getDbillID());
            ps.setDouble(5, roombill.getSurcharge());
            ps.setDate(6, roombill.getDateRead());
            ps.setDate(7, roombill.getDatePaid());
            ps.setString(8, roombill.getStatus());


            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoomBillDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<RoomBillBean> getAllBills() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from roombill order by roombillID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            RoomBillBean rb = new RoomBillBean();
            ArrayList<RoomBillBean> rblist = new ArrayList<>();

            int roomID, waterID, electricID, dbillID;
            double surcharge;
            java.util.Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt("roomID");
                waterID = resultSet.getInt("waterreadingID");
                electricID = resultSet.getInt("electricreadingID");
                dbillID = resultSet.getInt("dbillID");
                surcharge = resultSet.getDouble("surcharge");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                rb.setRoomID(roomID);
                rb.setWaterreadingID(waterID);
                rb.setElectricreadingID(electricID);
                rb.setDbillID(dbillID);
                rb.setSurcharge(surcharge);
                rb.setDateRead((Date) dateRead);
                rb.setDatePaid((Date) datePaid);
                rb.setStatus(status);

                rblist.add(rb);
            }
            connection.close();
            return rblist;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean editRoomBill(RoomBillBean roombill) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update roombill set roomID = ?, waterreadingID = ?, electricreadingID = ?, dbillID = ?, surcharge = ?, dateRead = ?, datePaid = ?, status = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roombill.getRoomID());
            ps.setInt(2, roombill.getWaterreadingID());
            ps.setInt(3, roombill.getElectricreadingID());
            ps.setInt(4, roombill.getDbillID());
            ps.setDouble(5, roombill.getSurcharge());
            ps.setDate(6, roombill.getDateRead());
            ps.setDate(7, roombill.getDatePaid());
            ps.setString(8, roombill.getStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<RoomBillBean> getAllPaidRooms() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from roombill where status = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "Paid");

            ResultSet resultSet = ps.executeQuery();

            RoomBillBean rb = new RoomBillBean();
            ArrayList<RoomBillBean> rblist = new ArrayList<>();

            int roomID, waterID, electricID, dbillID;
            double surcharge;
            java.util.Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt("roomID");
                waterID = resultSet.getInt("waterreadingID");
                electricID = resultSet.getInt("electricreadingID");
                dbillID = resultSet.getInt("dbillID");
                surcharge = resultSet.getDouble("surcharge");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                rb.setRoomID(roomID);
                rb.setWaterreadingID(waterID);
                rb.setElectricreadingID(electricID);
                rb.setDbillID(dbillID);
                rb.setSurcharge(surcharge);
                rb.setDateRead((Date) dateRead);
                rb.setDatePaid((Date) datePaid);
                rb.setStatus(status);

                rblist.add(rb);
            }
            connection.close();
            return rblist;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<RoomBillBean> getRoomBillsByRoomID(int room) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from roombill where roomID = ? order by roomID DESC";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, room);
            ResultSet resultSet = ps.executeQuery();

            RoomBillBean rb = new RoomBillBean();
            ArrayList<RoomBillBean> rblist = new ArrayList<>();

            int roomID, waterID, electricID, dbillID;
            double surcharge;
            java.util.Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt("roomID");
                waterID = resultSet.getInt("waterreadingID");
                electricID = resultSet.getInt("electricreadingID");
                dbillID = resultSet.getInt("dbillID");
                surcharge = resultSet.getDouble("surcharge");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                rb.setRoomID(roomID);
                rb.setWaterreadingID(waterID);
                rb.setElectricreadingID(electricID);
                rb.setDbillID(dbillID);
                rb.setSurcharge(surcharge);
                rb.setDateRead((Date) dateRead);
                rb.setDatePaid((Date) datePaid);
                rb.setStatus(status);

                rblist.add(rb);
            }
            connection.close();
            return rblist;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<RoomBillBean> getAllNotPaidRooms() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from roombill where status = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "Unpaid");

            ResultSet resultSet = ps.executeQuery();

            RoomBillBean rb = new RoomBillBean();
            ArrayList<RoomBillBean> rblist = new ArrayList<>();

            int roomID, waterID, electricID, dbillID;
            double surcharge;
            java.util.Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt("roomID");
                waterID = resultSet.getInt("waterreadingID");
                electricID = resultSet.getInt("electricreadingID");
                dbillID = resultSet.getInt("dbillID");
                surcharge = resultSet.getDouble("surcharge");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                rb.setRoomID(roomID);
                rb.setWaterreadingID(waterID);
                rb.setElectricreadingID(electricID);
                rb.setDbillID(dbillID);
                rb.setSurcharge(surcharge);
                rb.setDateRead((Date) dateRead);
                rb.setDatePaid((Date) datePaid);
                rb.setStatus(status);

                rblist.add(rb);
            }
            connection.close();
            return rblist;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean addSurcharge(RoomBillBean roombill) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update roombill set surcharge = ?"
                    + "where roomID = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, roombill.getSurcharge());
            ps.setInt(2, roombill.getRoomID());

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<RoomBillBean> getAllRoomBillByMonthandYear(Date date) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from roombill where month(?) = month(dateRead)and year(?) = year(dateRead)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, date);
            ps.setDate(2, date);
            ResultSet resultSet = ps.executeQuery();

            RoomBillBean rb = new RoomBillBean();
            ArrayList<RoomBillBean> rblist = new ArrayList<>();

            int roomID, waterID, electricID, dbillID;
            double surcharge;
            java.util.Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt("roomID");
                waterID = resultSet.getInt("waterreadingID");
                electricID = resultSet.getInt("electricreadingID");
                dbillID = resultSet.getInt("dbillID");
                surcharge = resultSet.getDouble("surcharge");
                dateRead = resultSet.getDate("dateRead");
                datePaid = resultSet.getDate("datePaid");
                status = resultSet.getString("status");

                rb.setRoomID(roomID);
                rb.setWaterreadingID(waterID);
                rb.setElectricreadingID(electricID);
                rb.setDbillID(dbillID);
                rb.setSurcharge(surcharge);
                rb.setDateRead((Date) dateRead);
                rb.setDatePaid((Date) datePaid);
                rb.setStatus(status);

                rblist.add(rb);
            }
            connection.close();
            return rblist;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RoomBillBean getRoomBillByDbill(int roomid, int dbillid) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select roomID, waterreadingID, electricreadingID, dbillID, surcharge, roombill.dateRead, status from roombill, dormbill where roomID = ? and dbillID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, roomid);
            ps.setInt(2, dbillid);

            ResultSet resultSet = ps.executeQuery();

            RoomBillBean rb = new RoomBillBean();

            int roomID, waterID, electricID, dbillID;
            double surcharge;
            java.util.Date dateRead, datePaid;
            String status;

            while (resultSet.next()) {
                roomID = resultSet.getInt(1);
                waterID = resultSet.getInt(2);
                electricID = resultSet.getInt(3);
                dbillID = resultSet.getInt(4);
                surcharge = resultSet.getDouble(5);
                dateRead = resultSet.getDate(6);
                status = resultSet.getString(7);

                rb.setRoomID(roomID);
                rb.setWaterreadingID(waterID);
                rb.setElectricreadingID(electricID);
                rb.setDbillID(dbillID);
                rb.setSurcharge(surcharge);
                rb.setDateRead((Date) dateRead);
                rb.setStatus(status);

            }
            connection.close();
            return rb;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
