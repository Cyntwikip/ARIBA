package GUI;

import ErrorHandling.AccountException;
import ErrorHandling.CheckAccount;
import Models.Beans.ContractBean;
import Models.Beans.GuardianBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.ContractDAOImplementation;
import Models.DAOImplementation.GuardianDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.ContractDAOInterface;
import Models.DAOInterface.GuardianDAOInterface;
import Models.DAOInterface.TenantDAOInterface;
import com.mysql.jdbc.Blob;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.SimpleDateFormat;
import java.awt.Component;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jao
 */
public class AddTenant extends javax.swing.JFrame {

    /**
     * Creates new form AddTenant
     */
    private int tenantID = 0;
    private int guardianID = 0;
    private boolean flag = false;
    private TenantDAOInterface tdao = new TenantDAOImplementation();
    private TenantBean bean = new TenantBean();
    private TenantDAOImplementation tenantImpl = new TenantDAOImplementation();
    private TenantBean tenant = new TenantBean();
    private ImageIcon icon;

    public AddTenant() {

        initComponents();
        flag = true;
        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 0; i <= year - 1980; i++) { // remove all years
            YearField.removeItem(1980 + i);
        }
        for (int i = 0; i <= year - 1980; i++) {
            YearField.addItem(1980 + i);
        }

        //jComboBox1
        for (int i = 2014; i <= year + 10; i++) {
            YearOfGraduationField.removeItem(i);
        }
        for (int i = 2014; i <= year + 10; i++) {
            YearOfGraduationField.addItem(i);
        }

        File ff = new File("Woman.jpg");
        ff = ff.getAbsoluteFile();
        File fm = new File("Man.jpg");
        fm = fm.getAbsoluteFile();

