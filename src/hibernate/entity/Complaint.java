package hibernate.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "complaintNumber")
    private String complaintNumber;

    @Column(name = "categorie")
    private String categorie;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "response")
    private String response;

    @Column(name = "date")
    private Date date;

    @Column(name = "custID")
    private String custID;

    @Column(name = "staffID")
    private String staffID;


    public String getComplaintNumber() {
        return complaintNumber;
    }

    public void setComplaintNumber(String complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintNumber='" + complaintNumber + '\'' +
                ", categorie='" + categorie + '\'' +
                ", complaint='" + complaint + '\'' +
                ", response='" + response + '\'' +
                ", date=" + date +
                ", custID='" + custID + '\'' +
                ", staffID='" + staffID + '\'' +
                '}';
    }
}
