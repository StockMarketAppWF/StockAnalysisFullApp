package com.wellsfargo.stocks.stockexchange.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stocks.stockexchange.dao.StockExchangeDAO;
import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;
import com.wellsfargo.stocks.stockexchange.repo.ExchangeRepo;

@Service
public class StockExchangeServiceImpl implements StockExchangeService{
	
	private StockExchangeDAO stockExchangeDAO;
	
	@Autowired
	public StockExchangeServiceImpl(StockExchangeDAO stockExchangeDAO) {
		super();
		this.stockExchangeDAO = stockExchangeDAO;
	}
	
	public List<Exchange> getStockExchangesList() {
		List<Exchange> exchangeListing = new ArrayList<>();
		exchangeListing = stockExchangeDAO.getStockExchangesList();
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
