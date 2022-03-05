package jdbc.controllers;

import java.sql.*;
import java.util.ArrayList;

import db.connection.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CustomerController {
	private Connection dbConn;
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	public CustomerController() {
		dbConn = DBConnector.getConnection();
		
	}
	
	public boolean createCustomer(String customer_ID, String lastname, String firstname, String email, int contact_num, String address) {
		int check=0;
		logger.info("Creating Customer");
		try {
			PreparedStatement preSta = dbConn.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?)");
			preSta.setObject(1, customer_ID);
			preSta.setObject(2, lastname);
			preSta.setObject(3, firstname);
			preSta.setObject(4, email);
			preSta.setObject(5, contact_num);
			preSta.setObject(6, address);
			 check = preSta.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error creating customer"+e.getMessage());
			e.printStackTrace();
		}

		if(check==1){
			return true;
		}else{
			return false;
		}
	}

	public ArrayList<hibernate.entity.Customer> selectCustomer(String Customer_ID) {
		ArrayList<hibernate.entity.Customer> customers = new ArrayList<hibernate.entity.Customer>();
		logger.info("Selecting Customer");
		try {
			final String QUERY = "SELECT * FROM customer WHERE Customer_Id = "+Customer_ID;
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while(rs.next()) {
				String id= rs.getString("Customer_Id");
				String lastname=rs.getString("Lastname");
				String Firstname= rs.getString("Firstname");
				String Email=rs.getString("Email");
				int Contact_num= rs.getInt("Contact_num");
				String Address=rs.getString("Address");

				customers.add(new hibernate.entity.Customer(id,lastname,Firstname,Email,Contact_num,Address));
			}
			rs.close();
		} catch (SQLException e) {
			logger.error("Error selecting customer"+e.getMessage());
			e.printStackTrace();
		}
		return customers;
	}

	public boolean updateCustomer(String id, String Lastname, String Firstname, String Email, int Contact_num, String Address) {
		PreparedStatement updateSql;
		int check =0;
		logger.info("Updating Customer");
		try {
			updateSql = dbConn.prepareStatement("UPDATE customer SET Customer_id=?,Lastname=?,Firstname=?, Email=?,Contact_num=?, Address=? where Customer_id="+id);
			updateSql.setObject(1, id);
			updateSql.setObject(2, Lastname);
			updateSql.setObject(3, Firstname);
			updateSql.setObject(4, Email);
			updateSql.setObject(5, Contact_num);
			updateSql.setObject(6, Address);
			check=updateSql.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error updating customer"+e.getMessage());
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
		
	}
	public boolean deleteCustomer(String cId) {
		PreparedStatement deleteSql;
		int check=0;
		logger.info("Deleting Customer");
		try {
			deleteSql = dbConn.prepareStatement("DELETE FROM customer WHERE Customer_id ="+cId);
			check =deleteSql.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error deleting  customer"+e.getMessage());
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
		
	}


	public ArrayList<hibernate.entity.Customer> readALLCustomer() {
		ArrayList<hibernate.entity.Customer> customers = new ArrayList<hibernate.entity.Customer>();
		logger.info("Reading All Customer");
		try {
			final String QUERY = "SELECT * FROM customer ";
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while(rs.next()) {
				String id= rs.getString("Customer_Id");
				String lastname=rs.getString("Lastname");
				String Firstname= rs.getString("Firstname");
				String Email=rs.getString("Email");
				int Contact_num= rs.getInt("Contact_num");
				String Address=rs.getString("Address");
				customers.add(new hibernate.entity.Customer(id,lastname,Firstname,Email,Contact_num,Address));
			}
			rs.close();
		} catch (SQLException e) {
			logger.error("Error reading all customer"+e.getMessage());
			e.printStackTrace();
		}
		return customers;
	}
}
