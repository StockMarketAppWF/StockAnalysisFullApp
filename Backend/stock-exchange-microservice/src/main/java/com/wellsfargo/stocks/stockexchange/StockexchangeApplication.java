package com.wellsfargo.stocks.stockexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.wellsfargo.stocks.stockexchange.controller",
		"com.wellsfargo.stocks.stockexchange.dao",
		"com.wellsfargo.stocks.stockexchange.entity",
		"com.wellsfargo.stocks.stockexchange.service",
		"com.wellsfargo.stocks.stockexchange.repo"} )
@EntityScan(basePackages = { "com.wellsfargo.stocks.stockexchange.controller",
		"com.wellsfargo.stocks.stockexchange.dao", 
		"com.wellsfargo.stocks.stockexchange.entity",
		"com.wellsfargo.stocks.stockexchange.repo",
		"com.wellsfargo.stocks.stockexchange.service"} )
@EnableJpaRepositories(basePackages = { "com.wellsfargo.stocks.stockexchange.controller", 
		"com.wellsfargo.stocks.stockexchange.dao",
		"com.wellsfargo.stocks.stockexchange.repo",
		"com.wellsfargo.stocks.stockexchange.entity",
		"com.wellsfargo.stocks.stockexchange.service"} )
public class StockexchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockexchangeApplication.class, args);
	}

}
