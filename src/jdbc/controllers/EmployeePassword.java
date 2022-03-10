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

public class EmployeePassword {
    private  Statement statement;
    private  ResultSet result;
    private  int check;
    private  Connection connection;

    public EmployeePassword(){
     connection = DBConnector.getConnection();
    }


    // Create Password
    public  void createPassword(String employeeId, String password) {
        String salt = getSalt();
        password = encryptPassword(password,salt);
        String insertSql = "INSERT INTO mstarcable.employee_password VALUES ('" + employeeId + "', '" + salt +"','"+ password +"')";
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
    public  Boolean validate(String employeeID, String password) {

        String saltFromDatabase= "";
        String employeePassword = "";
        String hashFromDatabase = "";

        saltFromDatabase = readSalt(employeeID);
        employeePassword = encryptPassword(password,saltFromDatabase);
        hashFromDatabase = readHash(employeeID);

        if(hashFromDatabase.equals(employeePassword)) {
            System.out.println("valid");
            return true;
        }else {
            return false;
        }
    }

    private  String readSalt(String employeeId) {
        String selectSql = "SELECT * FROM mstarcable.employee_password WHERE Employee_id = '" + employeeId + "'";
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
    private  String readHash(String employeeId) {
        String selectSql = "SELECT * FROM mstarcable.employee_password WHERE Employee_id = '" + employeeId + "'";
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
