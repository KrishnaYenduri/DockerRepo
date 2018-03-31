package com.manytomany.unidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name = "PERSON_MTM_UNI")
public class Person {

	@Id
	@GeneratedValue
	private int personId;

	private String fName;

	private String lName;

	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Address> addresses = new ArrayList<Address>();

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", fName=" + fName + ", lName=" + lName + ", addresses=" + addresses
				+ "]";
	}

}
