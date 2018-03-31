package com.onetomany.uni;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class OneToManyRetrievalTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Query getAllPersons = session.createQuery("from Person");
		List<Person> persons = getAllPersons.list();
		persons.stream().forEach(person -> System.out
				.println(person.getPersonId() + " " + person.getFirstName() + " " + person.getLastName()));

		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Query getAllOrders = session.createQuery("from Orders");
		List<Orders> orders = getAllOrders.list();
		orders.stream().forEach(order -> System.out.println(order));

		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
		Query getPersonsWithSpecifiOrderId = session.createQuery("from Orders o where o.orderNumber=1014");
		List<Orders> list = getPersonsWithSpecifiOrderId.list();
		list.stream().forEach(person -> System.out.println(person));
		session.close();
	}
}