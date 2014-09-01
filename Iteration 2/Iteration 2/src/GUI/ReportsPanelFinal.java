/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Beans.RoomBillBean;
import Models.Beans.ContractBean;
import Models.Beans.RoomBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.RoomBillDAOImplementation;
import Models.DAOImplementation.ContractDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.RoomBillDAOInterface;
import Models.DAOInterface.ContractDAOInterface;
import Models.DAOInterface.RoomDAOInterface;
import Models.DAOInterface.TenantDAOInterface;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Giodee
 */
public class ReportsPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form ReportsPanelFinal
     */
    private DefaultTableModel model;
    private TenantDAOImplementation tdao = new TenantDAOImplementation();

    public ReportsPanelFinal() {
        initComponents();

        model = (DefaultTableModel) jTable1.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setPreferredSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ", " ", " ", " "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(280, 40, 680, 500);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/unpaidtenants.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 80, 170, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/tenantscontract.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 130, 170, 40);

        jButton4.setText("Expired Contract");
        jButton4.setToolTipText("");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setContentAreaFilled(false);
        jButton4.setMinimumSize(new java.awt.Dimension(221, 47));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(30, 240, 130, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewcontractdate.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(10, 320, 170, 40);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/renew.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(0, 370, 110, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/end.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(100, 360, 80, 50);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 20, 0, 0);

        jLabel3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel3.setText("View Leaving Tenants By:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 200, 240, 40);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel4.setText("View...");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 44, 100, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewgrad.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(30, 280, 140, 30);

        add(jPanel1);
        jPanel1.setBounds(70, 40, 190, 470);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/5-reports-peg-edited-crop-panel.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        JTableHeader th = jTable1.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue("Tenant ID");
        tc = tcm.getColumn(1);
        tc.setHeaderValue("Last name");
        tc = tcm.getColumn(2);
        tc.setHeaderValue("First name");
        tc = tcm.getColumn(3);
        tc.setHeaderValue("Amount");
        th.repaint();
        ArrayList<RoomBillBean> bbeanlist = new ArrayList<RoomBillBean>();
        RoomBillBean bbean = new RoomBillBean();
        RoomBillDAOInterface bdao = new RoomBillDAOImplementation();

        ArrayList<RoomBean> rbeanlist = new ArrayList<RoomBean>();
        RoomBean rbean = new RoomBean();
        RoomDAOInterface rdao = new RoomDAOImplementation();
        rbeanlist = rdao.getAllRooms();

        ArrayList<TenantBean> tbeanlist = new ArrayList<TenantBean>();
        TenantBean tbean = new TenantBean();
        TenantDAOInterface tdao = new TenantDAOImplementation();

        bbeanlist = bdao.getAllNotPaidAll(rbeanlist.size());
        System.out.println(bbeanlist.size());

        int roomID;
        for (int i = 0; i < bbeanlist.size(); i++) {
            roomID = bbeanlist.get(i).getBill_roomID(); // current room ID

            tbeanlist = tdao.getTenantByRoomID(roomID);

            for (int j = 0; j < tbeanlist.size(); j++) {
                tbean = tbeanlist.get(j);
                double amount = bbeanlist.get(i).getPrice();
                String fname = tbean.getFname();
                String lname = tbean.getLname();

                Object[] obj = {roomID, lname, fname, amount};
                model.addRow(obj);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        JTableHeader th = jTable1.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue("Surname");
        tc = tcm.getColumn(1);
        tc.setHeaderValue("First name");
        tc = tcm.getColumn(2);
        tc.setHeaderValue("Degree");
        tc = tcm.getColumn(3);
        tc.setHeaderValue("Year");
        th.repaint();

        int year = Calendar.getInstance().get(Calendar.YEAR);

        ArrayList<TenantBean> tlist = tdao.getTenantByStatus("CURRENT");
        
        ContractDAOImplementation cdao = new ContractDAOImplementation();
        RoomDAOImplementation rdao = new RoomDAOImplementation();
        TenantDAOImplementation tdao = new TenantDAOImplementation();
        ContractBean tenantcontract = new ContractBean();
        RoomBean tenantroom = new RoomBean();
        
        Calendar date = Calendar.getInstance();
        java.util.Date utilDate = date.getTime();
        
        String fname, lname, degree;
        int yearofgrad;
        
        for (int i = 0; i < tlist.size(); i++) {
            tenantcontract = cdao.getLatestContractByTenantID(tlist.get(i).getTenantID());
            if(tenantcontract.getExpirydate().after(utildate)) { //expired
                fname = tlist.get(i).getLname();
                lname = tlist.get(i).getFname();
                degree = tlist.get(i).getDegree();
                tlist.get(i).setStatus("NOT CURRENT");
                yearofgrad = tlist.get(i).getExpectedyearofgrad();
                Object[] obj = {lname, fname, degree, yearofgrad};
                model.addRow(obj);
                
                tenantroom = rdao.getTenantRoom(tlist.get(i).getTenantID());
                rdao.removeTenantToRoom(tlist.get(i).getTenantID(), tenantroom.getRoomID());
                tdao.editTenant(tlist.get(i));
                
                tenantcontract = new ContractBean();
                tenantroom = new RoomBean();
            }
        }
        
        jButton6.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ArrayList<TenantBean> tlist = new ArrayList<TenantBean>();
        ArrayList<ContractBean> clist = new ArrayList<ContractBean>();
        ContractDAOInterface cdao = new ContractDAOImplementation();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        System.out.println(sqlDate);

        Calendar expirydate = Calendar.getInstance();
        expirydate.add(Calendar.DAY_OF_YEAR, 92); // add 3 months
        DateFormat df_contract = new SimpleDateFormat("MMMM d, yyyy");

        //converting Calendar to sql Date
        java.sql.Date sqlExpirydate = new java.sql.Date(expirydate.getTime().getTime());

        System.out.println(sqlExpirydate);
        clist = cdao.getAllContractsByDate(sqlDate, sqlExpirydate);

        System.out.println(clist.size());

        TenantBean tbean = new TenantBean();
        for (int i = 0; i < clist.size(); i++) {
            int tenantID = clist.get(i).getContract_tenantID();

            tbean = tdao.getTenantById(tenantID);

            deleteToRoom(tbean);

            Object[] obj = {tbean.getTenantID(), tbean.getLname(), tbean.getFname(), tbean.getDegree()};
            model.addRow(obj);

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        // renew contract
        int row = jTable1.getSelectedRow();

        String lname = (String) jTable1.getValueAt(row, 0);
        String fname = (String) jTable1.getValueAt(row, 1);
        System.out.println(lname);
        System.out.println(fname);

        TenantBean tbean = tdao.getTenantByName(fname, lname);
        System.out.println(tbean.getTenantID());

        ContractBean contractAcc = new ContractBean();
        ArrayList<ContractBean> temp = new ArrayList<ContractBean>();
        ContractDAOInterface contractdao = new ContractDAOImplementation();

        temp = contractdao.getAllContractsByTenantID(tbean.getTenantID());

        Calendar expirydate = Calendar.getInstance();

        //   year month day
        java.sql.Date sqlEffectivedate = temp.get(temp.size() - 1).getExpirydate();
        DateFormat df_contract = new SimpleDateFormat("MMMM d, yyyy");
        String text = df_contract.format(sqlEffectivedate);

        int x = text.indexOf(' ');

        System.out.println("index" + x);

        String month = text.substring(0, x);
        String day = text.substring(x + 1, x + 3);
        String year = text.substring(text.length() - 4, text.length());
        System.out.println(text);
        System.out.println(month + " " + day + " " + year);
        System.out.println("here");
        System.out.println(month);
        System.out.println(day);
        System.out.println(year);

        int year1 = Integer.valueOf(year);
        int month1 = toMonth(month);
        int day1 = Integer.valueOf(day);
        year1++;
        year1 = year1 - 1900;
        month1 = month1 - 1;
        java.sql.Date sqlExpirydate = new java.sql.Date(year1, month1, day1);

        //converting Calendar to sql Date
        contractAcc.setContract_tenantID(tbean.getTenantID());
        contractAcc.setEffectivedate(sqlEffectivedate);
        contractAcc.setExpirydate(sqlExpirydate);

        if (contractdao.addContract(contractAcc)) {
            System.out.println(expirydate);

            // delete na rin sa room
        } else {
            System.out.println("no");

        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        // end contract
        int row = jTable1.getSelectedRow();

        String lname = (String) jTable1.getValueAt(row, 0);
        String fname = (String) jTable1.getValueAt(row, 1);
        System.out.println(lname);
        System.out.println(fname);

        TenantBean tbean = tdao.getTenantByName(fname, lname);
        System.out.println(tbean.getTenantID());

        RoomDAOInterface rdao = new RoomDAOImplementation();
        RoomBean rbean = rdao.getTenantRoom(tbean.getTenantID());
        TenantDAOInterface tdao = new TenantDAOImplementation();

        tbean.setStatus("not current");
        boolean setold = tdao.setTenantToOld(tbean.getTenantID());
        if (setold) {
            System.out.println("End");
            deleteToRoom(tbean);
        } else {
            System.out.println("nope nope");
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    public void deleteToRoom(TenantBean tbean) {

        ContractDAOInterface cdao = new ContractDAOImplementation();
        ArrayList<ContractBean> cbeanlist = cdao.getAllContractsByTenantID(tbean.getTenantID());

        RoomDAOInterface rdao = new RoomDAOImplementation();
        RoomBean temp = rdao.getTenantRoom(tbean.getTenantID());

        Calendar date = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("MMMM d, yyyy");

        //converting Calendar to sql Date
        java.sql.Date date2 = new java.sql.Date(date.getTime().getTime());

        boolean removetenant = false;
        if (cbeanlist.get(cbeanlist.size() - 1).getExpirydate().before(date2)) {
            removetenant = rdao.removeTenantToRoom(tbean.getTenantID(), temp.getRoomID());
            if (removetenant) {
                JOptionPane.showMessageDialog(null, "Terminated " + tbean.getFname() + " " + tbean.getLname() + "'s contract. Effective on " + cbeanlist.get(cbeanlist.size() - 1).getExpirydate());
            }
        } else {
            //.showMessageDialog(null, "Terminated " + tbean.getFname() + " " + tbean.getLname() + "'s contract. Effective on " + cbeanlist.get(cbeanlist.size() - 1).getExpirydate());

        }

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        JTableHeader th = jTable1.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue("Surname");
        tc = tcm.getColumn(1);
        tc.setHeaderValue("First name");
        tc = tcm.getColumn(2);
        tc.setHeaderValue("Effective date");
        tc = tcm.getColumn(3);
        tc.setHeaderValue("Expiry date");
        th.repaint();

        ContractDAOInterface cdao = new ContractDAOImplementation();
        ArrayList<ContractBean> clist = new ArrayList<ContractBean>();
        clist = cdao.getAllContracts();

        TenantDAOInterface tdao = new TenantDAOImplementation();
        ArrayList<TenantBean> tlist = new ArrayList<TenantBean>();

        TenantBean temp = new TenantBean();
        int tenantID;
        String fname, lname;
        Date effectivedate, expirydate;
        for (int i = 0; i < clist.size(); i++) {
            tenantID = clist.get(i).getContract_tenantID();

            if (tenantID == 0) {
                // wala tenant
            } else {
                temp = tdao.getTenantById(tenantID);
                fname = temp.getFname();
                lname = temp.getLname();
                effectivedate = clist.get(i).getEffectivedate();
                expirydate = clist.get(i).getExpirydate();

                Object[] obj = {lname, fname, effectivedate, expirydate};
                model.addRow(obj);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public int toMonth(String m) {
        if (m.equals("January")) {
            return 1;
        } else if (m.equals("February")) {
            return 2;
        } else if (m.equals("March")) {
            return 3;
        } else if (m.equals("April")) {
            return 4;
        } else if (m.equals("May")) {
            return 5;
        } else if (m.equals("June")) {
            return 6;
        } else if (m.equals("July")) {
            return 7;
        } else if (m.equals("August")) {
            return 8;
        } else if (m.equals("September")) {
            return 9;
        } else if (m.equals("October")) {
            return 10;
        } else if (m.equals("November")) {
            return 11;
        } else if (m.equals("December")) {
            return 12;
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
