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
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giodee
 */
public class TenantPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form TenantPanelFinal
     */
    private DefaultTableModel model;
    private CheckAccount c = new CheckAccount();
    private ArrayList<TenantBean> searchnamelist = new ArrayList<>();
    private TenantDAOInterface tenantImpl = new TenantDAOImplementation();
    private int tenantID;
    private JPanel jPanel2;

    public TenantPanelFinal() {
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
        jLabel9.setText(bean.getLname());
        jLabel8.setText(bean.getFname());
//             birthday.setText(java.sql.Date.toString(bean.getBirthday()));
//        jLabel2.setText(bean.getAddress());
//       jLabel3.setText(bean.getGender());
//        Fnamelabel.setText(bean.getGender());
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
            roomnumber.setText("none");
        } else {
            roomnumber.setText(String.valueOf(roombean.getRoomID()));
        }

//        status.setText(bean.getStatus());
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
//        searchnamelist = tenantImpl.getTenantByStatus(CurrentField.getText());
        initSearch(searchnamelist);
    }

    public void searchOld() {
        //       searchnamelist = tenantImpl.getTenantByStatus(OldField.getText());
        //       searchnamelist = tenantImpl.getTenantByStatus(OldField.getText());
        initSearch(searchnamelist);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameField = new javax.swing.JTextField();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        YearOfGraduationField = new javax.swing.JComboBox();
        MaleField = new javax.swing.JRadioButton();
        FemaleField = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logstat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        logtime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roomnumber = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contactno = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

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
        add(NameField);
        NameField.setBounds(110, 180, 120, 20);

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
        add(SchoolField);
        SchoolField.setBounds(110, 210, 120, 20);

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
        DegreeField.setBounds(110, 240, 120, 19);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        add(YearOfGraduationField);
        YearOfGraduationField.setBounds(110, 270, 70, 20);

        MaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        MaleField.setText("Male");
        MaleField.setOpaque(false);
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        add(MaleField);
        MaleField.setBounds(110, 290, 60, 30);

        FemaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        FemaleField.setText("Female");
        FemaleField.setOpaque(false);
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        add(FemaleField);
        FemaleField.setBounds(170, 290, 80, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/AddTenant.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(70, 340, 160, 50);

        jLabel2.setText("First Name:");
        add(jLabel2);
        jLabel2.setBounds(660, 180, 90, 14);

        jLabel8.setText("jLabel8");
        add(jLabel8);
        jLabel8.setBounds(760, 180, 140, 20);

        jLabel3.setText("Last Name:");
        add(jLabel3);
        jLabel3.setBounds(660, 220, 80, 14);

        jLabel9.setText("jLabel9");
        add(jLabel9);
        jLabel9.setBounds(760, 220, 150, 14);

        jLabel4.setText("In/Out:");
        add(jLabel4);
        jLabel4.setBounds(660, 260, 70, 14);

        logstat.setText("jLabel10");
        add(logstat);
        logstat.setBounds(760, 260, 120, 14);

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
        jScrollPane1.setBounds(270, 30, 350, 520);

        jLabel5.setText("Last Log Time:");
        add(jLabel5);
        jLabel5.setBounds(660, 300, 100, 14);

        logtime.setText("jLabel10");
        add(logtime);
        logtime.setBounds(760, 300, 140, 14);

        jLabel6.setText("Room Number:");
        add(jLabel6);
        jLabel6.setBounds(660, 340, 90, 14);

        roomnumber.setText("jLabel10");
        add(roomnumber);
        roomnumber.setBounds(760, 340, 130, 14);

        jLabel7.setText("Contact Number:");
        add(jLabel7);
        jLabel7.setBounds(660, 380, 110, 14);

        contactno.setText("jLabel8");
        add(contactno);
        contactno.setBounds(760, 380, 160, 14);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewcompletedetails.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(720, 420, 170, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/edit_information button.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(720, 470, 170, 40);

        jLabel10.setText("Name");
        add(jLabel10);
        jLabel10.setBounds(70, 180, 30, 14);

        jLabel11.setText("School");
        jLabel11.setPreferredSize(null);
        add(jLabel11);
        jLabel11.setBounds(70, 210, 40, 14);

        jLabel12.setText("Degree");
        add(jLabel12);
        jLabel12.setBounds(70, 240, 40, 14);

        jLabel13.setText("Year");
        add(jLabel13);
        jLabel13.setBounds(70, 270, 40, 14);

        jLabel14.setText("Gender");
        add(jLabel14);
        jLabel14.setBounds(70, 300, 50, 14);

        imgLabel.setText("Picture");
        add(imgLabel);
        imgLabel.setBounds(810, 50, 120, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/tenant-tab-peg-crop.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void NameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameFieldKeyReleased
        // TODO add your handling code here:
        searchName();
    }//GEN-LAST:event_NameFieldKeyReleased

    private void SchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SchoolFieldActionPerformed

    private void SchoolFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyReleased
        // TODO add your handling code here:
        searchSchool();
    }//GEN-LAST:event_SchoolFieldKeyReleased

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        jPanel2 = new AddTenantPanelFinal();

        setJpanel();
//        mn.setJpanel(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();

        tenantID = (Integer) jTable1.getValueAt(row, 0);
        System.out.println(tenantID);
        setID(tenantID);
        getSelection();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        getSelection();
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        // edit tenant information
        this.removeAll();
        int row = jTable1.getSelectedRow();

        tenantID = (Integer) jTable1.getValueAt(row, 0);
        System.out.println(tenantID);
        setID(tenantID);

        jPanel2 = new EditTenantPanelFinal(tenantID);

        setJpanel();
        //      jScrollPane2.setViewportView(et);
        //   NewJFrame nj = new NewJFrame(tenantID);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void setJpanel() {
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 600));
        this.add(jPanel2);
        jPanel2.setOpaque(true);
        jPanel2.setBounds(0, 0, 1000, 600);
    }

    public void setID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int returnID() {
        return this.tenantID;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DegreeField;
    private javax.swing.JRadioButton FemaleField;
    private javax.swing.JRadioButton MaleField;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField SchoolField;
    private javax.swing.JComboBox YearOfGraduationField;
    private javax.swing.JLabel contactno;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logstat;
    private javax.swing.JLabel logtime;
    private javax.swing.JLabel roomnumber;
    // End of variables declaration//GEN-END:variables
}
