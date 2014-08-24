/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Beans.AttendanceLogBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.AttendanceLogDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.AttendanceLogDAOInterface;
import Models.DAOInterface.TenantDAOInterface;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jao
 */
public class TenantLoggingPanel extends javax.swing.JPanel {

    /**
     * Creates new form LogginPanel
     */
    private AttendanceLogDAOImplementation logdao = new AttendanceLogDAOImplementation();
    private DefaultTableModel model;
    private Object[] obj = {"", "", ""};

    public TenantLoggingPanel() {
        initComponents();
        java.util.Date currentdate = new java.util.Date();
        int month = currentdate.getMonth();
        int day = currentdate.getDay();
        int year = currentdate.getYear();

        jLabel2.setText(month + " " + day + " " + year);
        model = (DefaultTableModel) jTable1.getModel();

        updateTable();

        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());
    }

    public void updateTable() {
        AttendanceLogBean abean = new AttendanceLogBean();
        AttendanceLogBean in = new AttendanceLogBean();
        AttendanceLogBean out = new AttendanceLogBean();
        ArrayList<AttendanceLogBean> alist = new ArrayList<AttendanceLogBean>();
        ArrayList<TenantBean> tlist = new ArrayList<TenantBean>();

        TenantBean tbean = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();

        tlist = tdao.getAllTenants();
        System.out.println(tlist.size());
        for (int i = 0; i < tlist.size(); i++) {
            tbean = tlist.get(i);
            System.out.println(tbean.getFname());
            in = logdao.getLatestLoginByTenant(tbean.getTenantID());
            out = logdao.getLatestLogoutByTenant(tbean.getTenantID());
            String lname = tbean.getLname();
            String fname = tbean.getFname();
            String tenantid = Integer.toString(tbean.getTenantID());
            if (in == null && out == null) {

                Object[] obj = {tenantid + "-" + lname + ", " + fname, "", ""};
                model.addRow(obj);
            } else if (out == null) {
                Object[] obj = {tenantid + "-" + lname + ", " + fname, in.getTimeLogged(), " "};
                model.addRow(obj);
            } else if (in == null) {
                Object[] obj = {tenantid + "-" + lname + ", " + fname, " ", out.getTimeLogged()};
                model.addRow(obj);
            } else {
                Object[] obj = {tenantid + "-" + lname + ", " + fname, in.getTimeLogged(), out.getTimeLogged()};
                model.addRow(obj);
            }
        }
    }

    public void updateTable1() {

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        AttendanceLogBean abean = new AttendanceLogBean();
        AttendanceLogBean in = new AttendanceLogBean();
        AttendanceLogBean out = new AttendanceLogBean();
        ArrayList<AttendanceLogBean> alist = new ArrayList<AttendanceLogBean>();
        ArrayList<TenantBean> tlist = new ArrayList<TenantBean>();

        TenantBean tbean = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();

        alist = logdao.getLogsToday();
        tlist = tdao.getAllTenants();

        for (int i = 0; i < tlist.size(); i++) {
            tbean = tlist.get(i);

            in = logdao.getLatestLoginByTenant(tbean.getTenantID());
            out = logdao.getLatestLogoutByTenant(tbean.getTenantID());
            String lname = tbean.getLname();
            String fname = tbean.getFname();
            String tenantid = Integer.toString(tbean.getTenantID());
            if (in == null && out == null) {

                Object[] obj = {tenantid + "-" + lname + ", " + fname, "", ""};
                model.addRow(obj);
            } else if (out == null) {
                Object[] obj = {tenantid + "-" + lname + ", " + fname, in.getTimeLogged(), " "};
                model.addRow(obj);
            } else if (in == null) {
                Object[] obj = {tenantid + "-" + lname + ", " + fname, " ", out.getTimeLogged()};
                model.addRow(obj);
            } else {
                Object[] obj = {tenantid + "-" + lname + ", " + fname, in.getTimeLogged(), out.getTimeLogged()};
                model.addRow(obj);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setLayout(null);

        jLabel2.setText("Date Label");
        add(jLabel2);
        jLabel2.setBounds(190, 210, 120, 14);

        jLabel3.setText("Time Label");
        add(jLabel3);
        jLabel3.setBounds(190, 250, 90, 14);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(140, 340, 170, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/imgoingout.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(130, 420, 190, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/imcomingin.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(130, 470, 190, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time - IN", "Time - OUT"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(400, 80, 540, 520);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/logging-tab-peg-edited.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // out

        /*  int col = 0;
         int row = jTable1.getSelectedRow();

         String lname = (String) jTable1.getValueAt(row, 0);
         String fname = lname.substring(lname.indexOf(' '), lname.length()-1);
         System.out.println(lname);
         System.out.println(fname);

         */
        
        int tenantID = Integer.valueOf(jTextField1.getText());
        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean tbean = tdao.getTenantById(tenantID);

        System.out.println(tbean.getTenantID());
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tbean.getTenantID());

        ArrayList<AttendanceLogBean> alist = new ArrayList<AttendanceLogBean>();
        AttendanceLogBean alistout = new AttendanceLogBean();
        AttendanceLogBean alistin = new AttendanceLogBean();
        alist = logdao.getAllAtendanceLogsByTenantID(tbean.getTenantID());
        alistout = logdao.getLatestLogoutByTenant(tbean.getTenantID());
        alistin = logdao.getLatestLoginByTenant(tbean.getTenantID());

        if (bean.getFname() == null) {
            JOptionPane.showMessageDialog(null, "No tenant ID " + tbean.getTenantID());
            //      jTextField1.setText("");
        } else if (alist.isEmpty()) {
            Calendar c = Calendar.getInstance();
            Timestamp time = new Timestamp(c.getTimeInMillis());

            AttendanceLogBean logbean = new AttendanceLogBean();
            logbean.setLog_tenantID(tbean.getTenantID());
            logbean.setTimeLogged(time);
            logbean.setIsIn(false);

            logdao.addAttendanceLogDAOInterface(logbean);

            //      jTextField1.setText("");
            updateTable1();
        } else if (alist.get(0).getIsIn()) { // isIn = true

            System.out.println("true!");
            Calendar c = Calendar.getInstance();
            Timestamp time = new Timestamp(c.getTimeInMillis());

            AttendanceLogBean logbean = new AttendanceLogBean();
            logbean.setLog_tenantID(tbean.getTenantID());
            logbean.setTimeLogged(time);
            logbean.setIsIn(false);

            logdao.addAttendanceLogDAOInterface(logbean);

            //       jTextField1.setText("");
            updateTable1();
        } else {
            JOptionPane.showMessageDialog(null, "You are not allowed to log out. Log in first before logging out."); // di balance yung log in
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // in

        int tenantID = Integer.valueOf(jTextField1.getText());
        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean tbean = tdao.getTenantById(tenantID);

        System.out.println(tbean.getTenantID());
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tbean.getTenantID());

        int tenantid = bean.getTenantID();

        AttendanceLogBean alistout = new AttendanceLogBean();
        AttendanceLogBean alistin = new AttendanceLogBean();
        ArrayList<AttendanceLogBean> alist = new ArrayList<AttendanceLogBean>();
        alist = logdao.getAllAtendanceLogsByTenantID(tenantid);
        alistout = logdao.getLatestLogoutByTenant(tenantid);
        alistin = logdao.getLatestLoginByTenant(tenantid);

        if (bean.getFname() == null) {
            JOptionPane.showMessageDialog(null, "No tenant ID " + tenantid);

        } else if (alist.isEmpty()) {
            Calendar c = Calendar.getInstance();
            Timestamp time = new Timestamp(c.getTimeInMillis());

            AttendanceLogBean logbean = new AttendanceLogBean();
            logbean.setLog_tenantID(tenantid);
            logbean.setTimeLogged(time);
            logbean.setIsIn(true);

            logdao.addAttendanceLogDAOInterface(logbean);

            updateTable1();

        } else if (!alist.get(0).getIsIn()) {
            Calendar c = Calendar.getInstance();
            Timestamp time = new Timestamp(c.getTimeInMillis());

            AttendanceLogBean logbean = new AttendanceLogBean();
            logbean.setLog_tenantID(tenantid);
            logbean.setTimeLogged(time);
            logbean.setIsIn(true);

            logdao.addAttendanceLogDAOInterface(logbean);

            updateTable1();

        } else {
            JOptionPane.showMessageDialog(null, "You are not allowed to log in. Log out first before logging in again.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        String input = "";
        String trim1;
        String trim2;
        String re1 = "^[0-9]*$";
        int last;
        if (!jTextField1.getText().isEmpty()) {
            input = jTextField1.getText();
        }

        if (input.matches(re1)) { // number
            if (input.length() > 11) {
                trim1 = input.substring(0, input.length() - 1);
                input = trim1;
            }// more than 11 numbers

        } else {

            trim1 = input.substring(0, input.indexOf(c));//first to index of character;
            trim2 = input.substring(input.indexOf(c) + 1);
            input = trim1 + trim2;
        }

        jTextField1.setText(input);

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    public void preventDigit(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            System.out.println("digit");
            evt.setKeyCode(KeyEvent.VK_BACK_SPACE);
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
