package com.example.demo.Entitity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class ShoppingHIstoy {
	
	private String customer_cart;
	@Id
	long customers;
	public ShoppingHIstoy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCustomer_cart() {
		return customer_cart;
	}
	public void setCustomer_cart(String customer_cart) {
		this.customer_cart = customer_cart;
	}
	public long getCustomers() {
		return customers;
	}
	public void setCustomer_id(long customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "ShoppingHIstoy [customer_cart=" + customer_cart + ", customers=" + customers + "]";
	}
	
	

	
	
}
