/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Beans.TenantBean;
import Connector.Connector;
import DAOInterface.TenantDAOInterface;
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
public class TenantDAOImplementation implements TenantDAOInterface {

    @Override
    public boolean addTenant(TenantBean tenant) { // important
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into tenant (tenantID, fname, lname, image, contact, gender, address, degree, school, expectedyearofgrad, status)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tenant.getTenantID());
            ps.setString(2, tenant.getFname());
            ps.setString(3, tenant.getLname());
            ps.setBlob(4, tenant.getImage());
            //ps.setLong(5, 639166267392L);
            ps.setLong(5, tenant.getContact());
            ps.setString(6, tenant.getGender());
            ps.setString(7, tenant.getAddress());
            ps.setString(8, tenant.getDegree());
            ps.setString(9, tenant.getSchool());
            ps.setInt(10, tenant.getExpectedyearofgrad());
            ps.setBoolean(11, tenant.getStatus());
            ps.executeUpdate();
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return false;
    }

    @Override
    public TenantBean getTenantById(int tenantid) {
        try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where tenantID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tenantid);
            ResultSet resultSet = ps.executeQuery();
            
            TenantBean bean = new TenantBean();
            
            int tenantID, expectedyearofgrad;
            Long contact;
            String fname, lname, gender, address, degree, school;
            boolean status;
            Blob image;
            
            while(resultSet.next()){
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getLong("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getBoolean("status");
                image = resultSet.getBlob("image");
               
                bean = new TenantBean();
                
                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
                bean.setImage(image);
            }
            return bean;
    
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;       
    }

    @Override
    public ArrayList<TenantBean> getAllTenants() { // important
                try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<TenantBean> list = new ArrayList<TenantBean>();
            TenantBean bean = new TenantBean();
            
            int tenantID, expectedyearofgrad;
            Long contact;
            String fname, lname, gender, address, degree, school;
            Blob image;
            boolean status;
            
            while(resultSet.next()){
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getLong("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getBoolean("status");
                image = resultSet.getBlob("image");
               
                bean = new TenantBean();
                
                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
                bean.setImage(image);
                list.add(bean);
            }
            return list;
    
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;    
    }

    @Override
    public TenantBean getTenantByName(String firstname, String lastname) { // important

            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where fname = ? and lname = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ResultSet resultSet = ps.executeQuery();
            
            TenantBean bean = new TenantBean();
            
            int tenantID, expectedyearofgrad;
            Long contact;
            String fname, lname, gender, address, degree, school;
            boolean status;
            Blob image;
            
            while(resultSet.next()){
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getLong("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getBoolean("status");
                image = resultSet.getBlob("image");
               
                bean = new TenantBean();
                
                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
                bean.setImage(image);
            }
            return bean;
    
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;       
    }

    @Override
    public ArrayList<TenantBean> getTenantByExpectedYearofGrad(int year) {
  
            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where expectedyearofgrad = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, year);
            ResultSet resultSet = ps.executeQuery();
            
            ArrayList<TenantBean> list = new ArrayList<TenantBean>();
            TenantBean bean = new TenantBean();
            
            int tenantID, expectedyearofgrad;
            Long contact;
            String fname, lname, gender, address, degree, school;
            boolean status;
            Blob image;
            
            while(resultSet.next()){
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getLong("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getBoolean("status");
                image = resultSet.getBlob("image");
               
                bean = new TenantBean();
                
                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
                bean.setImage(image);
                
                list.add(bean);
            }
            return list;
    
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;   
    
    }

    @Override
    public boolean editTenant(TenantBean tenant, String fname, String lname) {
     
            try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            
            String query = "update tenant set image = ?, contact = ?, gender = ?, address = ?, degree = ?, school = ?, expectedyearofgrad = ?, status=? where fname = ? and lname = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBlob(1, tenant.getImage());
            ps.setDouble(2, tenant.getContact());
            ps.setString(3, tenant.getGender());
            ps.setString(4, tenant.getAddress());
            ps.setString(5, tenant.getDegree());
            ps.setString(6, tenant.getSchool());
            ps.setInt(7, tenant.getExpectedyearofgrad());
            ps.setBoolean(8, tenant.getStatus());
            ps.setString(9, fname);
            ps.setString(10, lname);
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return false;
    }

    @Override
    public ArrayList<TenantBean> getTenantByRoomID(int tenant_roomID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TenantBean> TenantBySchool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TenantBean> getMaleTenant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TenantBean> getFemaleTenant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TenantBean> getTenantByStatus(boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
