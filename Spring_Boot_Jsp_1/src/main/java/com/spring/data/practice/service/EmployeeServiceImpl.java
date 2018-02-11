package com.spring.data.practice.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.practice.comparators.EmployeeIdComparator;
import com.spring.data.practice.comparators.EmployeeNameComparator;
import com.spring.data.practice.dao.EmployeeRepository;
import com.spring.data.practice.employee.model.Employee;
import com.spring.data.practice.status.EmployeeStatus;

@Named("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeRepository empRepository;
	
	@Inject
	private EmployeeIdComparator idComparator;
	
	@Inject
	private EmployeeNameComparator nameComparator;

	@PersistenceContext
	private EntityManager entityManager;

	private static List<Employee> employees;

	public List<Employee> getAllEmployeesSortById(boolean sortById) {
		employees = (List<Employee>) empRepository.findAll();
		employees.stream().forEach(employee->employee.getName().toUpperCase());
		if(sortById)
			employees.sort(idComparator);
		else
			employees.sort(idComparator.reversed());
		return employees;
	}
	
	public List<Employee> getAllEmployeesSortByName(boolean sortByName) {
		employees = (List<Employee>) empRepository.findAll();
		employees.stream().forEach(employee->employee.getName().toUpperCase());
		if(sortByName)
			employees.sort(nameComparator);
		else
			employees.sort(nameComparator.reversed());
		return employees;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		employees = (List<Employee>) empRepository.findAll();
		employees.stream().forEach(employee->employee.getName().toUpperCase());
		return employees;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Employee employee = empRepository.findOne(empId);
		return employee;
	}

	@Override
	public String addEmployee(Employee employee) {
		Employee emp = empRepository.save(employee);
		if (emp.getEid() != null)
			return EmployeeStatus.SUCCESS.toString();
		else
			return EmployeeStatus.FAILED.toString();
	}
}
