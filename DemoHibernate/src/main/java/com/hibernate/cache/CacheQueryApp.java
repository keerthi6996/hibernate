package com.hibernate.cache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CacheQueryApp {

	public static void main(String[] args) {

		Product p = null;
		
		List ans =null;
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session1 = sf.openSession();
		Transaction tx = session1.beginTransaction();
		
		Query q1 = session1.createQuery("from items where price<7000");
		q1.setCacheable(true);
		List<Product> plist1 = q1.list();
		for(Product pp1 : plist1) {
			System.out.println(pp1.toString());
		}
		
		
		
		
		// p = (Product) q1.uniqueResult();
		
		//System.out.println(p.toString());
		
		tx.commit();
		
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		Query q2 = session2.createQuery("from items where price<7000");
		q2.setCacheable(true);
		
		List<Product> plist2 = q2.list();
		for(Product pp2 : plist2) {
			System.out.println(pp2.toString());
		}
		
		//p = (Product) q1.uniqueResult();
		//System.out.println(p.toString());
		
		tx2.commit();
	}
}
