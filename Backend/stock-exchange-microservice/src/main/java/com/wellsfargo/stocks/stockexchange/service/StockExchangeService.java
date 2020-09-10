package com.wellsfargo.stocks.stockexchange.service;

import java.util.List;

import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;

public interface StockExchangeService {
	public List<Exchange> getStockExchangesList();
	public Exchange addStockExchange(Exchange exchange);
	public List<Company> getCompaniesList(int id);
}
