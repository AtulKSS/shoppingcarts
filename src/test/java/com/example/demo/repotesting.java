package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.ShoppingDao;
import com.example.demo.dao.UserDao;

@SpringBootTest
public class repotesting {
	@Autowired
	private UserDao userssdao;
	
	@Mock
	private ShoppingDao shopdao;
	
	@Test
	void getPrice() {
		
		
		Boolean actualResult = shopdao.getPrice(0);
		assertThat(actualResult).isFalse();
		System.out.print(actualResult);
	}
	
	@Test
	void getusernamebyid() {
		Boolean actualResults = userssdao.getallusersbyid(4);
		assertThat(actualResults).isTrue();
		System.out.print(actualResults);
	}
	

}
