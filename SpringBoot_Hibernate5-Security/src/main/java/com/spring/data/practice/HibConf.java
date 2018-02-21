package com.spring.data.practice;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.data.practice.entity.Address;
import com.spring.data.practice.entity.Person;

@Configuration
@EnableTransactionManagement
public class HibConf {

	@Value("${db.driver}")
	private String DRIVER;

	@Value("${db.url}")
	private String URL;

	@Value("${db.username}")
	private String USERNAME;

	@Value("${db.password}")
	private String PASSWORD;

	@Value("${packages.scan}")
	private String packagesToScan;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL;

	@Value("${hibernate.showsql}")
	private String SHOWSQL;

	@Value("${hibernate.dialect}")
	private String DIALECT;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setPassword(PASSWORD);
		dataSource.setUsername(USERNAME);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setAnnotatedClasses(Person.class, Address.class);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", DIALECT);
		hibernateProperties.put("hibernate.show_sql", SHOWSQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL);
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transacionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactoryBean().getObject());
		return transactionManager;
	}

}
