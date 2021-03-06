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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
    private AdminBean adminBean;

    public AdminLoggingPanelFinal(AdminBean bean) {
        initComponents();

        adminBean = bean;
        jLabel2.setText("Hi! " + adminBean.getFname() + " " + adminBean.getLname());
        model = (DefaultTableModel) jTable2.getModel();

        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());

        jButton3.setBackground(java.awt.Color.GREEN);

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);

        ArrayList<TenantBean> tb = new ArrayList<TenantBean>();
        TenantDAOInterface tdao = new TenantDAOImplementation();
        tb = tdao.getAllTenants();
        String fname, lname;
        int id;

        jComboBox1.addItem("Choose one");

        for (int i = 0; i < tb.size(); i++) {
            id = tb.get(i).getTenantID();
            fname = tb.get(i).getFname();
            lname = tb.get(i).getLname();

            String id1 = String.valueOf(id);
            jComboBox1.addItem(id1 + ": " + lname + ", " + fname);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setPreferredSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Originals/logout.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(730, 500, 200, 45);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Admin Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 140, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Originals/createnew.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(0, 380, 190, 40);

        jButton3.setBackground(new java.awt.Color(0, 51, 0));
        jButton3.setForeground(new java.awt.Color(0, 51, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Originals/edit.jpg"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setName(""); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(20, 320, 140, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Search by:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 70, 110, 15);

        jRadioButton1.setText("Log in");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(20, 90, 80, 23);

        jRadioButton2.setText("Log out");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(20, 120, 90, 23);

        jRadioButton3.setText("Name");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(20, 150, 80, 23);

        jComboBox1.setMaximumRowCount(500);
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(20, 180, 160, 20);

        add(jPanel1);
        jPanel1.setBounds(50, 20, 190, 450);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2);
        jScrollPane2.setBounds(440, 40, 490, 450);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/logging-tab-peg-clear-panel.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 596));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AdminDAOImplementation admindao = new AdminDAOImplementation();
        AdminBean bean = new AdminBean();
        AdminBean beanDB = admindao.getAdminByID(adminBean.getAdminID());
        boolean check;

        JLabel jUserName = new JLabel("Username:");
        JTextField userName = new JTextField(beanDB.getUsername());

        JLabel jFirstName = new JLabel("First name: ");
        JTextField firstName = new JTextField(beanDB.getFname());

        JLabel jLastName = new JLabel("Last name: ");
        JTextField lastName = new JTextField(beanDB.getLname());

        JLabel jPassword = new JLabel("Password");
        JTextField password = new JPasswordField(beanDB.getPassword());

        Object[] ob = {jUserName, userName, jFirstName, firstName, jLastName, lastName, jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Admin Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if (userName == null || password == null) {

            } else {
                bean.setFname(firstName.getText());
                bean.setLname(lastName.getText());
                bean.setPassword(password.getText());
                bean.setUsername(userName.getText());
                bean.setAdminID(adminBean.getAdminID());
                check = admindao.editAdmin(bean, adminBean.getAdminID());

                if (check) {
                    //successful
                    jLabel2.setText("Hi! " + bean.getFname() + " " + bean.getLname());

                } else {
                    //unsuccessful
                }
            }
        }
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
            if (userName == null || password == null) {
                // 
                System.out.println("Here");

            } else {
                AdminDAOImplementation admindao = new AdminDAOImplementation();

                bean.setFname(firstName.getText());
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

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        jComboBox1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:

        System.out.println(jTable2.getColumnCount());
        if (jTable2.getColumnCount() == 3) {
            TableColumn tcol = jTable2.getColumnModel().getColumn(jTable2.getColumnCount() - 1);
            jTable2.removeColumn(tcol);

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
        jComboBox1.setEnabled(false);

        searchLogin();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:

        if (jTable2.getColumnCount() == 3) {
            TableColumn tcol = jTable2.getColumnModel().getColumn(jTable2.getColumnCount() - 1);
            jTable2.removeColumn(tcol);

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
        jComboBox1.setEnabled(false);

        searchLogout();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

        int selected = jComboBox1.getSelectedIndex();
        System.out.println(selected);

        String id1 = (String) jComboBox1.getSelectedItem();

        if (!id1.equals("Choose one")) {
            String id = id1.substring(0, id1.indexOf(":"));

            int idfin = Integer.valueOf(id);
            System.out.println("ID" + id);
            TenantBean tb = new TenantBean();
            TenantDAOInterface tdao = new TenantDAOImplementation();
            tb = tdao.getTenantById(idfin);

            setTable(idfin);
        } else {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();

        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public void setJpanel() {
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        this.add(jPanel1);
        jPanel1.setOpaque(true);
        jPanel1.setBounds(0, 10, 1000, 600);
    }

    public void searchLogin() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        AttendanceLogDAOInterface ldao = new AttendanceLogDAOImplementation();
        ArrayList<AttendanceLogBean> abean = new ArrayList<AttendanceLogBean>();
        TenantBean tb = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();
        abean = ldao.getLogsToday();
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < abean.size(); i++) {

            if (abean.get(i).getIsIn()) {
                tb = tdao.getTenantById(abean.get(i).getLog_tenantID());

                java.sql.Timestamp ts = abean.get(i).getTimeLogged();
                int microFraction = ts.getNanos() / 1000;

                StringBuilder sb = new StringBuilder(fmt.format(ts));

                System.out.println(sb.toString());
                Object[] obj = {tb.getLname() + ", " + tb.getFname(), sb};
                model.addRow(obj);
            }

        }

    }

    public void searchLogout() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        AttendanceLogDAOInterface ldao = new AttendanceLogDAOImplementation();
        ArrayList<AttendanceLogBean> abean = new ArrayList<AttendanceLogBean>();
        TenantBean tb = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();
        abean = ldao.getLogsToday();
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < abean.size(); i++) {

            if (!abean.get(i).getIsIn()) {
                tb = tdao.getTenantById(abean.get(i).getLog_tenantID());

                java.sql.Timestamp ts = abean.get(i).getTimeLogged();
                int microFraction = ts.getNanos() / 1000;

                StringBuilder sb = new StringBuilder(fmt.format(ts));

                System.out.println(sb.toString());
                Object[] obj = {tb.getLname() + ", " + tb.getFname(), sb};
                model.addRow(obj);
            }

        }

    }

    public void setTable(int id) {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        AttendanceLogDAOInterface ldao = new AttendanceLogDAOImplementation();
        ArrayList<AttendanceLogBean> abeanin = new ArrayList<AttendanceLogBean>();
        ArrayList<AttendanceLogBean> abeanout = new ArrayList<AttendanceLogBean>();
        ArrayList<AttendanceLogBean> abean = new ArrayList<AttendanceLogBean>();
        AttendanceLogBean temp = new AttendanceLogBean();
        TenantBean tb = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();
        abeanin = ldao.getAllLogInByTenant(id);
        abeanout = ldao.getAllLogOutByTenant(id);
        abean = ldao.getAllAtendanceLogsTodayByTenantID(id);
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");

        int size = 0;
        if (abeanin.size() > abeanout.size()) {
            size = abeanin.size();
            System.out.println("ditosize");
        } else {
            size = abeanout.size();
            System.out.println("ditosasdize");
        }
        AttendanceLogBean tempout = ldao.getLatestLogoutByTenant(id);
        AttendanceLogBean tempin = ldao.getLatestLogoutByTenant(id);
        for (int i = 0; i < size; i++) {

            tb = tdao.getTenantById(id);
            java.sql.Timestamp ts = abeanin.get(i).getTimeLogged();
            int microFraction = ts.getNanos() / 1000;
            StringBuilder sb = new StringBuilder(fmt.format(ts)); //log in


            if ( abeanout.size() == i) {
                System.out.println("here");
                Object[] add = {tb.getLname() + ", " + tb.getFname(), sb + " ---- "};
                model.addRow(add);
                model.fireTableDataChanged();
            } else {
                         System.out.println("he1re");
 
                java.sql.Timestamp ts1 = abeanout.get(i).getTimeLogged();
                int microFraction1 = ts1.getNanos() / 1000;
                StringBuilder sb1 = new StringBuilder(fmt.format(ts1)); //log in

                Object[] add = {tb.getLname() + ", " + tb.getFname(), sb + " ---- " + sb1};
                model.addRow(add);
                model.fireTableDataChanged();
            }

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
