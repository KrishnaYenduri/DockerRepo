package com.onetoone.unidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 **********  OWNEE ************
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
@Entity
@Table(name = "PHONE_OTO_UNI")
public class Phone {

	@Id
	@GeneratedValue
	private int phoneId;

	private Long phoneNumber;

	private String category;

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

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneNumber=" + phoneNumber + ", category=" + category + "]";
	}
}
