/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jao
 */
public class Tenant extends javax.swing.JPanel {

    /**
     * Creates new form Tenant
     */
    private DefaultTableModel model;
    private CheckAccount c = new CheckAccount();
    private ArrayList<TenantBean> searchnamelist = new ArrayList<>();
    private TenantDAOImplementation tenantImpl = new TenantDAOImplementation();

    public Tenant() {
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

        byte[] content = null;
        if (bean.getBlobimage() != null) {
            try {
                content = bean.getBlobimage().getBytes(1L, (int) bean.getBlobimage().length());
            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon icon = new ImageIcon(content);
            java.awt.Image img = icon.getImage();
            java.awt.Image newimg = img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            imgLabel.setIcon(icon);
        }
        //       tenantID.setText(String.valueOf(bean.getTenantID()));
        lname.setText(bean.getLname());
        fname.setText(bean.getFname());
//             birthday.setText(java.sql.Date.toString(bean.getBirthday()));
//        jLabel2.setText(bean.getAddress());
//       jLabel3.setText(bean.getGender());
        Fnamelabel.setText(bean.getGender());
        contactno.setText(bean.getContact());
        //    email.setText(bean.getEmail());
        //  school.setText(bean.getSchool());
        //degree.setText(bean.getDegree());
        //      yearofgraduation.setText(String.valueOf(bean.getExpectedyearofgrad()));
        DateFormat date = new SimpleDateFormat("MMMM d, yyyy");
        //    birthday.setText(date.format(bean.getBirthday()));

        GuardianDAOInterface gdao = new GuardianDAOImplementation();
        GuardianBean gbean = new GuardianBean();

        gbean = gdao.getGuardianByTenantID(tenantid);

        jLabel1.setText(gbean.getFname() + " " + gbean.getLname());
//      guardiancontactno.setText(gbean.getContact());

        GuardianBean guardianbean = new GuardianBean();

        guardianbean = gdao.getGuardianByTenant(bean.getFname(), bean.getLname());
//        guardianlname.setText(guardianbean.getLname());
//        guardianfname.setText(guardianbean.getFname());
//        guardiancontactno.setText(guardianbean.getContact());
//        guardianEmail.setText(guardianbean.getEmail());

        RoomBean roombean = new RoomBean();
        RoomDAOImplementation roomdao = new RoomDAOImplementation();

        roombean = roomdao.getTenantRoom(tenantid);
        if (roombean.getRoomID() == 0) {
            roomassignment.setText("none");
        } else {
            roomassignment.setText(String.valueOf(roombean.getRoomID()));
        }

//        status.setText(bean.getStatus());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NameField = new javax.swing.JTextField();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        YearOfGraduationField = new javax.swing.JComboBox();
        MaleField = new javax.swing.JRadioButton();
        FemaleField = new javax.swing.JRadioButton();
        imgLabel = new javax.swing.JLabel();
        Fnamelabel = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        roomassignment = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        roomassignment = new javax.swing.JLabel();
       contactno = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        NameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        add(SchoolField);
        SchoolField.setBounds(90, 240, 120, 19);
        jPanel1.add(NameField);
        NameField.setBounds(30, 120, 150, 20);

        SchoolField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
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
        jPanel1.add(SchoolField);
        SchoolField.setBounds(30, 160, 150, 20);

        DegreeField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
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
        add(DegreeField);
        DegreeField.setBounds(90, 280, 120, 19);

        jPanel1.add(DegreeField);
        DegreeField.setBounds(30, 200, 150, 20);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        add(YearOfGraduationField);
        YearOfGraduationField.setBounds(130, 310, 90, 40);
        jPanel1.add(YearOfGraduationField);
        YearOfGraduationField.setBounds(90, 240, 90, 30);

        MaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        MaleField.setText("Male");
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        jPanel1.add(MaleField);
        MaleField.setBounds(30, 280, 60, 25);

        FemaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        FemaleField.setText("Female");
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        jPanel1.add(FemaleField);
        FemaleField.setBounds(90, 280, 80, 25);
        jPanel1.add(imgLabel);
        imgLabel.setBounds(790, 20, 80, 80);

        Fnamelabel.setText("First Name:");
        jPanel1.add(Fnamelabel);
        Fnamelabel.setBounds(630, 110, 80, 14);

        fname.setText("jLabel9");
        jPanel1.add(fname);
        fname.setBounds(710, 110, 130, 14);

        jLabel4.setText("Last Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(630, 150, 80, 14);

        lname.setText("jLabel10");
        jPanel1.add(lname);
        lname.setBounds(720, 150, 140, 14);

        jLabel5.setText("In / Out:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(630, 190, 42, 14);

        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(720, 190, 130, 14);

        jLabel6.setText("Time of Last Log:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(630, 230, 82, 14);

        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(740, 230, 110, 14);

        jLabel7.setText("Room Number:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(630, 270, 100, 20);

        roomassignment.setText("jLabel13");
        jPanel1.add(roomassignment);
        roomassignment.setBounds(730, 280, 120, 14);

        jLabel8.setText("Contact Number:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(630, 310, 82, 14);

        contactno.setText("jLabel14");
        jPanel1.add(contactno);
        contactno.setBounds(750, 310, 120, 14);

        jButton2.setText("View All Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(650, 380, 180, 23);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/edit_information button.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(660, 420, 160, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/addnewtenant.png"))); // NOI18N
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 360, 160, 40);

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

        add(jScrollPane1);
        jScrollPane1.setBounds(270, 80, 350, 520);
        add(imgLabel);
        imgLabel.setBounds(850, 100, 80, 80);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/addnewtenant.png"))); // NOI18N
        add(jButton1);
        jButton1.setBounds(80, 430, 160, 40);
        add(jLabel2);
        jLabel2.setBounds(700, 120, 80, 80);


        jLabel4.setText("Last Name:");
        add(jLabel4);
        jLabel4.setBounds(690, 260, 54, 14);

        jLabel5.setText("In / Out:");
        add(jLabel5);
        jLabel5.setBounds(690, 300, 42, 14);

        jLabel6.setText("Time of Last Log:");
        add(jLabel6);
        jLabel6.setBounds(690, 340, 82, 14);

        jLabel7.setText("Room Number:");
        add(jLabel7);
        jLabel7.setBounds(690, 380, 100, 20);

        jLabel8.setText("Contact Number:");
        add(jLabel8);
        jLabel8.setBounds(690, 420, 82, 14);

        fname.setText("jLabel9");
        add(fname);
        fname.setBounds(780, 220, 130, 14);

        lname.setText("jLabel10");
        add(lname);
        lname.setBounds(780, 260, 140, 14);

        jLabel11.setText("jLabel11");
        add(jLabel11);
        jLabel11.setBounds(780, 300, 130, 14);

        jLabel12.setText("jLabel12");
        add(jLabel12);
        jLabel12.setBounds(810, 340, 110, 14);

        roomassignment.setText("jLabel13");
        add(roomassignment);
        roomassignment.setBounds(790, 380, 120, 14);

        contactno.setText("jLabel14");
        add(contactno);
        contactno.setBounds(810, 420, 120, 14);

        jButton2.setText("View All Details");
        add(jButton2);
        jButton2.setBounds(710, 500, 180, 23);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/edit_information button.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(720, 530, 160, 40);
        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(210, 0, 350, 520);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 30, 80, 80);

        add(jPanel1);
        jPanel1.setBounds(60, 80, 890, 550);

        jScrollPane2.setWheelScrollingEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/tenant-tab-peg-edited.png"))); // NOI18N
        jScrollPane2.setViewportView(jLabel1);

        add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 1010, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void SchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SchoolFieldActionPerformed

    private void SchoolFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyReleased
        // TODO add your handling code here:
        searchSchool();
    }//GEN-LAST:event_SchoolFieldKeyReleased

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void NameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameFieldKeyReleased
        // TODO add your handling code here:
        searchName();
    }//GEN-LAST:event_NameFieldKeyReleased

    private void DegreeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegreeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DegreeFieldActionPerformed

    private void DegreeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeFieldKeyReleased
        // TODO add your handling code here:
        searchDegree();
    }//GEN-LAST:event_DegreeFieldKeyReleased

