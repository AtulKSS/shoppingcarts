package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.Entitity.User;
import com.example.demo.controller.Mycontroller;
import com.example.demo.dao.UserDao;
import com.example.demo.services.ShoppingcartServices;
import com.example.demo.services.Shoppingcartimplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//@WebMvcTest(value=Mycontroller.class, useDefaultFilters = false)
@AutoConfigureMockMvc
@SpringBootTest
public class ShopppingcartApplicationTests{
				
				@Mock
				private Shoppingcartimplementation servicess;
				
//				@Autowired
//				private ShoppingcartServices services;
				
//				@Autowired
//				private UserDao userdaoaa;
//				
//				@Autowired
//				private Shoppingcart carttest;
				
				 @Autowired
				 private MockMvc mvc;
				
				@Test
				public void testingstarts()
				
				 throws Exception{
					Shoppingcart mockG = new Shoppingcart();
					mockG.setItem_name("MILKs");
					mockG.setPrice(455);
				
					
				
					String inputinJson = this.mapToJson(mockG);
					
					String URI = "/additemss";
					Mockito.when(servicess.additem(Mockito.any(Shoppingcart.class))).thenReturn(mockG);
					RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/additemss")
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					String outputInJson = response.getContentAsString();
					
					assertThat(outputInJson).isEqualTo(inputinJson);
					assertEquals(HttpStatus.OK.value(), response.getStatus());
					System.out.println(inputinJson);
					System.out.println(outputInJson+"This is outputinjson");
					System.out.println(response.getContentAsString()+"This is Response");
					System.out.println(result.getResponse()+"This is Result");
					
				}
				
				private String mapToJson(Object object) throws JsonProcessingException{
					ObjectMapper objectmapper = new ObjectMapper();
					return objectmapper.writeValueAsString(object);
				}
				
				@Test
				public void test2()
				throws Exception{
					
					User mockG = new User();
					mockG.setId(13);
					mockG.setAddress("PUNE");
					mockG.setEmail("email@gmail.com");
					mockG.setIs_email_verified("Yes");
					mockG.setMobile("9504034313");
					mockG.setPassword("1234");
					mockG.setName("Atul");
					mockG.setType(null);
					mockG.setLogin_token(null);
					mockG.setCreated_at(null);
				
					
					String inputinJson = this.mapToJson(mockG);
					
					String URI = "/adduser";
					Mockito.when(servicess.adduser(Mockito.any(User.class))).thenReturn(mockG);
					RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					String outputInJson = response.getContentAsString();
					
					assertThat(outputInJson).isEqualTo(inputinJson);
					assertEquals(HttpStatus.OK.value(), response.getStatus());
					
					
				}
				
				@Test
				void getAlluserss() {
					servicess.showitems();
					verify(servicess).showitems();
				}
				
				@Test
				public void testnew() {
					Shoppingcart mockGs = new Shoppingcart();
					mockGs.setItem_name("helo");
					mockGs.setPrice(34);
					
					assertEquals(mockGs.getPrice(), mockGs.getPrice());
					
					
				}


}
