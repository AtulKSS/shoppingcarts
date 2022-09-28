package com.example.demo.services;

import java.util.List;
import org.springframework.http.HttpStatus;

import com.example.demo.Entitity.AddtoCart;

import com.example.demo.Entitity.Products;

import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.Entitity.User;

public interface ShoppingcartServices {
	
	public List<Shoppingcart> showitems();
	
	public Shoppingcart additem(Shoppingcart shoppingcart);
	
	public Shoppingcart getsingleitem(long itemID);
	
	public Shoppingcart deleteitem(Shoppingcart shoppingcart);
	
	public void removeitem(long itemID);

	public List<Shoppingcart> getinfo(Long price);

	public Object getUserFullName();

	public List<Integer> getPrice();
	
	public List<String> getAllitems();



	public HttpStatus deletecart(String string, HttpStatus ok);

	public User adduser(User user);

	public Products addproduct(Products product);

	public AddtoCart addtocart(AddtoCart addtocart);


	String getallusersss();

	
	
	


}
