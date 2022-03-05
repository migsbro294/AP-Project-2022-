package jdbc.model;

import java.sql.*;
import db.connection.*;

public class Customer {
	private Connection dbConn;
	
	public Customer() {
		dbConn = DBConnector.getConnection();
		
	}
	
	public void createCustomer(String Customer_ID, String Lastname, String Firstname, String Email, int Contact_num, String Address) {
		try {
			PreparedStatement preSta = dbConn.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?)");
			preSta.setObject(1, Customer_ID);
			preSta.setObject(2, Lastname);
			preSta.setObject(3, Firstname);
			preSta.setObject(4, Email);
			preSta.setObject(5, Contact_num);
			preSta.setObject(6, Address);
			int i = preSta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void selectCustomer(String Customer_ID) {
		try {
			final String QUERY = "SELECT Customer_ID, name FROM customer";
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while(rs.next()) {
				System.out.print("ID: " + rs.getInt("Customer_Id"));
				System.out.print("\tLast Name" + rs.getString("Lastname"));
				System.out.print("\tFirst Name" + rs.getString("Firstname"));
				System.out.print("\tEmail" + rs.getString("Email"));
				System.out.print("\tContact: " + rs.getInt("Contact_num"));
				System.out.print("\tAddress" + rs.getString("Address"));
				System.out.print("\n");
			}
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void updateCustomer(String id, String email) {
		PreparedStatement updateSql;
		try {
			updateSql = dbConn.prepareStatement("UPDATE customer Set Firstname = ? WHERE id = ?");
			updateSql.setObject(1, email);
			updateSql.setObject(2, id);
			int i=updateSql.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void deleteCustomer(String cId) {
		PreparedStatement deleteSql;
		try {
			deleteSql = dbConn.prepareStatement("DELETE FROM customer WHERE id = ?");
			deleteSql.setObject(1, cId);
			int i = deleteSql.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
