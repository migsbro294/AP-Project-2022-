package jdbc.controllers;

import java.sql.*;
import java.util.ArrayList;

import db.connection.*;

public class EmployeeController {
	private Connection dbConn;
	
	public EmployeeController() {
		dbConn = DBConnector.getConnection();
		
	}
	
	public boolean createEmployee(String employee_id, String firstname, String lastname, int contact_num, String role, String email) {
		int check=0;
		try {
			PreparedStatement preSta = dbConn.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?)");
			preSta.setObject(1, employee_id);
			preSta.setObject(2, firstname);
			preSta.setObject(3, lastname);
			preSta.setObject(4, contact_num);
			preSta.setObject(5, role);
			preSta.setObject(6, email);
			check= preSta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
	}
	public ArrayList<hibernate.entity.Employee> selectEmployee(String eId) {
		ArrayList<hibernate.entity.Employee> employees = new ArrayList<hibernate.entity.Employee>();
		try {
			final String QUERY = "SELECT * FROM employee WHERE Employee_id = "+eId;
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while(rs.next()) {
				String id= rs.getString("Employee_id");
				String firstname= rs.getString("Firstname");
				String lastname= rs.getString("Lastname");
				int contact_num= rs.getInt("Contact_num");
				String role= rs.getString("Role");
				String email= rs.getString("Email");
				employees.add(new hibernate.entity.Employee(id,firstname,lastname,contact_num,role,email));
			}
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return employees;
	}
	public boolean updateEmployee(String eId,String firstname, String lastname, int contact_num, String role, String email) {
		PreparedStatement updateSql;
		int check=0;
		try {
			updateSql = dbConn.prepareStatement("UPDATE employee SET Employee_id=?,Firstname=?,Lastname=?, Contact_num=?,Role=?, Email=? where Employee_id="+eId);
			updateSql.setObject(1, email);
			updateSql.setObject(2, firstname);
			updateSql.setObject(3, lastname);
			updateSql.setObject(4, contact_num);
			updateSql.setObject(5, role);
			updateSql.setObject(6, email);
			check=updateSql.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
	}
	public boolean deleteEmployee(String eId) {
		PreparedStatement deleteSql;
		int check=0;
		try {
			deleteSql = dbConn.prepareStatement("DELETE FROM employee WHERE Employee_id ="+eId);
			check= deleteSql.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
	}

	public ArrayList<hibernate.entity.Employee> readALLEmployee() {
		ArrayList<hibernate.entity.Employee> employees = new ArrayList<hibernate.entity.Employee>();
		try {
			final String QUERY = "SELECT * FROM employee";
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while(rs.next()) {
				String id= rs.getString("Employee_id");
				String firstname= rs.getString("Firstname");
				String lastname= rs.getString("Lastname");
				int contact_num= rs.getInt("Contact_num");
				String role= rs.getString("Role");
				String email= rs.getString("Email");
				employees.add(new hibernate.entity.Employee(id,firstname,lastname,contact_num,role,email));
			}
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return employees;
	}

}
