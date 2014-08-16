/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jao
 */
public class AddTenantPanel extends javax.swing.JPanel {

    /**
     * Creates new form EditTenat
     */
    
    public AddTenantPanel() {
        
    }

    private TenantDAOInterface tdao = new TenantDAOImplementation();
    private GuardianDAOInterface gdao = new GuardianDAOImplementation();
    private int tenantID;
    private int guardID;
    private boolean flag = false;
    private TenantBean tenant = new TenantBean();
    private GuardianBean guard = new GuardianBean();
    private ImageIcon icon;
 
    public void EditTenant(int id) {
        initComponents();

        buttonGroup1.add(MaleField);
        buttonGroup1.add(FemaleField);
        
        tenant = tdao.getTenantById(id);
        int tenantID;
        tenantID = tenant.getTenantID();
        
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

        SurnameField.setText(tenant.getLname());
        FirstnameField.setText(tenant.getFname());
        jTextField3.setText(tenant.getAddress());
        if (tenant.getGender().equalsIgnoreCase("Male")) {
            MaleField.doClick();

        } else {
            FemaleField.doClick();
        }
        MaleField.setEnabled(false);
        FemaleField.setEnabled(false);
        ContactNumberField1.setText(tenant.getContact());
        EmailAddressField.setText(tenant.getEmail());
        SchoolField.setText(tenant.getSchool());
        DegreeField.setText(tenant.getDegree());
        YearOfGraduationField.setSelectedItem(tenant.getExpectedyearofgrad());

        // guardian part
        guard = gdao.getGuardianByTenantID(id);
        int guardID;
        guardID = guard.getGuardianID();

        GuardianFirstnameField.setText(guard.getFname());
        GuardianSurnameField.setText(guard.getLname());
        GuardianContactField.setText(guard.getContact());
        GuardianEmailField.setText(guard.getEmail());

        byte[] content = null;
        if (tenant.getBlobimage() != null) {
            try {
                content = tenant.getBlobimage().getBytes(1L, (int) tenant.getBlobimage().length());
            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon icon = new ImageIcon(content);
            Image img = icon.getImage();
            img = img.getScaledInstance(imgaddLabel.getWidth(), imgaddLabel.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            imgaddLabel.setIcon(icon);
        }

        tenant.setBlobimage(tenant.getBlobimage());

        //get birthday month
        for (int i = 0; i < MonthField.getItemCount(); i++) {
            if (MonthField.getItemAt(i).equals(new SimpleDateFormat("MMM").format(tenant.getBirthday()))) {
                MonthField.setSelectedIndex(id);
                break;
            }
        }

        //get birthday day
        for (int i = 0; i < DayField.getItemCount(); i++) {
            if (DayField.getItemAt(i).equals(new SimpleDateFormat("d").format(tenant.getBirthday()))) {
                DayField.setSelectedIndex(i);
                break;
            }
        }

        //get birthday year
        SimpleDateFormat yr = new SimpleDateFormat("yyyy");
        String c = yr.format(tenant.getBirthday());
        for (int i = 0; i < YearField.getItemCount(); i++) {
            if ((int) YearField.getItemAt(i) == Integer.parseInt(c)) {
                YearField.setSelectedIndex(i);
                break;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField3 = new javax.swing.JTextField();
        MaleField = new javax.swing.JRadioButton();
        FemaleField = new javax.swing.JRadioButton();
        ContactNumberField1 = new javax.swing.JTextField();
        EmailAddressField = new javax.swing.JTextField();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        YearOfGraduationField = new javax.swing.JComboBox();
        GuardianSurnameField = new javax.swing.JTextField();
        GuardianFirstnameField = new javax.swing.JTextField();
        GuardianContactField = new javax.swing.JTextField();
        GuardianEmailField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        imgaddLabel = new javax.swing.JLabel();
        MonthField = new javax.swing.JComboBox();
        DayField = new javax.swing.JComboBox();
        YearField = new javax.swing.JComboBox();
        FirstnameField = new javax.swing.JTextField();
        SurnameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jTextField3.setText("jTextField3");
        add(jTextField3);
        jTextField3.setBounds(430, 290, 170, 60);

        MaleField.setText("Male");
        MaleField.setActionCommand("Male");
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        add(MaleField);
        MaleField.setBounds(420, 360, 70, 23);

        FemaleField.setText("Female\n");
        FemaleField.setActionCommand("Female");
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        add(FemaleField);
        FemaleField.setBounds(500, 360, 90, 23);

        ContactNumberField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNumberField1ActionPerformed(evt);
            }
        });
        ContactNumberField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ContactNumberField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContactNumberField1FocusLost(evt);
            }
        });
        ContactNumberField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ContactNumberField1KeyReleased(evt);
            }
        });
        add(ContactNumberField1);
        ContactNumberField1.setBounds(470, 390, 130, 30);

        EmailAddressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmailAddressFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailAddressFieldFocusLost(evt);
            }
        });
        add(EmailAddressField);
        EmailAddressField.setBounds(470, 420, 130, 30);

        SchoolField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SchoolFieldFocusLost(evt);
            }
        });
        SchoolField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SchoolFieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SchoolFieldKeyReleased(evt);
            }
        });
        add(SchoolField);
        SchoolField.setBounds(650, 200, 190, 30);

        DegreeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DegreeFieldFocusLost(evt);
            }
        });
        DegreeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DegreeFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DegreeFieldKeyTyped(evt);
            }
        });
        add(DegreeField);
        DegreeField.setBounds(650, 230, 190, 30);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        add(YearOfGraduationField);
        YearOfGraduationField.setBounds(720, 260, 120, 30);

        GuardianSurnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GuardianSurnameFieldFocusLost(evt);
            }
        });
        GuardianSurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianSurnameFieldActionPerformed(evt);
            }
        });
        GuardianSurnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GuardianSurnameFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GuardianSurnameFieldKeyTyped(evt);
            }
        });
        add(GuardianSurnameField);
        GuardianSurnameField.setBounds(670, 330, 170, 30);

        GuardianFirstnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GuardianFirstnameFieldFocusLost(evt);
            }
        });
        GuardianFirstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianFirstnameFieldActionPerformed(evt);
            }
        });
        GuardianFirstnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GuardianFirstnameFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GuardianFirstnameFieldKeyTyped(evt);
            }
        });
        add(GuardianFirstnameField);
        GuardianFirstnameField.setBounds(670, 360, 170, 30);

        GuardianContactField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GuardianContactFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                GuardianContactFieldFocusLost(evt);
            }
        });
        GuardianContactField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GuardianContactFieldKeyReleased(evt);
            }
        });
        add(GuardianContactField);
        GuardianContactField.setBounds(700, 390, 140, 30);

        GuardianEmailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GuardianEmailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                GuardianEmailFieldFocusLost(evt);
            }
        });
        add(GuardianEmailField);
        GuardianEmailField.setBounds(700, 420, 140, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/save.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(760, 460, 80, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/backbutton.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(660, 460, 80, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/choosephoto.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(170, 400, 140, 40);

        imgaddLabel.setText("         Choose photo");
        add(imgaddLabel);
        imgaddLabel.setBounds(160, 230, 160, 160);

        MonthField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        MonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthFieldActionPerformed(evt);
            }
        });
        add(MonthField);
        MonthField.setBounds(420, 260, 60, 20);

        DayField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        DayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayFieldActionPerformed(evt);
            }
        });
        add(DayField);
        DayField.setBounds(480, 260, 50, 20);

        YearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearFieldActionPerformed(evt);
            }
        });
        add(YearField);
        YearField.setBounds(530, 260, 70, 20);

        FirstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstnameFieldActionPerformed(evt);
            }
        });
        FirstnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FirstnameFieldFocusLost(evt);
            }
        });
        FirstnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FirstnameFieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FirstnameFieldKeyReleased(evt);
            }
        });
        add(FirstnameField);
        FirstnameField.setBounds(430, 230, 170, 30);

        SurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurnameFieldActionPerformed(evt);
            }
        });
        SurnameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SurnameFieldFocusLost(evt);
            }
        });
        SurnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SurnameFieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SurnameFieldKeyReleased(evt);
            }
        });
        add(SurnameField);
        SurnameField.setBounds(430, 200, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/addedit-peg-edited.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void MaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleFieldActionPerformed

    private void FemaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleFieldActionPerformed

    private void ContactNumberField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactNumberField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactNumberField1ActionPerformed

    private void ContactNumberField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContactNumberField1FocusGained
        // TODO add your handling code here:
        ContactNumberField1.setBackground(Color.WHITE);
    }//GEN-LAST:event_ContactNumberField1FocusGained

    private void ContactNumberField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContactNumberField1FocusLost
        // TODO add your handling code here:
        String input = ContactNumberField1.getText();

        if (input.isEmpty()) {
            ContactNumberField1.setBackground(Color.PINK);
        } else if (input.length() != 11) {
            ContactNumberField1.setBackground(Color.PINK);
        } else {
            ContactNumberField1.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_ContactNumberField1FocusLost

    private void ContactNumberField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContactNumberField1KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim1;
        String trim2;
        String re1 = "^[0-9]*$";
        int last;
        if (!ContactNumberField1.getText().isEmpty()) {
            input = ContactNumberField1.getText();
        }

        if (input.matches(re1)) { // number
            if (input.length() > 11) {
                trim1 = input.substring(0, input.length() - 1);
                input = trim1;
            }// more than 11 numbers

        } else {

            trim1 = input.substring(0, input.indexOf(c));//first to index of character;
            trim2 = input.substring(input.indexOf(c) + 1);
            input = trim1 + trim2;
        }

        ContactNumberField1.setText(input);
    }//GEN-LAST:event_ContactNumberField1KeyReleased

    private void EmailAddressFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailAddressFieldFocusGained
        EmailAddressField.setBackground(Color.WHITE);
    }//GEN-LAST:event_EmailAddressFieldFocusGained

    private void EmailAddressFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailAddressFieldFocusLost
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = EmailAddressField.getText();

        try {
            check.checkEmail(input, "Email");
            EmailAddressField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            EmailAddressField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_EmailAddressFieldFocusLost

    private void SchoolFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SchoolFieldFocusLost
        String input = SchoolField.getText();

        if (input.isEmpty()) {
            SchoolField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_SchoolFieldFocusLost

    private void SchoolFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_SchoolFieldKeyTyped

    private void SchoolFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyReleased
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = SchoolField.getText();

        try {
            check.checkName(input, "Lastname");
            SchoolField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            SchoolField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_SchoolFieldKeyReleased

    private void DegreeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DegreeFieldFocusLost
        // TODO add your handling code here:
        String input = DegreeField.getText();

        if (input.isEmpty()) {
            DegreeField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_DegreeFieldFocusLost

    private void DegreeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeFieldKeyReleased
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = DegreeField.getText();

        try {
            check.checkName(input, "Lastname");
            DegreeField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            DegreeField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_DegreeFieldKeyReleased

    private void DegreeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_DegreeFieldKeyTyped

    private void YearOfGraduationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearOfGraduationFieldActionPerformed

    private void GuardianSurnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardianSurnameFieldFocusLost
        // TODO add your handling code here:
        String input = GuardianSurnameField.getText();

        if (input.isEmpty()) {
            GuardianSurnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_GuardianSurnameFieldFocusLost

    private void GuardianSurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianSurnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianSurnameFieldActionPerformed

    private void GuardianSurnameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuardianSurnameFieldKeyReleased
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = GuardianSurnameField.getText();

        try {
            check.checkName(input, "Lastname");
            GuardianSurnameField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            GuardianSurnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_GuardianSurnameFieldKeyReleased

    private void GuardianSurnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuardianSurnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_GuardianSurnameFieldKeyTyped

    private void GuardianFirstnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardianFirstnameFieldFocusLost
        // TODO add your handling code here:
        String input = GuardianFirstnameField.getText();

        if (input.isEmpty()) {
            GuardianFirstnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_GuardianFirstnameFieldFocusLost

    private void GuardianFirstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianFirstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianFirstnameFieldActionPerformed

    private void GuardianFirstnameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuardianFirstnameFieldKeyReleased
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = GuardianFirstnameField.getText();

        try {
            check.checkName(input, "Lastname");
            GuardianFirstnameField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            GuardianFirstnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_GuardianFirstnameFieldKeyReleased

    private void GuardianFirstnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuardianFirstnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_GuardianFirstnameFieldKeyTyped

    private void GuardianContactFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardianContactFieldFocusGained
        // TODO add your handling code here:
        GuardianContactField.setBackground(Color.WHITE);
    }//GEN-LAST:event_GuardianContactFieldFocusGained

    private void GuardianContactFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardianContactFieldFocusLost
        // TODO add your handling code here:
        String input = GuardianContactField.getText();

        if (input.isEmpty()) {
            GuardianContactField.setBackground(Color.PINK);
        } else if (input.length() != 11) {
            GuardianContactField.setBackground(Color.PINK);
        } else {
            GuardianContactField.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_GuardianContactFieldFocusLost

    private void GuardianContactFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuardianContactFieldKeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim1;
        String trim2;
        String re1 = "^[0-9]*$";
        int last;
        if (!GuardianContactField.getText().isEmpty()) {
            input = GuardianContactField.getText();
        }

        if (input.matches(re1)) { // number
            if (input.length() > 11) {
                trim1 = input.substring(0, input.length() - 1);
                input = trim1;
            }// more than 11 numbers

        } else {

            trim1 = input.substring(0, input.indexOf(c));//first to index of character;
            trim2 = input.substring(input.indexOf(c) + 1);
            input = trim1 + trim2;
        }

        GuardianContactField.setText(input);
    }//GEN-LAST:event_GuardianContactFieldKeyReleased

    private void GuardianEmailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardianEmailFieldFocusGained
        // TODO add your handling code here:
        GuardianEmailField.setBackground(Color.WHITE);
    }//GEN-LAST:event_GuardianEmailFieldFocusGained

    private void GuardianEmailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardianEmailFieldFocusLost
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = EmailAddressField.getText();

        try {
            check.checkEmail(input, "Email");
            EmailAddressField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            EmailAddressField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_GuardianEmailFieldFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        /*    */
        CheckAccount c = new CheckAccount();
        boolean tflag = false;
        String fname = FirstnameField.getText();
        String lname = SurnameField.getText();
        String degree = DegreeField.getText();
        String school = SchoolField.getText();
        String email = EmailAddressField.getText();
        String contact = ContactNumberField1.getText();
        String address = jTextField3.getText();
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

        GuardianBean guard = new GuardianBean();
        boolean empty = false;
        if (FirstnameField.getText().isEmpty()
                || SurnameField.getText().isEmpty()
                || ContactNumberField1.getText().isEmpty()
                || jTextField3.getText().isEmpty()
                || DegreeField.getText().isEmpty()
                || EmailAddressField.getText().isEmpty()
                || SchoolField.getText().isEmpty()
                || gender.isEmpty()
                || guardFname.isEmpty()
                || guardLname.isEmpty()
                || guardEmail.isEmpty()
                || guardContact.isEmpty()) {
            empty = true;
            JOptionPane.showMessageDialog(null, "Error: Make sure to input all necessary information correctly.");
        } else {
            empty = false;
            try {
                //error checking tenant
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

                /*                if (tenant.getBlobimage() == null) {
                 System.out.println("Yes");
                 }

                 if (tenant.getImage().isEmpty()) {
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
                
                 */
                //error checking guardian
                c.checkName(guardFname, "Guardian Firstname");
                c.checkName(guardLname, "Guardian Lastname");
                c.checkContact(guardContact, "Guardian Contact");
                c.checkEmail(guardEmail, "Guardian Email");

                //set guardian values
                guard.setFname(guardFname.toUpperCase());
                guard.setLname(guardLname.toUpperCase());
                guard.setContact(guardContact);
                guard.setEmail(guardEmail);

                // add tenant
                if (flag) {
                    boolean t1 = false, g1 = false, tg1;
                    g1 = gdao.addGuardian(guard);
                    t1 = tdao.addTenant(tenant);
                    tenant = tdao.getTenantByName(fname, lname);
                    guard = gdao.getGuardianByName(guardFname, guardLname);
                    tg1 = gdao.assignTenantToGuardian(guard, tenant);

                    tenant = tdao.getTenantByName(fname, lname);
                    guard = gdao.getGuardianByName(guardFname, guardLname);

                    if (t1 && g1 && tg1) {
                        ContractBean contractAcc = new ContractBean();
                        ContractDAOInterface contractdao = new ContractDAOImplementation();

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

                        JOptionPane.showMessageDialog(null, "Tenant " + tenant.getFname() + " " + tenant.getLname() + " has successfully added.");
                //        MainMenu main = new MainMenu();
                        //      main.setVisible(true);
                        //       this.dispose();

                    } else {
                        if (tenant != null) {
                            //            tenantImpl.deleteTenant(tenant);
                        }

                        if (guard != null) {
                            gdao.deleteGuardian(guard);
                        }

                        if (tg1) {
                            gdao.deleteAssignedTenantGuardian(tenant);
                        }
                        JOptionPane.showMessageDialog(null, "Error: Make sure to input all necessary information correctly.");
                    }

                    // edit tenant
                } else {
                    boolean edittenant = tdao.editTenant(tenant);
                    System.out.println(edittenant);
                    boolean editguardian = gdao.editGuardian(guard, guard.getGuardianID());
                    System.out.println(editguardian);
                    if (edittenant && editguardian) {
                        JOptionPane.showMessageDialog(null, "Tenant " + tenant.getFname() + " " + tenant.getLname() + "'s information has been successfully edited.");
                        //         this.dispose();
                        MainMenu main = new MainMenu();
                        main.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not successful");
                    }
                }
            } catch (AccountException e) {
                e.promptFieldError();
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        //       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, GIF & PNG Images", "jpg", "gif", "png", "jpeg");
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

    private void DayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayFieldActionPerformed

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

    private void FirstnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FirstnameFieldFocusLost
        // TODO add your handling code here:
        String input = FirstnameField.getText();

        if (input.isEmpty()) {
            FirstnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_FirstnameFieldFocusLost

    private void FirstnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_FirstnameFieldKeyTyped

    private void FirstnameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstnameFieldKeyReleased
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = FirstnameField.getText();

        try {
            check.checkName(input, "Lastname");
            FirstnameField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            FirstnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_FirstnameFieldKeyReleased

    private void SurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurnameFieldActionPerformed

    }//GEN-LAST:event_SurnameFieldActionPerformed

    private void SurnameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SurnameFieldFocusLost
        String input = SurnameField.getText();

        if (input.isEmpty()) {
            SurnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_SurnameFieldFocusLost

    private void SurnameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SurnameFieldKeyTyped
        // TODO add your handling code here:
        preventDigit(evt);
    }//GEN-LAST:event_SurnameFieldKeyTyped

    private void SurnameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SurnameFieldKeyReleased
        // TODO add your handling code here:
        CheckAccount check = new CheckAccount();

        String input = SurnameField.getText();

        try {
            check.checkName(input, "Lastname");
            SurnameField.setBackground(Color.WHITE);
        } catch (AccountException e) {
            SurnameField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_SurnameFieldKeyReleased

    private void FirstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstnameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ContactNumberField1;
    private javax.swing.JComboBox DayField;
    private javax.swing.JTextField DegreeField;
    private javax.swing.JTextField EmailAddressField;
    private javax.swing.JRadioButton FemaleField;
    private javax.swing.JTextField FirstnameField;
    private javax.swing.JTextField GuardianContactField;
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
    private javax.swing.JLabel imgaddLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    public void preventDigit(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            System.out.println("digit");
            evt.setKeyCode(KeyEvent.VK_BACK_SPACE);
            evt.consume();
        }
    }
}