    private void YearOfGraduationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldActionPerformed
        // TODO add your handling code here:
        searchYear();
    }//GEN-LAST:event_YearOfGraduationFieldActionPerformed

    private void MaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleFieldActionPerformed
        // TODO add your handling code here:
        searchMale();
    }//GEN-LAST:event_MaleFieldActionPerformed

    private void FemaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleFieldActionPerformed
        // TODO add your handling code here:
        searchFemale();
    }//GEN-LAST:event_FemaleFieldActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        getSelection();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        getSelection();
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        //    setVisible(false);
        int row = jTable1.getSelectedRow();
        int tenantID = (Integer) jTable1.getModel().getValueAt(row, 0);

        //  NewJFrame nj = new NewJFrame(0, tenantID);
        EditTenantPanel et = new EditTenantPanel(tenantID);

        jPanel1.hide();
        
        jScrollPane2.setViewportView(et);

    }//GEN-LAST:event_jButton3ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    
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
//        searchnamelist = tenantImpl.getTenantByStatus(CurrentField.getText());
        initSearch(searchnamelist);
    }

    public void searchOld() {
 //       searchnamelist = tenantImpl.getTenantByStatus(OldField.getText());
        //       searchnamelist = tenantImpl.getTenantByStatus(OldField.getText());
        initSearch(searchnamelist);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DegreeField;
    private javax.swing.JRadioButton FemaleField;
    private javax.swing.JLabel Fnamelabel;
    private javax.swing.JRadioButton MaleField;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField SchoolField;
    private javax.swing.JComboBox YearOfGraduationField;
    private javax.swing.JLabel contactno;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel roomassignment;
    // End of variables declaration//GEN-END:variables
}
