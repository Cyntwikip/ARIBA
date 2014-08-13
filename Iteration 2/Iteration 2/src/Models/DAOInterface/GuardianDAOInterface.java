/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.GuardianBean;
import Models.Beans.TenantBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface GuardianDAOInterface {
    
    public boolean addGuardian(GuardianBean guardian);
    public boolean editGuardian (GuardianBean guardian, int guardianID);
    public boolean assignTenantToGuardian (GuardianBean guardian, TenantBean tenant);
    public GuardianBean getGuardianByID(int guardianID);
    public GuardianBean getGuardianByName(String fname, String lname);
    public GuardianBean getGuardianByTenant(String fname, String lname);
    public GuardianBean getGuardianByTenantID(int tenantID);
    public ArrayList<GuardianBean> getAllGuardians();
    public ArrayList<TenantBean> getTenantsRelatedToGuardian(int guardianID);
    public GuardianBean searchGuardianByName(String name);
    public boolean deleteGuardian(GuardianBean guardian);
    public boolean deleteAssignedTenantGuardian(TenantBean tenant);
    
}
