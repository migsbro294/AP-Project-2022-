package hibernate.dao;

import hibernate.entity.Complaint;
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

public class ComplaintDao {
    private static final Logger logger = LogManager.getLogger(ComplaintDao.class);
    public void createComplaint(String Complaint_id, String Customer_id, String Catergory, String Details, String Employee_id, String Status, Date date,String Instructions ) {
        Transaction transaction = null;
        try  {
            Complaint complaint = new Complaint();
            complaint.setComplaint_id(Complaint_id);
            complaint.setCustomer_id(Customer_id);
            complaint.setCatergory(Catergory);
            complaint.setDetails(Details);
            complaint.setEmployee_id(Employee_id);
            complaint.setStatus(Status);
            complaint.setDate(date);
            complaint.setInstructions(Instructions);
            //Create session factory object
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            transaction=session.beginTransaction();

            session.save(complaint);
            System.out.println("Inserted Successfully");
            transaction.commit();
            session.close();
        } catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Complaint> readComplaint(){
        List<Complaint> complaintList = new ArrayList<>();
        Transaction transaction = null;
        try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
            transaction=session.beginTransaction();
	        complaintList = (List<Complaint>) session.createQuery ("FROM Complaint").getResultList();

            transaction.commit();
            session.close();
        } catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return complaintList;

    }



    public Complaint getComplaint(String Complaint_id) {

        Transaction transaction = null;
        Complaint complaint = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            // start a transaction
            transaction=session.beginTransaction();


            // get an complaint object
            String hql = " FROM Complaint C WHERE C.Complaint_id = :Complaint_id";
            Query query = session.createQuery(hql);
            query.setParameter("Complaint_id", Complaint_id);
            List results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                complaint = (Complaint) results.get(0);
            }
            // commit transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        return complaint;
    }

    public boolean updateComplaint(String Complaint_id, String Customer_id, String Catergory, String Details, String Employee_id, String Status, Date date,String Instructions ){
        int check=0;
        Transaction transaction = null;
        try {
	        //Create session factory object
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        //getting session object from session factory
	        Session session = sessionFactory.openSession();
	        //getting transaction object from session object
            transaction=session.beginTransaction();
	
	        Complaint complaint1 = (Complaint) session.get(Complaint.class, Complaint_id);
	        complaint1.setCustomer_id(Customer_id);
	        complaint1.setCatergory(Catergory);
	        complaint1.setDetails(Details);
	        complaint1.setEmployee_id(Employee_id);
	        complaint1.setStatus(Status);
	        complaint1.setDate(date);
	        complaint1.setInstructions(Instructions);
	        session.update(complaint1);
	        check=1;
            transaction.commit();
	        session.close();
		} catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
    		System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}
        if(check==1){
            return true;
        }else{
            return false;
        }
    }

    public void deleteComplaint(String  Complaint_id){
        Transaction transaction = null;
    	try {
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
         transaction=session.beginTransaction();
        Complaint complaint = (Complaint) session.load(Complaint.class, Complaint_id);
        session.delete(complaint);
        System.out.println("Deleted Successfully");
        transaction.commit();
        session.close();
    	} catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        	System.err.println(e.getMessage());
			logger.error(e.getMessage());
		}
    }

}
