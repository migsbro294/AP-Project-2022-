package jdbc.controllers;

import db.connection.DBConnector;
import hibernate.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class AccountController {
	private Connection dbConn;
	private static final Logger logger = LogManager.getLogger(AccountController.class);
	public AccountController() {
		dbConn = DBConnector.getConnection();
		
	}
	
	public boolean createAccount(String account_num, String customerID, String status, Date paymentDate, double balance, double amount) {
		int check=0;
		logger.info("Creating Account");
		try {
			PreparedStatement preSta = dbConn.prepareStatement("INSERT INTO ACCOUNT VALUES (?,?,?,?,?,?)");
			preSta.setObject(1, account_num);
			preSta.setObject(2, customerID);
			preSta.setObject(3, status);
			preSta.setObject(4, paymentDate);
			preSta.setObject(5, balance);
			preSta.setObject(6, amount);
			check= preSta.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error creating account"+e.getMessage());
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
	}
	public ArrayList getAccounts(String id){
		ArrayList<Account> account = new ArrayList<Account>();
		logger.info("Getting Account");
		String sql = "SELECT * FROM account WHERE Customer_id = "+id;
		try {
			Statement statement=dbConn.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()){
				Account account2= new Account();
				account2.setAccount_num(resultSet.getInt(1));
				account2.setCustomer_id(resultSet.getString(2));
				account2.setStatus(resultSet.getString(3));
				account2.setPayment_date(resultSet.getDate(4));
				account2.setBalance(resultSet.getDouble(5));
				account2.setAmount(resultSet.getDouble(6));
				account.add(account2);
			}
		} catch (SQLException e) {
			logger.error("Error setting account"+e.getMessage());
			e.printStackTrace();
		}
		return  account;
	}

	public boolean updateAccount(String account_num, String customerID, String status, Date paymentDate, double balance, double amount) {
		PreparedStatement updateSql;
		int check=0;
		logger.info("Update Account");
		try {
			updateSql = dbConn.prepareStatement("UPDATE account SET Account_num=?,Customer_id=?,Status=?, Payment_date=?,Balance=?, Amount=? where Account_num="+account_num);
			updateSql.setObject(1, account_num);
			updateSql.setObject(2, customerID);
			updateSql.setObject(3, status);
			updateSql.setObject(4, paymentDate);
			updateSql.setObject(5, balance);
			updateSql.setObject(6, amount);
			check= updateSql.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error updating account"+e.getMessage());
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
	}
	public boolean deleteAccount(String id) {
		PreparedStatement deleteSql;
		int check=0;
		logger.info("Delete Account");
		try {
			deleteSql = dbConn.prepareStatement("DELETE FROM account WHERE Customer_id ="+id);
			check= deleteSql.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error deleting account"+e.getMessage());
			e.printStackTrace();
		}
		if(check==1){
			return true;
		}else{
			return false;
		}
	}

	public ArrayList<hibernate.entity.Account> readALLAccount() {
		ArrayList<hibernate.entity.Account> accounts = new ArrayList<hibernate.entity.Account>();
		logger.info("ReadALL Account");
		try {
			final String QUERY = "SELECT * FROM account";
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while(rs.next()) {
				int accountNum= rs.getInt("Account_num");
				String customerID= rs.getString("Customer_id");
				String status= rs.getString("Status");
				Date paymentDate= rs.getDate("Payment_date");
				double balance= rs.getDouble("Balance");
				double amount= rs.getDouble("Amount");
				accounts.add(new hibernate.entity.Account(accountNum,customerID,status,paymentDate,balance,amount));

			}
			rs.close();
		} catch (SQLException e) {
			logger.error("Error reading account"+e.getMessage());
			e.printStackTrace();
		}
		return accounts;
	}

}
