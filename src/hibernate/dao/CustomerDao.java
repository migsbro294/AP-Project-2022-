package hibernate.dao;

import hibernate.entity.Customer;
import hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.io.Serializable;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerDao {

    private static final Logger logger = LogManager.getLogger(CustomerDao.class);

    public void createCustomer(String Customer_Id,String Lastname, String Firstname, String Email, int Contact_num, String Address  ) {
        Transaction transaction = null;
        try  {
            Customer customer = new Customer();
            customer.setCustomer_Id(Customer_Id);
            customer.setLastname(Lastname);
            customer.setFirstName(Firstname);
            customer.setEmail(Email);
            customer.setContactNumber(Contact_num);
            customer.setAddress(Address);

            //Create session factory object
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            transaction=session.beginTransaction();;

            session.save(customer);
            System.out.println("Inserted Successfully");
            transaction.commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
        	System.err.println("Error creating "+e.getMessage());
			logger.error("Error creating employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Customer> readCustomer(){
        Transaction transaction = null;
        List<Customer> customerList = new ArrayList<>();
    	try {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        transaction=session.beginTransaction();
        customerList = (List<Customer>) session.createQuery ("FROM Customer").getResultList();

//        for(Customer customer : customerList) {
//        }
//
         transaction.commit();
        session.close();
    	} catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error("Error reading employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return customerList;

    }



    public Customer getCustomer(String Customer_Id) {

        Transaction transaction = null;
        Customer customer = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get an customer object
            String hql = " FROM Customer C WHERE C.Customer_Id = :Customer_Id";
            Query query = session.createQuery(hql);
            query.setParameter("Customer_Id", Customer_Id);
            List results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                customer = (Customer) results.get(0);
            }
            // commit transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error("Error getting employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return customer;
    }

    public boolean updateCustomer(String Customer_Id, String Lastname,String Firstname, String Email,int Contact_num, String Address){
        Transaction transaction = null; int check=0;
        try {
	        //Create session factory object
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        //getting session object from session factory
	        Session session = sessionFactory.openSession();
	        //getting transaction object from session object
            transaction=session.beginTransaction();
	
	        Customer customer = (Customer) session.get(Customer.class, Customer_Id);
	        customer.setLastname(Lastname);
	        customer.setFirstName(Firstname);
	        customer.setContactNumber(Contact_num);
	        customer.setAddress(Address);
	        customer.setEmail(Email);
	        session.update(customer);
            check=1;
            transaction.commit();
            session.close();
    	} catch (Exception e) {
			System.err.println("Error updating "+e.getMessage());
			logger.error("Error updating employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(check==1){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteCustomer(String Customer_Id){
        Transaction transaction = null;
        int check=0;
        try {
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session objec
        transaction=session.beginTransaction();
        Customer customer = (Customer) session.load(Customer.class, Customer_Id);
        session.delete(customer);
        check=1;
        transaction.commit();
        session.close();
    	} catch (Exception e) {
        	System.err.println("Error Deleting "+e.getMessage());
			logger.error("Error Deleting employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(check==1){
            return true;
        }else{
            return false;
        }
    }



}
