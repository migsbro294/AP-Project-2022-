package hibernate.dao;

import hibernate.entity.Account;
import hibernate.utility.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class AccountDao {
	private static final Logger logger = LogManager.getLogger(AccountDao.class);
    public void createAccount(int Account_num,String Customer_id,String Status,Date  Payment_date, double Balance, double Amount  ) {
        Transaction transaction = null;
        try  {
            Account account = new Account();
            account.setAccount_num(Account_num);
            account.setCustomer_id(Customer_id);
            account.setStatus(Status);
            account.setPayment_date(Payment_date);
            account.setBalance(Balance);
            account.setAmount(Amount);

            //Create session factory object
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();

            session.save(account);
            System.out.println("Inserted Successfully");
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Account> readAccount(){
        List<Account> accountList = new ArrayList<>();
        try  {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        accountList = (List<Account>) session.createQuery ("FROM Account").getResultList();
	
	//        for(Account account : accountList) {
	//        }
	        session.getTransaction().commit();
	        sessionFactory.close();
        } catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}
        return accountList;

    }



    public Account getAccount(String Customer_id) {

        Transaction transaction = null;
        Account account = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get an account object
            String hql = " FROM Account A WHERE A.Customer_id = :Customer_id";
            Query query = session.createQuery(hql);
            query.setParameter("Customer_id", Customer_id);
            List results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                account = (Account) results.get(0);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return account;
    }

    public boolean updateAccount(int Account_num,String Customer_id,String Status,Date  Payment_date, double Balance, double Amount  ){
    	int check=0;
        try {
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();

        Account account = (Account) session.get(Account.class, Account_num);
        account.setCustomer_id(Customer_id);
        account.setStatus(Status);
        account.setPayment_date(Payment_date);
        account.setBalance(Balance);
        account.setAmount(Amount);
        check=1;
        session.getTransaction().commit();
        sessionFactory.close();
    	} catch (Exception e) {
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}
        if(check==1){
            return true;
        }else{
            return false;
        }
    }

    public void deleteComplaint(int  Account_num){
    	try {
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        Account account = (Account) session.load(Account.class, Account_num);
        session.delete(account);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
        sessionFactory.close();
    	} catch (Exception e) {
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}
    }

}
