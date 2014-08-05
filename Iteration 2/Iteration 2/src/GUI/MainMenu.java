package GUI;

import ErrorHandling.AccountException;
import ErrorHandling.CheckAccount;
import Models.Beans.GuardianBean;

import Models.Beans.RoomBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.GuardianDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.GuardianDAOInterface;
import Models.DAOInterface.TenantDAOInterface;
import com.google.common.io.ByteStreams;
import com.mysql.jdbc.Blob;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jao
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    private DefaultTableModel model;
    private CheckAccount c = new CheckAccount();
    private ArrayList<TenantBean> searchnamelist = new ArrayList<>();
    private TenantDAOImplementation tenantImpl = new TenantDAOImplementation();

    public MainMenu() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.removeItem(i);
        }
        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.addItem(i);
        }
        initTable();
    }

    public void initTable() {
        ArrayList<TenantBean> tenantlist = new ArrayList<>();
        tenantlist = tenantImpl.getAllTenants();
        initSearch(tenantlist);
    }

    public void searchName() {
        String name = NameField.getText();

        try {
            c.checkName(name, "Name");
            searchnamelist = tenantImpl.searchTenantName(name);
            initSearch(searchnamelist);

        } catch (AccountException ex) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }

    }

    public void searchSchool() {
        String school = SchoolField.getText();

        try {
            c.checkName(school, "School");
            searchnamelist = tenantImpl.getTenantBySchool(school);
            initSearch(searchnamelist);

        } catch (AccountException ex) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
    }

    public void searchDegree() {
        String degree = DegreeField.getText();

        try {
            c.checkName(degree, "Degree");
            searchnamelist = tenantImpl.getTenantByDegree(degree);
            initSearch(searchnamelist);

        } catch (AccountException ex) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
    }

    public void searchYear() {
        int year = Integer.parseInt(YearOfGraduationField.getSelectedItem().toString());

        searchnamelist = tenantImpl.getTenantByExpectedYearofGrad(year);
        initSearch(searchnamelist);

    }

    public void searchMale() {
        searchnamelist = tenantImpl.getMaleTenant();
        initSearch(searchnamelist);

    }

    public void searchFemale() {
        searchnamelist = tenantImpl.getFemaleTenant();
        initSearch(searchnamelist);
    }

    public void searchCurrent() {
        searchnamelist = tenantImpl.getTenantByStatus(CurrentField.getText());
        initSearch(searchnamelist);
    }

    public void searchOld() {
        searchnamelist = tenantImpl.getTenantByStatus(OldField.getText());
        initSearch(searchnamelist);
    }

    public TenantBean initializetenant() {
        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();

        int row = jTable1.getSelectedRow();
        int col = 0;
        int id = (Integer) jTable1.getValueAt(row, col);

        bean = tdao.getTenantById(id);

        return bean;

    }

    public void initSearch(ArrayList<TenantBean> list) {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (TenantBean tenant : list) {
            Object[] obj = {tenant.getTenantID(), tenant.getLname(), tenant.getFname()};
            model.addRow(obj);
        }
        if (!list.isEmpty()) {
            jTable1.addRowSelectionInterval(0, 0);
            getSelection();
        }
    }

    public void getSelection() {
        int row = jTable1.getSelectedRow();
        int col = 0;

        int tenantid = (Integer) jTable1.getModel().getValueAt(row, col);

        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tenantid);

        java.sql.Blob imgBlob = bean.getBlobimage();
        byte[] content = null;
        if (imgBlob != null) {
            try {
                content = imgBlob.getBytes(1L, (int) imgBlob.length());
            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon ik = new ImageIcon(content);
            java.awt.Image img = ik.getImage();
            java.awt.Image newimg = img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ik = new ImageIcon(newimg);
            imgLabel.setIcon(ik);
        }
        tenantID.setText(String.valueOf(bean.getTenantID()));
        lname.setText(bean.getLname());
        fname.setText(bean.getFname());
//             birthday.setText(java.sql.Date.toString(bean.getBirthday()));
        jLabel2.setText(bean.getAddress());
        jLabel3.setText(bean.getGender());
        contactno.setText(bean.getContact());
        email.setText(bean.getEmail());
        school.setText(bean.getSchool());
        degree.setText(bean.getDegree());
        yearofgraduation.setText(String.valueOf(bean.getExpectedyearofgrad()));
        DateFormat date = new SimpleDateFormat("MMMM d, yyyy");
        birthday.setText(date.format(bean.getBirthday()));

        GuardianDAOInterface gdao = new GuardianDAOImplementation();
        GuardianBean gbean = new GuardianBean();

        gbean = gdao.getGuardianByTenantID(tenantid);

        jLabel1.setText(gbean.getFname() + " " + gbean.getLname());
        guardiancontactno.setText(gbean.getContact());

        GuardianBean guardianbean = new GuardianBean();

        guardianbean = gdao.getGuardianByTenant(bean.getFname(), bean.getLname());
        guardianName.setText(guardianbean.getFname() + " " + guardianbean.getLname());
        guardiancontactno.setText(guardianbean.getContact());
        guardianEmail.setText(guardianbean.getEmail());

        /*
         RoomBean roombean = new RoomBean();
         RoomDAOImplementation roomdao = new RoomDAOImplementation();
        
         roombean = roomdao.getTenantRoom(tenantid);
         roomassignment.setText(String.valueOf(roombean.getRoomID()));
         */
        status.setText(bean.getStatus());

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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        tenantID = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        birthday = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        contactno = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        school = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        yearofgraduation = new javax.swing.JLabel();
        guardiancontactno = new javax.swing.JLabel();
        roomassignment = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        NameField = new javax.swing.JTextField();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        MaleField = new javax.swing.JRadioButton();
        FemaleField = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CurrentField = new javax.swing.JRadioButton();
        OldField = new javax.swing.JRadioButton();
        YearOfGraduationField = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        guardianName = new javax.swing.JLabel();
        guardianEmail = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1020, 560));
        setMinimumSize(new java.awt.Dimension(1020, 560));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(tenantID);
        tenantID.setBounds(810, 100, 90, 20);
        getContentPane().add(lname);
        lname.setBounds(800, 130, 100, 20);
        getContentPane().add(fname);
        fname.setBounds(810, 150, 90, 20);
        getContentPane().add(birthday);
        birthday.setBounds(800, 180, 180, 20);
        getContentPane().add(address);
        address.setBounds(800, 210, 180, 0);
        getContentPane().add(gender);
        gender.setBounds(790, 240, 190, 0);
        getContentPane().add(contactno);
        contactno.setBounds(820, 260, 170, 20);
        getContentPane().add(email);
        email.setBounds(790, 280, 190, 30);
        getContentPane().add(school);
        school.setBounds(800, 310, 180, 20);
        getContentPane().add(degree);
        degree.setBounds(800, 340, 180, 20);
        getContentPane().add(yearofgraduation);
        yearofgraduation.setBounds(870, 360, 110, 20);
        getContentPane().add(guardiancontactno);
        guardiancontactno.setBounds(820, 424, 160, 20);

        roomassignment.setText("jLabel15");
        getContentPane().add(roomassignment);
        roomassignment.setBounds(870, 460, 40, 14);

        status.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        getContentPane().add(status);
        status.setBounds(790, 480, 70, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/AddTenant.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 300, 260, 60);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Edit Tenant.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(70, 360, 260, 70);

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        NameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameFieldKeyReleased(evt);
            }
        });
        getContentPane().add(NameField);
        NameField.setBounds(150, 100, 160, 30);

        SchoolField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchoolFieldActionPerformed(evt);
            }
        });
        SchoolField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SchoolFieldKeyReleased(evt);
            }
        });
        getContentPane().add(SchoolField);
        SchoolField.setBounds(150, 130, 160, 30);

        DegreeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegreeFieldActionPerformed(evt);
            }
        });
        DegreeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DegreeFieldKeyReleased(evt);
            }
        });
        getContentPane().add(DegreeField);
        DegreeField.setBounds(150, 160, 160, 30);

        buttonGroup1.add(MaleField);
        MaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        MaleField.setText("Male");
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        getContentPane().add(MaleField);
        MaleField.setBounds(150, 210, 60, 30);

        buttonGroup1.add(FemaleField);
        FemaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        FemaleField.setText("Female");
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        getContentPane().add(FemaleField);
        FemaleField.setBounds(210, 210, 80, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tenant ID", "Surname", "Firstname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 70, 350, 450);

        buttonGroup2.add(CurrentField);
        CurrentField.setText("Current");
        CurrentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentFieldActionPerformed(evt);
            }
        });
        getContentPane().add(CurrentField);
        CurrentField.setBounds(150, 240, 63, 23);

        buttonGroup2.add(OldField);
        OldField.setText("Old");
        OldField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OldFieldActionPerformed(evt);
            }
        });
        getContentPane().add(OldField);
        OldField.setBounds(150, 260, 41, 23);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        getContentPane().add(YearOfGraduationField);
        YearOfGraduationField.setBounds(230, 190, 70, 20);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(800, 204, 170, 30);
        jLabel2.getAccessibleContext().setAccessibleName("address");

        getContentPane().add(jLabel3);
        jLabel3.setBounds(800, 230, 180, 20);
        jLabel3.getAccessibleContext().setAccessibleName("gender");

        getContentPane().add(guardianName);
        guardianName.setBounds(820, 400, 160, 20);
        getContentPane().add(guardianEmail);
        guardianEmail.setBounds(800, 440, 180, 20);

        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(750, 440, 60, 20);
        getContentPane().add(imgLabel);
        imgLabel.setBounds(910, 100, 70, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Tenant.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1020, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AddTenant at = new AddTenant();
        at.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();
        int tenantID = (Integer) jTable1.getValueAt(row, 0);
        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean tb = new TenantBean();
        tb = tdao.getTenantById(tenantID);

        this.setVisible(false);
        AddTenant at = new AddTenant(tenantID);
        at.setVisible(true);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_NameFieldActionPerformed

    private void MaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleFieldActionPerformed
        // TODO add your handling code here:
        searchMale();
    }//GEN-LAST:event_MaleFieldActionPerformed


    private void FemaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleFieldActionPerformed
        // TODO add your handling code here:
        searchFemale();
    }//GEN-LAST:event_FemaleFieldActionPerformed

    private void CurrentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentFieldActionPerformed
        // TODO add your handling code here:
        searchCurrent();

    }//GEN-LAST:event_CurrentFieldActionPerformed

    private void SchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SchoolFieldActionPerformed

    private void YearOfGraduationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldActionPerformed
        // TODO add your handling code here:
        searchYear();
    }//GEN-LAST:event_YearOfGraduationFieldActionPerformed

    private void DegreeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegreeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DegreeFieldActionPerformed

    private void OldFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OldFieldActionPerformed
        // TODO add your handling code here:
        searchOld();
    }//GEN-LAST:event_OldFieldActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        getSelection();
    }//GEN-LAST:event_jTable1MouseClicked


    private void NameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameFieldKeyReleased
        // TODO add your handling code here:
        searchName();
    }//GEN-LAST:event_NameFieldKeyReleased

    private void SchoolFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyReleased
        // TODO add your handling code here:
        searchSchool();
    }//GEN-LAST:event_SchoolFieldKeyReleased

    private void DegreeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeFieldKeyReleased
        // TODO add your handling code here:
        searchDegree();
    }//GEN-LAST:event_DegreeFieldKeyReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        getSelection();
    }//GEN-LAST:event_jTable1KeyReleased

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CurrentField;
    private javax.swing.JTextField DegreeField;
    private javax.swing.JRadioButton FemaleField;
    private javax.swing.JRadioButton MaleField;
    private javax.swing.JTextField NameField;
    private javax.swing.JRadioButton OldField;
    private javax.swing.JTextField SchoolField;
    private javax.swing.JComboBox YearOfGraduationField;
    private javax.swing.JLabel address;
    private javax.swing.JLabel birthday;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel contactno;
    private javax.swing.JLabel degree;
    private javax.swing.JLabel email;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel guardianEmail;
    private javax.swing.JLabel guardianName;
    private javax.swing.JLabel guardiancontactno;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel roomassignment;
    private javax.swing.JLabel school;
    private javax.swing.JLabel status;
    private javax.swing.JLabel tenantID;
    private javax.swing.JLabel yearofgraduation;
    // End of variables declaration//GEN-END:variables
}
