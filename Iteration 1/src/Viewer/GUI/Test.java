/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Viewer.GUI;

import Models.Beans.AttendanceLogBean;
import Models.Beans.ContractBean;
import Models.Beans.GuardianBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.AttendanceLogDAOImplementation;
import Models.DAOImplementation.ContractDAOImplementation;
import Models.DAOImplementation.GuardianDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Danica
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ContractDAOImplementation cdao = new ContractDAOImplementation();
        ArrayList<ContractBean> contractlist = new ArrayList<ContractBean>();
            
        contractlist = cdao.getAllContractsByTenantID(4);
        
        System.out.println(contractlist.size());
        
        //RoomDAOImplementation rdao = new RoomDAOImplementation();
        */
        
        AttendanceLogBean bean = new AttendanceLogBean();
        AttendanceLogDAOImplementation dao = new AttendanceLogDAOImplementation();
        
        bean.setIsIn(false);
        bean.setLog_tenantID(1);
        
        dao.addAttendanceLogDAOInterface(bean);
        
    }
    
}
