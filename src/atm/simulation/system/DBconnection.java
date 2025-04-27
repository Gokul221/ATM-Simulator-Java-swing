package atm.simulation.system;

import java.sql.*;

public class DBconnection {

    Connection c;
    Statement s;

    public DBconnection() {
        try {
            // create db connection
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulator", "root", "gokul@123");

            // create statement
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
