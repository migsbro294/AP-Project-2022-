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
        logger.info("Creating Employee");
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
            transaction=session.beginTransaction();
            session.save(employee);
            System.out.println("Inserted Successfully");
            transaction.commit();
            session.close();
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
        logger.info("Reading all Employee");
        try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
            transaction=session.beginTransaction();
	        employeeList= (List<Employee>) session.createQuery ("FROM Employee").getResultList();

            transaction.commit();
	        session.close();
        } catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error("Error reading all employee Record "+e.getMessage());
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
        logger.info("Getting Employee");
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
            session.close();
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

    public boolean updateEmployee(String Employee_id,String Firstname, String Lastname,int Contact_num,String Role,String Email ){
        Transaction transaction = null;int check=0;
        logger.info("Updating Employee");
        try {
	        //Create session factory object
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        //getting session object from session factory
	        Session session = sessionFactory.openSession();
	        //getting transaction object from session object
            transaction=session.beginTransaction();
	
	        Employee employee = (Employee) session.get(Employee.class, Employee_id);
	        employee.setFirstName(Firstname);
	        employee.setLastName(Lastname);
	        employee.setContact_num(Contact_num);
	        employee.setRole(Role);
	        employee.setEmail(Email);
	        session.update(employee);
            check=1;
            transaction.commit();
	        session.close();
    	} catch (Exception e) {
			System.err.println("Error updating"+e.getMessage());
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

    public boolean deleteEmployee(String Employee_id){
        Transaction transaction = null;int check=0;
        logger.info("deleting Employee: "+ Employee_id);
    	try {
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        transaction=session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class,Employee_id);
        session.delete(employee);
        check=1;
        transaction.commit();
        session.close();
    	} catch (Exception e) {
			System.err.println("Error Deleting"+e.getMessage());
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
