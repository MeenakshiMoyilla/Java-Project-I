package comm.coursereg.db;

import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/coursedb",
                    "root",
                    "root"   // change to your password
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
