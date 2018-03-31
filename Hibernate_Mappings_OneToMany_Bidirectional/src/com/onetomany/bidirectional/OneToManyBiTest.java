package com.onetomany.bidirectional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class OneToManyBiTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Phone phone1 = new Phone();
		phone1.setCategory("personal");
		phone1.setPhoneNumber(9791064265L);
		
		Phone phone2 = new Phone();
		phone2.setCategory("Office");
		phone2.setPhoneNumber(9791064376L);

		Person person = new Person();
		person.setPersonName("KRISHNA");
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		person.setPhones(phones);

		session.save(person);
		session.getTransaction().commit();

		session.close();
	}
}
