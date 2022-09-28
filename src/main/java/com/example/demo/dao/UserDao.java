package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Entitity.User;


public interface UserDao extends JpaRepository<User, Long> {
	@Query(value=("SELECT email from users"), nativeQuery=true)
	String getallusers();
	
	@Query(value=("SELECT id from users"), nativeQuery=true)
	Boolean getallusersbyid(Integer id);
	
	

}
