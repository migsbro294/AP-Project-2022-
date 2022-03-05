package jdbc.model;

import java.sql.*;
import db.connection.*;

public class Employee {
	private Connection dbConn;
	
	public Employee() {
		dbConn = DBConnector.getConnection();
		
	}
	
	public void createEmployee(String eId, String fName, String lName, int cNum, String role, String email) {
		try {
			PreparedStatement preSta = dbConn.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?)");
			preSta.setObject(1, eId);
			preSta.setObject(2, fName);
			preSta.setObject(3, lName);
			preSta.setObject(4, cNum);
			preSta.setObject(5, role);
			preSta.setObject(6, email);
			int i = preSta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void selectEmployee(String eId) {
		try {
			final String QUERY = "SELECT eId, name FROM employee";
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while(rs.next()) {
				System.out.print("ID: " + rs.getInt("Customer_Id"));
				System.out.print("\tLast Name" + rs.getString("Firstname"));
				System.out.print("\tFirst Name" + rs.getString("Lastname"));
				System.out.print("\tContact" + rs.getInt("Contact_num"));
				System.out.print("\tRole: " + rs.getString("Role"));
				System.out.print("\tEmail" + rs.getString("Email"));
				System.out.print("\n");
			}
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void updateEmployee(String eId, String email) {
		PreparedStatement updateSql;
		try {
			updateSql = dbConn.prepareStatement("UPDATE customer Set Email = ? WHERE id = ?");
			updateSql.setObject(1, email);
			updateSql.setObject(2, eId);
			int i=updateSql.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void deleteEmployee(String eId) {
		PreparedStatement deleteSql;
		try {
			deleteSql = dbConn.prepareStatement("DELETE FROM employee WHERE id = ?");
			deleteSql.setObject(1, eId);
			int i = deleteSql.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
