/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer.GUI;

import Models.Beans.ContractBean;
import Models.Beans.GuardianBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.ContractDAOImplementation;
import Models.DAOImplementation.GuardianDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.ContractDAOInterface;
import Models.DAOInterface.GuardianDAOInterface;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Uy
 */
public class Add_Tenant extends javax.swing.JFrame {

    /**
     * Creates new form Add_Tenant
     */
    public boolean proceed = false;

    public Add_Tenant() {
        initComponents();

        GuardianDAOInterface guardiandao = new GuardianDAOImplementation();
        ArrayList<GuardianBean> guardianlist = new ArrayList<GuardianBean>();
        guardianlist = guardiandao.getAllGuardians();

        for (int i = 0; i < guardianlist.size(); i++) {
            choice1.add(guardianlist.get(i).getGuardianID() + ": " + guardianlist.get(i).getLname() + ", " + guardianlist.get(i).getFname());
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

        FirstNameField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        AddTenant = new javax.swing.JPanel();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        ContactNoLabel = new javax.swing.JLabel();
        GenderLabel = new javax.swing.JLabel();
        AddressLabel = new javax.swing.JLabel();
        DegreeLabel = new javax.swing.JLabel();
        SchoolLabel = new javax.swing.JLabel();
        GradYearLabel = new javax.swing.JLabel();
        FirstNameGuardLabel = new javax.swing.JLabel();
        LastNameGuardLabel = new javax.swing.JLabel();
        GuardianNoLabel = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        ContactNoField = new javax.swing.JTextField();
        GenderComboBox = new javax.swing.JComboBox();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        GradYearField = new javax.swing.JTextField();
        GuardianNameField1 = new javax.swing.JTextField();
        GuardianNameField2 = new javax.swing.JTextField();
        GuardianNoFIeld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        FirstNameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameField1ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddTenant.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Tenant"));

        FirstNameLabel.setText("First Name:");

        LastNameLabel.setText("Last Name:");

        ContactNoLabel.setText("Contact Number:");

        GenderLabel.setText("Gender:");

        AddressLabel.setText("Address:");

        DegreeLabel.setText("Degree:");

        SchoolLabel.setText("School:");

        GradYearLabel.setText("Expected Year of Graduation:");

        FirstNameGuardLabel.setText("First Name of Guardian:");

        LastNameGuardLabel.setText("Last Name of Guardian:");

        GuardianNoLabel.setText("Contact Number of Guardian:");

        FirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameFieldActionPerformed(evt);
            }
        });

        LastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameFieldActionPerformed(evt);
            }
        });

        ContactNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNoFieldActionPerformed(evt);
            }
        });

        GenderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        SchoolField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchoolFieldActionPerformed(evt);
            }
        });

        DegreeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegreeFieldActionPerformed(evt);
            }
        });

        GradYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradYearFieldActionPerformed(evt);
            }
        });

        GuardianNameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianNameField1ActionPerformed(evt);
            }
        });

        GuardianNameField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianNameField2ActionPerformed(evt);
            }
        });

        GuardianNoFIeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianNoFIeldActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        AddressField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        AddressField.setLineWrap(true);
        jScrollPane1.setViewportView(AddressField);

        jLabel1.setText("Existing guardian:");

        jLabel2.setText("If existing guardian, enter ID here:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddTenantLayout = new javax.swing.GroupLayout(AddTenant);
        AddTenant.setLayout(AddTenantLayout);
        AddTenantLayout.setHorizontalGroup(
            AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTenantLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(DegreeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DegreeField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(SchoolLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SchoolField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(FirstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(ContactNoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContactNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(GradYearLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GradYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(GenderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddTenantLayout.createSequentialGroup()
                            .addComponent(AddressLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddTenantLayout.createSequentialGroup()
                            .addComponent(LastNameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddTenantLayout.createSequentialGroup()
                                .addComponent(GuardianNoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GuardianNoFIeld))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddTenantLayout.createSequentialGroup()
                                .addComponent(LastNameGuardLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GuardianNameField2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddTenantLayout.createSequentialGroup()
                                .addComponent(FirstNameGuardLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GuardianNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        AddTenantLayout.setVerticalGroup(
            AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddTenantLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameLabel)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameLabel)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContactNoLabel)
                    .addComponent(ContactNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenderLabel)
                    .addComponent(GenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DegreeLabel)
                    .addComponent(DegreeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SchoolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SchoolLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GradYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GradYearLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameGuardLabel)
                    .addComponent(GuardianNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LastNameGuardLabel)
                    .addComponent(GuardianNameField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GuardianNoFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GuardianNoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jButton1.setActionCommand("BackButton");
        jButton1.setLabel("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddTenant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(AddTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FirstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFieldActionPerformed

    private void LastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldActionPerformed

    private void ContactNoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactNoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactNoFieldActionPerformed

    private void SchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SchoolFieldActionPerformed

    private void DegreeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegreeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DegreeFieldActionPerformed

    private void GradYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GradYearFieldActionPerformed

    private void FirstNameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameField1ActionPerformed

    private void GuardianNameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianNameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianNameField1ActionPerformed

    private void GuardianNameField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianNameField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianNameField2ActionPerformed

    private void GuardianNoFIeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianNoFIeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianNoFIeldActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // DAO IMPLEMENTATIONS

        TenantBean tenantAcc = new TenantBean();
        GuardianBean guardianAcc = new GuardianBean();
        proceed = true;
        boolean newguardian = true;
        int guardianID = 0;

        if (FirstNameField.getText().isEmpty()
                || LastNameField.getText().isEmpty()
                || ContactNoField.getText().isEmpty()
                || AddressField.getText().isEmpty()
                || DegreeField.getText().isEmpty()
                || SchoolField.getText().isEmpty()
                || GradYearField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill up ALL the fields.");
        } else {

            if (FirstNameField.getText().matches("^[0-9]*$")) {
                proceed = false;
            } else {
                if (FirstNameField.getText().matches("^[a-zA-Z ]+$")) {
                    tenantAcc.setFname(FirstNameField.getText());
                } else {
                    proceed = false;
                }
            }

            if (LastNameField.getText().matches("^[0-9]*$")) { //special chharacters
                proceed = false;

            } else {
                if (LastNameField.getText().matches("^[a-zA-Z ]+$")) {
                    tenantAcc.setLname(LastNameField.getText());
                } else {
                    proceed = false;
                }
            }

            if (ContactNoField.getText().matches("^\\d{11,12}")) { //numbers only
                tenantAcc.setContact(parseLong(ContactNoField.getText()));
            } else {
                proceed = false;
                System.out.println("Contact false");
            }

            tenantAcc.setGender(GenderComboBox.getSelectedItem().toString());

            tenantAcc.setAddress(AddressField.getText());

            tenantAcc.setDegree(DegreeField.getText());

                    tenantAcc.setSchool(SchoolField.getText());
            
            

            if (GradYearField.getText().matches("^\\d{4,4}$")) {
                tenantAcc.setExpectedyearofgrad(parseInt(GradYearField.getText()));
                System.out.println("Success");
            } else {
                System.out.println("fail");
                proceed = false;
            }
            tenantAcc.setStatus("Current");
// new guardian
            if (GuardianNameField1.getText().matches("^[0-9]*$") || GuardianNameField1.getText().isEmpty()) {
                if (GuardianNameField1.getText().isEmpty()) {
                    newguardian = false; //existing guardian
                    System.out.println("Fname1 if");
                } else {
                    proceed = false;
                    System.out.println("Fname1 if2");
                }
            } else {
                if (GuardianNameField1.getText().matches("^[a-zA-Z ]+$")) {
                    guardianAcc.setFname(GuardianNameField1.getText());
                } else {
                    proceed = false;
                }

            }

            if (GuardianNameField2.getText().matches("^[0-9]*$") || GuardianNameField2.getText().isEmpty()) {
                if (GuardianNameField2.getText().isEmpty()) {
                    newguardian = false;
                    System.out.println("Fname1 if");
                } else {
                    proceed = false;
                    System.out.println("Fname1 if2");
                }
            } else {
                if (GuardianNameField2.getText().matches("^[a-zA-Z ]+$")) {
                    guardianAcc.setLname(GuardianNameField2.getText());
                } else {
                    proceed = false;
                }
            }

            if (GuardianNoFIeld.getText().matches("^\\d{11,12}") || GuardianNoFIeld.getText().isEmpty()) {
                if (GuardianNoFIeld.getText().isEmpty()) {
                    System.out.println("Contact if");
                    Long contact = Long.valueOf(0);
                    guardianAcc.setContact(contact);
                } else {
                    System.out.println("Contact else");
                    guardianAcc.setContact(parseLong(GuardianNoFIeld.getText()));
                }

            } else {
                proceed = false;
                newguardian = false;
            }
        }

        if (proceed) {
            TenantDAOImplementation addTenant = new TenantDAOImplementation();
            addTenant.addTenant(tenantAcc);
            tenantAcc = addTenant.getTenantByName(tenantAcc.getFname(), tenantAcc.getLname());
            this.setVisible(false);
            TenantPage tenant = new TenantPage();
            tenant.setVisible(true);
            GuardianDAOInterface addGuardian = new GuardianDAOImplementation();

            if (newguardian) { //create new guardian
                addGuardian.addGuardian(guardianAcc);
                guardianAcc = addGuardian.getGuardianByName(guardianAcc.getFname(), guardianAcc.getLname());

            } else {
                if (GuardianNameField1.getText().isEmpty()
                        && GuardianNameField2.getText().isEmpty()
                        && GuardianNoFIeld.getText().isEmpty()) { // existing guardian
                    if (jTextField1.getText().isEmpty()) { // no guardian id
                        JOptionPane.showMessageDialog(null, "No guardian ID indicated");
                    } else {
                        if (jTextField1.getText().matches("[0-9]+")) {
                            guardianID = Integer.parseInt(jTextField1.getText());
                            guardianAcc = addGuardian.getGuardianByID(guardianID);
                            newguardian = false;
                        } else {
                            guardianID = Integer.parseInt(jTextField1.getText());
                            System.out.println(guardianID);
                            JOptionPane.showMessageDialog(null, "Please input ALL necessary information.:)");
                        }
                    }
                }
            }
            ContractBean contractAcc = new ContractBean();
            ContractDAOInterface contractdao = new ContractDAOImplementation();

            tenantAcc = addTenant.getTenantByName(tenantAcc.getFname(), tenantAcc.getLname());

            Date effectivedate = new Date(System.currentTimeMillis());
            java.util.Date utilexpirydate = DateUtil.addDays(effectivedate, 365);
            java.sql.Date expirydate = new java.sql.Date(utilexpirydate.getTime());

            contractAcc.setContract_tenantID(tenantAcc.getTenantID());
            contractAcc.setEffectivedate(effectivedate);
            contractAcc.setExpirydate(expirydate);

            contractdao.addContract(contractAcc);

            GuardianDAOInterface guardiandao = new GuardianDAOImplementation();
            guardiandao.assignTenantToGuardian(guardianAcc, tenantAcc);

            JOptionPane.showMessageDialog(null, "Successfully added tenant " + tenantAcc.getFname()
                    + " with tenant ID: " + tenantAcc.getTenantID());

        } else {
            JOptionPane.showMessageDialog(null, "Please input ALL necessary information.");
        }


    }//GEN-LAST:event_SaveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        TenantPage tenant = new TenantPage();
        tenant.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     *//*
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Tenant().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddTenant;
    private javax.swing.JTextArea AddressField;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField ContactNoField;
    private javax.swing.JLabel ContactNoLabel;
    private javax.swing.JTextField DegreeField;
    private javax.swing.JLabel DegreeLabel;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JTextField FirstNameField1;
    private javax.swing.JLabel FirstNameGuardLabel;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JComboBox GenderComboBox;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JTextField GradYearField;
    private javax.swing.JLabel GradYearLabel;
    private javax.swing.JTextField GuardianNameField1;
    private javax.swing.JTextField GuardianNameField2;
    private javax.swing.JTextField GuardianNoFIeld;
    private javax.swing.JLabel GuardianNoLabel;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel LastNameGuardLabel;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SchoolField;
    private javax.swing.JLabel SchoolLabel;
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
