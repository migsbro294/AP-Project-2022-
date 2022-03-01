package hibernate.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "custID")
    private String custID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "contactNumber")
    private Double contactNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "date")
    private Date date;


    public String getCustID() {
        return custID;
    }

    public void setId(String custID) {
        this.custID = custID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Double contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID='" + custID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", date=" + date +
                '}';
    }
}
