package com.onetomany.unidirectional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.onetomany.unidirectional.HibernateUtil;

public class OneToManyUniTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Phone phone1 = new Phone();
		phone1.setCategory("Office");
		phone1.setPhoneNumber(9791254289L);

		Phone phone2 = new Phone();
		phone2.setCategory("Personal");
		phone2.setPhoneNumber(9866436256L);

		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		
		Person person = new Person();
		person.setPersonName("ISHITHA");
		person.setPhones(phones);

		session.save(person);
		session.getTransaction().commit();

		session.close();
	}
}
