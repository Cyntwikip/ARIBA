/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Viewer.GUI;
import Models.Beans.TenantBean;
import Models.DAOImplementation.TenantDAOImplementation;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;

/**
 *
 * @author Paul Uy
 */
public class Add_Tenant extends javax.swing.JFrame {

    /**
     * Creates new form Add_Tenant
     */
    public Add_Tenant() {
        initComponents();
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
        SaveButton = new javax.swing.JButton();

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

        LastNameGuardLabel.setText("First Name of Guardian:");

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
                        .addComponent(FirstNameGuardLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuardianNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(GuardianNoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuardianNoFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(GenderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createSequentialGroup()
                        .addComponent(LastNameGuardLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GuardianNameField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddTenantLayout.createSequentialGroup()
                            .addComponent(AddressLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddTenantLayout.createSequentialGroup()
                            .addComponent(LastNameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
                    .addComponent(GuardianNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LastNameGuardLabel)
                    .addComponent(GuardianNameField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GuardianNoFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuardianNoLabel))
                .addContainerGap())
        );

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
                    .addComponent(AddTenant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SaveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveButton)
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
        this.setVisible(false);
        TenantPage tenant = new TenantPage();
        tenant.setVisible(true);
        
        TenantBean tenantAcc = new TenantBean();
        tenantAcc.setFname(FirstNameField.getText());
        tenantAcc.setLname(LastNameField.getText());
        tenantAcc.setContact(parseLong(ContactNoField.getText()));
        tenantAcc.setGender(GenderComboBox.getSelectedItem().toString());
        tenantAcc.setAddress(AddressField.getText());
        tenantAcc.setDegree(DegreeField.getText());
        tenantAcc.setSchool(SchoolField.getText());
        tenantAcc.setExpectedyearofgrad(parseInt(GradYearField.getText()));
        tenantAcc.setStatus("Registered");
        
        TenantDAOImplementation addTenant = new TenantDAOImplementation();
        addTenant.addTenant(tenantAcc);
        
    }//GEN-LAST:event_SaveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
