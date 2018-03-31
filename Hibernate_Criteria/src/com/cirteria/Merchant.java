package com.cirteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Merchant")
@Table(name = "MERCHANT")
public class Merchant {

	@Id
	@Column(name="MERCH_ID")
	protected int merchId;

	@Column(name = "NAME")
	protected String name;

	@Column(name = "LOCATION")
	protected String location;

	public int getmerchId() {
		return merchId;
	}

	public void setmerchId(int merchId) {
		this.merchId = merchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Merchant [merchId=" + merchId + ", name=" + name + ", location=" + location + "]";
	}

}
