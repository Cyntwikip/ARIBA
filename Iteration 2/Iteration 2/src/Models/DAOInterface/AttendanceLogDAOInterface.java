/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.AttendanceLogBean;
import Models.Beans.TenantBean;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface AttendanceLogDAOInterface {
    // do something here
    public boolean addAttendanceLogDAOInterface (AttendanceLogBean attendance);
    public boolean editAttendanceLog(AttendanceLogBean attendance);
    public AttendanceLogBean getLatestLoginByTenant(int tenantID);
    public AttendanceLogBean getLatestLogoutByTenant(int tenantID);
    public ArrayList<AttendanceLogBean> getLogsToday();
    public ArrayList<AttendanceLogBean> getAllLogs(); //needed ba to haha
    public ArrayList<AttendanceLogBean> getAllAtendanceLogsByTenantID(int log_tenantID);
    public ArrayList<AttendanceLogBean> getAllAtendanceLogsTodayByTenantID(int tenantID);
    public ArrayList<AttendanceLogBean> checkLogin();
    public ArrayList<AttendanceLogBean> checkLogout();
}
