/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Beans.RoomBillBean;
import Models.Beans.ContractBean;
import Models.Beans.ElectricReadingBean;
import Models.Beans.RoomBean;
import Models.Beans.TenantBean;
import Models.Beans.WaterReadingBean;
import Models.DAOImplementation.RoomBillDAOImplementation;
import Models.DAOImplementation.ContractDAOImplementation;
import Models.DAOImplementation.ElectricReadingDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOImplementation.WaterDAOImplementation;
import Models.DAOInterface.RoomBillDAOInterface;
import Models.DAOInterface.ElectricReadingDAOInterface;
import Models.DAOInterface.RoomDAOInterface;
import Models.DAOInterface.WaterReadingDAOInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giodee
 */
public class RoomPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form RoomPanelFinal
     */
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private RoomDAOInterface rdao = new RoomDAOImplementation();
    private TenantDAOImplementation tdao = new TenantDAOImplementation();

    public RoomPanelFinal() {
        initComponents();

        ArrayList<RoomBean> list = rdao.getAllRooms();

        model1 = (DefaultTableModel) jTable1.getModel();
        model2 = (DefaultTableModel) jTable2.getModel();

        for (RoomBean room : list) {
            jComboBox1.addItem(room.getRoomID());
        }

        //lists of tenants that can be assigned to room
        ArrayList<TenantBean> tlist = tdao.getTenantByStatus("CURRENT");
        RoomDAOInterface rdao = new RoomDAOImplementation();
        RoomBean rbean = new RoomBean();
        tenantlist.removeAllItems();

        for (int i = 0; i < tlist.size(); i++) {
            rbean = rdao.getTenantRoom(tlist.get(i).getTenantID());
            if (rbean.getRoomID()==0) {
                tenantlist.addItem(tlist.get(i).getLname() + ", " + tlist.get(i).getFname());
            } else {
            }
        }
        if (tenantlist.getItemCount() == 0) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
        updateAvailableRooms();
    }

    public void updateAvailableRooms() {
        model2.getDataVector().removeAllElements();
        model2.fireTableDataChanged();

        ArrayList<RoomBean> availablerooms = rdao.getAllRooms();
        int roomID, count=0;

        for (int i = 0; i < availablerooms.size(); i++) {
            roomID = availablerooms.get(i).getRoomID();
            count = rdao.checkRoomCount(roomID);
            if (count < 4) {
                Object[] obj = {roomID, count};
                model2.addRow(obj);
            }
        }
        
        for(int j=0; j<availablerooms.size(); j++) {
            roomID = availablerooms.get(j).getRoomID();
            count = rdao.checkRoomCount(roomID);
            if(count>0) {
                rdao.setOccupied(availablerooms.get(j));
            }
            else {
                rdao.setUnoccupied(availablerooms.get(j));
            }
        }
        
        jTable2.requestFocus();
        jTable2.changeSelection(0, 0, false, false);
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
        if (tenantlist.getItemCount() == 0) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
    }

    public void updateRoomAssignments() {
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();

        int roomID = jComboBox1.getSelectedIndex() + 1;
        System.out.println(roomID);
        ArrayList<TenantBean> tenantlistfinal = new ArrayList<TenantBean>();
        RoomDAOInterface rdao = new RoomDAOImplementation();

        tenantlistfinal = tdao.getTenantByRoomID(roomID);
        String fname;
        String lname;

        if (tenantlistfinal.isEmpty()) {
            model1.getDataVector().removeAllElements();
            model1.fireTableDataChanged();
        }
        for (int i = 0; i < tenantlistfinal.size(); i++) {
            fname = tenantlistfinal.get(i).getFname();
            lname = tenantlistfinal.get(i).getLname();
            Object[] obj = {lname, fname};
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

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setPreferredSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(240, 60, 200, 30);

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

        add(jScrollPane1);
        jScrollPane1.setBounds(140, 100, 330, 410);

        tenantlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Tenant" }));
        tenantlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenantlistActionPerformed(evt);
            }
        });
        add(tenantlist);
        tenantlist.setBounds(630, 60, 200, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Population"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2);
        jScrollPane2.setBounds(520, 100, 340, 380);

        jButton1.setBackground(new java.awt.Color(0, 51, 0));
        jButton1.setForeground(new java.awt.Color(0, 51, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/assignroom.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setEnabled(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(740, 480, 120, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/addroom.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(530, 490, 120, 41);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/rooms-tab-peg-panel.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1000, 596));
        jLabel1.setMinimumSize(new java.awt.Dimension(1000, 596));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 596));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Object temp = tenantlist.getSelectedItem();

        //System.out.println(fname);
        //System.out.println(lname);
        int selectedrow = jTable2.getSelectedRow();
        int roomID = (Integer) jTable2.getValueAt(selectedrow, 0);
        System.out.println(roomID);

        System.out.println("chosen room:" + roomID);
        if (roomID == 0 && temp == null) {
            //          jButton1.setEnabled(false);
            //          JOptionPane.showMessageDialog(null, "No tenant and room selected. Please choose from the list.");
        } else if (roomID == 0) {
            //         jButton1.setEnabled(false);
            //         JOptionPane.showMessageDialog(null, "Please select a room.");
        } else if (temp == null) {
            //         jButton1.setEnabled(false);
            //JOptionPane.showMessageDialog(null, "Please select a tenant.");

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

                //JOptionPane.showMessageDialog(null, "Successfully added tenant " + tbean.getFname() + " " + tbean.getLname()
                //        + " to room " + rbean.getRoomID());
            } else {
                JOptionPane.showMessageDialog(null, "Tenant doesn't have contract.");
            }

            updateAvailableRooms();
            updateTenants();
            updateRoomAssignments();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tenantlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenantlistActionPerformed
        // TODO add your handling code here:

        int i = tenantlist.getSelectedIndex();
        int roomID = jTable2.getSelectedRow() + 1;

        System.out.println("selected" + roomID);

        if (i == -1 && roomID == -1) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }

    }//GEN-LAST:event_tenantlistActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        updateRoomAssignments();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        // check the room
        Object temp = tenantlist.getSelectedItem();

        //System.out.println(fname);
        //System.out.println(lname);
        int selectedrow = jTable2.getSelectedRow();
        int roomID = (Integer) jTable2.getValueAt(selectedrow, 0);
        System.out.println(roomID);

        System.out.println("chosen room:" + roomID);
        if (roomID == 0 && temp == null) {
            //          jButton1.setEnabled(false);
            //          JOptionPane.showMessageDialog(null, "No tenant and room selected. Please choose from the list.");
        } else if (roomID == 0) {
            //         jButton1.setEnabled(false);
            //         JOptionPane.showMessageDialog(null, "Please select a room.");
        } else if (temp == null) {
            //         jButton1.setEnabled(false);
            //JOptionPane.showMessageDialog(null, "Please select a tenant.");

        } else {
            String tempString = temp.toString();
            int index = tempString.indexOf(",");
            String lname = tempString.substring(0, index);
            String fname = tempString.substring(index + 2);

            RoomBean rbean = rdao.getRoomByRoomID(roomID);

            //System.out.println(roomID);
            TenantBean tbean = tdao.getTenantByName(fname, lname);
            ArrayList<TenantBean> tlist = new ArrayList<TenantBean>();
            tlist = tdao.getTenantByRoomID(rbean.getRoomID());

            String gender = tbean.getGender();
            if (!tlist.isEmpty()) {
                if (tlist.get(tlist.size() - 1).getGender().equals(gender)) {

                    jButton1.setEnabled(true);
                } else {
                    jButton1.setEnabled(false);
                }
            } else {

                jButton1.setEnabled(true);

                updateRoomAssignments();

            }
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:

        Object temp = tenantlist.getSelectedItem();

        int selectedrow = jTable2.getSelectedRow();
        int roomID = (Integer) jTable2.getValueAt(selectedrow, 0);
        System.out.println(roomID);

        System.out.println("chosen room:" + roomID);
        if (roomID == 0 && temp == null) {
            //          jButton1.setEnabled(false);
            //          JOptionPane.showMessageDialog(null, "No tenant and room selected. Please choose from the list.");
        } else if (roomID == 0) {
            //         jButton1.setEnabled(false);
            //         JOptionPane.showMessageDialog(null, "Please select a room.");
        } else if (temp == null) {
            //         jButton1.setEnabled(false);
            //JOptionPane.showMessageDialog(null, "Please select a tenant.");

        } else {
            String tempString = temp.toString();
            int index = tempString.indexOf(",");
            String lname = tempString.substring(0, index);
            String fname = tempString.substring(index + 2);

            RoomBean rbean = rdao.getRoomByRoomID(roomID);

            //System.out.println(roomID);
            TenantBean tbean = tdao.getTenantByName(fname, lname);
            ArrayList<TenantBean> tlist = new ArrayList<TenantBean>();
            tlist = tdao.getTenantByRoomID(rbean.getRoomID());

            String gender = tbean.getGender();
            if (!tlist.isEmpty()) {
                if (tlist.get(tlist.size() - 1).getGender().equals(gender)) {

                    jButton1.setEnabled(true);
                } else {
                    jButton1.setEnabled(false);
                }
            } else {

                jButton1.setEnabled(true);

                updateRoomAssignments();

            }
        }
    }//GEN-LAST:event_jTable2MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RoomDAOInterface rdao = new RoomDAOImplementation();
        RoomBean rbean = new RoomBean();
        ArrayList<RoomBean> rbeanlist = new ArrayList<RoomBean>();
        rbean.setStatus("Unoccupied");

        rbeanlist = rdao.getAllRooms();

        RoomBillDAOInterface bdao = new RoomBillDAOImplementation();
        RoomBillBean bbean = new RoomBillBean();
        ArrayList<ElectricReadingBean> ebeanlist = new ArrayList<ElectricReadingBean>();
        ArrayList<WaterReadingBean> wbeanlist = new ArrayList<WaterReadingBean>();
        ElectricReadingBean ebean = new ElectricReadingBean();
        ElectricReadingBean ebeantemp = new ElectricReadingBean();
        ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
        WaterReadingBean wbean = new WaterReadingBean();
        WaterReadingBean wbeantemp = new WaterReadingBean();
        WaterReadingDAOInterface wdao = new WaterDAOImplementation();
        rdao.addRoom(rbean);
        updateAvailableRooms();


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox tenantlist;
    // End of variables declaration//GEN-END:variables
}
