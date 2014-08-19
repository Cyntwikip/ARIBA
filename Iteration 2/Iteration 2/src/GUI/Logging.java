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
import Models.DAOInterface.TenantDAOInterface;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jao
 */
public class Logging extends javax.swing.JFrame {

    /**
     * Creates new form Logging
     */
    private AttendanceLogDAOImplementation logdao = new AttendanceLogDAOImplementation();
    private DefaultTableModel model;
    private Object[] obj = {"", "", ""};

    public Logging() {
        initComponents();

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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 450));
        setMinimumSize(new java.awt.Dimension(800, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imgoingout.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 300, 190, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/imcomingin.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(70, 350, 190, 40);

        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 20, 100, 30);

        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(140, 20, 110, 30);

        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(250, 20, 100, 30);

        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(460, 20, 110, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time - IN", "Time - OUT"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 80, 452, 320);

        jLabel2.setText("Current Date and Time HERE! ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 130, 190, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logging-peg-edited.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // in

        int col = 0;
        int row = jTable1.getSelectedRow();
        Object tenant = jTable1.getModel().getValueAt(row, 0);
        String tenantID = tenant.toString().substring(0, 1);
        System.out.println(tenantID);
        int tenantid = Integer.parseInt(tenantID);

        TenantDAOImplementation tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tenantid);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // out

        int col = 0;
        int row = jTable1.getSelectedRow();
        Object tenant = jTable1.getModel().getValueAt(row, 0);
        String tenantID = tenant.toString().substring(0, 1);
        System.out.println(tenantID);
        int tenantid = Integer.parseInt(tenantID);

        System.out.println(tenantid);
        TenantDAOImplementation tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tenantid);

        ArrayList<AttendanceLogBean> alist = new ArrayList<AttendanceLogBean>();
        AttendanceLogBean alistout = new AttendanceLogBean();
        AttendanceLogBean alistin = new AttendanceLogBean();
        alist = logdao.getAllAtendanceLogsByTenantID(tenantid);
        alistout = logdao.getLatestLogoutByTenant(tenantid);
        alistin = logdao.getLatestLoginByTenant(tenantid);

        if (bean.getFname() == null) {
            JOptionPane.showMessageDialog(null, "No tenant ID " + tenantid);
            //      jTextField1.setText("");
        } else if (alist.isEmpty()) {
            Calendar c = Calendar.getInstance();
            Timestamp time = new Timestamp(c.getTimeInMillis());

            AttendanceLogBean logbean = new AttendanceLogBean();
            logbean.setLog_tenantID(tenantid);
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
            logbean.setLog_tenantID(tenantid);
            logbean.setTimeLogged(time);
            logbean.setIsIn(false);

            logdao.addAttendanceLogDAOInterface(logbean);

            //       jTextField1.setText("");
            updateTable1();
        } else {
            JOptionPane.showMessageDialog(null, "You are not allowed to log out. Log in first before logging out."); // di balance yung log in
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainMenu tenant = new MainMenu();
        tenant.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Room room = new Room();
        room.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Bills bill = new Bills();
        bill.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Reports report = new Reports();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logging.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logging.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logging.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logging.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logging().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
