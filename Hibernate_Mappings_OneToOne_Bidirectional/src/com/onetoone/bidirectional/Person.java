package com.onetoone.bidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 
 * *********  CHILD ************
 * 
 * This is one-to-one bi directional mapping.
 * 
 * So the owner of the mapping exists on the other side of the relationship(Phone)(OWNER).
 * 
 * To define one-to-one relationship we will use @OneToOne annotation.
 * 
 * To convey that the owner of the relationship is existing on the other side we will write 'mappedBy' property in @OneToOne annotation. 
 * 
 * @author Yenduri
 *
 */
@Entity(name = "Person")
@Table(name = "PERSON_OTO_BI")
public class Person {

	@Id
	@GeneratedValue
	private int personId;

	private String personName;

	@OneToOne(mappedBy = "person")
	// @JoinColumn(name="PERSON_PHONE_FK")
	private Phone phone;

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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", phone=" + phone + "]";
	}
}
