/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.ContractBean;
import Models.Connector.Connector;
import Models.DAOInterface.ContractDAOInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ContractDAOImplementation implements ContractDAOInterface {

    @Override
    public boolean addContract(ContractBean contract) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into contract (contract_tenantID, effectivedate, expirydate) values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, room.getStatus());
            ps.setInt(1, contract.getContract_tenantID());
            ps.setDate(2, contract.getEffectivedate());
            ps.setDate(3, contract.getExpirydate());
            ps.executeUpdate();
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }

    @Override
    public ArrayList<ContractBean> getAllContracts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ContractBean> getAllContractsByTenantID(int contract_tenantID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ContractBean> getAllContractsByDate(Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
