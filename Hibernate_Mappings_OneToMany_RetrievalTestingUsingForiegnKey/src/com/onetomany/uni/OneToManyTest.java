package com.onetomany.uni;

import org.hibernate.Session;

public class OneToManyTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Orders order1 = new Orders();
		order1.setOrderNumber(1001);

		Orders order2 = new Orders();
		order2.setOrderNumber(1002);

		Orders order3 = new Orders();
		order3.setOrderNumber(1003);
		
		Orders order4 = new Orders();
		order4.setOrderNumber(1004);

		Orders order5 = new Orders();
		order5.setOrderNumber(1005);

		Orders order6 = new Orders();
		order6.setOrderNumber(1006);

		Person person1 = new Person();
		person1.setFirstName("SIVA");
		person1.setLastName("YENDURI");
		person1.getorders().add(order1);
		person1.getorders().add(order2);
		person1.getorders().add(order3);
		
		Person person2 = new Person();
		person2.setFirstName("SYAMALA");
		person2.setLastName("PASUPULETI");
		person2.getorders().add(order4);
		person2.getorders().add(order4);
		person2.getorders().add(order6);

		session.save(person1);
		session.save(person2);
		session.getTransaction().commit();

		session.close();

	}
}
