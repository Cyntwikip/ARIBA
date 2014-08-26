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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditGeneralBillPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form EditGeneralBillPanelFinal
     */
    private boolean dot = false;
    private float priceperkw;
    private float pricepercubicmeter;
    private String year;
    private String month;
    private JPanel jPanel2;
    ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
    RoomDAOInterface rdao = new RoomDAOImplementation();
    BillDAOInterface bdao = new BillDAOImplementation();
    WaterReadingDAOInterface wdao = new WaterDAOImplementation();

    public EditGeneralBillPanelFinal() {
        initComponents();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        year = formatter.format(new java.util.Date());
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
        month = formatter1.format(new java.util.Date());

        ArrayList<RoomBean> roomlist = rdao.getAllRooms();

        ArrayList<WaterReadingBean> waterlist = new ArrayList<WaterReadingBean>();
        ArrayList<ElectricReadingBean> electriclist = new ArrayList<ElectricReadingBean>();

        waterlist = wdao.getWaterReadingforThisMonth(roomlist.size());
        electriclist = edao.getAllElectricReadingforThisMonth(roomlist.size());

        ArrayList<ElectricReadingBean> ebeanlist = edao.getAllElectricReadingforThisMonth(roomlist.size());
        if (ebeanlist.isEmpty()) {
            System.out.println("wala pa laman.");
        } else { // may existing na

            WaterReadingBean watertemporary = new WaterReadingBean();
            ElectricReadingBean electrictemporary = new ElectricReadingBean();
            BillBean billtemporary = new BillBean();

            ArrayList<RoomBean> rbeanlist = new ArrayList<RoomBean>();
            RoomDAOInterface rdao = new RoomDAOImplementation();
            rbeanlist = rdao.getAllRooms();
            float waterprice, electricprice;
            boolean check = false;

            for (int i = 0; i < rbeanlist.size(); i++) {

                billtemporary = bdao.getBillsByRoomID(i + 1);
                billtemporary.setPaidRent(false);
                billtemporary.setPaidWater(false);
                billtemporary.setPaidElectric(false);
                billtemporary.setPrice(billtemporary.getPrice());
                billtemporary.setRoomprice(billtemporary.getRoomprice());
                billtemporary.setTotalelectricityconsumption(billtemporary.getTotalelectricityconsumption());
                billtemporary.setTotalwaterconsumption(billtemporary.getTotalwaterconsumption());
                System.out.println(billtemporary.getBillID());

                watertemporary = wdao.getWaterReadingsByBillID(billtemporary.getBillID());
                electrictemporary = edao.getElectricReadingByBillID(billtemporary.getBillID());

                System.out.println(watertemporary.getPrice());
                float temp1 = billtemporary.getTotalelectricityconsumption() * electrictemporary.getPriceperKW();
                jTextField1.setText(String.valueOf(billtemporary.getTotalelectricityconsumption()));
                jTextField2.setText(String.valueOf(temp1));

                float temp2 = billtemporary.getTotalwaterconsumption() * watertemporary.getPricepercubicmeter();
                jTextField3.setText(String.valueOf(billtemporary.getTotalwaterconsumption()));
                jTextField4.setText(String.valueOf(temp2));

                jTextField5.setText(String.valueOf(billtemporary.getRoomprice()));

            }

            initDate();
        }
    }

    public void initDate() {
        if (month.equals("01")) {
            jLabel2.setText("January " + year);
        } else if (month.equals("02")) {
            jLabel2.setText("February " + year);
        } else if (month.equals("03")) {
            jLabel2.setText("March " + year);
        } else if (month.equals("04")) {
            jLabel2.setText("April " + year);
        } else if (month.equals("05")) {
            jLabel2.setText("May " + year);
        } else if (month.equals("06")) {
            jLabel2.setText("June " + year);
        } else if (month.equals("07")) {
            jLabel2.setText("July " + year);
        } else if (month.equals("08")) {
            jLabel2.setText("August " + year);
        } else if (month.equals("09")) {
            jLabel2.setText("September " + year);
        } else if (month.equals("10")) {
            jLabel2.setText("October " + year);
        } else if (month.equals("11")) {
            jLabel2.setText("November " + year);
        } else {
            jLabel2.setText("December " + year);
        }
    }

    public java.sql.Date getDateRead() {
        String testDate = year + "-" + month;
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        java.util.Date date;
        try {
            date = df.parse(testDate);

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;

        } catch (ParseException ex) {
            Logger.getLogger(BillsPanelFinal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        jLabel2.setText("JLabel For Month Name");
        add(jLabel2);
        jLabel2.setBounds(200, 220, 160, 40);

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
        jTextField1.setBounds(300, 280, 100, 30);

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
        jTextField2.setBounds(300, 320, 100, 30);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        add(jTextField3);
        jTextField3.setBounds(540, 280, 100, 30);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        add(jTextField4);
        jTextField4.setBounds(540, 320, 100, 30);

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        add(jTextField5);
        jTextField5.setBounds(730, 280, 90, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/backbutton.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(650, 410, 80, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/save.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(750, 410, 80, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/editgeneralbills-peg-edited-panel.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        this.removeAll();
        jPanel2 = new BillsPanelFinal();
        setJpanel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (jTextField1.getText().isEmpty()
                || jTextField2.getText().isEmpty()
                || jTextField3.getText().isEmpty()
                || jTextField4.getText().isEmpty()
                || jTextField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input ALL necessary fields.");
        } else {
            float totalelectricityconsumption = Float.parseFloat(jTextField1.getText());
            float totalelectricitycost = Float.parseFloat(jTextField2.getText());

            float totalwaterconsumption = Float.parseFloat(jTextField3.getText());
            float totalwatercost = Float.parseFloat(jTextField4.getText());

            float roomrent = Float.parseFloat(jTextField5.getText());

            //price ng room
            priceperkw = totalelectricitycost / totalelectricityconsumption;
            System.out.println("Price per kw: " + priceperkw);

            pricepercubicmeter = totalwatercost / totalwaterconsumption;
            System.out.println(pricepercubicmeter);

            boolean paidRent = false;
            boolean paidWater = false;
            boolean paidElectric = false;
            boolean addbill = false;
            BillBean bbean = new BillBean();
            // initialize billbean for each room

            ArrayList<RoomBean> rbeanlist = rdao.getAllRooms();

            ElectricReadingBean ebean = new ElectricReadingBean();
            WaterReadingBean wbean = new WaterReadingBean();

            wbean.setPricepercubicmeter(pricepercubicmeter);
            ebean.setPriceperKW(priceperkw);
            java.sql.Date dateread = getDateRead();
            wbean.setDateRead(dateread);
            ebean.setDateRead(dateread);

            ArrayList<WaterReadingBean> watertemp = wdao.getWaterReadingforThisMonth(rbeanlist.size());

            ArrayList<BillBean> bbeanlist = new ArrayList<BillBean>();

            if (watertemp.isEmpty()) { //no existing bill for the month

                wbean.setCurrentcubicmeter(0);
                ebean.setCurrentKW(0);
                wbean.setPrice(0);
                ebean.setPrice(0);

                for (int i = 0; i < rbeanlist.size(); i++) {

                    bbean = new BillBean();

                    bbean.setBill_roomID(rbeanlist.get(i).getRoomID());
                    bbean.setPrice(roomrent);
                    bbean.setPaidElectric(paidElectric);
                    bbean.setPaidWater(paidWater);
                    bbean.setPaidRent(paidRent);
                    bbean.setRoomprice(roomrent);
                    bbean.setTotalelectricityconsumption(totalelectricityconsumption);
                    bbean.setTotalwaterconsumption(totalwaterconsumption);

                    if (bdao.addBill(bbean) == true) {
                        addbill = true;
                    } else {
                        addbill = false;
                    }
                    int billID = bdao.getAllBills().size();
                        
                        if (billID == 0) {
                            billID = i+1;
                        }
                 
                    System.out.println("BILLid" + billID);
                    wbean.setWater_billID(billID);
                    ebean.setElectric_billID(billID);
                    wdao.addWaterReadingToRoom(wbean);
                    edao.addElectricReadingToRoom(ebean);
                }
                if (addbill) {

                    //JOptionPane.showMessageDialog(null, "Succesfully added bills for all rooms!");
                    this.removeAll();
                    jPanel2 = new BillsPanelFinal();
                    setJpanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful in adding bills.");
                }
            } else { //change existing bill

                WaterReadingBean watertemporary = new WaterReadingBean();
                ElectricReadingBean electrictemporary = new ElectricReadingBean();
                BillBean billtemporary = new BillBean();

                float waterprice, electricprice;

                boolean proceed = false;
                for (int i = 0; i < rbeanlist.size(); i++) {

                    billtemporary = bdao.getBillsByRoomID(i + 1);

                    billtemporary.setPaidRent(false);
                    billtemporary.setPaidWater(false);
                    billtemporary.setPaidElectric(false);
                    billtemporary.setTotalelectricityconsumption(totalelectricityconsumption);
                    billtemporary.setTotalwaterconsumption(totalwaterconsumption);
                    billtemporary.setRoomprice(roomrent);
                    billtemporary.setPrice(roomrent);

                    watertemporary = wdao.getWaterReadingsByBillID(billtemporary.getBillID());
                    watertemporary.setPricepercubicmeter(pricepercubicmeter);
                    watertemporary.setDateRead(dateread);
                    waterprice = pricepercubicmeter * watertemporary.getCurrentcubicmeter();
                    watertemporary.setPrice(waterprice);

                    if (wdao.editWaterReading(watertemporary, watertemporary.getWater_billID())) {
                        electrictemporary = edao.getElectricReadingByBillID(billtemporary.getBillID());
                        electrictemporary.setPriceperKW(priceperkw);
                        electrictemporary.setDateRead(dateread);
                        electricprice = priceperkw * electrictemporary.getCurrentKW();
                        electrictemporary.setPrice(electricprice);

                        billtemporary.setPrice(watertemporary.getPrice() + electrictemporary.getPrice() + roomrent);

                        if (edao.editElectricReading(electrictemporary, electrictemporary.getElectric_billID())) {
                            if (bdao.editBill(billtemporary, billtemporary.getBillID())) {
                                proceed = true;
                            }

                        } else {
                            proceed = false;
                        }
                    }

                    billtemporary = new BillBean();
                    watertemporary = new WaterReadingBean();
                    electrictemporary = new ElectricReadingBean();

                }

                if (proceed) {
                    //JOptionPane.showMessageDialog(null, "Successfully edited bills.");
                    this.removeAll();
                    jPanel2 = new BillsPanelFinal();
                    setJpanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful.");
                }
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^(\\d*\\.?\\d*)$";
        int last;
        if (!jTextField3.getText().isEmpty()) {
            input = jTextField3.getText();
        }

        if (input.matches(re1)) {

        } else {
            trim = input.substring(0, input.length() - 1);
            input = trim;
            System.out.println(trim);
        }

        jTextField3.setText(input);
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^(\\d*\\.?\\d*)$";
        int last;
        if (!jTextField4.getText().isEmpty()) {
            input = jTextField4.getText();
        }

        if (input.matches(re1)) {

        } else {
            trim = input.substring(0, input.length() - 1);
            input = trim;
            System.out.println(trim);
        }

        jTextField4.setText(input);
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^(\\d*\\.?\\d*)$";
        int last;
        if (!jTextField5.getText().isEmpty()) {
            input = jTextField5.getText();
        }

        if (input.matches(re1)) {

        } else {
            trim = input.substring(0, input.length() - 1);
            input = trim;
            System.out.println(trim);
        }

        jTextField5.setText(input);
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    public void setJpanel() {
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 600));
        this.add(jPanel2);
        jPanel2.setOpaque(true);
        jPanel2.setBounds(0, -10, 1000, 600);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
