/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.AttendanceLogBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface AttendanceLogDAOInterface {
    // do something here
    public boolean addAttendanceLogDAOInterface (AttendanceLogBean attendance);
    
    public ArrayList<AttendanceLogBean> getAllLogs(); //needed ba to haha
    public ArrayList<AttendanceLogBean> getAllAtendanceLogsByTenantID(int log_tenantID);
    public ArrayList<AttendanceLogBean> getAllAttendanceLogsByName (String fname, String lname);
}
