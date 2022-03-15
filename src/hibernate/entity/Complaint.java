package hibernate.entity;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "complaint")
public class Complaint implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Complaint_id")
    private String Complaint_id;

    @Column(name = "Customer_id")
    private String Customer_id;

    @Column(name = "Catergory")
    private String Catergory;

    @Column(name = "Details")
    private String Details;

    @Column(name = "Employee_id")
    private String Employee_id;

    @Column(name = "Status")
    private String Status;

    @Column(name = "date")
    private Date date;

    @Column(name = "Instructions")
    private String Instructions;
    public Complaint() {
    }

    public Complaint(String complaintID, String customerID, String category, String details, String employeeID, String status, java.sql.Date date, String instruction) {
    }

    public String getComplaint_id() {
        return Complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        Complaint_id = complaint_id;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public String getCatergory() {
        return Catergory;
    }

    public void setCatergory(String catergory) {
        Catergory = catergory;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(String employee_id) {
        Employee_id = employee_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "Complaint_id='" + Complaint_id + '\'' +
                ", Customer_id='" + Customer_id + '\'' +
                ", Catergory='" + Catergory + '\'' +
                ", Details='" + Details + '\'' +
                ", Employee_id='" + Employee_id + '\'' +
                ", Status='" + Status + '\'' +
                ", date=" + date +
                ", Instructions='" + Instructions + '\'' +
                '}';
    }
}
