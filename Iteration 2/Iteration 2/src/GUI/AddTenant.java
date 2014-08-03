package GUI;

import ErrorHandling.AccountException;
import ErrorHandling.CheckAccount;
import Models.Beans.GuardianBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.GuardianDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.GuardianDAOInterface;
import Models.DAOInterface.TenantDAOInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;

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

    public AddTenant() {

        initComponents();
        jPanel1.setLayout(null);
        flag = true;
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

        ArrayList<GuardianBean> guardianList = new ArrayList<>();
        GuardianDAOImplementation guardImpl = new GuardianDAOImplementation();
        guardianList = guardImpl.getAllGuardians();
        for (GuardianBean guardian : guardianList) {
            ExistingGuardianComboBox.addItem(guardian.getGuardianID() + ":" + guardian.getLname() + ", " + guardian.getFname());
        }
    }

    public AddTenant(int id) {
        tenantID = id;
        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean tb = new TenantBean();
        tb = tdao.getTenantById(tenantID);
        initComponents();
        jPanel1.setLayout(null);

        MaleField.setText("Male");
        FemaleField.setText("Female");

        buttonGroup1.add(MaleField);
        buttonGroup1.add(FemaleField);

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
        if (tb.getGender().equals("Male")) {
            MaleField.doClick();
        } else {
            FemaleField.doClick();
        }
        ContactNumberField.setText(tb.getContact());
        EmailAddressField.setText(tb.getEmail());
        SchoolField.setText(tb.getSchool());
        DegreeField.setText(tb.getDegree());
        YearOfGraduationField.setSelectedItem(tb.getExpectedyearofgrad());

        // guardian part
        GuardianDAOInterface gdao = new GuardianDAOImplementation();
        GuardianBean gbean = new GuardianBean();

        gbean = gdao.getGuardianByTenantID(tenantID);

        if (gbean.getGuardianID() > 0) { // existing guardian
            guardianID = gbean.getGuardianID();
            GuardianFirstnameField.setText(gbean.getFname());
            GuardianSurnameField.setText(gbean.getLname());
            GuardianContactField.setText(gbean.getContact());
            GuardianEmailField.setText(gbean.getEmail());
        } else {
            JOptionPane.showMessageDialog(null, "No existing guardian for tenant " + FirstnameField.getText() + " " + SurnameField.getText());
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        MaleField = new javax.swing.JRadioButton();
        FemaleField = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        SurnameField = new javax.swing.JTextField();
        FirstnameField = new javax.swing.JTextField();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        YearOfGraduationField = new javax.swing.JComboBox();
        ContactNumberField = new javax.swing.JTextField();
        EmailAddressField = new javax.swing.JTextField();
        MonthField = new javax.swing.JComboBox();
        DayField = new javax.swing.JComboBox();
        YearField = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        GuardianNameField = new javax.swing.JTextField();
        GuardianContactField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        GuardianFirstnameField = new javax.swing.JTextField();
        GuardianSurnameField = new javax.swing.JTextField();
        GuardianEmailField = new javax.swing.JTextField();
        ExistingGuardianRadioButton = new javax.swing.JRadioButton();
        ExistingGuardianComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(801, 457));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setText("    jLabel - put picture here");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 210, 127, 14);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/choosephoto.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(90, 290, 140, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/backbutton.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(560, 380, 90, 40);

        buttonGroup1.add(MaleField);
        MaleField.setText("Male");
        MaleField.setActionCommand("Male");
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        jPanel1.add(MaleField);
        MaleField.setBounds(370, 270, 70, 23);

        buttonGroup1.add(FemaleField);
        FemaleField.setText("Female\n");
        FemaleField.setActionCommand("Female");
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        jPanel1.add(FemaleField);
        FemaleField.setBounds(460, 270, 80, 23);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/save.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(660, 380, 90, 40);

        SurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurnameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(SurnameField);
        SurnameField.setBounds(370, 100, 170, 30);
        jPanel1.add(FirstnameField);
        FirstnameField.setBounds(370, 130, 170, 30);
        jPanel1.add(SchoolField);
        SchoolField.setBounds(590, 100, 150, 30);
        jPanel1.add(DegreeField);
        DegreeField.setBounds(590, 130, 150, 30);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        jPanel1.add(YearOfGraduationField);
        YearOfGraduationField.setBounds(650, 160, 90, 20);
        jPanel1.add(ContactNumberField);
        ContactNumberField.setBounds(390, 300, 140, 30);
        jPanel1.add(EmailAddressField);
        EmailAddressField.setBounds(380, 330, 150, 30);

        MonthField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" }));
        MonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthFieldActionPerformed(evt);
            }
        });
        jPanel1.add(MonthField);
        MonthField.setBounds(370, 160, 60, 20);

        DayField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        DayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayFieldActionPerformed(evt);
            }
        });
        jPanel1.add(DayField);
        DayField.setBounds(430, 160, 50, 20);

        YearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearFieldActionPerformed(evt);
            }
        });
        jPanel1.add(YearField);
        YearField.setBounds(480, 160, 70, 20);

        AddressField.setColumns(20);
        AddressField.setLineWrap(true);
        AddressField.setRows(5);
        jScrollPane1.setViewportView(AddressField);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(370, 190, 160, 70);

        GuardianNameField.setText("<not used>");
        jPanel1.add(GuardianNameField);
        GuardianNameField.setBounds(610, 190, 130, 30);

        GuardianContactField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianContactFieldActionPerformed(evt);
            }
        });
        jPanel1.add(GuardianContactField);
        GuardianContactField.setBounds(630, 220, 110, 30);

        jLabel3.setText("Guardian Email");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(540, 330, 130, 14);

        jLabel4.setText("Guardian Firstname");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(540, 270, 130, 14);

        jLabel5.setText("Guardian Surname");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(540, 300, 130, 14);

        GuardianFirstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianFirstnameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(GuardianFirstnameField);
        GuardianFirstnameField.setBounds(650, 260, 90, 30);
        jPanel1.add(GuardianSurnameField);
        GuardianSurnameField.setBounds(650, 290, 90, 30);
        jPanel1.add(GuardianEmailField);
        GuardianEmailField.setBounds(630, 320, 110, 30);

        ExistingGuardianRadioButton.setText("Existing Guardian");
        ExistingGuardianRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExistingGuardianRadioButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ExistingGuardianRadioButton);
        ExistingGuardianRadioButton.setBounds(510, 360, 143, 23);

        jPanel1.add(ExistingGuardianComboBox);
        ExistingGuardianComboBox.setBounds(650, 360, 130, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/addnewtenant-peg-edited.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 450);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //Edit Tenant
        if (!flag) {
            CheckAccount c = new CheckAccount();
            if (FirstnameField.getText().isEmpty()
                    || SurnameField.getText().isEmpty()
                    || ContactNumberField.getText().isEmpty()
                    || AddressField.getText().isEmpty()
                    || DegreeField.getText().isEmpty()
                    || EmailAddressField.getText().isEmpty()
                    || SchoolField.getText().isEmpty()
                    || GuardianContactField.getText().isEmpty()
                    || GuardianFirstnameField.getText().isEmpty()
                    || GuardianSurnameField.getText().isEmpty()
                    || GuardianEmailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up ALL the fields.");
            } else {
                try {
                    c.checkName(FirstnameField.getText(), "Firstname");
                    c.checkName(SurnameField.getText(), "Lastname");
                    c.checkName(DegreeField.getText(), "Degree");
                    c.checkName(SchoolField.getText(), "School");
                    c.checkEmail(EmailAddressField.getText(), "Email");
                    c.checkContact(ContactNumberField.getText(), "Contact");
                    c.checkName(GuardianFirstnameField.getText(), "Firstname");
                    c.checkName(GuardianSurnameField.getText(), "Lastname");
                    c.checkEmail(GuardianEmailField.getText(), "Email");
                    c.checkContact(GuardianContactField.getText(), "Contact");

                    System.out.println("Tenant ID: " + tenantID);
                    if (tenantID == 0) { // add tenant

                    } else { // edit
                        TenantDAOInterface tdao = new TenantDAOImplementation();
                        TenantBean bean = new TenantBean();
                        bean.setFname(FirstnameField.getText().toUpperCase());
                        bean.setLname(SurnameField.getText().toUpperCase());
                        bean.setAddress(AddressField.getText().toUpperCase());

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

                        bean.setContact(ContactNumberField.getText());
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

        } else {
            CheckAccount c = new CheckAccount();
            boolean flag = false;
            TenantDAOImplementation tenantImpl = new TenantDAOImplementation();
            TenantBean tenant = new TenantBean();
            String fname = FirstnameField.getText();
            String lname = SurnameField.getText();
            String degree = DegreeField.getText();
            String school = SchoolField.getText();
            String email = EmailAddressField.getText();
            String contact = ContactNumberField.getText();
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

            if (FirstnameField.getText().isEmpty()
                    || SurnameField.getText().isEmpty()
                    || ContactNumberField.getText().isEmpty()
                    || AddressField.getText().isEmpty()
                    || DegreeField.getText().isEmpty()
                    || EmailAddressField.getText().isEmpty()
                    || SchoolField.getText().isEmpty()
                    || gender.isEmpty()
                    || guardFname.isEmpty()
                    || guardLname.isEmpty()
                    || guardContact.isEmpty()
                    || guardEmail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please input ALL necessary information");
            } else {
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
                    GuardianDAOImplementation guardImpl = new GuardianDAOImplementation();
                    guard.setFname(guardFname.toUpperCase());
                    guard.setLname(guardLname.toUpperCase());
                    guard.setContact(guardContact);
                    guard.setEmail(guardEmail);

                    boolean g = guardImpl.addGuardian(guard);
                    boolean t = tenantImpl.addTenant(tenant);
                    tenant = tenantImpl.getTenantByName(fname, lname);
                    guard = guardImpl.getGuardianByName(guardFname, guardLname);
                    boolean tg = guardImpl.assignTenantToGuardian(guard, tenant);
                    if (t && g && tg) {
                        guardImpl.assignTenantToGuardian(guard, tenant);

                        flag = true;
                    }

                    GuardianBean guard1 = new GuardianBean();
                    GuardianDAOImplementation guardImpl1 = new GuardianDAOImplementation();
                    boolean t1, g1, tg1;
                    t1 = false;
                    g1 = false;
                    tg1 = false;

                    if (ExistingGuardianRadioButton.isSelected()) {
                        String[] guardianSelected = ExistingGuardianComboBox.getSelectedItem().toString().split(":");
                        guard1 = guardImpl1.getGuardianByID(Integer.parseInt(guardianSelected[0]));
                        t1 = tenantImpl.addTenant(tenant);
                        g1 = true;

                    } else {
                        c.checkName(guardFname, "Guardian Firstname");
                        c.checkName(guardLname, "Guardian Lastname");
                        c.checkContact(guardContact, "Guardian Contact");
                        c.checkEmail(guardEmail, "Guardian Email");
                        guard1.setFname(guardFname.toUpperCase());
                        guard1.setLname(guardLname.toUpperCase());
                        guard1.setContact(guardContact);
                        guard1.setEmail(guardEmail);

                        g1 = guardImpl1.addGuardian(guard1);
                        t1 = tenantImpl.addTenant(tenant);
                        guard1 = guardImpl1.getGuardianByName(guardFname, guardLname);

                    }

                    tenant = tenantImpl.getTenantByName(fname, lname);
                    tg1 = guardImpl1.assignTenantToGuardian(guard, tenant);
                    if (t1 && g1 && tg1) {
                        flag = true;
                    }

                    if (flag) {
                        JOptionPane.showMessageDialog(null, "Tenant " + tenant.getFname() + " " + tenant.getLname() + " has successfully added.");
                        this.dispose();
                        MainMenu main = new MainMenu();
                        main.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Make sure to input all necessary information correcly.");
                    }
                } catch (AccountException e) {
                    e.promptFieldError();
                }
            }

            if (flag) {
                JOptionPane.showMessageDialog(null, "Tenant " + tenant.getFname() + " " + tenant.getLname() + " has successfully added.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Make sure to input all necessary information correcly.");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayFieldActionPerformed

    private void GuardianContactFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianContactFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianContactFieldActionPerformed

    private void FemaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleFieldActionPerformed

    private void MaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleFieldActionPerformed

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

    private void YearOfGraduationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearOfGraduationFieldActionPerformed

    private void SurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SurnameFieldActionPerformed

    private void GuardianFirstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianFirstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianFirstnameFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ExistingGuardianRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExistingGuardianRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExistingGuardianRadioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTextField ContactNumberField;
    private javax.swing.JComboBox DayField;
    private javax.swing.JTextField DegreeField;
    private javax.swing.JTextField EmailAddressField;
    private javax.swing.JComboBox ExistingGuardianComboBox;
    private javax.swing.JRadioButton ExistingGuardianRadioButton;
    private javax.swing.JRadioButton FemaleField;
    private javax.swing.JTextField FirstnameField;
    private javax.swing.JTextField GuardianContactField;
    private javax.swing.JTextField GuardianEmailField;
    private javax.swing.JTextField GuardianFirstnameField;
    private javax.swing.JTextField GuardianNameField;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
