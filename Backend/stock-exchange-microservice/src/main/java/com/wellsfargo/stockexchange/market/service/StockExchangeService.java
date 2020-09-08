package com.wellsfargo.stockexchange.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wellsfargo.stockexchange.market.entity.Company;
import com.wellsfargo.stockexchange.market.entity.Exchange;

@Service
public interface StockExchangeService {
	
	public List<Exchange> getAllStockExchange();
	public Exchange addStockExchange(Exchange exchange);
	public List<Company> getCompaniesList(int id);
}
