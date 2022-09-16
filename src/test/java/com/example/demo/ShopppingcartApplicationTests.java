package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Entitity.AddtoCart;
import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.controller.Mycontroller;
import com.example.demo.dao.UserDao;
import com.example.demo.services.ShoppingcartServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;



@SpringBootTest
class ShopppingcartApplicationTests {
	@Autowired
	private UserDao userdao;

	@Test
	void contextLoads() {
	String dow = userdao.getallusers();
	assertEquals("atul.sonkamble4321@gmail.com",dow);
	
	
		
	}
	
	
		
		
	}

	
	


