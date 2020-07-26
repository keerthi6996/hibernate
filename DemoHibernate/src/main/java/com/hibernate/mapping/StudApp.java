package com.hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StudApp {

	public static void main(String[] args) {
		
		List<Laptop> l = new ArrayList<Laptop>();
		
		Laptop l1 = new Laptop();
		l1.setLid(1);
		l1.setLname("Lenovo");
		l.add(l1);
		
		
		Student student = new Student();
		student.setRollNo(10);
		student.setSname("Harsha");
		student.setMarks(65);
		student.getLaptop().add(l1);
		l1.getStudent().add(student);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s =sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		s.save(student);
		s.save(l1);
		tx.commit();
		
		s.close();
		
	}
}
