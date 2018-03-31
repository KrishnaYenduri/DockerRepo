package com.hql.criteria;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

//		Query hqlQuery = session.createQuery("from Person AS P, Phone AS PH where PH.category='HOME'");

public class HqlTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		/*Query getAllPhonesBasedOnCategory = session.createQuery("from Phone AS P where P.category = ?");
		getAllPhonesBasedOnCategory.setString(0, "Office");
		List<Phone> homePhones = getAllPhonesBasedOnCategory.list();
		for (Phone p : homePhones) {
			System.out.println(p);
		}*/
		System.out.println("=====================================================================================================");
		Query getAllPersonsWhosePhoneCategoryIsHome = session.createQuery("from Person P, Phone Ph where Ph.category = ''");
		List<Object[]> persons = getAllPersonsWhosePhoneCategoryIsHome.list();
		
		for(Object[] object : persons) {
		System.out.println(object[0]);
		}
		
		session.flush();
	}
}
