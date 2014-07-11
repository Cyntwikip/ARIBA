/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.GuardianBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface GuardianDAOInterface {
    
    public boolean addGuardian(GuardianBean guardian);
    
    public GuardianBean getGuardianByID(int guardianID);
    public GuardianBean getGuardianByName(String fname, String lname);
    public ArrayList<GuardianBean> getAllGuardians();
    
    public boolean editGuardian (GuardianBean guardian, String fname, String lname);
    
}
