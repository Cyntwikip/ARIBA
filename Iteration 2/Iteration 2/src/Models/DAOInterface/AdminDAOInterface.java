/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.AdminBean;

/**
 *
 * @author Danica
 */
public interface AdminDAOInterface {
    public boolean addAdmin(AdminBean bean);
    public boolean verifyAdmin(String username, String password);
    public boolean deleteAdmin(int username, String password);
}
