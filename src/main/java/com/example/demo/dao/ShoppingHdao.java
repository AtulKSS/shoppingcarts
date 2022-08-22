package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entitity.ShoppingHIstoy;



public interface ShoppingHdao extends JpaRepository<ShoppingHIstoy, Long>{
	
	@Query(value=("SELECT item_name FROM shoppingcart"), nativeQuery=true)
	List<String> addallitemsincart();
	
	@Transactional
	@Modifying
	@Query(value=("insert into shoppinghistoy(customer_cart) SELECT item_name from shoppingcart"), nativeQuery=true)
	void updatecart(Boolean customer_cart, String item_name);
	
	


	
}


 