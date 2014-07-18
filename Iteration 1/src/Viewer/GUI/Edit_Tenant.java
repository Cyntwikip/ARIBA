/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer.GUI;

import Models.Beans.GuardianBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.GuardianDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pbu_015
 */
public class Edit_Tenant extends javax.swing.JFrame {

    /**
     * Creates new form Edit_Tenant
     */
    /*
     public Edit_Tenant() {
     initComponents();
     }
     */
    public boolean proceed = false;

    public Edit_Tenant(int tenantID) {
        initComponents();

        TenantDAOImplementation tdao = new TenantDAOImplementation();
        TenantBean tenant = new TenantBean();

        GuardianDAOImplementation gdao = new GuardianDAOImplementation();
        GuardianBean guardian = new GuardianBean();

        tenant = tdao.getTenantById(tenantID);
        guardian = gdao.getGuardianByTenant(tenant.getFname(), tenant.getLname());

        FirstNameField.setText(tenant.getFname());
        LastNameField.setText(tenant.getLname());
        ContactNoField.setText("0" + tenant.getContact().toString());
        GenderComboBox.setSelectedItem(tenant.getGender());
        AddressField.setText(tenant.getAddress());
        DegreeField.setText(tenant.getDegree());
        SchoolField.setText(tenant.getSchool());
        GradYearField.setText(Integer.toString(tenant.getExpectedyearofgrad()));
        GuardianNameField1.setText(guardian.getFname());
        GuardianNameField2.setText(guardian.getLname());
        GuardianNoFIeld.setText("0" + guardian.getContact().toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EditTenant = new javax.swing.JPanel();
        FirstNameField = new javax.swing.JTextField();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        LastNameField = new javax.swing.JTextField();
        ContactNoLabel = new javax.swing.JLabel();
        ContactNoField = new javax.swing.JTextField();
        GenderLabel = new javax.swing.JLabel();
        GenderComboBox = new javax.swing.JComboBox();
        AddressLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        DegreeLabel = new javax.swing.JLabel();
        DegreeField = new javax.swing.JTextField();
        SchoolLabel = new javax.swing.JLabel();
        SchoolField = new javax.swing.JTextField();
        GradYearLabel = new javax.swing.JLabel();
        GradYearField = new javax.swing.JTextField();
        FirstNameGuardLabel = new javax.swing.JLabel();
        GuardianNameField1 = new javax.swing.JTextField();
        LastNameGuardLabel = new javax.swing.JLabel();
        GuardianNameField2 = new javax.swing.JTextField();
        GuardianNoLabel = new javax.swing.JLabel();
        GuardianNoFIeld = new javax.swing.JTextField();
        Back_AddTenant = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EditTenant.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Tenant"));
        EditTenant.setPreferredSize(new java.awt.Dimension(370, 500));

        FirstNameField.setText("<insert previous info>");
        FirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameFieldActionPerformed(evt);
            }
        });

        FirstNameLabel.setText("First Name:");

        LastNameLabel.setText("Last Name:");

        LastNameField.setText("<insert previous info>");
        LastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameFieldActionPerformed(evt);
            }
        });

        ContactNoLabel.setText("Contact Number: (11 - 12 digits only)");

        ContactNoField.setText("<insert previous info>");
        ContactNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNoFieldActionPerformed(evt);
            }
        });

        GenderLabel.setText("Gender:");

        GenderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        AddressLabel.setText("Address:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        AddressField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        AddressField.setLineWrap(true);
        AddressField.setText("<insert previous info>");
        jScrollPane1.setViewportView(AddressField);

        DegreeLabel.setText("Degree:");

        DegreeField.setText("<insert previous info>");
        DegreeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegreeFieldActionPerformed(evt);
            }
        });

        SchoolLabel.setText("School:");

        SchoolField.setText("<insert previous info>");
        SchoolField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchoolFieldActionPerformed(evt);
            }
        });

        GradYearLabel.setText("Expected Year of Graduation:");

        GradYearField.setText("<insert previous info>");
        GradYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradYearFieldActionPerformed(evt);
            }
        });

        FirstNameGuardLabel.setText("First Name of Guardian:");

        GuardianNameField1.setText("<insert previous info>");
        GuardianNameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianNameField1ActionPerformed(evt);
            }
        });

        LastNameGuardLabel.setText("Last Name of Guardian:");

        GuardianNameField2.setText("<insert previous info>");
        GuardianNameField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianNameField2ActionPerformed(evt);
            }
        });

        GuardianNoLabel.setText("Contact Number of Guardian: (11-12 digits only)");

        GuardianNoFIeld.setText("<insert previous info>");
        GuardianNoFIeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardianNoFIeldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditTenantLayout = new javax.swing.GroupLayout(EditTenant);
        EditTenant.setLayout(EditTenantLayout);
        EditTenantLayout.setHorizontalGroup(
            EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditTenantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditTenantLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(FirstNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(ContactNoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ContactNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(LastNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addGroup(EditTenantLayout.createSequentialGroup()
                        .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(GenderLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(AddressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(DegreeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DegreeField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(SchoolLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SchoolField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(GradYearLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GradYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditTenantLayout.createSequentialGroup()
                                .addComponent(FirstNameGuardLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GuardianNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(EditTenantLayout.createSequentialGroup()
                        .addComponent(LastNameGuardLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GuardianNameField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(EditTenantLayout.createSequentialGroup()
                        .addComponent(GuardianNoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuardianNoFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        EditTenantLayout.setVerticalGroup(
            EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditTenantLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameLabel)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameLabel)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContactNoLabel)
                    .addComponent(ContactNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenderLabel)
                    .addComponent(GenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DegreeLabel)
                    .addComponent(DegreeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SchoolLabel)
                    .addComponent(SchoolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GradYearLabel)
                    .addComponent(GradYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameGuardLabel)
                    .addComponent(GuardianNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameGuardLabel)
                    .addComponent(GuardianNameField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardianNoLabel)
                    .addComponent(GuardianNoFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        Back_AddTenant.setText("Back");
        Back_AddTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_AddTenantActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditTenant, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Back_AddTenant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EditTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(Back_AddTenant))
                .addContainerGap())
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

    private void DegreeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegreeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DegreeFieldActionPerformed

    private void SchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SchoolFieldActionPerformed

    private void GradYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GradYearFieldActionPerformed

    private void GuardianNameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianNameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianNameField1ActionPerformed

    private void GuardianNameField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianNameField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianNameField2ActionPerformed

    private void GuardianNoFIeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardianNoFIeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardianNoFIeldActionPerformed

    private void Back_AddTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_AddTenantActionPerformed
        this.setVisible(false);

        EditTenantPage tenant = new EditTenantPage();
        tenant.setVisible(true);
    }//GEN-LAST:event_Back_AddTenantActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        TenantBean tenantbean = new TenantBean();
        GuardianBean editedguardian = new GuardianBean();

        String fname = FirstNameField.getText();
        String lname = LastNameField.getText();
        String gender = GenderComboBox.getSelectedItem().toString();
        String address = AddressField.getText();
        String degree = DegreeField.getText();
        String school = SchoolField.getText();
        String guarfname = GuardianNameField1.getText();
        String guarlname = GuardianNameField2.getText();

        proceed = true;
        boolean newguardian = true;

        if (FirstNameField.getText().isEmpty()
                || LastNameField.getText().isEmpty()
                || ContactNoField.getText().isEmpty()
                || AddressField.getText().isEmpty()
                || DegreeField.getText().isEmpty()
                || SchoolField.getText().isEmpty()
                || GradYearField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill up ALL the fields.");
        } else {

            //First Name
            if (FirstNameField.getText().matches("^[0-9]*$")) {
                proceed = false;
            } else {
                if (fname.matches("^[a-zA-Z ]+$")) {
                    tenantbean.setFname(fname);
                } else {
                    proceed = false;
                }
            }

            //Last Name
            if (LastNameField.getText().matches("^[0-9]*$")) {
                proceed = false;
            } else {
                if (lname.matches("^[a-zA-Z ]+$")) {
                    tenantbean.setLname(lname);
                } else {
                    proceed = false;
                }
            }

            //Contact
            if (ContactNoField.getText().matches("^\\d{11,12}")) {
                Long contact = parseLong(ContactNoField.getText());

                tenantbean.setContact(contact);
            } else {
                proceed = false;
                System.out.println("Contact false");
            }

        }

        //Gender
        tenantbean.setGender(gender);
        //Address
        tenantbean.setAddress(address);
        //Degree
        tenantbean.setDegree(degree);
        //School
        tenantbean.setSchool(school);
        //Expected Year
        if (GradYearField.getText().matches("^\\d{4,4}$")) {
            int grad = parseInt(GradYearField.getText());
            tenantbean.setExpectedyearofgrad(grad);
            System.out.println("Success");
        } else {
            System.out.println("fail");
            proceed = false;
        }

        //Status
        tenantbean.setStatus("Current");

        //Set Guardian First Name
        if (GuardianNameField1.getText().matches("^[0-9]*$")
                || GuardianNameField1.getText().isEmpty()) {
            if (GuardianNameField1.getText().isEmpty()) {
                newguardian = false; //existing guardian
                System.out.println("Fname1 if");
            } else {
                proceed = false;
                System.out.println("Fname1 if2");
            }
        } else {
            if (GuardianNameField1.getText().matches("^[a-zA-Z ]+$")) {
                editedguardian.setFname(guarfname);
            } else {
                proceed = false;
            }
        }

        if (GuardianNameField2.getText().matches("^[0-9]*$")
                || GuardianNameField2.getText().isEmpty()) {
            if (GuardianNameField2.getText().isEmpty()) {
                newguardian = false;
                System.out.println("Lname if");
            } else {
                proceed = false;
                System.out.println("Lname if2");
            }
        } else {
            if (GuardianNameField2.getText().matches("^[a-zA-Z ]+$")) {
                editedguardian.setLname(guarlname);
            } else {
                proceed = false;
            }
        }

        if (GuardianNoFIeld.getText().matches("^\\d{11,12}")
                || GuardianNoFIeld.getText().isEmpty()) {
            if (GuardianNoFIeld.getText().isEmpty()) {
                System.out.println("Contact if");
                Long temp = Long.valueOf(0);
                editedguardian.setContact(temp);
            } else {
                Long gcontact = parseLong(GuardianNoFIeld.getText());

                System.out.println("Contact else");
                editedguardian.setContact(gcontact);
            }
        } else {
            proceed = false;
            newguardian = false;
        }

        if (proceed && newguardian) {
            TenantDAOImplementation tenantdao = new TenantDAOImplementation();
            tenantdao.editTenant(tenantbean, fname, lname);

            this.setVisible(false);
            TenantPage tenant = new TenantPage();
            tenant.setVisible(true);

            GuardianDAOImplementation guardiandao = new GuardianDAOImplementation();
            GuardianBean guardianbean = new GuardianBean();
            guardianbean = guardiandao.getGuardianByTenant(fname, lname);
            guardiandao.editGuardian(editedguardian, guardianbean.getGuardianID());

            JOptionPane.showMessageDialog(null, "Successfully edited tenant");
        } else {
            JOptionPane.showMessageDialog(null, "Please input ALL neccessary information.");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //new Edit_Tenant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressField;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JButton Back_AddTenant;
    private javax.swing.JTextField ContactNoField;
    private javax.swing.JLabel ContactNoLabel;
    private javax.swing.JTextField DegreeField;
    private javax.swing.JLabel DegreeLabel;
    private javax.swing.JPanel EditTenant;
    private javax.swing.JTextField FirstNameField;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private String ParseInt(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
