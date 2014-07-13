/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.AttendanceLogBean;
import Models.Beans.TenantBean;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface AttendanceLogDAOInterface {
    // do something here
    public boolean addAttendanceLogDAOInterface (AttendanceLogBean attendance);
    public void editAttendanceLog(AttendanceLogBean attendance);
    public ArrayList<AttendanceLogBean> getAllLogs(); //needed ba to haha
    public ArrayList<AttendanceLogBean> getAllAtendanceLogsByTenantID(int log_tenantID);
    public ArrayList<AttendanceLogBean> getAllAttendanceLogsByName (String fname, String lname);
    public ArrayList<AttendanceLogBean> getAllLogin();
    public TenantBean checkLogin();
    public TenantBean checkLogout();
    public ArrayList<TenantBean> checkAllTenantByTime(Time time);
}
