/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Beans.GuardianBean;
import Connector.Connector;
import DAOInterface.GuardianDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public boolean addGuardian(GuardianBean guardian) {
                try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into guardian (fname, lname, contact)"
                    + " values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, guardian.getFname());
            ps.setString(2, guardian.getLname());
            ps.setInt(3, guardian.getContact());
            
            ps.executeUpdate();
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return false;
        
        
        
    }

    @Override
    public GuardianBean getGuardian(int guardianID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GuardianBean> getAllGuardians() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
