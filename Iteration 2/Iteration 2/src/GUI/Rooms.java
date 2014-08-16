/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author jao
 */
public class Rooms extends javax.swing.JPanel {

    /**
     * Creates new form Rooms
     */
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private RoomDAOInterface rdao = new RoomDAOImplementation();
    private TenantDAOImplementation tdao = new TenantDAOImplementation();

    public Rooms() {
        initComponents();

        ArrayList<RoomBean> list = rdao.getAllRooms();

        model1 = (DefaultTableModel) jTable1.getModel();
        model2 = (DefaultTableModel) jTable2.getModel();

        for (RoomBean room : list) {
            jComboBox1.addItem(room.getRoomID());
        }

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

        int roomID = (Integer) tenantlist.getSelectedItem();

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

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tenantlist = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 650));
        setLayout(null);

        jPanel2.setLayout(null);

        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(30, 23, 110, 30);

        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(250, 120, 200, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Surname", "First name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(150, 160, 320, 402);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Population"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(540, 160, 330, 370);

        tenantlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(tenantlist);
        tenantlist.setBounds(630, 120, 200, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/assignroom.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(740, 540, 120, 40);

        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(250, 23, 100, 30);

        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(350, 23, 110, 30);

        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(460, 23, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/rooms-tab-peg-edited.png"))); // NOI18N
        jScrollPane3.setViewportView(jLabel1);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(0, 0, 1000, 650);
        jScrollPane3.getAccessibleContext().setAccessibleParent(null);

        add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 640);
        jPanel2.getAccessibleContext().setAccessibleParent(jScrollPane3);
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    
        jButton1.hide();
        jButton2.hide();
        jButton3.hide();
        jButton4.hide();
        jButton5.hide();
        jComboBox1.hide();
        tenantlist.hide();
        jScrollPane1.hide();
        jScrollPane2.hide();
        jTable1.hide();
        jTable2.hide();
        
        
        
        TenantPanel t = new TenantPanel();
        jScrollPane3.setViewportView(t);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
                jButton1.hide();
        jButton2.hide();
        jButton3.hide();
        jButton4.hide();
        jButton5.hide();
        jComboBox1.hide();
        tenantlist.hide();
        jScrollPane1.hide();
        jScrollPane2.hide();
        jTable1.hide();
        jTable2.hide();
        
        
        
        BillsPanel bp = new BillsPanel();
        jScrollPane3.setViewportView(bp);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
                jButton1.hide();
        jButton2.hide();
        jButton3.hide();
        jButton4.hide();
        jButton5.hide();
        jComboBox1.hide();
        tenantlist.hide();
        jScrollPane1.hide();
        jScrollPane2.hide();
        jTable1.hide();
        jTable2.hide();
        
        
        AdminLoggingPanel al = new AdminLoggingPanel();
        TenantLoggingPanel tl = new TenantLoggingPanel();
       jScrollPane3.setViewportView(al);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
                jButton1.hide();
        jButton2.hide();
        jButton3.hide();
        jButton4.hide();
        jButton5.hide();
        jComboBox1.hide();
        tenantlist.hide();
        jScrollPane1.hide();
        jScrollPane2.hide();
        jTable1.hide();
        jTable2.hide();
        
        
        
        ReportPanel rp = new ReportPanel();
        jScrollPane3.setViewportView(rp);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox tenantlist;
    // End of variables declaration//GEN-END:variables
}
