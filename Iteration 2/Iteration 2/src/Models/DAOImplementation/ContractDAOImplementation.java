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
import java.sql.ResultSet;
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
            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from contract";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            ContractBean bean = new ContractBean();
            ArrayList<ContractBean> list = new ArrayList<ContractBean>();
            
            int contractID, contract_tenantID;
            Date effectivedate, expirydate;
            //String status;
            
            while(resultSet.next()){
                contractID = resultSet.getInt("contractID");
                contract_tenantID = resultSet.getInt("contract_tenantID");
                effectivedate = resultSet.getDate("effectivedate");
                expirydate = resultSet.getDate("expirydate");
                
                
                bean = new ContractBean();
                
                bean.setContractID(contractID);
                bean.setContract_tenantID(contract_tenantID);
                bean.setEffectivedate(effectivedate);
                bean.setExpirydate(expirydate);
                
                list.add(bean);
             }
                     connection.close();

            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
      }

    @Override
    public ArrayList<ContractBean> getAllContractsByTenantID(int contract_tenantID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from contract where contract_tenantID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, contract_tenantID);
            ResultSet resultSet = ps.executeQuery();
            
            ContractBean bean = new ContractBean();
            ArrayList<ContractBean> contractlist = new ArrayList<ContractBean>();
            
            int contractID;
            Date effectivedate, expirydate;
            
            while(resultSet.next()) {
                contractID = resultSet.getInt("contractID");
                effectivedate = resultSet.getDate("effectivedate");
                expirydate = resultSet.getDate("expirydate");
                
                bean.setContractID(contractID);
                bean.setContract_tenantID(contract_tenantID);
                bean.setEffectivedate(effectivedate);
                bean.setExpirydate(expirydate);
                
                contractlist.add(bean);
                bean = new ContractBean();
            }
                     connection.close();

            return contractlist;
            
        } catch (SQLException ex) {
            Logger.getLogger(ContractDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ContractBean> getAllContractsByDate(Date from, Date to) {
            try{
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from contract where expirydate "
                    + "BETWEEN '" + from + "' and '" + to + "'" ;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            ContractBean bean = new ContractBean();
            ArrayList<ContractBean> list = new ArrayList<ContractBean>();
            
            int contractID, contract_tenantID;
            Date effectivedate, expirydate;
            //String status;
            
            while(resultSet.next()){
                contractID = resultSet.getInt("contractID");
                contract_tenantID = resultSet.getInt("contract_tenantID");
                effectivedate = resultSet.getDate("effectivedate");
                expirydate = resultSet.getDate("expirydate");
                
                
                bean = new ContractBean();
                
                bean.setContractID(contractID);
                bean.setContract_tenantID(contract_tenantID);
                bean.setEffectivedate(effectivedate);
                bean.setExpirydate(expirydate);
                
                list.add(bean);
             }
                     connection.close();

            return list;
        }   catch(SQLException ex){
        Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
}
