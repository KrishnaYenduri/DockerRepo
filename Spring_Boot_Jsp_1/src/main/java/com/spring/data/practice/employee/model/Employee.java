package com.spring.data.practice.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "STAFF")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4293518003100139962L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eid;

	@Column(name = "NAME")
	@NotNull
	@Size(min = 2, max = 12)
	private String name;

	@Column(name = "DESIGNATION")
	@Size(min = 2, max = 15)
	private String designation;

	public Employee() {

	}

	public Employee(int eid, String name, String designation) {
		this.eid = eid;
		this.name = name;
		this.designation = designation;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
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
