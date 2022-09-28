package com.example.demo.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Entitity.AddtoCart;
//import com.example.demo.Entitity.CheckoutCart;
import com.example.demo.Entitity.Products;
//import com.example.demo.Entitity.ShoppingHIstoy;
import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.Entitity.User;
//import com.example.demo.Entitity.Users;
import com.example.demo.dao.AddToCartRepo;
import com.example.demo.dao.ProductRepo;
import com.example.demo.dao.ShoppingDao;

import com.example.demo.dao.UserDao;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Service
public class Shoppingcartimplementation implements ShoppingcartServices {
	@Autowired
	private ShoppingDao shoppingdao;
	

	@Autowired
	private UserDao userdao;
	
	@Autowired
	private ProductRepo productDao;
	
	@Autowired
	private AddToCartRepo addtocarts;
	
	
	
	
	public Shoppingcartimplementation () {
	
	}
	
	@Override
	public List<Shoppingcart> showitems() {		
		return shoppingdao.findAll();
	}

	@Override
	public Shoppingcart additem(Shoppingcart shoppingcart) {
		// TODO Auto-generated method stub
		shoppingdao.save(shoppingcart);
		return shoppingcart;
	}

	@Override
	public Shoppingcart getsingleitem(long itemID) {
		return shoppingdao.getReferenceById(itemID);
		
	}

	@Override
	public Shoppingcart deleteitem(Shoppingcart shoppingcart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeitem(long parseLong) {
		// TODO Auto-generated method stub
		Shoppingcart entity = shoppingdao.getReferenceById(parseLong);
		shoppingdao.delete(entity);
	}


	@Override
	public Object getUserFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getPrice() {
		List<Integer> priceList = shoppingdao.getPrice();
		System.out.println("All prices"+priceList);
		int sumss = 0;
		for(int i = 0;i<priceList.size();i++) {
			
			sumss = sumss + priceList.get(i);
			
		}
		float gstss = (sumss*(18/100.0f));
		float discounts = (sumss)*10/100.0f;
		float totalamount= sumss+gstss;
		float lastamount = totalamount-discounts;
		System.out.println("Total amount without GST "+sumss);
		System.out.println("Total amount with GST "+(sumss+gstss));
		System.out.println("Total amount with 10% discount "+lastamount);
		
		return priceList;
	}
	
	

	@Override
	public List<String> getAllitems() {
		List<String> priceAllitems = shoppingdao.getAllitems();
		return priceAllitems;
	}

	@Override
	public List<Shoppingcart> getinfo(Long price) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public HttpStatus updatecart(String string, HttpStatus ok) {
		HttpStatus shoppinghistory = ok;
		shoppinghdao.updatecart(true, "erfeefsfe");
	// TODO Auto-generated method stub
	return shoppinghistory;
}


	
	@Override
	public HttpStatus deletecart(String string, HttpStatus ok) {
		HttpStatus shoppingcart = ok;
		shoppingdao.deletecart(true, "erfeefsfe");
	// TODO Auto-generated method stub
	return shoppingcart;
		
	}

	@Override
	public User adduser(User user) {	
		return userdao.save(user);
	}

	@Override
	public Products addproduct(Products product) {
		// TODO Auto-generated method stub
		productDao.save(product);
		return product;
	}



	@Override
	public AddtoCart addtocart(AddtoCart addtocart) {
		// TODO Auto-generated method stub
		addtocarts.save(addtocart);
		return addtocart;
	}
	
	@Override
	public String getallusersss() {
		// TODO Auto-generated method stub\
		String getalluserss = userdao.getallusers();
		return getalluserss;
	}





}