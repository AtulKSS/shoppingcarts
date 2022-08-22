package com.example.demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.example.demo.Entitity.ShoppingHIstoy;
import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.dao.ShoppingDao;

public interface ShoppingcartServices {
	
	public List<Shoppingcart> showitems();
	
	public Shoppingcart additem(Shoppingcart shoppingcart);
	
	public Shoppingcart getsingleitem(long itemID);
	
	public Shoppingcart deleteitem(Shoppingcart shoppingcart);
	
	public void removeitem(long itemID);

	public long sumitems();
	
//	public List<Shoppingcart> getinfo();

	public List<Shoppingcart> getinfo(Long price);

	public Object getUserFullName();

	public List<Integer> getPrice();
	
	public List<String> getAllitems();

	public ShoppingHIstoy additeminhis(ShoppingHIstoy shoppinghistory);
	
//	public ShoppingHIstoy saveitems(ShoppingHIstoy shoppinghistory);

	public List<String> saveitems(ShoppingHIstoy shoppinghistory);


	public HttpStatus updatecart(String string, HttpStatus ok);

	public HttpStatus deletecart(String string, HttpStatus ok);

	
	
	


}
