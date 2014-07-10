/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dormitory;

import Beans.TenantBean;
import DAOImplementation.TenantDAOImplementation;
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
            tenant1.setAddress("Address1");
            tenant1.setContact(number);
            tenant1.setDegree("CS");
            tenant1.setExpectedyearofgrad(2016);
            tenant1.setFname("Fname");
            tenant1.setGender("female");
            tenant1.setLname("Lname");
            tenant1.setSchool("School");
            tenant1.setStatus("new");
            
            TenantDAOInterface tdao = new TenantDAOImplementation();
            tdao.addTenant(tenant1);
            
            
    }
    
}
