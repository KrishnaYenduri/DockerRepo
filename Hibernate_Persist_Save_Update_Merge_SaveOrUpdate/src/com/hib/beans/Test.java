package com.hib.beans;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		Session session = HibernateUtil.getSession();
		Transaction tr = session.getTransaction();
		tr.begin();
		
		Cart cart = new Cart();
		cart.setUsername("sai");
		cart.setLocation("Kolkatta");
		
		session.save(cart);
		session.evict(cart);
		
		cart.setUsername("siva");
		session.save(cart);
		
		tr.commit();
		
		session.close();
		


	}
}
