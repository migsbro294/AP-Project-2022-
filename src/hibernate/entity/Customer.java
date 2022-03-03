package hibernate.entity;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table (name = "customer")
public class Customer implements Serializable {

    // private static final long serialVersionUID = 84344L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Customer_Id")
    private String Customer_Id;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Contact_num")
    private int contactNumber;

    @Column(name = "Address")
    private String address;




    public String getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(String Customer_Id) {
        this.Customer_Id = Customer_Id;
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

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "Customer_Id='" + Customer_Id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                ", address='" + address +
                '}';
    }
}
