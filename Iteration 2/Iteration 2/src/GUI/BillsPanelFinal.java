/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Giodee
 */
import Models.Beans.BillBean;
import Models.Beans.ElectricReadingBean;
import Models.Beans.RoomBean;
import Models.Beans.WaterReadingBean;
import Models.DAOImplementation.BillDAOImplementation;
import Models.DAOImplementation.ElectricReadingDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.WaterDAOImplementation;
import Models.DAOInterface.BillDAOInterface;
import Models.DAOInterface.ElectricReadingDAOInterface;
import Models.DAOInterface.RoomDAOInterface;
import Models.DAOInterface.WaterReadingDAOInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BillsPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form BillsPanelFinal
     */
    public RoomDAOInterface rdao = new RoomDAOImplementation();
    public BillDAOInterface bdao = new BillDAOImplementation();
    private float priceperkw;
    private float pricepercubicmeter;
    private String year;
    private String month;
    private DefaultTableModel model;
    private JPanel jPanel2;

    public BillsPanelFinal() {
        initComponents();

        model = (DefaultTableModel) jTable1.getModel();
        initdate();

        roomlist();
        roomtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setPreferredSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(220, 120, 160, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Room", "Bill Amount", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(470, 50, 340, 410);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(300, 220, 100, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(300, 260, 100, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        add(jTextField2);
        jTextField2.setBounds(300, 300, 100, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/computeforbills.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(200, 350, 190, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/editoverallbills.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(200, 390, 190, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/paid.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(540, 510, 100, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/unpaid.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(660, 510, 100, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/bills-tab-peg-edited-panel.png"))); // NOI18N
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^(\\d*\\.?\\d*)$";
        int last;
        if (!jTextField1.getText().isEmpty()) {
            input = jTextField1.getText();
        }

        if (input.matches(re1)) {

        } else {
            trim = input.substring(0, input.length() - 1);
            input = trim;
            System.out.println(trim);
        }

        jTextField1.setText(input);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^(\\d*\\.?\\d*)$";
        int last;
        if (!jTextField2.getText().isEmpty()) {
            input = jTextField2.getText();
        }

        if (input.matches(re1)) {

        } else {
            trim = input.substring(0, input.length() - 1);
            input = trim;
            System.out.println(trim);
        }

        jTextField2.setText(input);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        BillDAOInterface bdao = new BillDAOImplementation();
        BillBean bbean = new BillBean();
        ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
        ElectricReadingBean ebean = new ElectricReadingBean();
        WaterReadingBean wbean = new WaterReadingBean();
        WaterReadingDAOInterface wdao = new WaterDAOImplementation();
        int roomID = (Integer) jComboBox1.getSelectedItem();

        //System.out.println(roomID);
        bbean = bdao.getBillsByRoomID(roomID);
        float electricprice;
        float waterprice;
        ArrayList<BillBean> blist = new ArrayList<BillBean>();
        blist = bdao.getAllBills();

        if (jTextField1.getText().isEmpty() && jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input values for Electric Meter and Water Meter.");
        } else if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input value for Electric meter.");
        } else if (jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input value for Water meter.");
        } else if (blist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bills generated.");
        } else {
            float currentkw = Float.parseFloat(jTextField1.getText());
            float currentcubicmeter = Float.parseFloat(jTextField2.getText());

            ebean = edao.getElectricReadingByBillID(bbean.getBillID());
            wbean = wdao.getWaterReadingsByBillID(bbean.getBillID());

            System.out.println("Bill ID" + ebean.getElectric_billID());

            ebean.setCurrentKW(currentkw);
            ebean.setElectric_billID(bbean.getBillID());
            electricprice = currentkw * ebean.getPriceperKW();
            ebean.setPrice(electricprice);

            wbean.setCurrentcubicmeter(currentcubicmeter);
            wbean.setWater_billID(bbean.getBillID());
            waterprice = currentcubicmeter * wbean.getPricepercubicmeter();
            wbean.setPrice(waterprice);

            edao.editElectricReading(ebean, bbean.getBillID());
            wdao.editWaterReading(wbean, bbean.getBillID());
            if (edao.editElectricReading(ebean, bbean.getBillID()) && wdao.editWaterReading(wbean, bbean.getBillID())) {
                JOptionPane.showMessageDialog(null, "Successfully added water and electric bill for room " + roomID);
                roomtable();
            } else {
                JOptionPane.showMessageDialog(null, "Not successful in adding water and electric bill for room " + roomID);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        this.removeAll();
        jPanel2 = new EditGeneralBillPanelFinal();
        setJpanel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow() + 1;

        BillDAOImplementation billdao = new BillDAOImplementation();
        BillBean bbean = new BillBean();
        bbean = billdao.getBillsByRoomID(row);

        WaterDAOImplementation wdao = new WaterDAOImplementation();
        WaterReadingBean wbean = wdao.getWaterReadingsByBillID(bbean.getBillID());

        ElectricReadingDAOImplementation edao = new ElectricReadingDAOImplementation();
        ElectricReadingBean ebean = edao.getElectricReadingByBillID(bbean.getBillID());

        if (bbean.getPrice() == 0 || wbean.getPrice() == 0 || ebean.getPrice() == 0) {
            JOptionPane.showMessageDialog(null, "Check if Rent, Water and Electric Price was set");
        } else if (bbean.getPaidWater() && bbean.getpaidElectric() && bbean.getpaidRent()) {
            JOptionPane.showMessageDialog(null, "Paid already");
        } else {
            bbean.setPaidElectric(true);
            bbean.setPaidRent(true);
            bbean.setPaidWater(true);

            boolean check;
            if (billdao.editBill(bbean, bbean.getBillID())) {
                JOptionPane.showMessageDialog(null, "Successful");
                roomtable();
            } else {
                JOptionPane.showMessageDialog(null, "Not Successful");
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow() + 1;

        BillDAOImplementation billdao = new BillDAOImplementation();
        BillBean bbean = new BillBean();
        bbean = billdao.getBillsByRoomID(row);

        WaterDAOImplementation wdao = new WaterDAOImplementation();
        WaterReadingBean wbean = wdao.getWaterReadingsByBillID(bbean.getBillID());

        ElectricReadingDAOImplementation edao = new ElectricReadingDAOImplementation();
        ElectricReadingBean ebean = edao.getElectricReadingByBillID(bbean.getBillID());

        if (bbean.getPrice() == 0 || wbean.getPrice() == 0 || ebean.getPrice() == 0) {
            JOptionPane.showMessageDialog(null, "Already set to unpaid");
        } else if (bbean.getPaidWater() && bbean.getpaidElectric() && bbean.getpaidRent()) {
            bbean.setPaidElectric(false);
            bbean.setPaidRent(false);
            bbean.setPaidWater(false);

            boolean check;
            if (billdao.editBill(bbean, bbean.getBillID())) {
                JOptionPane.showMessageDialog(null, "Successful");
                roomtable();
            } else {
                JOptionPane.showMessageDialog(null, "Not Successful");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Already set to unpaid");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void roomlist() {
        jComboBox1.removeAllItems();

        ArrayList<RoomBean> rbean = new ArrayList<RoomBean>();
        rbean = rdao.getAllRooms();

        for (int i = 0; i < rbean.size(); i++) {
            jComboBox1.addItem(rbean.get(i).getRoomID());
        }
    }

    public void initdate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        year = formatter.format(new java.util.Date());
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
        month = formatter1.format(new java.util.Date());

        if (month.equals("01")) {
            jLabel3.setText("Jauary " + year);
        } else if (month.equals("02")) {
            jLabel3.setText("February " + year);
        } else if (month.equals("03")) {
            jLabel3.setText("March " + year);
        } else if (month.equals("04")) {
            jLabel3.setText("April " + year);
        } else if (month.equals("05")) {
            jLabel3.setText("May " + year);
        } else if (month.equals("06")) {
            jLabel3.setText("June " + year);
        } else if (month.equals("07")) {
            jLabel3.setText("July " + year);
        } else if (month.equals("08")) {
            jLabel3.setText("August " + year);
        } else if (month.equals("09")) {
            jLabel3.setText("September " + year);
        } else if (month.equals("10")) {
            jLabel3.setText("October " + year);
        } else if (month.equals("11")) {
            jLabel3.setText("November " + year);
        } else {
            jLabel3.setText("December " + year);
        }
    }

    public void roomtable() {
        model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        RoomDAOImplementation rdao = new RoomDAOImplementation();
        ArrayList<RoomBean> rlist = rdao.getAllRooms();

        BillDAOImplementation bdao = new BillDAOImplementation();
        ArrayList<BillBean> blist = bdao.getAllBills();
        BillBean bbean = new BillBean();

        if (blist.isEmpty()) {
            for (int i = 0; i < rlist.size(); i++) {
                Object[] obj = {rlist.get(i).getRoomID(), "0", "UNPAID"};
                model.addRow(obj);
            }
        } else {

            WaterDAOImplementation wdao = new WaterDAOImplementation();
            ArrayList<WaterReadingBean> wlist = wdao.getWaterReadingforThisMonth(rlist.size()); //this month
            WaterReadingBean wbean = new WaterReadingBean();

            ElectricReadingDAOImplementation edao = new ElectricReadingDAOImplementation();
            ArrayList<ElectricReadingBean> elist = edao.getAllElectricReadingforThisMonth(rlist.size()); //this month
            ElectricReadingBean ebean = new ElectricReadingBean();

            ArrayList<BillBean> bbeanlistnotpaidelectric = new ArrayList<BillBean>();
            ArrayList<BillBean> bbeanlistnotpaidwater = new ArrayList<BillBean>();
            ArrayList<BillBean> bbeanlistnotpaidrent = new ArrayList<BillBean>();
            ArrayList<ElectricReadingBean> ebeanlistnotpaid = new ArrayList<ElectricReadingBean>();
            ArrayList<WaterReadingBean> wbeanlistnotpaid = new ArrayList<WaterReadingBean>();
            float waterprice, electricprice, roomrent;
            double rentprice, total = 0;
            int billID = 0;

            for (int i = 0; i < rlist.size(); i++) {
                bbean = bdao.getBillsByRoomID(i + 1);

                billID = bbean.getBillID();

                ebean = edao.getElectricReadingByBillID(billID);
                wbean = wdao.getWaterReadingsByBillID(billID);

                if (ebean == null || wbean == null) {
                    Object[] obj = {rlist.get(i).getRoomID(), "0", "UNPAID"};
                } else {
                    if (bbean.getPrice() == 0 && ebean.getPrice() == 0 && wbean.getPrice() == 0) { // wala talagang bill
                        System.out.println("wala talaga");
                        System.out.println("rlist size" + rlist.size());

                        Object[] obj = {rlist.get(i).getRoomID(), "0", "UNPAID"};
                        model.addRow(obj);

                    } else if (bbean.getpaidElectric() == false && bbean.getpaidElectric() == false && bbean.getpaidRent() == false) {
                        System.out.println("wal2a talaga");
                        System.out.println("rlist size" + i);

                        electricprice = ebean.getPrice();
                        waterprice = wbean.getPrice();
                        roomrent = bbean.getRoomprice();

                        total = electricprice + waterprice + roomrent;
                        Object[] obj = {rlist.get(i).getRoomID(), total, "UNPAID"};
                        model.addRow(obj);
                    } else {
                        electricprice = ebean.getPrice();
                        waterprice = wbean.getPrice();
                        roomrent = bbean.getRoomprice();

                        total = bbean.getPrice() + electricprice + waterprice + roomrent;
                        Object[] obj = {rlist.get(i).getRoomID(), total, "PAID"};
                        model.addRow(obj);
                    }

                    bbean = new BillBean();
                    ebean = new ElectricReadingBean();
                    wbean = new WaterReadingBean();
                    total = 0;
                }
            }
        }
        jTable1.requestFocus();
        jTable1.changeSelection(0, 0, false, false);
    }

    public void setJpanel() {
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 600));
        this.add(jPanel2);
        jPanel2.setOpaque(true);
        jPanel2.setBounds(0, -10, 1000, 600);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
