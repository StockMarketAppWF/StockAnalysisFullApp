package com.wellsfargo.stockexchange;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import com.wellsfargo.stockexchange.util.UserRepository;
import com.wellsfargo.stockexchange.models.User;
import com.wellsfargo.stockexchange.models.enums.UserTypes;

//@EnableEurekaClient
@SpringBootApplication
public class StockExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserRepository userRepository) {

	    return args -> {

	            //newAdminRole.setRole("ADMIN");
	            User user = new User();
				user.setUsername("admin");
				user.setPassword("123456");
				user.setFullName("Karthik Iyer");
				user.setConfirmed(true);
				user.setEmail("abc@gmail.com");
				user.setUserType(UserTypes.ADMIN);
				userRepository.save(user);
	        
	    };

	}

}

