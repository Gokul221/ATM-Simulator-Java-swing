package atm.simulation.system;

import java.sql.*;
import javax.swing.*;

public class DBconnection implements AutoCloseable {

    Connection c;
    Statement s;

    public DBconnection() {
        try {
            // create db connection
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulator", "root", "gokul@123");

            // create statement
            s = c.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        if (c != null) {
            c.close();
        }
        if (s != null) {
            s.close();
        }
    }

}
