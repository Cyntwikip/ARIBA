/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.TenantBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface TenantDAOInterface {
    
    public boolean addTenant(TenantBean tenant); // important
    public boolean editTenant (TenantBean tenant);
    public ArrayList<TenantBean> getAllTenants(); // important
    public TenantBean getTenantById(int tenantid);
    public ArrayList<TenantBean> getTenantBySchool(String school);
    public TenantBean getTenantByName (String fname, String lname);
    public ArrayList<TenantBean> getTenantListByName (String fname, String lname);
    public ArrayList<TenantBean> getTenantByDegree(String degree);
    public ArrayList<TenantBean> getMaleTenant();
    public ArrayList<TenantBean> getFemaleTenant();
    public ArrayList<TenantBean> getTenantByStatus(String status);
    public ArrayList<TenantBean> getTenantByExpectedYearofGrad (int year);
    public ArrayList<TenantBean> getTenantByRoomID(int tenant_roomID);
    
}