        if (MaleField.isSelected()) {
            icon = new ImageIcon(fm.getAbsolutePath());
            tenant.setImage(fm.getAbsolutePath());
        } else {
            icon = new ImageIcon(ff.getAbsolutePath());
            tenant.setImage(ff.getAbsolutePath());
        }

    }

    public AddTenant(int id) {
        tenantID = id;
        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean tb = new TenantBean();
        tb = tdao.getTenantById(tenantID);
        initComponents();

        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 0; i <= year - 1900; i++) { // remove all years
            YearField.removeItem(1900 + i);
        }
        for (int i = 0; i <= year - 1900; i++) {
            YearField.addItem(1900 + i);
        }

        //jComboBox1
        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.removeItem(i);
        }
        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.addItem(i);
        }

        SurnameField.setText(tb.getLname());
        FirstnameField.setText(tb.getFname());
        // birthday;
        AddressField.setText(tb.getAddress());
        if (tb.getGender().equalsIgnoreCase("Male")) {
            MaleField.doClick();
        } else {
            FemaleField.doClick();
        }
        ContactNumberField1.setText(tb.getContact());
        EmailAddressField.setText(tb.getEmail());
        SchoolField.setText(tb.getSchool());
        DegreeField.setText(tb.getDegree());
        YearOfGraduationField.setSelectedItem(tb.getExpectedyearofgrad());

        //   imgaddLabel.setIcon(tb.getImage());
        // guardian part
        GuardianDAOInterface gdao = new GuardianDAOImplementation();
        GuardianBean gbean = new GuardianBean();

        gbean = gdao.getGuardianByTenantID(tenantID);

        guardianID = gbean.getGuardianID();
        GuardianFirstnameField.setText(gbean.getFname());
        GuardianSurnameField.setText(gbean.getLname());
        GuardianContactField.setText(gbean.getContact());
        GuardianEmailField.setText(gbean.getEmail());

        byte[] content = null;
        if (tb.getBlobimage() != null) {
            try {
                content = tb.getBlobimage().getBytes(1L, (int) tb.getBlobimage().length());
            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon icon = new ImageIcon(content);
            Image img = icon.getImage();
            img = img.getScaledInstance(imgaddLabel.getWidth(), imgaddLabel.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            imgaddLabel.setIcon(icon);
        }

        for (int i = 0; i < MonthField.getItemCount(); i++) {
            if (MonthField.getItemAt(i).equals(new SimpleDateFormat("MMM").format(tb.getBirthday()))) {
                MonthField.setSelectedIndex(id);
                break;
            }
        }

        for (int i = 0; i < DayField.getItemCount(); i++) {
            if (DayField.getItemAt(i).equals(new SimpleDateFormat("d").format(tb.getBirthday()))) {
                DayField.setSelectedIndex(i);
                break;
            }
        }
        SimpleDateFormat yr = new SimpleDateFormat("yyyy");
        String c = yr.format(tb.getBirthday());
        for (int i = 0; i < YearField.getItemCount(); i++) {
            if ((int)YearField.getItemAt(i) == Integer.parseInt(c)) {
                YearField.setSelectedIndex(i);
                break;
            }
        }


    }

    public void preventDigit(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            System.out.println("digit");
            evt.setKeyCode(KeyEvent.VK_BACK_SPACE);
            evt.consume();
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        SurnameField = new javax.swing.JTextField();
        FirstnameField = new javax.swing.JTextField();
        MonthField = new javax.swing.JComboBox();
        DayField = new javax.swing.JComboBox();
        YearField = new javax.swing.JComboBox();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        YearOfGraduationField = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        imgaddLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        MaleField = new javax.swing.JRadioButton();
        FemaleField = new javax.swing.JRadioButton();
        EmailAddressField = new javax.swing.JTextField();
        GuardianFirstnameField = new javax.swing.JTextField();
        GuardianSurnameField = new javax.swing.JTextField();
        GuardianEmailField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        GuardianContactField = new javax.swing.JFormattedTextField();
        ContactNumberField1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        SurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurnameFieldActionPerformed(evt);
            }
        });
        SurnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SurnameFieldKeyTyped(evt);
            }
        });
        getContentPane().add(SurnameField);
        SurnameField.setBounds(360, 90, 170, 30);

        FirstnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FirstnameFieldKeyTyped(evt);
            }
        });
        getContentPane().add(FirstnameField);
        FirstnameField.setBounds(360, 120, 170, 30);

        MonthField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        MonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthFieldActionPerformed(evt);
            }
        });
        getContentPane().add(MonthField);
        MonthField.setBounds(350, 160, 60, 27);

        DayField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        DayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayFieldActionPerformed(evt);
            }
        });
        getContentPane().add(DayField);
        DayField.setBounds(410, 160, 50, 27);

        YearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearFieldActionPerformed(evt);
            }
        });
        getContentPane().add(YearField);
        YearField.setBounds(460, 160, 70, 27);

        SchoolField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SchoolFieldKeyTyped(evt);
            }
        });
        getContentPane().add(SchoolField);
        SchoolField.setBounds(580, 90, 190, 30);

        DegreeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DegreeFieldKeyTyped(evt);
            }
        });
        getContentPane().add(DegreeField);
        DegreeField.setBounds(580, 120, 190, 30);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        getContentPane().add(YearOfGraduationField);
        YearOfGraduationField.setBounds(650, 160, 120, 20);

        AddressField.setColumns(20);
        AddressField.setLineWrap(true);
        AddressField.setRows(5);
        jScrollPane1.setViewportView(AddressField);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(350, 190, 180, 70);

        imgaddLabel.setText("                   Choose photo");
        getContentPane().add(imgaddLabel);
        imgaddLabel.setBounds(80, 100, 180, 180);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/choosephoto.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(100, 290, 140, 40);

        buttonGroup1.add(MaleField);
        MaleField.setText("Male");
        MaleField.setActionCommand("Male");
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        getContentPane().add(MaleField);
        MaleField.setBounds(380, 270, 70, 23);

        buttonGroup1.add(FemaleField);
        FemaleField.setText("Female\n");
        FemaleField.setActionCommand("Female");
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        getContentPane().add(FemaleField);
        FemaleField.setBounds(450, 270, 90, 23);
        getContentPane().add(EmailAddressField);
        EmailAddressField.setBounds(390, 320, 140, 30);

        GuardianFirstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianFirstnameFieldActionPerformed(evt);
            }
        });
        GuardianFirstnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GuardianFirstnameFieldKeyTyped(evt);
            }
        });
        getContentPane().add(GuardianFirstnameField);
        GuardianFirstnameField.setBounds(600, 240, 170, 30);

        GuardianSurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianSurnameFieldActionPerformed(evt);
            }
        });
        GuardianSurnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GuardianSurnameFieldKeyTyped(evt);
            }
        });
        getContentPane().add(GuardianSurnameField);
        GuardianSurnameField.setBounds(600, 210, 170, 30);
        getContentPane().add(GuardianEmailField);
        GuardianEmailField.setBounds(630, 300, 140, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/backbutton.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(530, 360, 80, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/save.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(630, 360, 80, 40);

        try {
            GuardianContactField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(GuardianContactField);
        GuardianContactField.setBounds(630, 270, 140, 30);

        try {
            ContactNumberField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ContactNumberField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNumberField1ActionPerformed(evt);
            }
        });
        ContactNumberField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ContactNumberField1KeyReleased(evt);
            }
        });
        getContentPane().add(ContactNumberField1);
        ContactNumberField1.setBounds(390, 288, 140, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/addnewtenant-peg-edited.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardianFirstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianFirstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianFirstnameFieldActionPerformed

    private void YearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearFieldActionPerformed
        // TODO add your handling code here:
        int year = (Integer) YearField.getSelectedItem();
        if ((year % 4) == 0) {
            if (MonthField.getSelectedItem().equals("Feb")) {
                DayField.removeItem("29");
                DayField.addItem("29");
            }
        } else {
            DayField.removeItem("29");
        }
    }//GEN-LAST:event_YearFieldActionPerformed

    private void DayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayFieldActionPerformed

    private void MonthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthFieldActionPerformed
        // TODO add your handling code here:

        if (MonthField.getSelectedItem().equals("Jan")
                || MonthField.getSelectedItem().equals("Mar")
                || MonthField.getSelectedItem().equals("May")
                || MonthField.getSelectedItem().equals("Jul")
                || MonthField.getSelectedItem().equals("Aug")
                || MonthField.getSelectedItem().equals("Oct")
                || MonthField.getSelectedItem().equals("Dec")) {
            DayField.removeItem("29");
            DayField.removeItem("30");
            DayField.removeItem("31");
            DayField.addItem("29");
            DayField.addItem("30");
            DayField.addItem("31");

        } else if (MonthField.getSelectedItem().equals("Feb")) { // feb
            DayField.removeItem("29");
            DayField.removeItem("30");
            DayField.removeItem("31");
        } else {
            DayField.removeItem("29");
            DayField.removeItem("30");
            DayField.removeItem("31");
            DayField.addItem("29");
            DayField.addItem("30");

        }
    }//GEN-LAST:event_MonthFieldActionPerformed

    private void YearOfGraduationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearOfGraduationFieldActionPerformed

    private void SurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SurnameFieldActionPerformed

    private void FemaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleFieldActionPerformed

    private void MaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, GIF & PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getAbsolutePath());

            if (!chooser.getSelectedFile().getAbsolutePath().isEmpty()) {
                icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
                tenant.setImage(chooser.getSelectedFile().getAbsolutePath());
            }

        }
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(imgaddLabel.getWidth(), imgaddLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        imgaddLabel.setIcon(icon);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void GuardianSurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianSurnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianSurnameFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        //Edit Tenant
        if (!flag) {
            CheckAccount c = new CheckAccount();
            if (FirstnameField.getText().isEmpty()
                    || SurnameField.getText().isEmpty()
                    || ContactNumberField1.getText().isEmpty()
                    || AddressField.getText().isEmpty()
                    || DegreeField.getText().isEmpty()
                    || EmailAddressField.getText().isEmpty()
                    || SchoolField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill up ALL the fields.");
            } else {
                try {
                    c.checkName(FirstnameField.getText(), "Firstname");
                    c.checkName(SurnameField.getText(), "Lastname");
                    c.checkName(DegreeField.getText(), "Degree");
                    c.checkName(SchoolField.getText(), "School");
                    c.checkEmail(EmailAddressField.getText(), "Email");
                    c.checkContact(ContactNumberField1.getText(), "Contact");
                    c.checkName(GuardianFirstnameField.getText(), "Firstname");
                    c.checkName(GuardianSurnameField.getText(), "Lastname");
                    c.checkEmail(GuardianEmailField.getText(), "Email");
                    c.checkContact(GuardianContactField.getText(), "Contact");

                    System.out.println("Tenant ID: " + tenantID);
                    if (tenantID == 0) { // add tenant

                    } else { // edit

                        bean.setFname(FirstnameField.getText().toUpperCase());
                        bean.setLname(SurnameField.getText().toUpperCase());
                        bean.setAddress(AddressField.getText().toUpperCase());
                        bean.setContact(ContactNumberField1.getText());

                        //converting string to Calendar
                        String sDate = MonthField.getSelectedItem().toString() + " " + DayField.getSelectedItem().toString() + ", " + YearField.getSelectedItem().toString();
                        Calendar birthdate = Calendar.getInstance();
                        DateFormat df = new SimpleDateFormat("MMMM d, yyyy");
                        try {
                            birthdate.setTime(df.parse(sDate));
                        } catch (ParseException ex) {
                            Logger.getLogger(AddTenant.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //converting Calendar to sql Date
                        java.sql.Date sqlBirthdate = new java.sql.Date(birthdate.getTime().getTime());

                        String gender;
                        try {
                            gender = buttonGroup1.getSelection().getActionCommand();
                        } catch (NullPointerException n) {
                            gender = "";
                        }

                        bean.setContact(ContactNumberField1.getText());
                        bean.setDegree(DegreeField.getText().toUpperCase());
                        bean.setEmail(EmailAddressField.getText());
                        bean.setExpectedyearofgrad((Integer) YearOfGraduationField.getSelectedItem());
                        if (MaleField.isSelected()) {
                            bean.setGender("MALE");
                        } else {
                            bean.setGender("FEMALE");
                        }
                        //         bean.setImage(null);
                        bean.setStatus("CURRENT");

                        // guardian  
                        boolean edittenant = tdao.editTenant(bean);

                        GuardianDAOInterface gdao = new GuardianDAOImplementation();
                        GuardianBean gbean = new GuardianBean();

                        gbean.setFname(GuardianFirstnameField.getText().toUpperCase());
                        gbean.setLname(GuardianSurnameField.getText().toUpperCase());
                        gbean.setContact(GuardianContactField.getText());
                        gbean.setGuardianID(guardianID);
                        gbean.setEmail(GuardianEmailField.getText());

                        boolean editguardian = gdao.editGuardian(gbean, guardianID);

                        if (edittenant && editguardian) {
                            JOptionPane.showMessageDialog(null, "Tenant " + bean.getFname() + " " + bean.getLname() + "'s information has been successfully edited.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Not successful");
                        }
                    }

                } catch (AccountException e) {
                    e.promptFieldError();
                }
            }

            // Add Account
        } else {
            CheckAccount c = new CheckAccount();
            boolean tflag = false;
            String fname = FirstnameField.getText();
            String lname = SurnameField.getText();
            String degree = DegreeField.getText();
            String school = SchoolField.getText();
            String email = EmailAddressField.getText();
            String contact = ContactNumberField1.getText();
            String address = AddressField.getText();
            //converting string to Calendar
            String sDate = MonthField.getSelectedItem().toString() + " " + DayField.getSelectedItem().toString() + ", " + YearField.getSelectedItem().toString();
            Calendar birthdate = Calendar.getInstance();
            DateFormat df = new SimpleDateFormat("MMMM d, yyyy");
            try {
                birthdate.setTime(df.parse(sDate));
            } catch (ParseException ex) {
                Logger.getLogger(AddTenant.class.getName()).log(Level.SEVERE, null, ex);
            }
            //converting Calendar to sql Date
            java.sql.Date sqlBirthdate = new java.sql.Date(birthdate.getTime().getTime());

            String gender;
            try {
                gender = buttonGroup1.getSelection().getActionCommand();
            } catch (NullPointerException n) {
                gender = "";
            }
            int gradyear = (int) YearOfGraduationField.getSelectedItem();

            String guardFname = GuardianFirstnameField.getText();
            String guardLname = GuardianSurnameField.getText();
            String guardContact = GuardianContactField.getText();
            String guardEmail = GuardianEmailField.getText();
            boolean empty = false;
            if (FirstnameField.getText().isEmpty()
                    || SurnameField.getText().isEmpty()
                    || ContactNumberField1.getText().isEmpty()
                    || AddressField.getText().isEmpty()
                    || DegreeField.getText().isEmpty()
                    || EmailAddressField.getText().isEmpty()
                    || SchoolField.getText().isEmpty()
                    || gender.isEmpty()
                    || guardFname.isEmpty()
                    || guardLname.isEmpty()
                    || guardEmail.isEmpty()
                    || guardContact.isEmpty()) {
                empty = true;
            } else {
                empty = false;
                try {
                    //error checking
                    c.checkName(fname, "Firstname");
                    c.checkName(lname, "Lastname");
                    c.checkName(degree, "Degree");
                    c.checkName(school, "School");
                    c.checkEmail(email, "Email");
                    c.checkContact(contact, "Contact");
                    tenant.setFname(fname.toUpperCase());
                    tenant.setLname(lname.toUpperCase());
                    tenant.setContact(contact);
                    tenant.setGender(gender.toUpperCase());
                    tenant.setAddress(address.toUpperCase());
                    tenant.setDegree(degree.toUpperCase());
                    tenant.setEmail(email);
                    tenant.setBirthday((java.sql.Date) sqlBirthdate);
                    tenant.setSchool(school.toUpperCase());
                    tenant.setExpectedyearofgrad(gradyear);
                    tenant.setStatus("CURRENT");
                    c.checkName(guardFname, "Guardian Firstname");
                    c.checkName(guardLname, "Guardian Lastname");
                    c.checkContact(guardContact, "Guardian Contact");
                    c.checkEmail(guardEmail, "Guardian Email");

                    GuardianBean guard = new GuardianBean();
                    GuardianDAOImplementation guardImpl1 = new GuardianDAOImplementation();
                    boolean t1 = false, g1 = false, tg1;
                    guard.setFname(guardFname.toUpperCase());
                    guard.setLname(guardLname.toUpperCase());
                    guard.setContact(guardContact);
                    guard.setEmail(guardEmail);
                    g1 = guardImpl1.addGuardian(guard);
                    t1 = tenantImpl.addTenant(tenant);
                    guard = guardImpl1.getGuardianByName(guardFname, guardLname);

                    tenant = tenantImpl.getTenantByName(fname, lname);
                    tg1 = guardImpl1.assignTenantToGuardian(guard, tenant);
                    if (t1 && g1 && tg1) {
                        tflag = true;
                    }

                    ContractBean contractAcc = new ContractBean();
                    ContractDAOInterface contractdao = new ContractDAOImplementation();

                    tenant = tdao.getTenantByName(tenant.getFname(), tenant.getLname());

                    Calendar effectivedate = Calendar.getInstance();
                    Calendar expirydate = Calendar.getInstance();
                    expirydate.add(Calendar.DAY_OF_YEAR, 365); // add 1 year
                    DateFormat df_contract = new SimpleDateFormat("MMMM d, yyyy");

                    //converting Calendar to sql Date
                    java.sql.Date sqlEffectivedate = new java.sql.Date(effectivedate.getTime().getTime());
                    java.sql.Date sqlExpirydate = new java.sql.Date(expirydate.getTime().getTime());

                    contractAcc.setContract_tenantID(tenant.getTenantID());
                    contractAcc.setEffectivedate(sqlEffectivedate);
                    contractAcc.setExpirydate(sqlExpirydate);

                    contractdao.addContract(contractAcc);

                    if (tflag) {
                        JOptionPane.showMessageDialog(null, "Tenant " + tenant.getFname() + " " + tenant.getLname() + " has successfully added.");
                        MainMenu main = new MainMenu();
                        main.setVisible(true);
                        this.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Make sure to input all necessary information correctly.");
                    }
                } catch (AccountException e) {
                    e.promptFieldError();
                }
            }

            if (empty == false) {
                JOptionPane.showMessageDialog(null, "Please input ALL necessary information");

            }

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void SurnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SurnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_SurnameFieldKeyTyped

    private void FirstnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_FirstnameFieldKeyTyped

    private void SchoolFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_SchoolFieldKeyTyped

    private void DegreeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_DegreeFieldKeyTyped

    private void GuardianSurnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuardianSurnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_GuardianSurnameFieldKeyTyped

    private void GuardianFirstnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuardianFirstnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_GuardianFirstnameFieldKeyTyped

    private void ContactNumberField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactNumberField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactNumberField1ActionPerformed

    private void ContactNumberField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContactNumberField1KeyReleased
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        System.out.println(c);
    }//GEN-LAST:event_ContactNumberField1KeyReleased

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
            java.util.logging.Logger.getLogger(AddTenant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTenant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTenant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTenant.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTenant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressField;
    private javax.swing.JFormattedTextField ContactNumberField1;
    private javax.swing.JComboBox DayField;
    private javax.swing.JTextField DegreeField;
    private javax.swing.JTextField EmailAddressField;
    private javax.swing.JRadioButton FemaleField;
    private javax.swing.JTextField FirstnameField;
    private javax.swing.JFormattedTextField GuardianContactField;
    private javax.swing.JTextField GuardianEmailField;
    private javax.swing.JTextField GuardianFirstnameField;
    private javax.swing.JTextField GuardianSurnameField;
    private javax.swing.JRadioButton MaleField;
    private javax.swing.JComboBox MonthField;
    private javax.swing.JTextField SchoolField;
    private javax.swing.JTextField SurnameField;
    private javax.swing.JComboBox YearField;
    private javax.swing.JComboBox YearOfGraduationField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel imgaddLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
