package com.wellsfargo.stocks.stockexchange.dao;

import java.util.List;

import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;

public interface StockExchangeDAO {
	public List<Exchange> getStockExchangesList();
	public void addStockExchange(Exchange exchange);
	public List<Company> getCompaniesList(int id);
	public Exchange findById(int id);
}
