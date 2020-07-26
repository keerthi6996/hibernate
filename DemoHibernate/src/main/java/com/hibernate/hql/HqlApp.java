package com.hibernate.hql;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlApp {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(HqlDemo.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		// adding 20 records
		/*
		 * Random r = new Random();
		 * 
		 * for(int i=1;i<=20;i++) { HqlDemo o = new HqlDemo(); o.setOid(i);
		 * o.setOname("Order name "+ i); o.setOprice(r.nextDouble()); s.save(o); }
		 */
		
		Query q = s.createQuery(" from hqldemo where oprice>0.50 and oid<5");
		
		
		List<HqlDemo> l = q.list();
		
		for(HqlDemo h : l) {
			System.out.println("id: "+ h.getOid());
			System.out.println("name : "+ h.getOname());
			System.out.println("price : " + h.getOprice());
		}
		
		System.out.println("*************select statement fetching single record*************");
		
		Query qo = s.createQuery("select oid,oname from hqldemo where oid=1");
		System.out.println("first way...");
		Object[] oo = (Object[]) qo.uniqueResult();
		for(Object o : oo) {
			System.out.println(o);
		}
		
		System.out.println("second way...");
		
		System.out.println("id : " + oo[0] + " name : "+ oo[1]);
		
		
		
		System.out.println("*************** select statement fetching multiple records (alias name)************");
		
		Query qq = s.createQuery("select h.oid,h.oname from hqldemo h where h.oid<=3");
		List<Object[]> objects  = (List<Object[]>) qq.list();
		
		for(Object[] object : objects) {
			System.out.println("id :" + object[0] +  " name : " + object[1]);
		}
		
		
		System.out.println("***************** sum of price**************");
		Query sumOfPrice = s.createQuery("select sum(oprice) from hqldemo");
		Object sum = sumOfPrice.uniqueResult();
		System.out.println("sum is : " + sum);
		
		tx.commit();
		s.close();
	}
}
