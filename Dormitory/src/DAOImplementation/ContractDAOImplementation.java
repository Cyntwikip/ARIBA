/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOImplementation;

import Beans.ContractBean;
import DAOInterface.ContractDAOInterface;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ContractDAOImplementation implements ContractDAOInterface {

    @Override
    public boolean addContract(ContractBean contract) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
