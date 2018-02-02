package com.spring.data.practice.controller;

import java.io.Serializable;

public class Employee implements Serializable {

	private int eid;

	private String name;

	private String designation;

	public Employee(int eid, String name, String designation) {
		this.eid = eid;
		this.name = name;
		this.designation = designation;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", designation=" + designation + "]";
	}
}
