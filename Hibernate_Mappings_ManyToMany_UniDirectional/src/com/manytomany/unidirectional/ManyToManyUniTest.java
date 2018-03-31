package com.manytomany.unidirectional;

import org.hibernate.Session;

public class ManyToManyUniTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Address address1 = new Address();
		address1.setAddrLine1("PQR");
		address1.setCity("KKD1");

		Address address2 = new Address();
		address2.setAddrLine1("XYZ");
		address2.setCity("BZA1");

		Person person1 = new Person();
		person1.setfName("ANANYA");
		person1.setlName("PASUPALETI");
		person1.getAddresses().add(address1);
		person1.getAddresses().add(address2);

		Person person2 = new Person();
		person2.setfName("ISHITHA");
		person2.setlName("BULA");
		person2.getAddresses().add(address1);

		session.persist(person1);
		session.persist(person2);

		session.getTransaction().commit();
		
		person1.getAddresses().remove(address1);
		
		session.close();
	}
}
