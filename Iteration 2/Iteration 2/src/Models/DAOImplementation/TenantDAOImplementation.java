/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAOImplementation;

import Models.Beans.TenantBean;
import Models.Connector.Connector;
import Models.DAOInterface.TenantDAOInterface;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author User
 */
public class TenantDAOImplementation implements TenantDAOInterface {

    @Override
    public boolean addTenant(TenantBean tenant) { // important
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into tenant (fname, lname, image, contact, gender, address, degree, school, expectedyearofgrad, status, email, birthday)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenant.getFname());
            ps.setString(2, tenant.getLname());
            FileInputStream fin = null;
            if (tenant.getImage() != null) {
                try {
                    fin = new FileInputStream(tenant.getImage());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    ps.setBinaryStream(3, fin, fin.available());
                } catch (IOException ex) {
                    Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                ps.setBlob(3, tenant.getBlobimage());
            }
            ps.setString(4, tenant.getContact());
            ps.setString(5, tenant.getGender());
            ps.setString(6, tenant.getAddress());
            ps.setString(7, tenant.getDegree());
            ps.setString(8, tenant.getSchool());
            ps.setInt(9, tenant.getExpectedyearofgrad());
            ps.setString(10, tenant.getStatus());
            ps.setString(11, tenant.getEmail());
            ps.setDate(12, tenant.getBirthday());
            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public TenantBean getTenantById(int tenantid) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where tenantID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tenantid);
            ResultSet resultSet = ps.executeQuery();

            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, email, contact;
            Date birthday;
            Blob image;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
                bean.setBlobimage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);
            }
            connection.close();

            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<TenantBean> getAllTenants() { // important
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant order by lname, fname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<TenantBean>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Date birthday;

            Blob image;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);
                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public TenantBean getTenantByName(String firstname, String lastname) { // important

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where fname = ? and lname = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ResultSet resultSet = ps.executeQuery();

            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);
            }
            connection.close();

            return bean;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<TenantBean> getTenantByExpectedYearofGrad(int year) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where expectedyearofgrad = ? order by lname, fname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, year);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<TenantBean>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public ArrayList<TenantBean> getTenantByRoomID(int tenant_roomID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant, tenantroom where tenantID = tr_tenantID and tr_roomID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tenant_roomID);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, email, contact;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public ArrayList<TenantBean> getTenantBySchool(String currschool) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where school like '%" + currschool + "%' order by lname, fname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setBirthday(birthday);
                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<TenantBean> getMaleTenant() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where gender = 'male' order by lname, fname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<TenantBean> getFemaleTenant() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where gender = 'female' order by lname, fname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, email, contact;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<TenantBean> getTenantByStatus(String currstatus) {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where status =? order by lname, fname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, currstatus);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, email, contact;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<TenantBean> getTenantListByName(String firstname, String lastname) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where fname = ? and lname = ? order by fname, lname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ArrayList<TenantBean> getTenantByDegree(String currdegree) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where degree like '%" + currdegree + "%' order by lname, fname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean editTenant(TenantBean tenant) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();

            String query = "update tenant set image = ?, contact = ?, gender = ?, address = ?, degree = ?, school = ?, expectedyearofgrad = ?, status=?, fname = ?, lname = ?, email = ?, birthday = ? where tenantID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            FileInputStream fin = null;

            if (tenant.getImage().isEmpty()) {
                ps.setBlob(1, tenant.getBlobimage());
            }else{
                try {
                    fin = new FileInputStream(tenant.getImage());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    ps.setBinaryStream(1, fin, fin.available());
                } catch (IOException ex) {
                    Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ps.setString(2, tenant.getContact());
            ps.setString(3, tenant.getGender());
            ps.setString(4, tenant.getAddress());
            ps.setString(5, tenant.getDegree());
            ps.setString(6, tenant.getSchool());
            ps.setInt(7, tenant.getExpectedyearofgrad());
            ps.setString(8, tenant.getStatus());
            ps.setString(9, tenant.getFname());
            ps.setString(10, tenant.getLname());
            ps.setString(11, tenant.getEmail());
            ps.setDate(12, tenant.getBirthday());
            ps.setInt(13, tenant.getTenantID());

            ps.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<TenantBean> searchTenantName(String name) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from tenant where fname like '%" + name + "%'"
                    + "or lname like '%" + name + "%' or concat (fname,' ',lname) like '%" + name + "%' order by fname, lname ASC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public ArrayList<TenantBean> getAllTenantsWithoutRoom() {

        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select tenant.lname, tenant.fname, tenant.tenantID from tenant, tenantroom where tr_tenantID = tenantID order asc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<TenantBean> list = new ArrayList<>();
            TenantBean bean = new TenantBean();

            int tenantID, expectedyearofgrad;
            String fname, lname, gender, address, degree, school, status, contact, email;
            Blob image;
            Date birthday;

            while (resultSet.next()) {
                tenantID = resultSet.getInt("tenantID");
                contact = resultSet.getString("contact");
                expectedyearofgrad = resultSet.getInt("expectedyearofgrad");
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                degree = resultSet.getString("degree");
                school = resultSet.getString("school");
                status = resultSet.getString("status");
                image = resultSet.getBlob("image");
                email = resultSet.getString("email");
                birthday = resultSet.getDate("birthday");

                bean = new TenantBean();

                bean.setTenantID(tenantID);
                bean.setContact(contact);
                bean.setExpectedyearofgrad(expectedyearofgrad);
                bean.setFname(fname);
                bean.setLname(lname);
                bean.setGender(gender);
                bean.setDegree(degree);
                bean.setAddress(address);
                bean.setSchool(school);
                bean.setStatus(status);
//                bean.setImage(image);
                bean.setEmail(email);
                bean.setBirthday(birthday);

                list.add(bean);
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean deleteTenant(TenantBean tenant) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "delete from Tenant where tenantID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tenant.getTenantID());
            ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(TenantDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

}
