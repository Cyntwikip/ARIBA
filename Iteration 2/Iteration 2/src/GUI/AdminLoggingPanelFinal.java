/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Beans.AdminBean;
import Models.Beans.AttendanceLogBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.AdminDAOImplementation;
import Models.DAOImplementation.AttendanceLogDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.AttendanceLogDAOInterface;
import Models.DAOInterface.TenantDAOInterface;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giodee
 */
public class AdminLoggingPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form AdminLoggingPanelFinal
     */
    private AttendanceLogDAOInterface logdao = new AttendanceLogDAOImplementation();
    private DefaultTableModel model;
    private Object[] obj = {"", "", ""};

    public AdminLoggingPanelFinal() {
        initComponents();

        model = (DefaultTableModel) jTable1.getModel();
        updateTable();

        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());

        jButton3.setBackground(java.awt.Color.GREEN);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setPreferredSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time - IN", "Time - OUT"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(250, 20, 690, 460);

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(830, 510, 100, 30);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Admin Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 140, 40);

        jButton2.setText("Create new admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 393, 140, 40);

        jButton3.setBackground(new java.awt.Color(0, 51, 0));
        jButton3.setForeground(new java.awt.Color(0, 51, 0));
        jButton3.setText("Edit account");
        jButton3.setBorder(null);
        jButton3.setName(""); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(30, 340, 140, 40);

        jLabel3.setText("<admin name here>");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 70, 130, 40);

        add(jPanel1);
        jPanel1.setBounds(50, 20, 190, 450);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/logging-tab-peg-clear-panel.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 596));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // create new admin

        JLabel jUserName = new JLabel("Username:");
        JTextField userName = new JTextField();
     
        JLabel jFirstName = new JLabel("First name: ");
        JTextField firstName = new JTextField();
        
        JLabel jLastName = new JLabel("Last name: ");
        JTextField lastName = new JTextField();
        
        JLabel jPassword = new JLabel("Password");
        JTextField password = new JPasswordField();
        
        Object[] ob = {jUserName, userName, jFirstName, firstName, jLastName, lastName, jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Admin Login", JOptionPane.OK_CANCEL_OPTION);

        AdminBean bean = new AdminBean();
        
        if (result == JOptionPane.OK_OPTION) {
            if (userName == null || password == null ) {
               // 
                System.out.println("Here");
            
            } else {
                AdminDAOImplementation admindao = new AdminDAOImplementation();
                
                bean.setFname(userName.getText());
                bean.setLname(lastName.getText());
                bean.setPassword(password.getText());
                bean.setUsername(userName.getText());
                if (admindao.addAdmin(bean)) {
                    System.out.println("successful");
                } else {
                    System.out.println("not successful.");
                    /*
                     JLabel incorrect = new JLabel("The username or password you entered is incorrect.");
                     incorrect.setForeground(Color.RED);
                     Object[] obj = {jUserName, userName, jPassword, password, incorrect};
                     result = JOptionPane.showConfirmDialog(null, obj, "Admin Login", JOptionPane.OK_CANCEL_OPTION);
                     */
                }

            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        jPanel1 = new TenantLoggingPanel();
        setJpanel();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void setJpanel() {
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        this.add(jPanel1);
        jPanel1.setOpaque(true);
        jPanel1.setBounds(0, 10, 1000, 600);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
