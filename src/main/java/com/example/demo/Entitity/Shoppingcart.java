package com.example.demo.Entitity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity

public class Shoppingcart {
	
	@Id
	private long price;
	private String item_name;
	
	public Shoppingcart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shoppingcart(long price, String item_name) {
		super();
		this.price = price;
		this.item_name = item_name;
		
	}

	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	@Override
	public String toString() {
		return "Shoppingcart [price=" + price + ", item_name=" + item_name + "]";
	}
	
	
	
	
	
	

	
	

}
