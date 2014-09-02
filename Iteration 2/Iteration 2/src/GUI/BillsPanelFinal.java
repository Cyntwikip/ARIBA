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
import Models.Beans.DormBillBean;
import Models.Beans.RoomBillBean;
import Models.Beans.ElectricReadingBean;
import Models.Beans.RoomBean;
import Models.Beans.WaterReadingBean;
import Models.DAOImplementation.DormBillDAOImplementation;
import Models.DAOImplementation.RoomBillDAOImplementation;
import Models.DAOImplementation.ElectricReadingDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.WaterDAOImplementation;
import Models.DAOInterface.RoomBillDAOInterface;
import Models.DAOInterface.ElectricReadingDAOInterface;
import Models.DAOInterface.RoomDAOInterface;
import Models.DAOInterface.WaterReadingDAOInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BillsPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form BillsPanelFinal
     */
    public RoomDAOInterface rdao = new RoomDAOImplementation();
    public RoomBillDAOInterface rbdao = new RoomBillDAOImplementation();
    public DormBillDAOImplementation dbdao = new DormBillDAOImplementation();
    private WaterDAOImplementation wdao = new WaterDAOImplementation();
    private ElectricReadingDAOImplementation edao = new ElectricReadingDAOImplementation();
    private double priceperkw;
    private double pricepercubicmeter;
    private double rent;
    private String year;
    private String month;
    private DefaultTableModel model;
    private JPanel jPanel2;
    private java.sql.Date date;
    private DormBillBean dorm;

    public BillsPanelFinal() {
        initComponents();

        model = (DefaultTableModel) jTable1.getModel();
        dorm = new DormBillBean();
        initdate();
        roomlist();
        roomtable();
        prices();
    }

    public void prices() {
        //get dormbill for the month
        date = new java.sql.Date(new java.util.Date().getTime());

        //set view units and prices for water and electricity
        dorm = dbdao.getDormBillByMonthandYear(date);
        System.out.println("dbillID: " + dorm.getDbill_ID());

        priceperkw = dorm.getElectprice() / dorm.getElectconsumption();
        pricepercubicmeter = dorm.getWaterprice() / dorm.getWaterconsumption();
        rent = dorm.getRoomprice();

        kwlabel.setText(Double.toString(priceperkw));
        cubicmeterlabel.setText(Double.toString(priceperkw));
        rentlabel.setText(Double.toString(rent));

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
        electricmeterlabel = new javax.swing.JTextField();
        watermeterlabel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kwlabel = new javax.swing.JLabel();
        cubicmeterlabel = new javax.swing.JLabel();
        rentlabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setPreferredSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(200, 120, 220, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Room", "electricity", "water", "surcharge", "total", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(450, 50, 390, 410);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(300, 220, 100, 30);

        electricmeterlabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                electricmeterlabelActionPerformed(evt);
            }
        });
        electricmeterlabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                electricmeterlabelKeyReleased(evt);
            }
        });
        add(electricmeterlabel);
        electricmeterlabel.setBounds(300, 260, 100, 30);

        watermeterlabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watermeterlabelActionPerformed(evt);
            }
        });
        watermeterlabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                watermeterlabelKeyReleased(evt);
            }
        });
        add(watermeterlabel);
        watermeterlabel.setBounds(300, 300, 100, 30);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Price per KW:");
        add(jLabel2);
        jLabel2.setBounds(840, 50, 130, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Price per cubicmeter:");
        add(jLabel4);
        jLabel4.setBounds(840, 100, 120, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Rent:");
        add(jLabel6);
        jLabel6.setBounds(840, 150, 120, 15);

        kwlabel.setForeground(new java.awt.Color(250, 0, 0));
        kwlabel.setText("jLabel7");
        add(kwlabel);
        kwlabel.setBounds(870, 70, 34, 14);

        cubicmeterlabel.setForeground(new java.awt.Color(250, 0, 0));
        cubicmeterlabel.setText("jLabel8");
        add(cubicmeterlabel);
        cubicmeterlabel.setBounds(870, 120, 34, 14);

        rentlabel.setForeground(new java.awt.Color(250, 0, 0));
        rentlabel.setText("jLabel9");
        add(rentlabel);
        rentlabel.setBounds(870, 170, 34, 14);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        add(jPanel1);
        jPanel1.setBounds(190, 150, 230, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/bills-tab-peg-edited-panel.png"))); // NOI18N
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void electricmeterlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_electricmeterlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_electricmeterlabelActionPerformed

    private void electricmeterlabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_electricmeterlabelKeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^(\\d*\\.?\\d*)$";
        int last;
        if (!electricmeterlabel.getText().isEmpty()) {
            input = electricmeterlabel.getText();
        }

        if (input.matches(re1)) {

        } else {
            trim = input.substring(0, input.length() - 1);
            input = trim;
            System.out.println(trim);
        }

        electricmeterlabel.setText(input);
    }//GEN-LAST:event_electricmeterlabelKeyReleased

    private void watermeterlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watermeterlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_watermeterlabelActionPerformed

    private void watermeterlabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_watermeterlabelKeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^(\\d*\\.?\\d*)$";
        int last;
        if (!watermeterlabel.getText().isEmpty()) {
            input = watermeterlabel.getText();
        }

        if (input.matches(re1)) {

        } else {
            trim = input.substring(0, input.length() - 1);
            input = trim;
            System.out.println(trim);
        }

        watermeterlabel.setText(input);
    }//GEN-LAST:event_watermeterlabelKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (electricmeterlabel.getText().isEmpty() || watermeterlabel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input ALL necessary fields.");
        } else {
            float electric, water;
            double ecost, wcost;
            date = new java.sql.Date(new java.util.Date().getTime());
            electric = Float.parseFloat(electricmeterlabel.getText());
            water = Float.parseFloat(watermeterlabel.getText());

            //create water and electricity reading
            WaterReadingBean waterbean = new WaterReadingBean();
            ElectricReadingBean electricbean = new ElectricReadingBean();
            WaterDAOImplementation wdao = new WaterDAOImplementation();
            ElectricReadingDAOImplementation edao = new ElectricReadingDAOImplementation();

            electricbean.setCurrentKW(electric);
            electricbean.setDateRead(date);
            electricbean.setStatus("Unpaid");
            waterbean.setCurrentcubicpermeter(water);
            waterbean.setDateRead(date);
            waterbean.setStatus("Unpaid");

            wdao.addWaterReadingToRoom(waterbean);
            edao.addElectricReadingToRoom(electricbean);

            //get water and electric  reading by month and year
            waterbean = wdao.getWaterReadingByMonth(date);
            electricbean = edao.getElectricReadingByMonth(date);

            //create room bill
            int row = jTable1.getSelectedRow();
            int col = 0;

            int roomID = (int) jComboBox1.getSelectedItem();

            RoomBillBean room = new RoomBillBean();
            room.setRoomID(roomID);
            room.setDbillID(dorm.getDbill_ID());
            room.setWaterreadingID(waterbean.getWater_billID());
            room.setElectricreadingID(electricbean.getElectric_billID());
            room.setSurcharge(0);
            room.setDatePaid(null);
            room.setStatus("Unpaid");
            room.setDateRead(date);

            if (rbdao.addRoomBill(room)) {
                System.out.println("hi");
            } else {
                System.out.println("bye");
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

        //paid
        
        
        ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
        ElectricReadingBean ebean = new ElectricReadingBean();

        WaterReadingDAOInterface wdao = new WaterDAOImplementation();
        WaterReadingBean wbean = new WaterReadingBean();

        RoomBillDAOInterface rbdao = new RoomBillDAOImplementation();
        ArrayList<RoomBillBean> rblist = new ArrayList<RoomBillBean>();
        RoomBillBean rbill = new RoomBillBean();

        int row = jTable1.getSelectedRow();
        int roomID =  (Integer)jTable1.getValueAt(row, 0);
        System.out.println(roomID);
        rblist = rbdao.getRoomBillsByRoomID(roomID);

        System.out.println(rblist.get(rblist.size() - 1).getRoomID());
        int electricid = rblist.get(rblist.size()-1).getElectricreadingID();
        int waterid = rblist.get(rblist.size()-1).getWaterreadingID();
        
        System.out.println("electricid"+electricid);
        System.out.println("waterid"+waterid);
        
        ebean = edao.getElectricReadingsByElectricBillID(electricid);
        wbean = wdao.getWaterReadingsByWaterBillID(waterid);
        
        ebean.setCurrentKW(ebean.getCurrentKW());
        ebean.setDatePaid(date);
        ebean.setDateRead(ebean.getDateRead());
        ebean.setElectric_billID(electricid);
        ebean.setStatus("Paid");
        
        wbean.setCurrentcubicpermeter(wbean.getCurrentcubicpermeter());
        wbean.setDatePaid(date);
        wbean.setDateRead(wbean.getDateRead());
        wbean.setStatus("Paid");
        wbean.setWater_billID(waterid);
        
        rbill = rblist.get(rblist.size()-1);
        rbill.setDatePaid(date);
        rbill.setDbillID(rbill.getDbillID());
        rbill.setElectricreadingID(electricid);
        rbill.setRoomID(roomID);
        rbill.setStatus("Paid");
        rbill.setSurcharge(0);
        rbill.setWaterreadingID(waterid);
        rbill.setDateRead(rbill.getDateRead());
        
        
        if(edao.editElectricReading(ebean) && wdao.editWaterReading(wbean) && rbdao.editRoomBill(rbill)){
            System.out.println("edit successful");
        }else{
            System.out.println("edit not successful");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
        ElectricReadingBean ebean = new ElectricReadingBean();

        WaterReadingDAOInterface wdao = new WaterDAOImplementation();
        WaterReadingBean wbean = new WaterReadingBean();

        RoomBillDAOInterface rbdao = new RoomBillDAOImplementation();
        ArrayList<RoomBillBean> rblist = new ArrayList<RoomBillBean>();
        RoomBillBean rbill = new RoomBillBean();

        int row = jTable1.getSelectedRow();
        int roomID =  (Integer)jTable1.getValueAt(row, 0);
        System.out.println(roomID);
        rblist = rbdao.getRoomBillsByRoomID(roomID);

        System.out.println(rblist.get(rblist.size() - 1).getRoomID());
        int electricid = rblist.get(rblist.size()-1).getElectricreadingID();
        int waterid = rblist.get(rblist.size()-1).getWaterreadingID();
        
        System.out.println("electricid"+electricid);
        System.out.println("waterid"+waterid);
        
        ebean = edao.getElectricReadingsByElectricBillID(electricid);
        wbean = wdao.getWaterReadingsByWaterBillID(waterid);
        
        ebean.setCurrentKW(ebean.getCurrentKW());
        ebean.setDatePaid(null);
        ebean.setDateRead(ebean.getDateRead());
        ebean.setElectric_billID(electricid);
        ebean.setStatus("Unpaid");
        
        wbean.setCurrentcubicpermeter(wbean.getCurrentcubicpermeter());
        wbean.setDatePaid(null);
        wbean.setDateRead(wbean.getDateRead());
        wbean.setStatus("Unpaid");
        wbean.setWater_billID(waterid);
        
        
        rbill = rblist.get(rblist.size()-1);
        rbill.setDatePaid(date);
        rbill.setDbillID(rbill.getDbillID());
        rbill.setElectricreadingID(electricid);
        rbill.setRoomID(roomID);
        rbill.setStatus("unpaid");
        rbill.setSurcharge(0);
        rbill.setWaterreadingID(waterid);
        rbill.setDateRead(rbill.getDateRead());
        
        
        if(edao.editElectricReading(ebean) && wdao.editWaterReading(wbean) && rbdao.editRoomBill(rbill)){
            System.out.println("EDIT!!");
        }else{
            System.out.println("fail");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    public void roomlist() {
        jComboBox1.removeAllItems();

        ArrayList<RoomBean> rbean = new ArrayList<RoomBean>();
        rbean = rdao.getRoomByStatus("Occupied");

        for (int i = 0; i < rbean.size(); i++) {
            jComboBox1.addItem(rbean.get(i).getRoomID());
        }
    }

    public void roomtable() {
        model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        ArrayList<RoomBean> occupied = new ArrayList<>();
        occupied = rdao.getRoomByStatus("Occupied");

        int room;
        float electricity, water;
        double surcharge, total;
        String status;

        for (RoomBean bean : occupied) {
            room = bean.getRoomID();
            Object[] obj = {room, 0, 0, 0, 0, "none"};
            model.addRow(obj);
        }
        model.fireTableDataChanged();
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
    private javax.swing.JLabel cubicmeterlabel;
    private javax.swing.JTextField electricmeterlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel kwlabel;
    private javax.swing.JLabel rentlabel;
    private javax.swing.JTextField watermeterlabel;
    // End of variables declaration//GEN-END:variables
}
