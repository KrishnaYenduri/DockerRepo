package com.spring.data.practice.comparators;

import java.util.Comparator;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import com.spring.data.practice.employee.model.Employee;

@Named
public class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp2.getName().compareToIgnoreCase(emp1.getName());
	}

}