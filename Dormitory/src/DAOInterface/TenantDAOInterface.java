/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.TenantBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface TenantDAOInterface {
    
    public boolean addTenant(TenantBean tenant);
    
    public TenantBean getTenantById(int tenantid);
    public ArrayList<TenantBean> getAllTenants();
    public TenantBean getTenantByName (String fname, String lname);
    public ArrayList<TenantBean> getTenantByExpectedYearofGrad (int year);
    
    // assign tenant to room??
    
    public boolean editTenant (TenantBean tenant, String fname, String lname);
    
    public ArrayList<TenantBean> getTenantByRoomID(int tenant_roomID);
    
}
