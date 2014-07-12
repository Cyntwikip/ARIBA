
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Connector {

    private String username = "ariba";
    private String password = "p@ssword";
    private String url = "jdbc:mysql://localhost:3306/dormitory";
    private String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection() {
        try {        
            Class.forName(driver);
            Connection c = DriverManager.getConnection(url, username, password);
            return c;
        
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}