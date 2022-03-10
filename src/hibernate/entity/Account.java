package hibernate.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "Account_num")
    private int Account_num;

    @Column(name = "Customer_id")
    private String Customer_id;

    @Column(name = "Status")
    private String Status;

    @Column(name = "Payment_date")
    private Date Payment_date;

    @Column(name = "Balance")
    private double Balance;

    @Column(name = "Amount")
    private double Amount;
    public Account() {
    }
    public Account(int accountNum, String customerID, String status, java.sql.Date paymentDate, double balance, double amount) {
    }


    public int getAccount_num() {
        return Account_num;
    }

    public void setAccount_num(int account_num) {
        Account_num = account_num;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getPayment_date() {
        return Payment_date;
    }

    public void setPayment_date(Date payment_date) {
        Payment_date = payment_date;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
