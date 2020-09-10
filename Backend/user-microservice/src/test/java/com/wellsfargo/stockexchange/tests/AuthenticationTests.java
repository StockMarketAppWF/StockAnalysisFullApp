package com.wellsfargo.stockexchange.tests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.wellsfargo.stockexchange.models.User;
import com.wellsfargo.stockexchange.models.enums.UserTypes;
import com.wellsfargo.stockexchange.service.AuthenticationService;
import com.wellsfargo.stockexchange.util.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationTests {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@MockBean
	private UserRepository userRepo;

		@Test
		public void saveUserTest() {
			
			User user = new User();
			user.setUsername("admin");
			user.setPassword("12345");
			user.setFullName("Karthik Iyer");
			user.setConfirmed(true);
			user.setEmail("abc@gmail.com");
			user.setUserType(UserTypes.ADMIN);
			when(userRepo.save(user)).thenReturn(user);
			assertEquals(user, authenticationService.save(user));
			
			User user = new User();
			user.setUsername("user");
			user.setPassword("12345");
			user.setFullName("Tmp Iyer");
			user.setConfirmed(true);
			user.setEmail("xyz@gmail.com");
			user.setUserType(UserTypes.USER);
			when(userRepo.save(user)).thenReturn(user);
			assertEquals(user, authenticationService.save(user));
		}
}