package hibernate.utility;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;//created attribute
    static
    {
        try
        {
            //instantiate attribute with hibernate configuration file
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        catch(Throwable th){
            System.err.println("SessionFactory creation failed"+th);
            throw new ExceptionInInitializerError(th);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
