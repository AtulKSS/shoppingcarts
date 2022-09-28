package com.example.demo.services;


import org.hibernate.annotations.common.util.impl.LoggerFactory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entitity.AddtoCart;
import com.example.demo.Entitity.Products;

import com.example.demo.dao.AddToCartRepo;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Service
public class CartSerivceImpl implements CartService {

	@Autowired
	private AddToCartRepo addCartRepo;
	
	@Autowired
	private ProductServices proServices;
	
    private static final org.jboss.logging.Logger logger = LoggerFactory.logger(CartSerivceImpl.class);

	@Override
	public List<AddtoCart> addCartbyUserIdAndProductId(long productId, long userId,int qty,double price) throws Exception {
		try {
			if(addCartRepo.getCartByProductIdAnduserId(userId, productId).isPresent()){
				throw new Exception("Product is already exist.");
			}
			else {
			AddtoCart obj = new AddtoCart();
			obj.setQty(qty);
			obj.setUser_id(userId);
			Products pro = proServices.getProductsById(productId);
			obj.setProduct(pro); 
			//TODO price has to check with qty
			obj.setPrice(price);
			addCartRepo.save(obj);		
			return this.getCartByUserId(userId);	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
		
	}

	@Override
	public List<AddtoCart> getCartByUserId(long userId) {
		return addCartRepo.getCartByuserId(userId);
	}

//	@Override
//	public List<AddtoCart> removeCartByUserId(long cartId, long userId) {
//		addCartRepo.deleteCartByIdAndUserId(userId, cartId);
//		return this.getCartByUserId(userId);
//	}

	@Override
	public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
		addCartRepo.updateQtyByCartId(cartId,price,qty);
	}

	
//	@Override
//	public List<AddtoCart> removeAllCartByUserId(long userId) {
//		addCartRepo.deleteAllCartByUserId(userId);
//		return null;
//	}

	@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddtoCart> removeCartByUserId(long cartId, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddtoCart> removeAllCartByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}