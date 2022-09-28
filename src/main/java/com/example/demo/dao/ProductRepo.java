package com.example.demo.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entitity.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
//	@Query("Select pro FROM Products pro WHERE pro.category_id=:cat_id")
//	List<Products> getByCategoryId(@Param("cat_id")String cat_id);
}
