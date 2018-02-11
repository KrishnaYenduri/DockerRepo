package com.spring.data.practice.service;

import java.util.List;

import com.spring.data.practice.employee.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployeeDetails();
	public Employee getEmployeeById(int empId);
	public String addEmployee(Employee employee);
}
