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
import jdbc.controllers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Handler extends Thread{
    private static final Logger logger = LogManager.getLogger(Handler.class);

    private final Socket socket;
    private   ObjectOutputStream outputStream;
    private  ObjectInputStream inputStream;

    CustomerController customerController = new CustomerController();
    EmployeeController employeeController =new EmployeeController();
    ComplaintController complaintController=new ComplaintController();
    AccountController accountController = new AccountController();
    CustomerDao customerDao =new CustomerDao();
    EmployeeDao employeeDao = new EmployeeDao();
    ComplaintDao complaintDao = new ComplaintDao();
    AccountDao accountDao = new AccountDao();
    CustomerPassword customerPassword = new CustomerPassword();
    EmployeePassword employeePassword = new EmployeePassword();


    public Handler(Socket socket) throws IOException {
        this.socket = socket;
        logger.info("configuring streams in handler ");
        try {
            this.outputStream=new ObjectOutputStream(socket.getOutputStream());
            this.inputStream=new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            logger.error("IOException: Error configuring streams in handler: "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            logger.info("Carrying client request");
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
                if(options==Options.READ_ALL_COMPLAINT){
                    List<Complaint> read = complaintController.readALLComplaint();
                    outputStream.writeObject(read);
                    outputStream.flush();
                }




                //both hibernate and JDBC used to get
                if(options==Options.GET_EMPLOYEE){
                    String employee_id = (String) inputStream.readObject();
                    Employee get = employeeDao.getEmployee(employee_id);
                    outputStream.writeObject(get);
                    outputStream.flush();
                }

                if(options==Options.GET_COMPLAINT){
                    String complaint_id = (String) inputStream.readObject();
                    List get = complaintController.getComplaint(complaint_id);
                    outputStream.writeObject(get);
                    outputStream.flush();
                }

                if(options==Options.GET_CUSTOMER){
                    String customer_ID = (String) inputStream.readObject();
                    Customer get = customerDao.getCustomer(customer_ID);
                    outputStream.writeObject(get);
                    outputStream.flush();
                }

                if(options==Options.GET_ACCOUNT){
                    String customer_ID = (String) inputStream.readObject();
                    ArrayList<Account> account = accountController.getAccounts(customer_ID);
                    outputStream.writeObject(account);
                    outputStream.flush();
                }



                if(options == Options.CUSTOMER_LOGIN) {
                    String id = (String) inputStream.readObject();
                    String password = (String) inputStream.readObject();
                    Boolean isValid = customerPassword.validate(id,password);
                    outputStream.writeObject(isValid);
                    outputStream.flush();
                }
                if(options == Options.CREATE_CUST_PASSWORD) {
                    String id = (String) inputStream.readObject();
                    String password = (String) inputStream.readObject();
                    customerPassword.createPassword(id,password);
                    outputStream.flush();
                }

                if(options == Options.EMPLOYEE_LOGIN) {
                    String id = (String) inputStream.readObject();
                    String password = (String) inputStream.readObject();
                    Boolean isValid = employeePassword.validate(id,password);
                    outputStream.writeObject(isValid);
                    outputStream.flush();
                }

                if(options == Options.CREATE_EMPL_PASSWORD) {
                    String id = (String) inputStream.readObject();
                    String password = (String) inputStream.readObject();
                    employeePassword.createPassword(id,password);
                    outputStream.flush();
                }
            }
        }catch (EOFException e) {
            logger.warn("EOFException : error performing client request on database "+ e.getMessage());
        }catch (Exception ex){
            logger.error("Exception  Error:" + socket);
            System.out.println("Error:" + socket);
        }finally {
            logger.info("Closing socket");
            try {
                outputStream.close();
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                logger.error("IOException: Error closing socket: "+e.getMessage());
                e.printStackTrace();
            }
            logger.info("Socket is closed: " + socket);
            System.out.println("Closed: " + socket);
        }
    }
}
