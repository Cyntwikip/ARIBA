/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.GuardianBean;
import Models.Beans.TenantBean;
import Models.Connector.Connector;
import Models.DAOInterface.GuardianDAOInterface;
import java.sql.Blob;
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
public class GuardianDAOImplementation implements GuardianDAOInterface {

    @Override
    public boolean addGuardian(GuardianBean guardian) { // important
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into guardian (guardianID, fname, lname, contact, email)"
                    + " values(?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, guardian.getGuardianID());
            ps.setString(2, guardian.getFname());
            ps.setString(3, guardian.getLname());
            ps.setString(4, guardian.getContact());
            ps.setString(5, guardian.getEmail());

            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public GuardianBean getGuardianByID(int guardianID) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from guardian where guardianID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, guardianID);
            ResultSet resultSet = ps.executeQuery();

            GuardianBean bean = new GuardianBean();

            int guardianid;
            String fname, lname, contact, email;

            while (resultSet.next()) {
                guardianid = resultSet.getInt("guardianID");
                contact = resultSet.getString("contact");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                email = resultSet.getString("email");

                bean = new GuardianBean();

                bean.setGuardianID(guardianID);
                bean.setContact(contact);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setEmail(email);
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public ArrayList<GuardianBean> getAllGuardians() {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from guardian";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            GuardianBean bean = new GuardianBean();
            ArrayList<GuardianBean> list = new ArrayList<GuardianBean>();

            int guardianid;
            String fname, lname, contact, email;

            while (resultSet.next()) {
                guardianid = resultSet.getInt("guardianID");
                contact = resultSet.getString("contact");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                email = resultSet.getString("email");
                
                bean = new GuardianBean();

                bean.setGuardianID(guardianid);
                bean.setContact(contact);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setEmail(email);
                
                list.add(bean);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public boolean editGuardian(GuardianBean guardian, int guardianID) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update guardian set contact=?, fname=?, lname=?, email=? where guardianID = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, guardian.getContact());
            ps.setString(2, guardian.getFname());
            ps.setString(3, guardian.getLname());
            ps.setString(4, guardian.getEmail());
            ps.setInt(5, guardianID);
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public GuardianBean getGuardianByName(String fname, String lname) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from guardian where fname = ? and lname = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ResultSet resultSet = ps.executeQuery();

            GuardianBean bean = new GuardianBean();

            int guardianid;
            String Fname, Lname, contact, email;

            while (resultSet.next()) {
                guardianid = resultSet.getInt("guardianID");
                contact = resultSet.getString("contact");
                Fname = resultSet.getString("fname");
                Lname = resultSet.getString("lname");
                email = resultSet.getString("email");

                bean = new GuardianBean();

                bean.setGuardianID(guardianid);
                bean.setContact(contact);
                bean.setFname(Fname);
                bean.setLname(Lname);
                bean.setEmail(email);

            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public GuardianBean getGuardianByTenant(String fname, String lname) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            
            TenantDAOImplementation tenantdao = new TenantDAOImplementation();
            TenantBean tenantbean = new TenantBean();
            
            tenantbean = tenantdao.getTenantByName(fname, lname);

            String query = "select * from tenantguardian where tg_tenantID = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, tenantbean.getTenantID());
            
            ResultSet resultSet = ps.executeQuery();
            
            GuardianBean bean = new GuardianBean();
            int guardianid;
            String Fname, Lname, contact, email;
            
            PreparedStatement ps2;
            ResultSet resultSet2;
            
            while (resultSet.next()) {
                guardianid = resultSet.getInt("tg_guardianID");
                query = "select * from guardian where guardianID = ?";
                ps2 = connection.prepareStatement(query);
                
                //System.out.println(guardianid);
                
                ps2.setInt(1, guardianid);
                resultSet2 = ps2.executeQuery();
                
                while(resultSet2.next()) {
                    contact = resultSet2.getString("contact");
                    Fname = resultSet2.getString("fname");
                    Lname = resultSet2.getString("lname");
                    email = resultSet2.getString("email");
                    
                    bean = new GuardianBean();

                    bean.setGuardianID(guardianid);
                    bean.setContact(contact);
                    bean.setFname(Fname);
                    bean.setLname(Lname);
                    bean.setEmail(email);
                }
            }
            
            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean assignTenantToGuardian(GuardianBean guardian, TenantBean tenant) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "insert into tenantguardian (tg_tenantID, tg_guardianID) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, tenant.getTenantID());
            ps.setInt(2, guardian.getGuardianID());
            ps.executeUpdate();
            connection.close();
            System.out.println(tenant.getTenantID());
            System.out.println(guardian.getGuardianID());
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<TenantBean> getTenantsRelatedToGuardian(int guardianID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "select * from tenant, tenantguardian, guardian where tenantID = tg_tenantID and guardianID = tg_guardianID and tg_guardianID = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, guardianID);
            ResultSet resultSet = ps.executeQuery();

            TenantBean bean = new TenantBean();
            ArrayList<TenantBean> list = new ArrayList<TenantBean>();
            int tenantID, expectedyearofgraduation;
            String Fname, Lname, gender, address, degree, school, status, contact, email;
            Blob image;
            
            while (resultSet.next()) {
                tenantID = resultSet.getInt("guardianID");
                Fname = resultSet.getString("fname");
                Lname = resultSet.getString("lname");
                image = resultSet.getBlob("image");
                contact = resultSet.getString("contact");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                email = resultSet.getString("email");
                expectedyearofgraduation = resultSet.getInt("expectedyearofgrad");
                status = resultSet.getString("status");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setFname(Fname);
                bean.setLname(Lname);
                bean.setImage(image);
                bean.setGender(gender);
                bean.setAddress(address);
                bean.setDegree(degree);
                bean.setSchool(school);
                bean.setExpectedyearofgrad(expectedyearofgraduation);
                bean.setStatus(status);
                bean.setEmail(email);
                
                list.add(bean);

            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
