package com.onetoone.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 **********  OWNER ************
 * 
 * This is one-to-one uni directional mapping.
 * 
 * To define one-to-one relationship we will use @OneToOne annotation.
 * 
 * To establish a relation between the OWNER and CHILD(OWNEE) we will use FOREIGN KEY .So to define that we will use @JoinColumn(name="Give a name to your FK")
 * 
 * @author Yenduri
 *
 */
@Entity(name = "Person")
@Table(name = "PERSON_OTO_UNI")
public class Person {

	@Id
	@GeneratedValue
	private int personId;

	private String personName;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PERSON_PHONE_FK")
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
