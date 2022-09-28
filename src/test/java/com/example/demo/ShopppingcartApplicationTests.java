package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
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

import com.example.demo.Entitity.AddtoCart;
import com.example.demo.Entitity.CheckoutCart;
import com.example.demo.Entitity.Products;
import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.Entitity.User;
import com.example.demo.controller.Mycontroller;
import com.example.demo.dao.AddToCartRepo;
import com.example.demo.dao.UserDao;
import com.example.demo.services.CartService;
import com.example.demo.services.ShoppingcartServices;
import com.example.demo.services.Shoppingcartimplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ShopppingcartApplicationTests{
				
				@Mock
				private Shoppingcartimplementation servicess;
				
				@Mock
				private CartService imp;
								
				@Autowired
				private MockMvc mvc;
				
				@MockBean
				private UserDao userDao;
				
				@MockBean
				private AddToCartRepo addtocartrepo;
				 
	//TESTING CONTROLLER
				
				@Test
				public void testAdditems()
				
				 throws Exception{
					Shoppingcart mockG = new Shoppingcart();
					mockG.setItem_name("MILKs");
					mockG.setPrice(455);
					String inputinJson = this.mapToJson(mockG);
					
					String URI = "/additemss";
					Mockito.when(servicess.additem(Mockito.any(Shoppingcart.class))).thenReturn(mockG);
					RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					String outputInJson = response.getContentAsString();
					
					assertThat(outputInJson).isEqualTo(inputinJson);
					assertEquals(HttpStatus.OK.value(), response.getStatus());		
			}
				
				private String mapToJson(Object object) throws JsonProcessingException{
					ObjectMapper objectmapper = new ObjectMapper();
					return objectmapper.writeValueAsString(object);
				}
				
				@Test
				public void testadduser()
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
//				
//					assertThat(outputInJson).isEqualTo(inputinJson);
					assertEquals(HttpStatus.OK.value(), response.getStatus());
				}
				
				@Test
				public void testAddtoCart()
				throws Exception{
					
					AddtoCart mockG = new AddtoCart();
					mockG.setId(13);
					mockG.setPrice(456);
					mockG.setProduct(null);
					mockG.setQty(5);
					mockG.setAdded_date(null);
					mockG.setUser_id(null);
					String inputinJson = this.mapToJson(mockG);
					
					String URI = "/addtocart";
					Mockito.when(servicess.addtocart(Mockito.any(AddtoCart.class))).thenReturn(mockG);
					RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					String outputInJson = response.getContentAsString();
				
					assertThat(outputInJson).isEqualTo(inputinJson);
					assertEquals(HttpStatus.OK.value(), response.getStatus());
					
					
				}
				
				@Test
				public void testingtoget()
				
				 throws Exception{
					Shoppingcart mockG = new Shoppingcart();
					mockG.setItem_name("Chana daal");
					mockG.setPrice(34);
					
					Shoppingcart mockG1 = new Shoppingcart();
					mockG1.setItem_name("MILKs");
					mockG1.setPrice(455);
					List<Shoppingcart> showitemsss = new ArrayList<>();
					showitemsss.add(mockG);
					showitemsss.add(mockG1);

					Mockito.when(servicess.showitems()).thenReturn(showitemsss);					
					String URI = "/showitems";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
							URI).accept(
									MediaType.APPLICATION_JSON);
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					String expectedJson = this.mapToJson(showitemsss);
					String outputInJson1 = result.getResponse().getContentAsString();
					assertThat(outputInJson1).isEqualTo(expectedJson);
				}
				
				@Test
				public void testAddproduct()
				throws Exception{
					
					Products mockG = new Products();
					mockG.setId(13);
					mockG.setAdded_on(null);
					mockG.setName("Bread");
					mockG.setPrice(null);
					mockG.setCategory_id(null);
					String inputinJson = this.mapToJson(mockG);
					
					String URI = "/addproduct";
					Mockito.when(servicess.addproduct(Mockito.any(Products.class))).thenReturn(mockG);
					RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					String outputInJson = response.getContentAsString();
					
					assertThat(outputInJson).isEqualTo(inputinJson);
					assertEquals(HttpStatus.OK.value(), response.getStatus());
				}
				
			
				//Testing for Get method, Getting a list of String from database
				@Test
				public void testinggetallitem() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					 mockG.add("Chana daal");
					 mockG.add("MILKs");
		
					String inputinJson = this.mapToJson(mockG);		
					Mockito.when(servicess.getAllitems()).thenReturn(mockG);		
					String URI = "/allitems";
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.OK.value(), response.getStatus());
				}
								
				@Test
				public void testingapi() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					 mockG.add("Chana daal");
					 mockG.add("MILKs");
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(servicess.getAllitems()).thenReturn(mockG);
					
					String URI = "/allitems";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					

					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.OK.value(), response.getStatus());
				}
				
				@Test
				public void testingapi2() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(servicess.getsingleitem(34)).thenReturn(null);
					
					String URI = "/additemss/34";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
				
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.OK.value(), response.getStatus());				
				}
				
				
				@Test
				public void testingapi3() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(servicess.getallusersss()).thenReturn(null);
					
					String URI = "/getallusersss";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
				
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.OK.value(), response.getStatus());				
				}
				
				
				@Test
				public void testingapi4() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(servicess.getPrice()).thenReturn(null);
					
					String URI = "/price";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
				
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.OK.value(), response.getStatus());				
				}
				
				
				@Test
				public void testingapi5() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
//					Mockito.when(servicess.removeitem(5)).thenReturn(mockG);
					
					String URI = "/additemss/1";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
				
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.OK.value(), response.getStatus());				
				}
				
				@Test
				public void testingapi6() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(servicess.getsingleitem(1)).thenReturn(null);
					
					String URI = "/additemss/1";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
				
					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());				
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				@Test
				public void testingss() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(servicess.getAllitems()).thenReturn(mockG);
					
					String URI = "/updateQtyForCart";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					

					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
				}
				
				@Test
				public void testingsss() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(imp.removeCartByUserId(0, 0)).thenReturn(null);
					
					String URI = "/removeProductFromCart";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					

					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
				}
				
				@Test
				public void testingssss() throws Exception {
					 List<String> mockG=new ArrayList<String>();  
					
				
					 String inputinJson = this.mapToJson(mockG);
					
					Mockito.when(imp.getCartByUserId(0)).thenReturn(null);
					
					String URI = "/getCartsByUserId";
					
					RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
							.accept(MediaType.APPLICATION_JSON).content(inputinJson).contentType(MediaType.APPLICATION_JSON);
					

					MvcResult result = mvc.perform(requestBuilder).andReturn();
					MockHttpServletResponse response = result.getResponse();
					assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
				}
				
//				@Test
//				public void testCreateTicket(){
//
//					Shoppingcart mock = new Shoppingcart();
//					mock.setItem_name("Jam");
//					
//					
//				    Mockito.when(userDao.save(mock)).thenReturn(mock);
//				    
//				    assertThat(servicess.additem(mock)).isEqualTo(mock);
//				
//				}
				
	
				
								
		//TESTING SERVICES
				
				
				
	
				
		
				
				

}
