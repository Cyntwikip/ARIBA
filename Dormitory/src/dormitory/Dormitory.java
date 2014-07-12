/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dormitory;

import Beans.GuardianBean;
import Beans.TenantBean;
import DAOImplementation.GuardianDAOImplementation;
import DAOImplementation.TenantDAOImplementation;
import DAOInterface.GuardianDAOInterface;
import DAOInterface.TenantDAOInterface;

/**
 *
 * @author User
 */
public class Dormitory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int number = 123;
        TenantBean tenant1 = new TenantBean();
            tenant1.setAddress("Address:(");
            tenant1.setContact(number);
            tenant1.setDegree("CS");
            tenant1.setExpectedyearofgrad(2016);
            tenant1.setFname("Fname1");
            tenant1.setGender("female");
            tenant1.setLname("Lname");
            tenant1.setSchool("SCHOOL!!!");
            tenant1.setStatus(true);
            
            TenantDAOInterface tdao = new TenantDAOImplementation();
       //     tdao.addTenant(tenant1);
       //     tdao.editTenant(tenant1, "Fname1", "Lname");
         
            GuardianBean guardian1 = new GuardianBean();
            guardian1.setContact(number);
            guardian1.setFname("Sherlock");
            guardian1.setLname("Holmes");
            
            GuardianDAOInterface gdao = new GuardianDAOImplementation();
            gdao.addGuardian(guardian1);
            
    }
    
}
