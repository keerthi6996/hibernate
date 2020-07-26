package com.hibernate.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Customer customer = new Customer();
    	customer.setCustomerId(1000);
    	customer.setCustomerName("AT&T COLLABORATE");
    	
    	Employee emp = new Employee();
    	emp.setEmpId(46103);
    	emp.setEmpName("Virat");

    	
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
    	   	
    	SessionFactory sf = con.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	Transaction tx = session.getTransaction();
    	
    	session.save(emp);
    	
    	tx.commit();
    	
    	
    	
    }
}
