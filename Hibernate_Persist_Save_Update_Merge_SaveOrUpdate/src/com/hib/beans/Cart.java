package com.hib.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="CART")
public class Cart implements Serializable{

	@Id
	@GeneratedValue
	private int cartId;

	@Column(name="username")
	private String username;

	@Column(name="location")
	private String location;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", username=" + username + ", location=" + location + "]";
	}

}
