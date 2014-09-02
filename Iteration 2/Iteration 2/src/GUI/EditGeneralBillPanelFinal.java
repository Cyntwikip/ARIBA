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
    private boolean proceed;
    private float priceperkw;
    private float pricepercubicmeter;
    private String year;
    private String month;
    private JPanel jPanel2;
    ElectricReadingDAOInterface edao = new ElectricReadingDAOImplementation();
    RoomDAOInterface rdao = new RoomDAOImplementation();
    RoomBillDAOInterface rbdao = new RoomBillDAOImplementation();
    WaterReadingDAOInterface wdao = new WaterDAOImplementation();
    DormBillDAOImplementation ddao = new DormBillDAOImplementation();

    public EditGeneralBillPanelFinal() {
        initComponents();
        proceed = false;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        year = formatter.format(new java.util.Date());
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
        month = formatter1.format(new java.util.Date());

        initDate();

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
            double totalelectricitycost = Double.parseDouble(jTextField2.getText());

            float totalwaterconsumption = Float.parseFloat(jTextField3.getText());
            double totalwatercost = Double.parseDouble(jTextField4.getText());

            double roomrent = Double.parseDouble(jTextField5.getText());

            java.util.Date date = new java.util.Date();
            java.sql.Date dateRead = new java.sql.Date(date.getTime());

            //set value for dormbill table
            DormBillBean dorm = new DormBillBean();
            dorm.setWaterconsumption(totalwaterconsumption);
            dorm.setElectconsumption(totalelectricityconsumption);
            dorm.setWaterprice(totalwatercost);
            dorm.setElectprice(totalelectricitycost);
            dorm.setDateRead(dateRead);
            ddao.addDormBill(dorm);

            //get occupied rooms
            ArrayList<RoomBean> occupied = rdao.getRoomByStatus("Occupied");

            //change roomprice for each occupied rooms
            RoomBillBean rbean = new RoomBillBean();
            
            for(RoomBean bean: occupied){
                rdao.setPrice(bean.getRoomID(), roomrent);
            }

            this.removeAll();
            jPanel2 = new BillsPanelFinal();
            setJpanel();

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