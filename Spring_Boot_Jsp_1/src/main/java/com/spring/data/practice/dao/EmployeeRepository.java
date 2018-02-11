package com.spring.data.practice.dao;

import javax.inject.Named;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.practice.employee.model.Employee;

@Named
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
