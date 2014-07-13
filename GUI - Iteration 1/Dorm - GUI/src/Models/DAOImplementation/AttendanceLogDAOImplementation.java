/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.AttendanceLogBean;
import Models.Beans.TenantBean;
import Models.DAOInterface.AttendanceLogDAOInterface;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AttendanceLogDAOImplementation implements AttendanceLogDAOInterface {

    @Override
    public boolean addAttendanceLogDAOInterface(AttendanceLogBean attendance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AttendanceLogBean> getAllLogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AttendanceLogBean> getAllAtendanceLogsByTenantID(int log_tenantID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AttendanceLogBean> getAllAttendanceLogsByName(String fname, String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAttendanceLog(AttendanceLogBean attendance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AttendanceLogBean> getAllLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TenantBean checkLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TenantBean checkLogout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TenantBean> checkAllTenantByTime(Time time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
