/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.sql.Date;

/**
 *
 * @author User
 */
public class ContractBean {
    
    private int contractID;
    private int contract_tenantID;
    private Date effectivedate;
    private Date expirydate;

    public int getContractID() {
        return contractID;
    }

    public int getContract_tenantID() {
        return contract_tenantID;
    }

    public Date getEffectivedate() {
        return effectivedate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public void setContract_tenantID(int contract_tenantID) {
        this.contract_tenantID = contract_tenantID;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }
    
    
}
