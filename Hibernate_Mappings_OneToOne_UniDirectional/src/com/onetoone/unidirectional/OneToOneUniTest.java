package com.onetoone.unidirectional;

import org.hibernate.Session;

public class OneToOneUniTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Phone phone = new Phone();
		phone.setCategory("Office");
		phone.setPhoneNumber(9866406324L);

		Person p = new Person();
		p.setPersonName("SHIVA");
		p.setPhone(phone);

		session.save(p);
		session.getTransaction().commit();
		session.close();
	}
}
