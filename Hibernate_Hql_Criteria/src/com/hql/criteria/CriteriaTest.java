package com.hql.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CriteriaTest {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Person.class);
		List<Person> persons = criteria.add(Restrictions.like("personName", "ISHI%")).list();
		
		persons.stream().forEach(person->System.out.println(person.getPersonId()+" "+person.getPersonName()));
		
		session.close();
	}
	
}
