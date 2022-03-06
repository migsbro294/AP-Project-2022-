package jdbc.controllers;

import db.connection.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class ComplaintController {
    private Connection dbConn;
    private static final Logger logger = LogManager.getLogger(ComplaintController.class);
    public ComplaintController() {
        dbConn = DBConnector.getConnection();

    }

    public boolean createComplaint(String complaintID, String customerID, String category, String Details, String employeeID, String Status, Date date, String instructions) {
        int check=0;
        logger.info("Creating Complaint");
        try {
            PreparedStatement preSta = dbConn.prepareStatement("INSERT INTO Complaint VALUES (?,?,?,?,?,?,?,?)");
            preSta.setObject(1, complaintID);
            preSta.setObject(2, customerID);
            preSta.setObject(3, category);
            preSta.setObject(4, Details);
            preSta.setObject(5, employeeID);
            preSta.setObject(6, Status);
            preSta.setObject(7, date);
            preSta.setObject(8, instructions);
            check= preSta.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error creating complaint"+e.getMessage());
            e.printStackTrace();
        }
        if(check==1){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<hibernate.entity.Complaint> selectComplaint(String cId) {
        ArrayList<hibernate.entity.Complaint> complaints = new ArrayList<hibernate.entity.Complaint>();
        logger.info("Selecting Complaint");
        try {
            final String QUERY = "SELECT * FROM complaint WHERE Complaint_id = "+cId;
            Statement stmt = dbConn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()) {
                String complaintID= rs.getString("Complaint_id");
                String customerID= rs.getString("Customer_id");
                String category= rs.getString("Category");
                String details= rs.getString("Details");
                String employeeID= rs.getString("Employee_id");
                String status= rs.getString("Status");
                Date date= rs.getDate("Date");
                String instruction= rs.getString("Instruction");

                complaints.add(new hibernate.entity.Complaint(complaintID,customerID,category,details,employeeID,status,date,instruction));
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Error setting complaint"+e.getMessage());
            e.printStackTrace();
        }
        return complaints;
    }
    public boolean updateComplaint(String complaintID, String customerID, String category, String Details, String employeeID, String Status, Date date, String instructions) {
        PreparedStatement updateSql;
        int check=0;
        logger.info("Update Complaint");
        try {
            updateSql = dbConn.prepareStatement("UPDATE complaint SET Complaint_id=?,Customer_id=?,Category=?, Details=?,Employee_id=?, Status=?, Date=?, Instructions=? where Complaint_id="+complaintID);
            updateSql.setObject(1, complaintID);
            updateSql.setObject(2, customerID);
            updateSql.setObject(3, category);
            updateSql.setObject(4, Details);
            updateSql.setObject(5, employeeID);
            updateSql.setObject(6, Status);
            updateSql.setObject(7, date);
            updateSql.setObject(8, instructions);
            check= updateSql.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating complaint"+e.getMessage());
            e.printStackTrace();
        }
        if(check==1){
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteComplaint(String aNum) {
        PreparedStatement deleteSql;
        int check=0;
        logger.info("Delete Complaint");
        try {
            deleteSql = dbConn.prepareStatement("DELETE FROM complaint WHERE Complaint_id ="+aNum);
            check= deleteSql.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting complaint"+e.getMessage());
            e.printStackTrace();
        }
        if(check==1){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<hibernate.entity.Complaint> readALLComplaint() {
        ArrayList<hibernate.entity.Complaint> complaints = new ArrayList<hibernate.entity.Complaint>();
        logger.info("ReadALL Complaint");
        try {
            final String QUERY = "SELECT * FROM complaint";
            Statement stmt = dbConn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()) {
                String complaintID= rs.getString("Complaint_id");
                String customerID= rs.getString("Customer_id");
                String category= rs.getString("Category");
                String details= rs.getString("Details");
                String employeeID= rs.getString("Employee_id");
                String status= rs.getString("Status");
                Date date= rs.getDate("Date");
                String instruction= rs.getString("Instruction");

                complaints.add(new hibernate.entity.Complaint(complaintID,customerID,category,details,employeeID,status,date,instruction));

            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Error reading complaint"+e.getMessage());
            e.printStackTrace();
        }
        return complaints;
    }

}
