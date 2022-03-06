package hibernate.dao;

import hibernate.entity.Employee;
import hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EmployeeDao {

    private static final Logger logger = LogManager.getLogger(EmployeeDao.class);


    public void createEmployee(String Employee_id,String Firstname, String Lastname,int Contact_num,String Role,String Email ) {
        Transaction transaction = null;
        try  {
            Employee employee = new Employee();
            employee.setEmployee_id(Employee_id);
            employee.setFirstName(Firstname);
            employee.setLastName(Lastname);
            employee.setContact_num(Contact_num);
            employee.setRole(Role);
            employee.setEmail(Email);
            //Create session factory object
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            //getting session object from session factory
            Session session = sessionFactory.openSession();
            //getting transaction object from session object
            session.beginTransaction();
            session.save(employee);
            System.out.println("Inserted Successfully");
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error("Error creating employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Employee> readEmployee(){
        Transaction transaction = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        employeeList= (List<Employee>) session.createQuery ("FROM Employee").getResultList();
	
	//       for(Employee employee : employeeList) {
	//           System.out.println("id "+employee.getEmployee_id()+"  fname  "+employee.getFirstName()+
	//                   "  lname  "+employee.getLastName()+"  phone  "+employee.getContact_num()+"  role  "+
	//                   employee.getRole()+"   email  "+employee.getEmail());
	//        }
	
	        session.getTransaction().commit();
	        session.close();
        } catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error("Error reading employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employeeList;

    }



    public Employee getEmployee(String Employee_id) {

        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get an employee object
            String hql = " FROM Employee E WHERE E.Employee_id = :Employee_id";
            Query query = session.createQuery(hql);
            query.setParameter("Employee_id", Employee_id);
            List results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                employee = (Employee) results.get(0);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
			System.err.println("ERROR "+e.getMessage());
			logger.error("Error getting employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }

    public void updateEmployee(String Employee_id,String Firstname, String Lastname,int Contact_num,String Role,String Email ){
        Transaction transaction = null;
        try {
	        //Create session factory object
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        //getting session object from session factory
	        Session session = sessionFactory.openSession();
	        //getting transaction object from session object
	        session.beginTransaction();
	
	        Employee employee = (Employee) session.get(Employee.class, Employee_id);
	        employee.setFirstName(Firstname);
	        employee.setLastName(Lastname);
	        employee.setContact_num(Contact_num);
	        employee.setRole(Role);
	        employee.setEmail(Email);
	        session.update(employee);
	        System.out.println("Updated Successfully");
	        session.getTransaction().commit();
	        sessionFactory.close();
    	} catch (Exception e) {
			System.err.println("Error updating"+e.getMessage());
			logger.error("Error updating employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEmployee(String Employee_id){
        Transaction transaction = null;
    	try {
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        Employee employee = (Employee) session.load(Employee.class, Employee_id);
        session.delete(employee);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
        session.close();
    	} catch (Exception e) {
			System.err.println("Error Deleting"+e.getMessage());
			logger.error("Error Deleting employee Record "+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
