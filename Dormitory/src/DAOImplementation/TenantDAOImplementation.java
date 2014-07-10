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
    public boolean addTenant(TenantBean tenant) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into tenant (fname, lname, image, contact, gender, address, degree, school, expectedyearofgrad, status)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenant.getFname());
            ps.setString(2, tenant.getLname());
            ps.setBlob(3, tenant.getImage());
            ps.setInt(4, tenant.getContact());
            ps.setString(5, tenant.getGender());
            ps.setString(6, tenant.getAddress());
            ps.setString(7, tenant.getDegree());
            ps.setString(8, tenant.getSchool());
            ps.setInt(9, tenant.getExpectedyearofgrad());
            ps.setString(10, tenant.getStatus());
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
            
            int tenantID, contact, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status;
            Blob image;
            
            while(resultSet.next()){
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getInt("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
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
    public ArrayList<TenantBean> getAllTenants() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TenantBean getTenantByName(String fname, String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TenantBean> getTenantByExpectedYearofGrad(int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editTenant(TenantBean tenant, String fname, String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
