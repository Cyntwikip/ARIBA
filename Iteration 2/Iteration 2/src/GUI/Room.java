package GUI;

import Models.Beans.ContractBean;
import Models.Beans.RoomBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.ContractDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.RoomDAOInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
public class Room extends javax.swing.JFrame {

    /**
     * Creates new form Room
     */
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private RoomDAOInterface rdao = new RoomDAOImplementation();
    private TenantDAOImplementation tdao = new TenantDAOImplementation();

    public Room() {
        initComponents();

        ArrayList<RoomBean> list = rdao.getAllRooms();

        model1 = (DefaultTableModel) jTable1.getModel();
        model2 = (DefaultTableModel) jTable2.getModel();

        for (RoomBean room : list) {
            jComboBox1.addItem(room.getRoomID());
        }

        TenantDAOImplementation tdao = new TenantDAOImplementation();
        ArrayList<TenantBean> tlist = tdao.getAllTenants();

        RoomDAOInterface rdao = new RoomDAOImplementation();
        RoomBean rbean = new RoomBean();
        tenantlist.removeAllItems();

        for (int i = 0; i < tlist.size(); i++) {
            rbean = rdao.getTenantRoom(tlist.get(i).getTenantID());
            System.out.println(rbean.getRoomID());
            if (rbean.getRoomID() == 0) {
                tenantlist.addItem(tlist.get(i).getLname() + ", " + tlist.get(i).getFname());

            } else {
            }
        }
        updateAvailableRooms();
    }

    public void updateAvailableRooms() {
        model2.getDataVector().removeAllElements();
        model2.fireTableDataChanged();

        ArrayList<RoomBean> availablerooms = rdao.getAllRooms();
        int roomID, count;

        for (int i = 0; i < availablerooms.size(); i++) {
            roomID = availablerooms.get(i).getRoomID();
            count = rdao.checkRoomCount(roomID);
            if (count < 4) {
                Object[] obj = {roomID, count};
                model2.addRow(obj);
            }
        }
    }

    public void updateTenants() {
        tenantlist.removeAllItems();

        RoomDAOInterface rdao = new RoomDAOImplementation();
        RoomBean rbean = new RoomBean();

        ArrayList<TenantBean> tlist = new ArrayList<TenantBean>();
        tlist = tdao.getAllTenants();

        for (int i = 0; i < tlist.size(); i++) {
            rbean = rdao.getTenantRoom(tlist.get(i).getTenantID());
            System.out.println(rbean.getRoomID());
            if (rbean.getRoomID() == 0) {
                tenantlist.addItem(tlist.get(i).getLname() + ", " + tlist.get(i).getFname());

            } else {
            }
        }
    }

    public void updateRoomAssignments() {
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();

        int roomID = (Integer) jComboBox1.getSelectedItem();

        System.out.println(roomID);
        ArrayList<TenantBean> tenantlist = new ArrayList<TenantBean>();
        RoomDAOInterface rdao = new RoomDAOImplementation();

        tenantlist = tdao.getTenantByRoomID(roomID);
        String name;

        if (tenantlist.isEmpty()) {
            model1.getDataVector().removeAllElements();
            model1.fireTableDataChanged();
        }
        for (int i = 0; i < tenantlist.size(); i++) {
            name = tenantlist.get(i).getFname() + " " + tenantlist.get(i).getLname();
            Object[] obj = {name};
            model1.addRow(obj);
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

        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tenantlist = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(180, 110, 130, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tenant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 150, 250, 210);

        tenantlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenantlistActionPerformed(evt);
            }
        });
        getContentPane().add(tenantlist);
        tenantlist.setBounds(500, 110, 220, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Population"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 160, 300, 160);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/assignroom.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(590, 330, 120, 40);

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 20, 100, 30);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 450);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/rooms-peg-edited.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(820, 480));
        jLabel2.setMinimumSize(new java.awt.Dimension(820, 480));
        jLabel2.setPreferredSize(new java.awt.Dimension(1020, 560));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Object temp = tenantlist.getSelectedItem();

        //System.out.println(fname);
        //System.out.println(lname);
        int roomID = jTable2.getSelectedRow() + 1;

        if (roomID == 0 && temp == null) {
            JOptionPane.showMessageDialog(null, "No tenant and room selected. Please choose from the list.");
        } else if (roomID == 0) {
            JOptionPane.showMessageDialog(null, "Please select a room.");
        } else if (temp == null) {
            JOptionPane.showMessageDialog(null, "Please select a tenant.");

        } else {
            String tempString = temp.toString();
            int index = tempString.indexOf(",");
            String lname = tempString.substring(0, index);
            String fname = tempString.substring(index + 2);

            RoomBean rbean = rdao.getRoomByRoomID(roomID);

            //System.out.println(roomID);
            TenantBean tbean = tdao.getTenantByName(fname, lname);

            ContractDAOImplementation cdao = new ContractDAOImplementation();
            ArrayList<ContractBean> contractlist = new ArrayList<ContractBean>();

            contractlist = cdao.getAllContractsByTenantID(tbean.getTenantID());

            int contractindex = contractlist.size() - 1;
            ContractBean currentContract = new ContractBean();

            if (contractindex >= 0) {
                currentContract = contractlist.get(contractindex);
                rdao.assignTenanttoRoom(tbean, rbean, currentContract);

                JOptionPane.showMessageDialog(null, "Successfully added tenant " + tbean.getFname() + " " + tbean.getLname()
                        + " to room " + rbean.getRoomID());
            } else {
                JOptionPane.showMessageDialog(null, "Tenant doesn't have contract.");
            }

            updateAvailableRooms();
            updateTenants();
            updateRoomAssignments();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        updateRoomAssignments();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void tenantlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenantlistActionPerformed

    }//GEN-LAST:event_tenantlistActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainMenu menu = new MainMenu();

        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Room.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox tenantlist;
    // End of variables declaration//GEN-END:variables
}
