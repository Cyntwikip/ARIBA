/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jao
 */
public class Bills extends javax.swing.JFrame {

    /**
     * Creates new form Bills
     */
    public RoomDAOImplementation rdao = new RoomDAOImplementation();
    public BillDAOImplementation bdao = new BillDAOImplementation();
    private float priceperkw;
    private float pricepercubicmeter;
    private String year;
    private String month;
    private DefaultTableModel model;

    public Bills() {
        initComponents();
        initdate();

        roomlist();
        roomtable();
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

    public void roomlist() {
        jComboBox1.removeAllItems();

        ArrayList<RoomBean> rbean = new ArrayList<RoomBean>();
        rbean = rdao.getAllRooms();

        for (int i = 0; i < rbean.size(); i++) {
            jComboBox1.addItem(rbean.get(i).getRoomID());
        }
    }

    public void roomtable() {
        model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        /*
         Calendar datefrom = Calendar.getInstance();
         datefrom.set(Calendar.DAY_OF_MONTH, 1);
        
         Calendar dateto = Calendar.getInstance();
         int lastday = dateto.getActualMaximum(Calendar.DAY_OF_MONTH);
         dateto.set(Calendar.DAY_OF_MONTH, lastday);
        
         //java.sql.Date sqldatefrom = new java.sql.Date(datefrom.getTimeInMillis());
         //java.sql.Date sqldateto = new java.sql.Date(dateto.getTimeInMillis());
        
         */
        RoomDAOImplementation rdao = new RoomDAOImplementation();
        ArrayList<RoomBean> rlist = rdao.getAllRooms();

        WaterDAOImplementation wdao = new WaterDAOImplementation();
        ArrayList<WaterReadingBean> wlist = wdao.getWaterReadingforThisMonth(rlist.size()); //this month

        ElectricReadingDAOImplementation edao = new ElectricReadingDAOImplementation();
        ArrayList<ElectricReadingBean> elist = edao.getAllElectricReadingforThisMonth(rlist.size()); //this month

        BillDAOImplementation bdao = new BillDAOImplementation();
        ArrayList<BillBean> blist = bdao.getAllBills();

        float waterprice, electricprice;
        double rentprice, total = 0;

        for (int i = 0; i < rlist.size(); i++) {

            if (blist.get(i).getPaidWater() == false || blist.get(i).getpaidElectric() == false || blist.get(i).getpaidRent() == false) {
                Object[] obj = {rlist.get(i).getRoomID(), total, "UNPAID"};
                model.addRow(obj);
            } else if (wlist.isEmpty() && elist.isEmpty() && blist.isEmpty()) {
                Object[] obj = {rlist.get(i).getRoomID(), 0, "UNPAID"};
                model.addRow(obj);

            } else {
                waterprice = wlist.get(i).getPrice();
                electricprice = elist.get(i).getPrice();
                rentprice = blist.get(i).getPrice();
                total = waterprice + electricprice + rentprice;
                Object[] obj = {rlist.get(i).getRoomID(), total, "PAID"};
                model.addRow(obj);
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

        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 470));
        setMinimumSize(new java.awt.Dimension(800, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(210, 180, 100, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 210, 100, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 240, 100, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/computeforbills.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 290, 190, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/editoverallbills.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(120, 340, 190, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/paid.png"))); // NOI18N
        jButton3.setText("jButton3");
        getContentPane().add(jButton3);
        jButton3.setBounds(610, 310, 90, 40);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(350, 80, 240, 320);

        jPanel1.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 5, 0, 0);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 140, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(110, 110, 140, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bills-peg-edited.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        EditBills nj = new EditBills();
        nj.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        BillDAOInterface bdao = new BillDAOImplementation();
        BillBean bbean = new BillBean();
        ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
        ElectricReadingBean ebean = new ElectricReadingBean();
        WaterReadingBean wbean = new WaterReadingBean();
        WaterReadingDAOInterface wdao = new WaterDAOImplementation();
        int roomID = (Integer) jComboBox1.getSelectedItem();

        System.out.println(roomID);
        bbean = bdao.getBillsByRoomID(roomID);
        System.out.println(bbean.getBillID());
        float electricprice;
        float waterprice;

        EditBills eb = new EditBills();
        if (jTextField1.getText().isEmpty() && jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input values for Electric Meter and Water Meter.");
        } else if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input value for Electric meter.");
        } else if (jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input value for Water meter.");
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

            //  edao.editElectricReading(ebean, bbean.getBillID());
            //wdao.editWaterReading(wbean, bbean.getBillID());
            if (edao.editElectricReading(ebean, bbean.getBillID()) && wdao.editWaterReading(wbean, bbean.getBillID())) {
                JOptionPane.showMessageDialog(null, "Successfully added water and electric bill for room " + roomID);
            } else {
                JOptionPane.showMessageDialog(null, "Not successful in adding water and electric bill for room " + roomID);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public java.sql.Date initializedate() {

        initdate();

        String testDate = year + "-" + month;
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        java.util.Date date;
        try {
            date = df.parse(testDate);

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        } catch (ParseException ex) {
            Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

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
            java.util.logging.Logger.getLogger(Bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
