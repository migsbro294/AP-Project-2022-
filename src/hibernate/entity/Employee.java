package hibernate.entity;



import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Employee_id")
    private String Employee_id;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name="Contact_num")
    private int Contact_num;

    @Column(name = "Role")
    private String role;

    @Column(name = "Email")
    private String email;

    public Employee() {
    }

    public Employee( String firstName, String lastName, int contact_num, String role, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        Contact_num = contact_num;
        this.role = role;
        this.email = email;
    }

    public String getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(String employee_id) {
        Employee_id = employee_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getContact_num() {
        return Contact_num;
    }

    public void setContact_num(int contact_num) {
        Contact_num = contact_num;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee_id='" + Employee_id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Contact_num=" + Contact_num +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
