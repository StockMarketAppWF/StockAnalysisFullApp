package com.wellsfargo.stockexchange.market.dao;

import java.util.List;

import com.wellsfargo.stockexchange.market.entity.Company;
import com.wellsfargo.stockexchange.market.entity.Exchange;

public interface StockExchangeDAO {
	public List<Exchange> getAllStockExchange();
	public void addStockExchange(Exchange exchange);
	public List<Company> getCompaniesList(int id);
	public Exchange findById(int id);
}
