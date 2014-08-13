/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.AttendanceLogBean;
import Models.Beans.TenantBean;
import Models.Connector.Connector;
import Models.DAOInterface.AttendanceLogDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AttendanceLogDAOImplementation implements AttendanceLogDAOInterface {

    @Override
    public boolean addAttendanceLogDAOInterface(AttendanceLogBean attendance) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into attendancelog (log_tenantID, isIN) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, attendance.getLog_tenantID());
            ps.setBoolean(2, attendance.getIsIn());
            ps.executeUpdate();
            connection.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public ArrayList<AttendanceLogBean> getAllLogs() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from attendancelog";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            AttendanceLogBean bean = new AttendanceLogBean();
            ArrayList<AttendanceLogBean> list = new ArrayList<AttendanceLogBean>();

            int logID, log_tenantID;
            boolean isIn;
            Timestamp timeLogged;

            while (resultSet.next()) {
                logID = resultSet.getInt("logID");
                log_tenantID = resultSet.getInt("log_tenantID");
                isIn = resultSet.getBoolean("isIn");
                timeLogged = resultSet.getTimestamp("timeLogged");

                bean = new AttendanceLogBean();

                bean.setLogID(logID);
                bean.setLog_tenantID(log_tenantID);
                bean.setIsIn(isIn);
                bean.setTimeLogged(timeLogged);

                list.add(bean);

            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<AttendanceLogBean> getAllAtendanceLogsByTenantID(int log_tenantID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from attendancelog where log_tenantID = ? order by logID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, log_tenantID);
            ResultSet resultSet = ps.executeQuery();

            AttendanceLogBean bean = new AttendanceLogBean();
            ArrayList<AttendanceLogBean> list = new ArrayList<AttendanceLogBean>();

            int logID;
            boolean isIn;
            Timestamp timeLogged;

            while (resultSet.next()) {
                logID = resultSet.getInt("logID");
                isIn = resultSet.getBoolean("isIn");
                timeLogged = resultSet.getTimestamp("timeLogged");

                bean = new AttendanceLogBean();

                bean.setLogID(logID);
                bean.setLog_tenantID(log_tenantID);
                bean.setIsIn(isIn);
                bean.setTimeLogged(timeLogged);

                list.add(bean);
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean editAttendanceLog(AttendanceLogBean attendance) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update attendancelog set log_tenantID = ?, isIn = ?, timeLogged = ? "
                    + "where logID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, attendance.getLog_tenantID());
            ps.setBoolean(2, attendance.getIsIn());
            ps.setTimestamp(3, attendance.getTimeLogged());
            ps.setInt(4, attendance.getLogID());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public ArrayList<AttendanceLogBean> checkLogin() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from attendancelog where isIn = true";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            AttendanceLogBean bean = new AttendanceLogBean();
            ArrayList<AttendanceLogBean> list = new ArrayList<AttendanceLogBean>();
            int logID, log_tenantID;
            boolean isIn;
            Timestamp timeLogged;
            while (resultSet.next()) {
                logID = resultSet.getInt("logID");
                log_tenantID = resultSet.getInt("log_tenantID");
                isIn = resultSet.getBoolean("isIn");
                timeLogged = resultSet.getTimestamp("timeLogged");

                bean = new AttendanceLogBean();

                bean.setLogID(logID);
                bean.setLog_tenantID(log_tenantID);
                bean.setIsIn(isIn);
                bean.setTimeLogged(timeLogged);

                list.add(bean);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<AttendanceLogBean> checkLogout() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from attendancelog where isIn = false";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            AttendanceLogBean bean = new AttendanceLogBean();
            ArrayList<AttendanceLogBean> list = new ArrayList<AttendanceLogBean>();
            int logID, log_tenantID;
            boolean isIn;
            Timestamp timeLogged;
            while (resultSet.next()) {
                logID = resultSet.getInt("logID");
                log_tenantID = resultSet.getInt("log_tenantID");
                isIn = resultSet.getBoolean("isIn");
                timeLogged = resultSet.getTimestamp("timeLogged");

                bean = new AttendanceLogBean();

                bean.setLogID(logID);
                bean.setLog_tenantID(log_tenantID);
                bean.setIsIn(isIn);
                bean.setTimeLogged(timeLogged);

                list.add(bean);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<TenantBean> checkAllTenantByTime(Timestamp from, Timestamp to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AttendanceLogBean> getLogsToday() {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from attendancelog where timeLogged >= CURDATE()";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            AttendanceLogBean bean = new AttendanceLogBean();
            ArrayList<AttendanceLogBean> list = new ArrayList<AttendanceLogBean>();
            int logID, log_tenantID;
            boolean isIn;
            Timestamp timeLogged;
            while (resultSet.next()) {
                logID = resultSet.getInt("logID");
                log_tenantID = resultSet.getInt("log_tenantID");
                isIn = resultSet.getBoolean("isIn");
                timeLogged = resultSet.getTimestamp("timeLogged");

                bean = new AttendanceLogBean();

                bean.setLogID(logID);
                bean.setLog_tenantID(log_tenantID);
                bean.setIsIn(isIn);
                bean.setTimeLogged(timeLogged);

                list.add(bean);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public AttendanceLogBean getLatestLoginByTenant(int tenantID) {
          try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from attendancelog where isIn = true and log_tenantID = " + tenantID + "  and timeLogged >= CURDATE() order by logID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            AttendanceLogBean bean = new AttendanceLogBean();
            ArrayList<AttendanceLogBean> list = new ArrayList<AttendanceLogBean>();
    
            int logID, log_tenantID;
            boolean isIn;
            Timestamp timeLogged;
            while (resultSet.next()) {
                logID = resultSet.getInt("logID");
                log_tenantID = resultSet.getInt("log_tenantID");
                isIn = resultSet.getBoolean("isIn");
                timeLogged = resultSet.getTimestamp("timeLogged");

     
                bean.setLogID(logID);
                bean.setLog_tenantID(log_tenantID);
                bean.setIsIn(isIn);
                bean.setTimeLogged(timeLogged);

                return bean;

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public AttendanceLogBean getLatestLogoutByTenant(int tenantID) {
         try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from attendancelog where isIn = false and log_tenantID = "+ tenantID + " and timeLogged >= CURDATE() order by logID desc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            AttendanceLogBean bean = new AttendanceLogBean();
            ArrayList<AttendanceLogBean> list = new ArrayList<AttendanceLogBean>();
            int logID, log_tenantID;
            boolean isIn;
            Timestamp timeLogged;
            while (resultSet.next()) {
                logID = resultSet.getInt("logID");
                log_tenantID = resultSet.getInt("log_tenantID");
                isIn = resultSet.getBoolean("isIn");
                timeLogged = resultSet.getTimestamp("timeLogged");

                bean = new AttendanceLogBean();

                bean.setLogID(logID);
                bean.setLog_tenantID(log_tenantID);
                bean.setIsIn(isIn);
                bean.setTimeLogged(timeLogged);

                return bean;

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceLogDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
