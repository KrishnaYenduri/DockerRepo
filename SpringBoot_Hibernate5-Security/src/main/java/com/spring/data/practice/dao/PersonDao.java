package com.spring.data.practice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.data.practice.entity.Person;

@Repository
@Transactional
public class PersonDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String savePerson(Person person) {

		System.out.println("Inside DAO");
		System.out.println("Saving to DB");
		Transaction tr = getSession().beginTransaction();
		int isSuccess = (int) getSession().save(person);
		if (isSuccess >= 1) {
			System.out.println("Success");
			return "Success";
		} else {
			return "Failed";
		}
	}

}
