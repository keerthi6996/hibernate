package com.hibernate.fetchTypes;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonApp {

	public static void main(String[] args) {
		
		/** 
		 
		 creation started
		 
		Address a1 = new Address();
		Address a2 = new Address();
		Address a3 = new Address();
		Address a4 = new Address();
		Address a5 = new Address();
		a1.setLocId(10);
		a1.setLocation("Jharkand");
		
		a2.setLocId(20);
		a2.setLocation("Jaipur");
		
		a3.setLocId(30);
		a3.setLocation("Hyderabad");
		
		a4.setLocId(40);
		a4.setLocation("Chennai");
		
		a5.setLocId(50);
		a5.setLocation("Bangalore");
		
		Person person = new Person();
		person.setPid(30);
		person.setPname("Hannah");
		//person.getAddress().add(a2);
		a5.setPerson(person);
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Address.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		s.save(a5);
		s.save(person);
		tx.commit();
		s.close();
		
		creation ended
	
		**/
		Person p =null;
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Address.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		p = s.get(Person.class, 10);
		System.out.println(p.getPname());
		
		
		
		Collection<Address> addr = p.getAddress();

		for (Address a : addr) {
			System.out.println(a.toString());
		}
		
		
		
		tx.commit();
		s.close();
		
		
		
		
	}
}
