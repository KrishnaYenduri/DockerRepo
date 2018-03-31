package com.onetomany.uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name = "TEST_PERSONS")
public class Person {

	@Id
	@GeneratedValue
	private int personId;

	private String lastName;
	
	private String firstName;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="PERSONID")
	private List<Orders> orders = new ArrayList<Orders>();

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Orders> getorders() {
		return orders;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", lastName=" + lastName + ", firstName=" + firstName + ", orders="
				+ orders + "]";
	}
}
