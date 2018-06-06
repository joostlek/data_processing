package P1;

import java.sql.*;

public class OracleBaseDao {
    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521";
    private static final String DB_USER = "OV";
    private static final String DB_PASS = "admin";
    private static Connection conn;

    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
