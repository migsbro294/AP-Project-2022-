package hibernate.dao;

import hibernate.entity.Complaint;
import hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintDao {

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
            session.beginTransaction();

            session.save(complaint);
            System.out.println("Inserted Successfully");
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Complaint> readComplaint(){
        List<Complaint> complaintList = new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        complaintList = (List<Complaint>) session.createQuery ("FROM Complaint").getResultList();

//        for(Complaint complaint : complaintList) {
//        }
        session.getTransaction().commit();
        sessionFactory.close();
        return complaintList;

    }



    public Complaint getComplaint(String Complaint_id) {

        Transaction transaction = null;
        Complaint complaint = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

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
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return complaint;
    }

    public void updateComplaint(String Complaint_id, String Customer_id, String Catergory, String Details, String Employee_id, String Status, Date date,String Instructions ){

        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();

        Complaint complaint1 = (Complaint) session.get(Complaint.class, Complaint_id);
        complaint1.setCustomer_id(Customer_id);
        complaint1.setCatergory(Catergory);
        complaint1.setDetails(Details);
        complaint1.setEmployee_id(Employee_id);
        complaint1.setStatus(Status);
        complaint1.setDate(date);
        complaint1.setInstructions(Instructions);
        session.update(complaint1);
        System.out.println("Updated Successfully");
        session.getTransaction().commit();
        sessionFactory.close();
    }

    public void deleteComplaint(String  Complaint_id){

        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        Complaint complaint = (Complaint) session.load(Complaint.class, Complaint_id);
        session.delete(complaint);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
        sessionFactory.close();
    }

}
