package com.wellsfargo.stockexchange.market.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stockexchange.market.dao.StockExchangeDAO;
import com.wellsfargo.stockexchange.market.entity.Company;
import com.wellsfargo.stockexchange.market.entity.Exchange;

@Service
public class StockExchangeServiceImpl implements StockExchangeService{
	
	@Autowired
	private StockExchangeDAO stockExchangeDAO;
	
	
	public List<Exchange> getAllStockExchange() {
		List<Exchange> exchangeListing = new ArrayList<>();
		exchangeListing = stockExchangeDAO.getAllStockExchange();
		return exchangeListing;
	}
	
	public Exchange addStockExchange(Exchange exchange){
		stockExchangeDAO.addStockExchange(exchange);
		return exchange;
	}

	public List<Company> getCompaniesList(int id) {
		
		List<Company> companylist = new ArrayList<Company>();
		companylist = stockExchangeDAO.getCompaniesList(id);
		return companylist;
	}
	 
}
