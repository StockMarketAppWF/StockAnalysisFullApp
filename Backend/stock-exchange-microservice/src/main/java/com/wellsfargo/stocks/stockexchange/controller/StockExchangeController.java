package com.wellsfargo.stocks.stockexchange.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;
import com.wellsfargo.stocks.stockexchange.service.StockExchangeService;
import com.wellsfargo.stocks.stockexchange.service.StockExchangeServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class StockExchangeController {
	
	private StockExchangeService stockExchangeService;
	
	@Autowired
	public StockExchangeController(StockExchangeService stockExchangeService) {
		super();
		this.stockExchangeService = stockExchangeService;
	}
	

	@RequestMapping("/stockexchange/getstockexchangelist")
	public List<Exchange> getStockExchangesList()
	{
		List<Exchange> exchangeList = new ArrayList<>();
		exchangeList = stockExchangeService.getStockExchangesList();
		return exchangeList;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/stockexchange/addstockexchange")
	public Exchange addStockExchange(@RequestBody Exchange exchange)
	{
		if(exchange == null)
			System.out.println("Exchange is null");
		else {
		System.out.println(exchange);
		stockExchangeService.addStockExchange(exchange);
		}
		
		return exchange;
	}
	
	@RequestMapping("/stockexchange/getcompanylist/{id}")
	public List<Company> getCompaniesList(@PathVariable int id)
	{
		return stockExchangeService.getCompaniesList(id);
	}

	 
}

