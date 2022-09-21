package com.example.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.ShoppingConfiguration;
import com.example.demo.Entitity.AddtoCart;
import com.example.demo.Entitity.CheckoutCart;
import com.example.demo.Entitity.Products;
import com.example.demo.Entitity.ShoppingHIstoy;
import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.Entitity.User;
import com.example.demo.Entitity.Users;
import com.example.demo.dao.ShoppingDao;
import com.example.demo.services.CartService;
import com.example.demo.services.ShoppingcartServices;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
public class Mycontroller {
	
	@Autowired
	private ShoppingcartServices shoppingservices;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/showitems")
	public List<Shoppingcart> showitems()
	{
		return this.shoppingservices.showitems();
	
	}
	@CrossOrigin
	@PostMapping(value = "/additemss", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Shoppingcart additem(@RequestBody Shoppingcart shoppingcart) {
		return this.shoppingservices.additem(shoppingcart);
		
	}
	
	//Getting a single item from shopping cart
	@GetMapping("/additemss/{itemID}")
	public Shoppingcart getsingleitem(@PathVariable String itemID) {
		return this.shoppingservices.getsingleitem(Long.parseLong(itemID));
	}
	
	@DeleteMapping("/additemss/{itemID}")
	public ResponseEntity<HttpStatus> removeitem(@PathVariable String itemID) {
		try {
		this.shoppingservices.removeitem(Long.parseLong(itemID));
		return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/totalitems")
	public long sumitems() {
		return (long) this.shoppingservices.sumitems();
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public <T> ResponseEntity<T> createCustomer(UriComponentsBuilder builder) {
		return null;
	    // implementation
	}

	@GetMapping("/price")
	public List<Integer> getPrice() {
	return this.shoppingservices.getPrice();
}
	@GetMapping("/allitems")
	public List<String> getAllitems() {
	return this.shoppingservices.getAllitems();
}
	
	@GetMapping("/getallusersss")
	public String getallusersss() {
	return this.shoppingservices.getallusersss();
}
	
	
	@GetMapping("/additemss/v1/orders/current/items/add")
	public Shoppingcart additem1(@RequestBody Shoppingcart shoppingcart) {
		return this.shoppingservices.additem(shoppingcart);
		
	}
	
	@PostMapping("/additemssss")
	public ShoppingHIstoy additeminhis(@RequestBody ShoppingHIstoy shoppinghistory) {
		return this.shoppingservices.additeminhis(shoppinghistory);	
	}
	
	@PutMapping("/saveitems")
	public List<String> saveitems(@RequestBody ShoppingHIstoy shoppinghistory) {
		return this.shoppingservices.saveitems(shoppinghistory);	
	}
	
	@PutMapping("/updatecart")
	public ResponseEntity<String> updatecart() {
		return new ResponseEntity<String>(shoppingservices.updatecart( " record(s) updated.", HttpStatus.OK));
	}
	
	@PutMapping("/deletecart")
	public ResponseEntity<String> deletecart() {
		return new ResponseEntity<String>(shoppingservices.deletecart( " record(s) updated.", HttpStatus.OK));
	}
	
	@PostMapping("/adduser")
	public User adduser(@RequestBody User user) {
		return this.shoppingservices.adduser(user);
		
	}
	
	@PostMapping("/addproduct")
	public Products addproduct(@RequestBody Products product) {
		return this.shoppingservices.addproduct(product);
		
	}
	
	@PostMapping("/checkout")
	public CheckoutCart checkout(@RequestBody CheckoutCart checkout) {
		return this.shoppingservices.checkout(checkout);
		
	}
	
	@PostMapping("/addtocart")
	public AddtoCart addtocart(@RequestBody AddtoCart addtocart){
		return this.shoppingservices.addtocart(addtocart);
		
	}
//	ADDTOCART CONTROLLER 2
	
	@GetMapping("/addProduct")
 	public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"productId","userId","qty","price"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
				
			}
			long productId = Long.parseLong(addCartRequest.get("productId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
		 	int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			List<AddtoCart> obj = cartService.addCartbyUserIdAndProductId(productId,userId,qty,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Try Again.......");
			return ResponseEntity.badRequest().body(new ApiResponse());
		}
		
   }
	
	@PostMapping("/updateQtyForCart")
  	public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"cartId","userId","qty","price"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
				
			}
			long cartId = Long.parseLong(addCartRequest.get("cartId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			 cartService.updateQtyByCartId(cartId, qty, price);
			 List<AddtoCart> obj = cartService.getCartByUserId(userId);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse());
		}
		
   }
	
	@DeleteMapping("/removeProductFromCart")
  	public ResponseEntity<?> removeCartwithProductId(@RequestBody HashMap<String,String> removeCartRequest) {
		try {
			String keys[] = {"userId","cartId"};
			if(ShoppingConfiguration.validationWithHashMap(keys, removeCartRequest)) {
				
			}
			List<AddtoCart> obj = cartService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Long.parseLong(removeCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse());
		}		
   }
	
	
	@GetMapping("/getCartsByUserId")
  	public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String,String> getCartRequest) {
		try {
			String keys[] = {"userId"};
			if(ShoppingConfiguration.validationWithHashMap(keys, getCartRequest)) {
			}
			List<AddtoCart> obj = cartService.getCartByUserId(Long.parseLong(getCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse());
		}	
		
		
   }
	
//	Order Controllers
	
	@GetMapping("/getOrdersByUserId")
	public ResponseEntity<?> getOrdersByUserId(@RequestBody HashMap<String,String> ordersRequest) {
	try {
		return ResponseEntity.ok(new ApiResponse());
	}catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(new ApiResponse());
	}
	
}
	
	
	
	
	
	
	
		
	
}
