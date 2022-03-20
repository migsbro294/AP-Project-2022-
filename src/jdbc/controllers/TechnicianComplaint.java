package jdbc.controllers;

import db.connection.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TechnicianComplaint implements Serializable {

    private int id;

    private String Employee_id;

    private String Complaint_id;

    public TechnicianComplaint(int id, String employee_id, String complaint_id) {
        this.id = id;
        this.Employee_id = employee_id;
        this.Complaint_id = complaint_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(String employee_id) {
        Employee_id = employee_id;
    }

    public String getComplaint_id() {
        return Complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        Complaint_id = complaint_id;
    }

    private Connection dbConn;
    private static final Logger logger = LogManager.getLogger(TechnicianComplaint.class);
    public TechnicianComplaint() {
        dbConn = DBConnector.getConnection();

    }

    public boolean assign(String employeeId,String complaintId) {
        int check=0;
        int id = (new Random()).nextInt(700000) + 200000;
        logger.info("assigning complaint to technician");
        try {
            PreparedStatement preSta = dbConn.prepareStatement("INSERT INTO assigned_tech VALUES (?,?,?)");
            preSta.setObject(1, id);
            preSta.setObject(2, employeeId);
            preSta.setObject(3, complaintId);
            check= preSta.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error assigning complaint to technician "+e.getMessage());
            e.printStackTrace();
        }
        if(check==1){
            return true;
        }else{
            return false;
        }
    }

    public List getAssignComplaint(String id){
        List assign = new ArrayList();
        logger.info("getting assigning complaint to technician");
        String sql = "SELECT * FROM assigned_tech WHERE Employee_id = "+id;
        try {
            Statement statement=dbConn.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                assign.add(resultSet.getString(1));
                assign.add(resultSet.getString(2));
                assign.add(resultSet.getString(3));
            }
        } catch (SQLException e) {
            logger.error("Error getting complaint"+e.getMessage());
            e.printStackTrace();
        }
        return  assign;
    }


    public ArrayList<TechnicianComplaint> readALL() {
        ArrayList<TechnicianComplaint> technicianComplaintArrayList = new ArrayList<TechnicianComplaint>();
        logger.info("ReadALL");
        try {
            final String QUERY = "SELECT * FROM assigned_tech";
            Statement stmt = dbConn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()) {
                int id= rs.getInt("id");
                String employeeid= rs.getString("Employee_id");
                String complaintid= rs.getString("Complaint_id");
                technicianComplaintArrayList.add(new TechnicianComplaint(id,employeeid,complaintid));
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Error reading employee"+e.getMessage());
            e.printStackTrace();
        }
        return technicianComplaintArrayList;
    }
}
