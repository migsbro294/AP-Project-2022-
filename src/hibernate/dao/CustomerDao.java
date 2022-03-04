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

public class CustomerDao {



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
            session.beginTransaction();

            session.save(customer);
            System.out.println("Inserted Successfully");
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (SQLDataException e) {
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Customer> readCustomer(){
    	try {
        List<Customer> customerList = new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        customerList = (List<Customer>) session.createQuery ("FROM Customer").getResultList();

//        for(Customer customer : customerList) {
//        }

        session.getTransaction().commit();
        sessionFactory.close();
    	}
    	catch (SQLDataException e) {
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
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
        } catch (SQLDataException e) {
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return customer;
    }

    public void updateCustomer(String Customer_Id, String Lastname,String Firstname, String Email,int Contact_num, String Address){
    	try {
	        //Create session factory object
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        //getting session object from session factory
	        Session session = sessionFactory.openSession();
	        //getting transaction object from session object
	        session.beginTransaction();
	
	        Customer customer = (Customer) session.get(Customer.class, Customer_Id);
	        customer.setLastname(Lastname);
	        customer.setFirstName(Firstname);
	        customer.setContactNumber(Contact_num);
	        customer.setAddress(Address);
	        customer.setEmail(Email);
	        session.update(customer);
	        System.out.println("Updated Successfully");
	        session.getTransaction().commit();
	        sessionFactory.close();
    	}
    	catch (SQLDataException e) {
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteCustomer(String Customer_Id){
    	try {
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        Customer customer = (Customer) session.load(Customer.class, Customer_Id);
        session.delete(customer);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
        sessionFactory.close();
    	}
    	catch (SQLDataException e) {
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }



}
