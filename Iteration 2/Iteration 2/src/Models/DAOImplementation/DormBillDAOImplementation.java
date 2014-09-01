/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOImplementation;

import Models.Beans.DormBillBean;
import Models.Connector.Connector;
import Models.DAOInterface.DormBillDAOInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class DormBillDAOImplementation implements DormBillDAOInterface{

    @Override
    public boolean addDormBill(DormBillBean dorm) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "insert into dormbill (waterconsumption, electricityconsumption, totalwaterprice, totalelectricityprice, dateRead) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, dorm.getWaterconsumption());
            ps.setFloat(2, dorm.getElectconsumption());
            ps.setDouble(3, dorm.getWaterprice());
            ps.setDouble(4, dorm.getElectprice());
            ps.setDate(5, dorm.getDateRead());
            ps.executeUpdate();
            connection.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean editDormBill(DormBillBean dorm) {
         try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "update dormbill set waterconsumption = ?, electricityconsumption = ?,"
                    +"totalwaterprice = ?, totalelectricityprice = ?, dateRead = ? where dbill_ID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, dorm.getWaterconsumption());
            ps.setFloat(2, dorm.getElectconsumption());
            ps.setDouble(3, dorm.getWaterprice());
            ps.setDouble(4, dorm.getElectprice());
            ps.setDate(5, dorm.getDateRead());
            ps.setInt(6, dorm.getDbill_ID());
            ps.executeUpdate();
            connection.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<DormBillBean> getAllDormBills() {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dormbill";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            
            DormBillBean dorm = new DormBillBean();
            ArrayList<DormBillBean> list = new ArrayList<>();
            
            int dbill_ID;
            float waterconsumption, electconsumption;
            double waterprice, electprice;
            java.sql.Date dateRead;
            
            while(resultSet.next()){                
                dbill_ID = resultSet.getInt("dbill_ID");
                waterconsumption = resultSet.getFloat("waterconsumption");
                electconsumption = resultSet.getFloat("electconsumption");
                waterprice = resultSet.getDouble("totalwaterprice");
                electprice = resultSet.getDouble("totalelectricityprice");
                dateRead = resultSet.getDate("dateRead");
                
                dorm.setDbill_ID(dbill_ID);
                dorm.setWaterconsumption(waterconsumption);
                dorm.setElectconsumption(electconsumption);
                dorm.setWaterprice(waterprice);
                dorm.setElectprice(electprice);
                dorm.setDateRead(dateRead);
                
                list.add(dorm);
                
            }
            connection.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DormBillBean getDormBillByID(int dormID) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dormbill where dbill_ID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, dormID);
            ResultSet resultSet = ps.executeQuery();
            
            DormBillBean dorm = new DormBillBean();
            
            int dbill_ID;
            float waterconsumption, electconsumption;
            double waterprice, electprice;
            java.sql.Date dateRead;
            
            while(resultSet.next()){                
                dbill_ID = resultSet.getInt("dbill_ID");
                waterconsumption = resultSet.getFloat("waterconsumption");
                electconsumption = resultSet.getFloat("electconsumption");
                waterprice = resultSet.getDouble("totalwaterprice");
                electprice = resultSet.getDouble("totalelectricityprice");
                dateRead = resultSet.getDate("dateRead");
                
                dorm.setDbill_ID(dbill_ID);
                dorm.setWaterconsumption(waterconsumption);
                dorm.setElectconsumption(electconsumption);
                dorm.setWaterprice(waterprice);
                dorm.setElectprice(electprice);
                dorm.setDateRead(dateRead);
                
            }
            connection.close();

            return dorm;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DormBillBean getDormBillByMonthandYear(Date date) {
        try {
            Connector c = new Connector();
            Connection connection = c.getConnection();
            String query = "select * from dormbill where month(?) = month(dateRead)and year(?) = year(dateRead)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, date);
            ps.setDate(2, date);
            ResultSet resultSet = ps.executeQuery();
            
            DormBillBean dorm = new DormBillBean();
            
            int dbill_ID;
            float waterconsumption, electconsumption;
            double waterprice, electprice;
            java.sql.Date dateRead;
            
            while(resultSet.next()){                
                dbill_ID = resultSet.getInt("dbill_ID");
                waterconsumption = resultSet.getFloat("waterconsumption");
                electconsumption = resultSet.getFloat("electricityconsumption");
                waterprice = resultSet.getDouble("totalwaterprice");
                electprice = resultSet.getDouble("totalelectricityprice");
                dateRead = resultSet.getDate("dateRead");
                
                dorm.setDbill_ID(dbill_ID);
                dorm.setWaterconsumption(waterconsumption);
                dorm.setElectconsumption(electconsumption);
                dorm.setWaterprice(waterprice);
                dorm.setElectprice(electprice);
                dorm.setDateRead(dateRead);
                
            }
            connection.close();

            return dorm;

        } catch (SQLException ex) {
            Logger.getLogger(ElectricReadingDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

  
    
}
