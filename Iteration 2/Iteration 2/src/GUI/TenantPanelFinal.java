/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ErrorHandling.AccountException;
import ErrorHandling.CheckAccount;
import Models.Beans.AttendanceLogBean;
import Models.Beans.GuardianBean;
import Models.Beans.RoomBean;
import Models.Beans.TenantBean;
import Models.DAOImplementation.AttendanceLogDAOImplementation;
import Models.DAOImplementation.GuardianDAOImplementation;
import Models.DAOImplementation.RoomDAOImplementation;
import Models.DAOImplementation.TenantDAOImplementation;
import Models.DAOInterface.AttendanceLogDAOInterface;
import Models.DAOInterface.GuardianDAOInterface;
import Models.DAOInterface.TenantDAOInterface;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giodee
 */
public class TenantPanelFinal extends javax.swing.JPanel {

    /**
     * Creates new form TenantPanelFinal
     */
    private DefaultTableModel model;
    private CheckAccount c = new CheckAccount();
    private ArrayList<TenantBean> searchnamelist = new ArrayList<>();
    private TenantDAOInterface tenantImpl = new TenantDAOImplementation();
    private int tenantID;
    private JPanel jPanel2;

    public TenantPanelFinal() {
        initComponents();

        backbutton.hide();
        initBasicInfo();

        model = (DefaultTableModel) jTable1.getModel();
        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.removeItem(i);
        }
        for (int i = 2000; i <= year + 10; i++) {
            YearOfGraduationField.addItem(i);
        }
        initTable();

    }

    public void initBasicInfo() {
        birthdaylabel.hide();
        birthday.hide();
        genderlabel.hide();
        gender.hide();
        emaillabel.hide();
        email.hide();
        addresslabel.hide();
        address.hide();
        schooldegreelabel.hide();
        schooldegree.hide();
        yearofgradlabel.hide();
        yearofgrad.hide();
        statuslabel.hide();
        status.hide();
        gnamelabel.hide();
        gnumlabel.hide();
        gemaillabel.hide();
        gname.hide();
        gnum.hide();
        gemail.hide();

        fnamelabel.setLocation(20, 40);
        fname.setLocation(110, 40);

        lnamelabel.setLocation(20, 80);
        lname.setLocation(120, 80);

        inoutlabel.setLocation(20, 120);
        inout.setLocation(120, 120);

        logtimelabel.setLocation(20, 160);
        logtime.setLocation(120, 160);

        roomnumberlabel.setLocation(20, 200);
        roomnumber.setLocation(120, 200);

        contactnumberlabel.setLocation(20, 240);
        contactno.setLocation(130, 240);

        completebutton.setLocation(70, 280);
        editbutton.setLocation(70, 330);

    }

    public void initTable() {
        ArrayList<TenantBean> tenantlist = new ArrayList<>();
        tenantlist = tenantImpl.getAllTenants();
        initSearch(tenantlist);
    }

    public void initSearch(ArrayList<TenantBean> list) {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (TenantBean tenant : list) {
            Object[] obj = {tenant.getTenantID(), tenant.getLname(), tenant.getFname()};
            model.addRow(obj);
        }
        if (!list.isEmpty()) {
            jTable1.addRowSelectionInterval(0, 0);
            getSelection();
        }
    }

    public void getSelection() {

        int row = jTable1.getSelectedRow();
        int col = 0;

        int tenantid = (Integer) jTable1.getModel().getValueAt(row, col);

        TenantDAOInterface tdao = new TenantDAOImplementation();
        TenantBean bean = new TenantBean();
        bean = tdao.getTenantById(tenantid);

        byte[] content = null;
        if (bean.getBlobimage() != null) {
            try {
                content = bean.getBlobimage().getBytes(1L, (int) bean.getBlobimage().length());
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon icon = new ImageIcon(content);
            java.awt.Image img = icon.getImage();
            java.awt.Image newimg = img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            imgLabel.setIcon(icon);
        }
        if (tenantid != 0) {
            lname.setText(bean.getLname());
            fname.setText(bean.getFname());
            address.setText(bean.getAddress());
            gender.setText(bean.getGender());
            gender.setText(bean.getGender());
            contactno.setText(bean.getContact());
            email.setText(bean.getEmail());
            schooldegree.setText(bean.getSchool() + "/" + bean.getDegree());
            yearofgrad.setText(String.valueOf(bean.getExpectedyearofgrad()));
            DateFormat date = new SimpleDateFormat("MMMM d, yyyy");
            birthday.setText(date.format(bean.getBirthday()));

            GuardianDAOInterface gdao = new GuardianDAOImplementation();
            GuardianBean gbean = new GuardianBean();

            gbean = gdao.getGuardianByTenantID(tenantid);

            gname.setText(gbean.getFname() + " " + gbean.getLname());
            gnum.setText(gbean.getContact());
            gemail.setText(gbean.getEmail());

            GuardianBean guardianbean = new GuardianBean();

            RoomBean roombean = new RoomBean();
            RoomDAOImplementation roomdao = new RoomDAOImplementation();

            roombean = roomdao.getTenantRoom(tenantid);
            if (roombean.getRoomID() == 0) {
                roomnumber.setText("none");
            } else {
                roomnumber.setText(String.valueOf(roombean.getRoomID()));
            }

            AttendanceLogDAOInterface ldao = new AttendanceLogDAOImplementation();
            AttendanceLogBean lbean = ldao.getLatestLoginByTenant(tenantid);
            AttendanceLogBean lbean1 = ldao.getLatestLogoutByTenant(tenantid);

            if (lbean == null && lbean1 == null) { // wala pa talaga
                System.out.println("First");
                inout.setText("No logs yet.");
                logtime.setText("No logs yet.");

            } else if (lbean == null & lbean1 != null) {
                inout.setText("OUT");
                System.out.println("Second");

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
                java.sql.Timestamp ts = lbean1.getTimeLogged();
                int microFraction = ts.getNanos() / 1000;

                StringBuilder sb = new StringBuilder(fmt.format(ts));

                System.out.println(sb.toString());

                logtime.setText(sb.toString());
            } else if (lbean1 == null && lbean != null) {
                inout.setText("IN");
                System.out.println("Third");

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
                java.sql.Timestamp ts = lbean.getTimeLogged();
                int microFraction = ts.getNanos() / 1000;

                StringBuilder sb = new StringBuilder(fmt.format(ts));

                System.out.println(sb.toString());

                logtime.setText(sb.toString());
            } else if (lbean.getLogID() > lbean1.getLogID()) { // login
                inout.setText("IN");
                System.out.println("fourth");

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
                java.sql.Timestamp ts = lbean.getTimeLogged();
                int microFraction = ts.getNanos() / 1000;

                StringBuilder sb = new StringBuilder(fmt.format(ts));

                System.out.println(sb.toString());

                logtime.setText(sb.toString());
            } else {
                inout.setText("OUT");

                System.out.println("fifth");

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
                java.sql.Timestamp ts = lbean1.getTimeLogged();
                int microFraction = ts.getNanos() / 1000;

                StringBuilder sb = new StringBuilder(fmt.format(ts));

                System.out.println(sb.toString());
            }
        } else {
            System.out.println("no tenant selected");
        }
    }

    public void searchName() {
        String name = NameField.getText();

        try {
            c.checkName(name, "Name");
            searchnamelist = tenantImpl.searchTenantName(name);
            initSearch(searchnamelist);

        } catch (AccountException ex) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
    }

    public void searchSchool() {
        String school = SchoolField.getText();

        try {
            c.checkName(school, "School");
            searchnamelist = tenantImpl.getTenantBySchool(school);
            initSearch(searchnamelist);

        } catch (AccountException ex) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
    }

    public void searchDegree() {
        String degree = DegreeField.getText();

        try {
            c.checkName(degree, "Degree");
            searchnamelist = tenantImpl.getTenantByDegree(degree);
            initSearch(searchnamelist);

        } catch (AccountException ex) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
    }

    public void searchYear() {
        int year = Integer.parseInt(YearOfGraduationField.getSelectedItem().toString());

        searchnamelist = tenantImpl.getTenantByExpectedYearofGrad(year);
        initSearch(searchnamelist);

    }

    public void searchMale() {
        searchnamelist = tenantImpl.getMaleTenant();
        initSearch(searchnamelist);

    }

    public void searchFemale() {
        searchnamelist = tenantImpl.getFemaleTenant();
        initSearch(searchnamelist);
    }

    public void searchCurrent() {
//        searchnamelist = tenantImpl.getTenantByStatus(CurrentField.getText());
        initSearch(searchnamelist);
    }

    public void searchOld() {
        //       searchnamelist = tenantImpl.getTenantByStatus(OldField.getText());
        //       searchnamelist = tenantImpl.getTenantByStatus(OldField.getText());
        initSearch(searchnamelist);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameField = new javax.swing.JTextField();
        SchoolField = new javax.swing.JTextField();
        DegreeField = new javax.swing.JTextField();
        YearOfGraduationField = new javax.swing.JComboBox();
        MaleField = new javax.swing.JRadioButton();
        FemaleField = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fnamelabel = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        lnamelabel = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        inoutlabel = new javax.swing.JLabel();
        inout = new javax.swing.JLabel();
        logtimelabel = new javax.swing.JLabel();
        logtime = new javax.swing.JLabel();
        roomnumberlabel = new javax.swing.JLabel();
        roomnumber = new javax.swing.JLabel();
        contactnumberlabel = new javax.swing.JLabel();
        contactno = new javax.swing.JLabel();
        completebutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        birthdaylabel = new javax.swing.JLabel();
        birthday = new javax.swing.JLabel();
        genderlabel = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        emaillabel = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        addresslabel = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        schooldegreelabel = new javax.swing.JLabel();
        schooldegree = new javax.swing.JLabel();
        yearofgradlabel = new javax.swing.JLabel();
        yearofgrad = new javax.swing.JLabel();
        statuslabel = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        gnamelabel = new javax.swing.JLabel();
        gnumlabel = new javax.swing.JLabel();
        gemaillabel = new javax.swing.JLabel();
        gname = new javax.swing.JLabel();
        gnum = new javax.swing.JLabel();
        gemail = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 596));
        setMinimumSize(new java.awt.Dimension(1000, 596));
        setLayout(null);

        NameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        NameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameFieldKeyReleased(evt);
            }
        });
        add(NameField);
        NameField.setBounds(110, 170, 120, 30);

        SchoolField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        SchoolField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchoolFieldActionPerformed(evt);
            }
        });
        SchoolField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SchoolFieldKeyReleased(evt);
            }
        });
        add(SchoolField);
        SchoolField.setBounds(110, 200, 120, 30);

        DegreeField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        DegreeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegreeFieldActionPerformed(evt);
            }
        });
        DegreeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DegreeFieldKeyReleased(evt);
            }
        });
        add(DegreeField);
        DegreeField.setBounds(110, 229, 120, 30);

        YearOfGraduationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearOfGraduationFieldActionPerformed(evt);
            }
        });
        add(YearOfGraduationField);
        YearOfGraduationField.setBounds(110, 260, 70, 30);

        MaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        MaleField.setText("Male");
        MaleField.setOpaque(false);
        MaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleFieldActionPerformed(evt);
            }
        });
        add(MaleField);
        MaleField.setBounds(110, 290, 60, 30);

        FemaleField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        FemaleField.setText("Female");
        FemaleField.setOpaque(false);
        FemaleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleFieldActionPerformed(evt);
            }
        });
        add(FemaleField);
        FemaleField.setBounds(160, 290, 80, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/AddTenant.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(70, 340, 160, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tenant ID", "Surname", "Firstname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(270, 30, 350, 520);

        jLabel10.setText("Name");
        add(jLabel10);
        jLabel10.setBounds(70, 180, 40, 14);

        jLabel11.setText("School");
        jLabel11.setPreferredSize(null);
        add(jLabel11);
        jLabel11.setBounds(70, 210, 40, 14);

        jLabel12.setText("Degree");
        add(jLabel12);
        jLabel12.setBounds(70, 240, 50, 14);

        jLabel13.setText("Year");
        add(jLabel13);
        jLabel13.setBounds(70, 270, 40, 14);

        jLabel14.setText("Gender");
        add(jLabel14);
        jLabel14.setBounds(70, 300, 50, 14);

        imgLabel.setText("Picture");
        add(imgLabel);
        imgLabel.setBounds(840, 40, 100, 90);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        fnamelabel.setText("First Name:");
        jPanel1.add(fnamelabel);
        fnamelabel.setBounds(20, 40, 90, 14);

        fname.setText("jLabel8");
        jPanel1.add(fname);
        fname.setBounds(110, 40, 200, 20);

        lnamelabel.setText("Last Name:");
        jPanel1.add(lnamelabel);
        lnamelabel.setBounds(20, 60, 80, 14);

        lname.setText("jLabel9");
        jPanel1.add(lname);
        lname.setBounds(110, 60, 200, 14);

        inoutlabel.setText("In/Out:");
        jPanel1.add(inoutlabel);
        inoutlabel.setBounds(20, 80, 70, 14);

        inout.setText("jLabel10");
        jPanel1.add(inout);
        inout.setBounds(110, 74, 200, 20);

        logtimelabel.setText("Last Log Time:");
        jPanel1.add(logtimelabel);
        logtimelabel.setBounds(20, 100, 100, 14);

        logtime.setText("jLabel10");
        jPanel1.add(logtime);
        logtime.setBounds(110, 100, 200, 14);

        roomnumberlabel.setText("Room Number:");
        jPanel1.add(roomnumberlabel);
        roomnumberlabel.setBounds(20, 120, 100, 14);

        roomnumber.setText("jLabel10");
        jPanel1.add(roomnumber);
        roomnumber.setBounds(110, 120, 200, 14);

        contactnumberlabel.setText("Contact Number:");
        jPanel1.add(contactnumberlabel);
        contactnumberlabel.setBounds(20, 140, 110, 14);

        contactno.setText("jLabel8");
        jPanel1.add(contactno);
        contactno.setBounds(110, 140, 200, 14);

        completebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewcompletedetails.png"))); // NOI18N
        completebutton.setContentAreaFilled(false);
        completebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(completebutton);
        completebutton.setBounds(80, 330, 170, 40);

        editbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/edit_information button.png"))); // NOI18N
        editbutton.setContentAreaFilled(false);
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(editbutton);
        editbutton.setBounds(70, 400, 170, 40);

        birthdaylabel.setText("Birthday:");
        jPanel1.add(birthdaylabel);
        birthdaylabel.setBounds(20, 160, 80, 14);

        birthday.setText("jLabel16");
        jPanel1.add(birthday);
        birthday.setBounds(110, 160, 200, 14);

        genderlabel.setText("Gender:");
        jPanel1.add(genderlabel);
        genderlabel.setBounds(20, 180, 80, 14);

        gender.setText("jLabel18");
        jPanel1.add(gender);
        gender.setBounds(110, 180, 190, 14);

        emaillabel.setText("E-mail:");
        jPanel1.add(emaillabel);
        emaillabel.setBounds(20, 200, 70, 14);

        email.setText("jLabel20");
        jPanel1.add(email);
        email.setBounds(110, 200, 190, 14);

        addresslabel.setText("Address:");
        jPanel1.add(addresslabel);
        addresslabel.setBounds(20, 220, 80, 14);

        address.setText("jLabel22");
        jPanel1.add(address);
        address.setBounds(110, 220, 190, 14);

        schooldegreelabel.setText("School/Degree:");
        jPanel1.add(schooldegreelabel);
        schooldegreelabel.setBounds(20, 240, 90, 14);

        schooldegree.setText("jLabel24");
        jPanel1.add(schooldegree);
        schooldegree.setBounds(110, 240, 190, 14);

        yearofgradlabel.setText("Year of Graduation:");
        jPanel1.add(yearofgradlabel);
        yearofgradlabel.setBounds(20, 260, 110, 14);

        yearofgrad.setText("jLabel26");
        jPanel1.add(yearofgrad);
        yearofgrad.setBounds(130, 260, 170, 14);

        statuslabel.setText("Status:");
        jPanel1.add(statuslabel);
        statuslabel.setBounds(20, 280, 60, 14);

        status.setText("jLabel28");
        jPanel1.add(status);
        status.setBounds(110, 280, 190, 14);

        gnamelabel.setText("Guardian's Name:");
        jPanel1.add(gnamelabel);
        gnamelabel.setBounds(20, 300, 100, 14);

        gnumlabel.setText("Guardian's Contact Number:");
        jPanel1.add(gnumlabel);
        gnumlabel.setBounds(20, 320, 190, 14);

        gemaillabel.setText("Guardian's E-mail:");
        jPanel1.add(gemaillabel);
        gemaillabel.setBounds(20, 340, 120, 14);

        gname.setText("jLabel32");
        jPanel1.add(gname);
        gname.setBounds(110, 300, 190, 14);

        gnum.setText("jLabel33");
        jPanel1.add(gnum);
        gnum.setBounds(170, 320, 130, 14);

        gemail.setText("jLabel34");
        jPanel1.add(gemail);
        gemail.setBounds(110, 340, 190, 14);

        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/backbutton.png"))); // NOI18N
        backbutton.setContentAreaFilled(false);
        backbutton.setEnabled(false);
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(backbutton);
        backbutton.setBounds(100, 360, 115, 40);

        add(jPanel1);
        jPanel1.setBounds(640, 100, 310, 450);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/tenant-tab-peg-crop.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void NameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameFieldKeyReleased
        // TODO add your handling code here:
        searchName();
    }//GEN-LAST:event_NameFieldKeyReleased

    private void SchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SchoolFieldActionPerformed

    private void SchoolFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolFieldKeyReleased
        // TODO add your handling code here:
        searchSchool();
    }//GEN-LAST:event_SchoolFieldKeyReleased

    private void DegreeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegreeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DegreeFieldActionPerformed

    private void DegreeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeFieldKeyReleased
        // TODO add your handling code here:
        searchDegree();
    }//GEN-LAST:event_DegreeFieldKeyReleased

    private void YearOfGraduationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearOfGraduationFieldActionPerformed
        // TODO add your handling code here:
        searchYear();
    }//GEN-LAST:event_YearOfGraduationFieldActionPerformed

    private void MaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleFieldActionPerformed
        // TODO add your handling code here:
        searchMale();
    }//GEN-LAST:event_MaleFieldActionPerformed

    private void FemaleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleFieldActionPerformed
        // TODO add your handling code here:
        searchFemale();
    }//GEN-LAST:event_FemaleFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        jPanel2 = new AddTenantPanelFinal();

        setJpanel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();

        tenantID = (Integer) jTable1.getValueAt(row, 0);
        System.out.println(tenantID);
        setID(tenantID);
        getSelection();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        getSelection();
    }//GEN-LAST:event_jTable1KeyReleased

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        // TODO add your handling code here:

        // edit tenant information
        this.removeAll();
        int row = jTable1.getSelectedRow();

        tenantID = (Integer) jTable1.getValueAt(row, 0);
        System.out.println(tenantID);
        setID(tenantID);

        jPanel2 = new EditTenantPanelFinal(tenantID);

        setJpanel();
        //      jScrollPane2.setViewportView(et);
        //   NewJFrame nj = new NewJFrame(tenantID);
    }//GEN-LAST:event_editbuttonActionPerformed

    private void completebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completebuttonActionPerformed
        // TODO add your handling code here:

        fnamelabel.setLocation(20, 40);
        fname.setLocation(130, 40);

        lnamelabel.setLocation(20, 60);
        lname.setLocation(130, 60);

        inoutlabel.setLocation(20, 80);
        inout.setLocation(130, 80);

        logtimelabel.setLocation(20, 100);
        logtime.setLocation(130, 100);

        roomnumberlabel.setLocation(20, 120);
        roomnumber.setLocation(130, 120);

        contactnumberlabel.setLocation(20, 140);
        contactno.setLocation(130, 140);

        birthdaylabel.show();
        birthdaylabel.setLocation(20, 160);
        birthday.show();
        birthday.setLocation(130, 160);

        genderlabel.show();
        genderlabel.setLocation(20, 180);
        gender.show();
        gender.setLocation(130, 180);

        emaillabel.show();
        emaillabel.setLocation(20, 200);
        email.show();
        email.setLocation(130, 200);

        addresslabel.show();
        addresslabel.setLocation(20, 220);
        address.show();
        address.setLocation(130, 220);

        schooldegreelabel.show();
        schooldegreelabel.setLocation(20, 240);
        schooldegree.show();
        schooldegree.setLocation(130, 240);

        yearofgradlabel.show();
        yearofgradlabel.setLocation(20, 260);
        yearofgrad.show();
        yearofgrad.setLocation(150, 260);

        statuslabel.show();
        statuslabel.setLocation(20, 280);
        status.show();
        status.setLocation(130, 280);

        gnamelabel.show();
        gnamelabel.setLocation(20, 300);
        gname.show();
        gname.setLocation(130, 300);

        gnumlabel.show();
        gnumlabel.setLocation(20, 320);
        gnum.show();
        gnum.setLocation(190, 320);

        gemaillabel.show();
        gemaillabel.setLocation(20, 340);
        gemail.show();
        gemail.setLocation(130, 340);
      
        editbutton.setLocation(70, 400);
        backbutton.setEnabled(true);
        backbutton.show();
        completebutton.hide();
        getSelection();
    }//GEN-LAST:event_completebuttonActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        // TODO add your handling code here:

        completebutton.show();
        backbutton.hide();
        backbutton.setEnabled(true);
        initBasicInfo();
    }//GEN-LAST:event_backbuttonActionPerformed

    public void setJpanel() {
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 600));
        this.add(jPanel2);
        jPanel2.setOpaque(true);
        jPanel2.setBounds(0, 0, 1000, 600);
    }

    public void setID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int returnID() {
        return this.tenantID;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DegreeField;
    private javax.swing.JRadioButton FemaleField;
    private javax.swing.JRadioButton MaleField;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField SchoolField;
    private javax.swing.JComboBox YearOfGraduationField;
    private javax.swing.JLabel address;
    private javax.swing.JLabel addresslabel;
    private javax.swing.JButton backbutton;
    private javax.swing.JLabel birthday;
    private javax.swing.JLabel birthdaylabel;
    private javax.swing.JButton completebutton;
    private javax.swing.JLabel contactno;
    private javax.swing.JLabel contactnumberlabel;
    private javax.swing.JButton editbutton;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel fnamelabel;
    private javax.swing.JLabel gemail;
    private javax.swing.JLabel gemaillabel;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel genderlabel;
    private javax.swing.JLabel gname;
    private javax.swing.JLabel gnamelabel;
    private javax.swing.JLabel gnum;
    private javax.swing.JLabel gnumlabel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel inout;
    private javax.swing.JLabel inoutlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel lnamelabel;
    private javax.swing.JLabel logtime;
    private javax.swing.JLabel logtimelabel;
    private javax.swing.JLabel roomnumber;
    private javax.swing.JLabel roomnumberlabel;
    private javax.swing.JLabel schooldegree;
    private javax.swing.JLabel schooldegreelabel;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statuslabel;
    private javax.swing.JLabel yearofgrad;
    private javax.swing.JLabel yearofgradlabel;
    // End of variables declaration//GEN-END:variables
}
