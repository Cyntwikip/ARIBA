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
            String query = "insert into guardian (guardianID, fname, lname, contact)"
                    + " values(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, guardian.getGuardianID());
            ps.setString(2, guardian.getFname());
            ps.setString(3, guardian.getLname());
            ps.setLong(4, guardian.getContact());
            
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

            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from guardian where guardianID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, guardianID);
            ResultSet resultSet = ps.executeQuery();
            
            GuardianBean bean = new GuardianBean();
            
            int guardianid;
            Long contact;
            String fname, lname;
            
            while(resultSet.next()){
                guardianid = resultSet.getInt("guardianID");
                contact = resultSet.getLong("contact");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
               
                bean = new GuardianBean();
                
                bean.setGuardianID(guardianID);
                bean.setContact(contact);
                bean.setFname(fname);
                bean.setLname(lname);
                
             }
            return bean;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    
    }

    @Override
    public ArrayList<GuardianBean> getAllGuardians() {

            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from guardian";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            GuardianBean bean = new GuardianBean();
            ArrayList<GuardianBean> list = new ArrayList<GuardianBean>();
            
            int guardianid;
            Long contact;
            String fname, lname;
            
            while(resultSet.next()){
                guardianid = resultSet.getInt("guardianID");
                contact = resultSet.getLong("contact");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
               
                bean = new GuardianBean();
                
                bean.setGuardianID(guardianid);
                bean.setContact(contact);
                bean.setFname(fname);
                bean.setLname(lname);
                
                list.add(bean);
             }
            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    
    }

    @Override
    public boolean editGuardian(GuardianBean guardian, String fname, String lname) {
      
            try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            
            String query = "update guardian set contact = ? where fname = ? and lname = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, guardian.getContact());
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return false;
    }

    @Override
    public GuardianBean getGuardianByName(String fname, String lname) {
 
            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from guardian where fname = ? and lname = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ResultSet resultSet = ps.executeQuery();
            
            GuardianBean bean = new GuardianBean();
            
            int guardianid;
            Long contact;
            String Fname, Lname;
            
            while(resultSet.next()){
                guardianid = resultSet.getInt("guardianID");
                contact = resultSet.getLong("contact");
                Fname = resultSet.getString("fname");
                Lname = resultSet.getString("lname");
               
                bean = new GuardianBean();
                
                bean.setGuardianID(guardianid);
                bean.setContact(contact);
                bean.setFname(Fname);
                bean.setLname(Lname);
                
             }
            return bean;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    
    }

    @Override
    public ArrayList<GuardianBean> getGuardianByTenant(String fname, String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
