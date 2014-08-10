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
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Giodee
 */
public class EditBills extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private boolean dot = false;
    private float priceperkw;
    private float pricepercubicmeter;
    private String year;
    private String month;

    public EditBills() {
        initComponents();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        year = formatter.format(new java.util.Date());
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
        month = formatter1.format(new java.util.Date());

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(250, 340));
        setMinimumSize(new java.awt.Dimension(250, 340));
        setPreferredSize(new java.awt.Dimension(250, 340));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 340));
        jPanel1.setMinimumSize(new java.awt.Dimension(250, 340));
        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Month + Year");
        jLabel2.setAlignmentX(0.6F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 40, 190, 30);

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
        jPanel1.add(jTextField1);
        jTextField1.setBounds(120, 90, 100, 30);

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
        jPanel1.add(jTextField2);
        jTextField2.setBounds(120, 120, 100, 30);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(120, 160, 100, 30);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(120, 190, 100, 30);

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(120, 220, 100, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/confirm.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(80, 250, 90, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/billsedit-peg1.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(250, 340));
        jLabel1.setMinimumSize(new java.awt.Dimension(250, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(250, 340));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 230, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        // check if digit

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

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        String input = "";
        String trim;
        String re1 = "^([+-]?\\d*\\.?\\d*)$";
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (jTextField1.getText().isEmpty()
                || jTextField2.getText().isEmpty()
                || jTextField3.getText().isEmpty()
                || jTextField4.getText().isEmpty()
                || jTextField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input ALL necessary fields.");
        } else {
            String totalelectricityconsumption = jTextField1.getText();
            String totalelectricitycost = jTextField2.getText();

            String totalwaterconsumption = jTextField3.getText();
            String totalwatercost = jTextField4.getText();

            String roomrent = jTextField5.getText();

            //price ng room
            double price = Double.parseDouble(roomrent);

            priceperkw = Float.parseFloat(totalelectricitycost) / Float.parseFloat(totalelectricityconsumption);

            System.out.println(priceperkw);
            pricepercubicmeter = Float.parseFloat(totalwatercost) / Float.parseFloat(totalwaterconsumption);
            System.out.println(pricepercubicmeter);
            boolean paidRent = false;
            boolean paidWater = false;
            boolean paidElectric = false;
            boolean addbill = false;
            BillBean bbean = new BillBean();
            BillDAOInterface bdao = new BillDAOImplementation();
            // initialize billbean for each room

            RoomDAOInterface rdao = new RoomDAOImplementation();
            ArrayList<RoomBean> rbeanlist = new ArrayList<RoomBean>();
            rbeanlist = rdao.getAllRooms();
            RoomBean rbean = new RoomBean();
            ElectricReadingBean ebean = new ElectricReadingBean();
            WaterReadingBean wbean = new WaterReadingBean();
            ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
            WaterReadingDAOInterface wdao = new WaterDAOImplementation();

            ArrayList<BillBean> bbeanlist = new ArrayList<BillBean>();
            bbeanlist = bdao.getAllBills();
            wbean.setPricepercubicmeter(pricepercubicmeter);
            ebean.setCurrentKW(priceperkw);
            java.sql.Date dateread = getDateRead();
            wbean.setDateRead(dateread);
            ebean.setDateRead(dateread);
            wbean.setCurrentcubicmeter(0);
            ebean.setCurrentKW(0);
            wbean.setPrice(0);
            ebean.setPrice(0);
            for (int i = 0; i < rbeanlist.size(); i++) {

                bbean.setBill_roomID(rbeanlist.get(i).getRoomID());
                bbean.setPrice(price);
                bbean.setPaidElectric(paidElectric);
                bbean.setPaidWater(paidWater);
                bbean.setPaidRent(paidRent);

                if (bdao.addBill(bbean) == true) {
                    addbill = true;
                } else {
                    addbill = false;
                }
                wdao.addWaterReadingToRoom(wbean, bbeanlist.size() + i);
                edao.addElectricReadingToRoom(ebean, bbeanlist.size() + i);
            }

            if (addbill) {
                JOptionPane.showMessageDialog(null, "Succesfully added bills for all rooms!");
            } else {
                JOptionPane.showMessageDialog(null, "Unsuccessful in adding bills.");
            }

        }

        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    public float getPricePerKwAll() {
        return this.priceperkw;
    }

    public float getPricePerCubicmeterAll() {
        return this.pricepercubicmeter;
    }

    public String getYear() {
        return this.year;
    }

    public String getMonth() {
        return this.month;
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
            java.util.logging.Logger.getLogger(EditBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditBills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
