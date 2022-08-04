package com.example.demo.Entitity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity

public class ShoppingHIstoy {
	@Id
	long customer_id;
	private String Customer_cart;
	public ShoppingHIstoy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingHIstoy(long customer_id, String customer_cart) {
		super();
		this.customer_id = customer_id;
		Customer_cart = customer_cart;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_cart() {
		return Customer_cart;
	}
	public void setCustomer_cart(String customer_cart) {
		Customer_cart = customer_cart;
	}
	@Override
	public String toString() {
		return "ShoppingHIstoy [customer_id=" + customer_id + ", Customer_cart=" + Customer_cart + "]";
	}
	

}
