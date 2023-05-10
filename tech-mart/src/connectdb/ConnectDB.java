package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB implements DatabaseInfor{
	private static ConnectDB instance;

    public Connection openConnection() throws ClassNotFoundException {
        try {
        	Class.forName(driverName);
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            return con;
        } catch (SQLException ex) {
        	System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    // get instance of database only one time
    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }
}
