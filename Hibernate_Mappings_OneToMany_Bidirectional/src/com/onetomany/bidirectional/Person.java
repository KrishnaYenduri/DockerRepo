package com.onetomany.bidirectional;

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
@Table(name = "PERSON_OTM_BI")
public class Person {

	@Id
	@GeneratedValue
	private int personId;

	private String personName;
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name="PHONE_PERSON_FK")
	private List<Phone> phones;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", phones=" + phones + "]";
	}
}
