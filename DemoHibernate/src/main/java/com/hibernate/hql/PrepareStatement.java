package com.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate.DemoHibernate.Customer;

public class PrepareStatement {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Customer.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		int custId = 1500;
		String state = "Illinois";
		
		Query q = s.createQuery("from customer where customerId < :custid and state not in :state");
		q.setParameter("custid", custId);
		q.setParameter("state", state);
		
		List<Customer> c = q.list();
		for(Customer cc : c) {
			System.out.println(cc);
		}
		
		System.out.println("******************** where clause**************");
		
		
		
		String customerName = null;
		Customer cus = new Customer();
		cus.setCustomerId(1200);
		
		String query = "from com.hibernate.DemoHibernate.Customer c where";
		if(0!=cus.getCustomerId()) {
			query = query + " c.customerId  = " + cus.getCustomerId();
		} 
		if(customerName!=null && !customerName.isEmpty()) {
			query = query + " c.customerName = :customerName"; 
		}
		System.out.println("query is ..... "+ query);
		Query clause = s.createQuery(query);
		
		
		
		//clause.setParameter("customerName", customerName);
		//clause.setParameter("customerId", cus.getCustomerId());
		List<Customer> list = clause.list();
		for(Customer l : list) {
			System.out.println(l);
		}
		
		tx.commit();
		s.close();
	}
}
