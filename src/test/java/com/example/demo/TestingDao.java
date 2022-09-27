package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Entitity.User;
import com.example.demo.dao.UserDao;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class TestingDao {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserDao userdao;
	
	@Test
	public void testuser() {
		User user = getTicket();
		User savedindb = entityManager.persist(user);
		String getfromdb = userdao.getallusers();
		
		assertThat(getfromdb).isEqualTo(savedindb);
	}
		


	
	private User getTicket() {
		User ticket = new User();
		ticket.setEmail("sean.s2006@gmail.com");
		ticket.setId(12);
		ticket.setIs_email_verified("yes");
		return ticket;
	}
}
