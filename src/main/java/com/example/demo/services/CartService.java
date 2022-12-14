package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.Entitity.AddtoCart;

//import antlr.collections.List;

@Service
public interface CartService {
	List<AddtoCart> addCartbyUserIdAndProductId(long productId,long userId,int qty,double price) throws Exception;
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	List<AddtoCart> getCartByUserId(long userId);
	List<AddtoCart> removeCartByUserId(long cartId,long userId);
	List<AddtoCart> removeAllCartByUserId(long userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);

	
	
	//CheckOutCart
}
