/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.ContractBean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ContractDAOInterface {
    
    // do something here
    
    public boolean addContract(ContractBean contract);
    public ArrayList <ContractBean> getAllContracts();
    public ArrayList<ContractBean> getAllContractsByTenantID(int contract_tenantID);
    public ArrayList<ContractBean> getAllContractsByDate(Date from, Date to);
}
