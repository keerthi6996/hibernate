package com.hibernate.sql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WorkerApp {

	public static void main(String[] args) {
	
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		int sal = 15000;
		
		
		System.out.println("******** using normal hql");
		
		Query q = s.createQuery(" from worker where salary > :sal");
		q.setParameter("sal", sal);
		
		
		List<Worker> wList = q.list();
		for(Worker w : wList) {
			System.out.println(w);
		}
		
		System.out.println("using sql fetch all records");
		
		SQLQuery query = s.createSQLQuery("select * from worker where salary > :sal");
		query.addEntity(Worker.class);
		query.setParameter("sal", sal);
		List<Worker> wokersList = query.list();
		
		for(Worker o : wokersList) {
			System.out.println(o);
		}
		
		
		System.out.println("using sql fetch selected columns");
		
		SQLQuery qall = s.createSQLQuery("select name,location from worker where salary > :sal");
		qall.setParameter("sal", sal);
		qall.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		
		List wlist = qall.list();
		
		for(Object o : wlist) {
			Map m = (Map) o;
			System.out.println(m.get("name")  + " : " + m.get("location"));
		}
		
		tx.commit();
		s.close();
		
	}
}
