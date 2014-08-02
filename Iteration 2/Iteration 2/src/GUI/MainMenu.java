package GUI;


import ErrorHandling.CheckAccount;
import Models.Beans.TenantBean;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.TenantDAOInterface;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
    public MainMenu() {
        initComponents();
        CheckAccount c = new CheckAccount();
        buttonGroup1.add(MaleField);
        buttonGroup1.add(FemaleField);

        buttonGroup2.add(CurrentField);
        buttonGroup2.add(OldField);

        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.removeItem(i);
        }
        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.addItem(i);
        }

    }

    public void checkresults() {
        TenantDAOInterface tdao = new TenantDAOImplementation();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }
        model.setRowCount(0);
        model.setNumRows(0);

        ArrayList<TenantBean> list = new ArrayList<TenantBean>(); // final list
        ArrayList<TenantBean> searchnamelist = new ArrayList<TenantBean>();
        ArrayList<TenantBean> searchschoollist = new ArrayList<TenantBean>();
        ArrayList<TenantBean> searchdegreelist = new ArrayList<TenantBean>();
        ArrayList<TenantBean> searchyearlist = new ArrayList<TenantBean>();
        ArrayList<TenantBean> searchgenderlist = new ArrayList<TenantBean>();
        ArrayList<TenantBean> searchstatuslist = new ArrayList<TenantBean>();

        if (NameField.getText().matches("^[a-zA-Z ]+$")) { // letters lang
            String name = NameField.getText();
            searchnamelist = tdao.searchTenantName(name); // list from searchname
            for (int i = 0; i < searchnamelist.size(); i++) {
                list.add(searchnamelist.get(i));
            }
        }
        if (!(SchoolField.getText().isEmpty())) {
            String school = SchoolField.getText();
            searchschoollist = tdao.getTenantBySchool(school);
            for (int i = 0; i < searchschoollist.size(); i++) {
                list.add(searchschoollist.get(i));
            }
        }
        if (!(DegreeField.getText().isEmpty())) {
            String degree = DegreeField.getText();
            searchdegreelist = tdao.getTenantByDegree(degree);
            for (int i = 0; i < searchdegreelist.size(); i++) {
                list.add(searchdegreelist.get(i));
            }
        }
        int expectedyear = (Integer) YearOfGraduationField.getSelectedItem();
        searchyearlist = tdao.getTenantByExpectedYearofGrad(expectedyear);
        for (int i = 0; i < searchyearlist.size(); i++) {
            list.add(searchyearlist.get(i));
        }
        if (MaleField.isSelected()) {
            searchgenderlist = tdao.getMaleTenant();
            for (int i = 0; i < searchgenderlist.size(); i++) {
                list.add(searchgenderlist.get(i));
            }

        } else if (FemaleField.isSelected()) {
            searchgenderlist = tdao.getFemaleTenant();
            for (int i = 0; i < searchgenderlist.size(); i++) {
                list.add(searchgenderlist.get(i));
            }

        }

        if (CurrentField.isSelected()) {
            searchstatuslist = tdao.getTenantByStatus("Current");
            for (int i = 0; i < searchstatuslist.size(); i++) {
                list.add(searchstatuslist.get(i));
            }

        } else if (OldField.isSelected()) {
            searchstatuslist = tdao.getTenantByStatus("Old");
            for (int i = 0; i < searchstatuslist.size(); i++) {
                list.add(searchstatuslist.get(i));
            }

        }

        // filter searchnamelist searchschoollist
        ArrayList<TenantBean> result = new ArrayList<TenantBean>();
        Set<Integer> ids = new HashSet<Integer>();

        // filter list
        for (int i = 0; i < list.size(); i++) {
            System.out.println("I: " + i);
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(i).getTenantID() == list.get(j).getTenantID()) {
                    list.remove(j);
                }
            }
        }

        for (TenantBean bean : list) {
            int tenantid = bean.getTenantID();
            String fname = bean.getFname();
            String lname = bean.getLname();

            Object[] obj = {tenantid, fname, lname};

            model.addRow(obj);
        }

        list = null;
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
        guardian = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1020, 560));
        setMinimumSize(new java.awt.Dimension(1020, 560));
        getContentPane().setLayout(null);

        tenantID.setText("jLabel2");
        getContentPane().add(tenantID);
        tenantID.setBounds(810, 100, 90, 20);

        lname.setText("jLabel3");
        getContentPane().add(lname);
        lname.setBounds(800, 130, 100, 20);

        fname.setText("jLabel4");
        getContentPane().add(fname);
        fname.setBounds(810, 150, 90, 20);

        birthday.setText("jLabel5");
        getContentPane().add(birthday);
        birthday.setBounds(800, 180, 180, 20);

        address.setText("jLabel6");
        getContentPane().add(address);
        address.setBounds(800, 210, 180, 16);

        gender.setText("jLabel7");
        getContentPane().add(gender);
        gender.setBounds(790, 240, 190, 16);

        contactno.setText("jLabel8");
        getContentPane().add(contactno);
        contactno.setBounds(820, 260, 170, 20);

        email.setText("jLabel9");
        getContentPane().add(email);
        email.setBounds(790, 280, 190, 30);

        school.setText("jLabel10");
        getContentPane().add(school);
        school.setBounds(800, 310, 180, 20);

        degree.setText("jLabel11");
        getContentPane().add(degree);
        degree.setBounds(800, 340, 180, 20);

        yearofgraduation.setText("jLabel12");
        getContentPane().add(yearofgraduation);
        yearofgraduation.setBounds(870, 360, 110, 20);

        guardian.setText("jLabel13");
        getContentPane().add(guardian);
        guardian.setBounds(810, 400, 53, 16);

        guardiancontactno.setText("jLabel14");
        getContentPane().add(guardiancontactno);
        guardiancontactno.setBounds(820, 420, 53, 16);

        roomassignment.setText("jLabel15");
        getContentPane().add(roomassignment);
        roomassignment.setBounds(870, 460, 53, 16);

        status.setText("jLabel16");
        getContentPane().add(status);
        status.setBounds(790, 480, 53, 16);

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NameFieldKeyPressed(evt);
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SchoolFieldKeyPressed(evt);
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DegreeFieldKeyPressed(evt);
            }
        });
        getContentPane().add(DegreeField);
        DegreeField.setBounds(150, 160, 160, 30);

        MaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        MaleField.setText("Male");
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        MaleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MaleFieldKeyPressed(evt);
            }
        });
        getContentPane().add(MaleField);
        MaleField.setBounds(150, 210, 60, 30);

        FemaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        FemaleField.setText("Female");
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        FemaleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FemaleFieldKeyPressed(evt);
            }
        });
        getContentPane().add(FemaleField);
        FemaleField.setBounds(210, 210, 80, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tenant ID", "First Name", "Last Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 70, 350, 450);

        CurrentField.setText("Current");
        CurrentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentFieldActionPerformed(evt);
            }
        });
        CurrentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CurrentFieldKeyPressed(evt);
            }
        });
        getContentPane().add(CurrentField);
        CurrentField.setBounds(150, 240, 79, 23);

        OldField.setText("Old");
        OldField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OldFieldActionPerformed(evt);
            }
        });
        OldField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OldFieldKeyPressed(evt);
            }
        });
        getContentPane().add(OldField);
        OldField.setBounds(150, 260, 54, 23);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        YearOfGraduationField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                YearOfGraduationFieldKeyPressed(evt);
            }
        });
        getContentPane().add(YearOfGraduationField);
        YearOfGraduationField.setBounds(230, 190, 70, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Tenant.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1020, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
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
        checkresults();

    }//GEN-LAST:event_NameFieldActionPerformed

    private void MaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleFieldActionPerformed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_MaleFieldActionPerformed


    private void FemaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleFieldActionPerformed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_FemaleFieldActionPerformed

    private void CurrentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentFieldActionPerformed
        // TODO add your handling code here:
        checkresults();

    }//GEN-LAST:event_CurrentFieldActionPerformed

    private void SchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolFieldActionPerformed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_SchoolFieldActionPerformed

    private void YearOfGraduationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldActionPerformed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_YearOfGraduationFieldActionPerformed

    private void DegreeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegreeFieldActionPerformed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_DegreeFieldActionPerformed

    private void OldFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OldFieldActionPerformed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_OldFieldActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int col = 0;

        int tenantid = (Integer) jTable1.getModel().getValueAt(row, col);
        System.out.println(tenantID);

        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tenantid);
        
        tenantID.setText(String.valueOf(bean.getTenantID()));
        lname.setText(bean.getLname());
        fname.setText(bean.getFname());
        //     birthday.setText(java.sql.Date.toString(bean.getBirthday()));
        address.setText(bean.getAddress());
        gender.setText(bean.getGender());
        contactno.setText(bean.getContact());
        email.setText(bean.getEmail());
        school.setText(bean.getSchool());
        degree.setText(bean.getDegree());
        yearofgraduation.setText(String.valueOf(bean.getExpectedyearofgrad()));
           
    

    }//GEN-LAST:event_jTable1MouseClicked


    private void NameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_NameFieldKeyPressed

    private void SchoolFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_SchoolFieldKeyPressed

    private void DegreeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_DegreeFieldKeyPressed

    private void YearOfGraduationFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_YearOfGraduationFieldKeyPressed

    private void MaleFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MaleFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_MaleFieldKeyPressed

    private void FemaleFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FemaleFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_FemaleFieldKeyPressed

    private void CurrentFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CurrentFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_CurrentFieldKeyPressed

    private void OldFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OldFieldKeyPressed
        // TODO add your handling code here:
        checkresults();
    }//GEN-LAST:event_OldFieldKeyPressed

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
    private javax.swing.JLabel guardian;
    private javax.swing.JLabel guardiancontactno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
