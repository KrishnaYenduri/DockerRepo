package com.onetoone.bidirectional;

import org.hibernate.Session;

/**
 * One to one Bi-directional Mapping.
 * 
 * Whenever you are working on bi-directional mapping, that means you are saying owner of the relationship is on the other side.
 * 
 * @author Yenduri
 *
 */
public class OneToOneBiTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Person person = new Person();
		person.setPersonName("Keerthi Suresh1");

		Phone phone = new Phone();
		phone.setCategory("Guest House1");
		phone.setPhoneNumber(9396519139L);
		phone.setPerson(person);

		session.save(phone);
		session.getTransaction().commit();
		session.close();
	}

}
