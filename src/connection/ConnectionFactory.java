/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31448933
 */
public class ConnectionFactory {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String protocol = "jdbc:mysql://localhost:3306";
    private final String dbName = "/database";
    private Connection connection;

    public ConnectionFactory() {
    }

    public Connection getConnection(String type) {
        if (type.equalsIgnoreCase("derby")) {
            try {
                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(protocol + dbName, "root", "");
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
