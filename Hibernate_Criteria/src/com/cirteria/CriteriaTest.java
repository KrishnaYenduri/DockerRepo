package com.cirteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class CriteriaTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		
		Criteria criteria = session.createCriteria(Merchant.class);

		criteria.add(Restrictions.eq("merchId", 1001));
		
//		criteria.add(Restrictions.like("name", "p%").ignoreCase());
		
		List<Merchant> merchants = criteria.list();

		merchants.stream().forEach(merchant -> System.out.println(merchant));

		
		
		
	}

}
