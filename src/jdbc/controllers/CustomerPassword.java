package jdbc.controllers;

import db.connection.DBConnector;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerPassword {
    private  Statement statement;
    private  ResultSet result;
    private  int check;
    private  Connection connection;

    public CustomerPassword(){
     connection = DBConnector.getConnection();
    }


    // Create Password
    public  void createPassword(String id, String password) {
        String salt = getSalt();
        password = encryptPassword(password,salt);
        String insertSql = "INSERT INTO mstarcable.customer_password VALUES ('" + id + "', '" + salt +"','"+ password +"')";
        try {
            statement = connection.createStatement();
            check = statement.executeUpdate(insertSql);
            if (check == 1) {
                System.out.println("password created");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception thrown: create " + e.getMessage());
        }
    }

    // Add salt
    private  String getSalt(){
        // Always use a SecureRandom generator
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
        // Create array for salt
        byte[] salt = new byte[512];
        // Get a random salt
        secureRandom.nextBytes(salt);
        // return salt
        return salt.toString();
    }

    // Encrypt password
    private  String encryptPassword(String passwordToHash,String salt) {
        String generatedPassword = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt.getBytes());
            byte[] bytes = messageDigest.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                //convert to HEX
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch (NoSuchAlgorithmException  e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }


    // Validate password
    public  Boolean validate(String customerID, String password) {

        boolean vaild=false;
        String saltFromDatabase= "";
        String customerPassword = "";
        String hashFromDatabase = "";

        saltFromDatabase = readSalt(customerID);
        customerPassword = encryptPassword(password,saltFromDatabase);
        hashFromDatabase = readHash(customerID);

        if(hashFromDatabase.equals(customerPassword)) {
            System.out.println("valid");
            vaild = true;
        }
        return vaild;
    }

    private  String readSalt(String customerID) {
        String selectSql = "SELECT * FROM mstarcable.customer_password WHERE Customer_Id = '" + customerID + "'";
        String salt = "";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(selectSql);
            result.next();
            salt = result.getString("Salt");
        }
        catch(SQLException e)
        {
            System.err.println("SQL Exception: " +e.getMessage());
        }
        return salt;
    }

    // Read Password
    private  String readHash(String customerID) {
        String selectSql = "SELECT * FROM mstarcable.customer_password WHERE Customer_Id = '" + customerID + "'";
        String password = "";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(selectSql);
            result.next();
            password = result.getString("hash");

        }
        catch(SQLException e)
        {
            System.err.println("SQL Exception: " +e.getMessage());
        }
        return password;
    }

}
