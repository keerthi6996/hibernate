package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CacheApp {

	public static void main(String[] args) {
		
		Product p = null;
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session1 = sf.openSession();
		Transaction tx = session1.beginTransaction();
		p = session1.get(Product.class, 1);
		System.out.println(p.toString());
		/*
		 * p = session1.get(Product.class, 1); System.out.println(p.toString()); // same session wont call query again
		 */
		tx.commit();
		
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		p = session2.get(Product.class, 1);
		System.out.println(p.toString());
		
		tx2.commit();
		
		
	}
}
