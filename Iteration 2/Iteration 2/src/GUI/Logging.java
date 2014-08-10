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

    public Logging() {
        initComponents();

        updateTable();
        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());
    }

    public void updateTable() {

        AttendanceLogBean abean = new AttendanceLogBean();
        AttendanceLogBean in = new AttendanceLogBean();
        AttendanceLogBean out = new AttendanceLogBean();
        ArrayList<AttendanceLogBean> alist = new ArrayList<AttendanceLogBean>();

        TenantBean tbean = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();

        alist = logdao.getLogsToday();

        model = (DefaultTableModel) jTable1.getModel();

        int size = 0;
        if ((alist.size() % 2) == 0) {//EVEN
            size = alist.size() / 2;
        } else {
            size = (alist.size() / 2) + 1;
        }
        for (int i = 0; i < size; i++) {
            tbean = tdao.getTenantById(alist.get(i).getLog_tenantID());
            System.out.println(tbean.getTenantID());

            in = logdao.getLatestLoginByTenant(tbean.getTenantID());
            out = logdao.getLatestLogoutByTenant(tbean.getTenantID());

            String lname = tbean.getLname();
            String fname = tbean.getFname();

            if (in != null && out != null) { // may log-in and logout
                Timestamp intemp = in.getTimeLogged();
                Timestamp outtemp = out.getTimeLogged();
                Object[] obj = {lname + ", " + fname, intemp, outtemp};

                model.addRow(obj);
            } else {
                if (in == null) { // wala in
                    Timestamp outtemp = out.getTimeLogged();

                    Object[] obj = {lname + ", " + fname, " ", outtemp};
                    model.addRow(obj);
                } else {
                    Timestamp intemp = in.getTimeLogged();
                    Object[] obj = {lname + ", " + fname, intemp, " "};
                    model.addRow(obj);

                }

            }
            System.out.println(alist.size());

            // get tenant
        }

    }

    public void updateTable1() {

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        AttendanceLogBean abean = new AttendanceLogBean();
        AttendanceLogBean in = new AttendanceLogBean();
        AttendanceLogBean out = new AttendanceLogBean();
        ArrayList<AttendanceLogBean> alist = new ArrayList<AttendanceLogBean>();

        TenantBean tbean = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();

        alist = logdao.getLogsToday();

        int size = 0;
        if ((alist.size() % 2) == 0) {//EVEN
            size = alist.size() / 2;
        } else {
            size = (alist.size() / 2) + 1;
        }
        for (int i = 0; i < size; i++) {
            tbean = tdao.getTenantById(alist.get(i).getLog_tenantID());
            System.out.println(tbean.getTenantID());

            in = logdao.getLatestLoginByTenant(tbean.getTenantID());
            out = logdao.getLatestLogoutByTenant(tbean.getTenantID());

            String lname = tbean.getLname();
            String fname = tbean.getFname();

            if (in != null && out != null) { // may log-in and logout
                Timestamp intemp = in.getTimeLogged();
                Timestamp outtemp = out.getTimeLogged();
                Object[] obj = {lname + ", " + fname, intemp, outtemp};

                model.addRow(obj);
            } else {
                if (in == null) { // wala in
                    Timestamp outtemp = out.getTimeLogged();

                    Object[] obj = {lname + ", " + fname, " ", outtemp};
                    model.addRow(obj);
                } else {
                    Timestamp intemp = in.getTimeLogged();
                    Object[] obj = {lname + ", " + fname, intemp, " "};
                    model.addRow(obj);

                }

            }
            System.out.println(alist.size());

            // get tenant
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

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 450));
        setMinimumSize(new java.awt.Dimension(800, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(80, 250, 180, 40);

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
        jLabel1.setBounds(0, 0, 800, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int tenantid = Integer.parseInt(jTextField1.getText());

        TenantDAOImplementation tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tenantid);
        if (bean.getFname() == null) {
            JOptionPane.showMessageDialog(null, "No tenant ID " + tenantid);
            jTextField1.setText("");
        } else {
            Calendar c = Calendar.getInstance();
            Timestamp time = new Timestamp(c.getTimeInMillis());

            AttendanceLogBean logbean = new AttendanceLogBean();
            logbean.setLog_tenantID(tenantid);
            logbean.setTimeLogged(time);
            logbean.setIsIn(true);

            logdao.addAttendanceLogDAOInterface(logbean);

            jTextField1.setText("");

            updateTable1();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int tenantid = Integer.parseInt(jTextField1.getText());

        TenantDAOImplementation tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tenantid);

        if (bean.getFname() == null) {
            JOptionPane.showMessageDialog(null, "No tenant ID " + tenantid);
            jTextField1.setText("");
        } else {

            Calendar c = Calendar.getInstance();
            Timestamp time = new Timestamp(c.getTimeInMillis());

            AttendanceLogBean logbean = new AttendanceLogBean();
            logbean.setLog_tenantID(tenantid);
            logbean.setTimeLogged(time);
            logbean.setIsIn(false);

            logdao.addAttendanceLogDAOInterface(logbean);

            jTextField1.setText("");

            updateTable1();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Logging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
