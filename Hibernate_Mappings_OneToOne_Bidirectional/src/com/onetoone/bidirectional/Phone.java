package com.onetoone.bidirectional;

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
 * This is one-to-one bi directional mapping.
 * 
 * To define one-to-one relationship we will use @OneToOne annotation.
 * 
 * To establish a relation between the OWNER and CHILD(OWNEE) we will use FOREIGN KEY .So to define that we will use @JoinColumn(name="Give a name to your FK")
 * 
 * @author Yenduri
 *
 */
@Entity
@Table(name = "PHONE_OTO_BI")
public class Phone {

	@Id
	@GeneratedValue
	private int phoneId;

	private Long phoneNumber;

	private String category;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "PHONE_PERSON_FK")
	private Person person;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneNumber=" + phoneNumber + ", category=" + category + ", person="
				+ person + "]";
	}
}
