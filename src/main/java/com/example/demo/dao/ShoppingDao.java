package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entitity.Shoppingcart;

public interface ShoppingDao extends JpaRepository<Shoppingcart, Long>{
	
	@Query(value=("SELECT * FROM shoppingcart"), nativeQuery=true)
	List<Shoppingcart> getinfo(Long price);
	
//	@Query(value="select first_name, last_name from Users u where u.user_id =:userId", nativeQuery=true)
//	List<Object[]> getUserFullNameById(@Param("userId") String userId);

	@Query(value="SELECT * FROM shoppingcart", nativeQuery=true)
	List<Object[]> getUserFullNameById(@Param("price") String price);
    
	@Query(value=("SELECT price FROM shoppingcart"), nativeQuery=true)
	List<Integer> getPrice();
//	Boolean getPrice(int price);
	
	@Query(value=("SELECT item_name FROM shoppingcart"), nativeQuery=true)
	List<String> getAllitems();
	
	@Transactional
	@Modifying
	@Query(value=("DELETE from shoppingcart"), nativeQuery=true)
	void deletecart(Boolean price, String item_name);

	
	


}





