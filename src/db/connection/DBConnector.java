package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static final String dbUrl ="jdbc:mysql://localhost:3306/mstarcable";
	private static final String dbUsername="root";
	private static final String dbPassword="root";
	
	
	private static Connection connection = null;
	static{
		try {
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return connection;
	}
}