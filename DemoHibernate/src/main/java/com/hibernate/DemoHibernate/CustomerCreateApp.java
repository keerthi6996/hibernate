package com.hibernate.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerCreateApp {

	public static void main(String[] args) {
		
		Address address = new Address();
		address.setCity("Ashland");
		address.setState("California");
		address.setCountry("United States");
		address.setPostalCode(94541);
		
		Customer customer = new Customer();
		customer.setCustomerId(1400);
		customer.setCustomerName("Madman");
		customer.setAddress(address);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(customer);
		
		tx.commit();
		
		
		// fetch
		
		
		Customer customerFetch = null;
		customerFetch = s.get(Customer.class, 1400);
		System.out.println(customerFetch);
		
		
		s.close();
	}
}
