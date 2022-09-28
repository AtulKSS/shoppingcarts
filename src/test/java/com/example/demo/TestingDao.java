package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Entitity.User;
import com.example.demo.dao.UserDao;
import com.example.demo.services.Shoppingcartimplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestingDao {
	
	@Autowired
	private Shoppingcartimplementation servicess;
	
	@MockBean
	private UserDao userdao;
	
	

	

	
		
}
