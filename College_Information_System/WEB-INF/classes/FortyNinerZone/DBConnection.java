/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LokeshPC
 */
public class DBConnection {
    public Connection getConnection() {
        Connection con;

        try {
         Class.forName("com.mysql.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi_49erZone","root","priyankamysql13");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
