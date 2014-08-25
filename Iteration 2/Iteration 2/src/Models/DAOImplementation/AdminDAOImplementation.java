/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.AdminBean;
import Models.Connector.Connector;
import Models.DAOInterface.AdminDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danica
 */
public class AdminDAOImplementation implements AdminDAOInterface {

    @Override
    public boolean addAdmin(AdminBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifyAdmin(String username, String password) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from admin where username = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            
            AdminBean bean = new AdminBean();
            int adminid;
            String fname, lname, user, pass;
            
            while(resultSet.next()) {
                adminid = resultSet.getInt("adminID");
                fname = resultSet.getString("FirstName");
                lname = resultSet.getString("LastName");
                user = resultSet.getString("username");
                pass = resultSet.getString("password");
                
                bean.setAdminID(adminid);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setUsername(user);
                bean.setPassword(pass);
                
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(int username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
