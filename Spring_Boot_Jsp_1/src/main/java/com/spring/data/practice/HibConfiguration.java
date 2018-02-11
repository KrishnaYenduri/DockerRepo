package com.spring.data.practice;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.data.practice.employee.model.Employee;

@Configuration
@EnableTransactionManagement
public class HibConfiguration {

	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER;

	@Value("${spring.datasource.password}")
	private String PASSWORD;

	@Value("${spring.datasource.url}")
	private String URL;

	@Value("${spring.datasource.username}")
	private String USERNAME;

	@Value("${spring.jpa.database-platform}")
	private String DIALECT;

	@Value("${spring.jpa.show-sql}")
	private String SHOWSQL;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String HBM2DDL_AUTO;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		dataSource.setDriverClassName(DRIVER);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setAnnotatedClasses(Employee.class);
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", DIALECT);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		hibernateProperties.setProperty("hibernate.show_sql", SHOWSQL);
		sessionFactoryBean.setHibernateProperties(hibernateProperties);
		return sessionFactoryBean;
	}

//	@Bean
//	public HibernateTransactionManager getTransactionManager() {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(getSessionFactory().getObject());
//		return transactionManager;
//	}

}
