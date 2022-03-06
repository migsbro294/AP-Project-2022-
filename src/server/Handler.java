package server;

import client.Options;
import hibernate.dao.AccountDao;
import hibernate.dao.ComplaintDao;
import hibernate.dao.CustomerDao;
import hibernate.dao.EmployeeDao;
import hibernate.entity.Account;
import hibernate.entity.Complaint;
import hibernate.entity.Customer;
import hibernate.entity.Employee;
import jdbc.controllers.AccountController;
import jdbc.controllers.ComplaintController;
import jdbc.controllers.CustomerController;
import jdbc.controllers.EmployeeController;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Handler extends Thread{

    private final Socket socket;
    private   ObjectOutputStream outputStream;
    private  ObjectInputStream inputStream;
    CustomerController customerController;
    EmployeeController employeeController;
    ComplaintController complaintController;
    AccountController accountController;
    CustomerDao customerDao;
    EmployeeDao employeeDao;
    ComplaintDao complaintDao;
    AccountDao accountDao;

    public Handler(Socket socket) throws IOException {
        this.socket = socket;
        try {
            this.outputStream=new ObjectOutputStream(socket.getOutputStream());
            this.inputStream=new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("Error configuring streams in client handler");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            while(true){
                Options options = (Options) inputStream.readObject();

    //JDBC used to created
                if(options== Options.CREATE_CUSTOMER) {
                    String id = (String) inputStream.readObject();
                    String lastname = (String) inputStream.readObject();
                    String firstname = (String) inputStream.readObject();
                    String email = (String) inputStream.readObject();
                    int contact_num = (int) inputStream.readObject();
                    String address = (String) inputStream.readObject();
                    boolean created= customerController.createCustomer(id,lastname,firstname,email,contact_num,address);
                    outputStream.writeObject(created);
                    outputStream.flush();
                }

                if(options==Options.CREATE_EMPLOYEE){
                    String id = (String) inputStream.readObject();
                    String firstname = (String) inputStream.readObject();
                    String lastname = (String) inputStream.readObject();
                    int contact_num = (int) inputStream.readObject();
                    String role = (String) inputStream.readObject();
                    String email = (String) inputStream.readObject();
                    boolean created= employeeController.createEmployee(id,firstname,lastname,contact_num,role,email);
                    outputStream.writeObject(created);
                    outputStream.flush();
                }

                if(options==Options.CREATE_COMPLAINT){
                    String complaintID = (String) inputStream.readObject();
                    String customerID = (String) inputStream.readObject();
                    String category = (String) inputStream.readObject();
                    String details = (String) inputStream.readObject();
                    String employeeID = (String) inputStream.readObject();
                    String status = (String) inputStream.readObject();
                    Date date = (Date) inputStream.readObject();
                    String instruction = (String) inputStream.readObject();
                    boolean created=complaintController.createComplaint( complaintID,customerID,category,details,employeeID,status, java.sql.Date.valueOf(date.toString()),instruction);
                    outputStream.writeObject(created);
                    outputStream.flush();
                }
                if(options==Options.CREATE_ACCOUNT){
                    String accountNum = (String) inputStream.readObject();
                    String customerID = (String) inputStream.readObject();
                    String status = (String) inputStream.readObject();
                    Date paymentDate = (Date) inputStream.readObject();
                    double balance = (double) inputStream.readObject();
                    double amount = (double) inputStream.readObject();
                    boolean created=accountController.createAccount( accountNum,customerID,status, java.sql.Date.valueOf(paymentDate.toString()),balance,amount);
                    outputStream.writeObject(created);
                    outputStream.flush();
                }

                //used hibernate to update


                //both hibernate and JDBC used to delete




                //both hibernate and JDBC used to READ



                //both hibernate and JDBC used to get

            }
        }catch (EOFException e) {
            System.out.println("EOFException : error performing client request on database "+ e.getMessage());
        }catch (Exception ex){
            System.out.println("Error:" + socket);
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Closed: " + socket);
        }
    }
}
