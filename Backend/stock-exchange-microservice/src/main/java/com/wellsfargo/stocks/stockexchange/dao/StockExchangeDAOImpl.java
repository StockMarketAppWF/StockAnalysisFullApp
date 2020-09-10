package com.wellsfargo.stocks.stockexchange.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;
import com.wellsfargo.stocks.stockexchange.repo.ExchangeRepo;

@Repository
public class StockExchangeDAOImpl implements StockExchangeDAO{

	@Autowired
	
	private ExchangeRepo stockExchangeDAO;
	
	public List<Exchange> getStockExchangesList() {
		List<Exchange> exchangeListing = new ArrayList<>();
		stockExchangeDAO.findAll().forEach(exchangeListing::add);  
		return exchangeListing;
	}
	
	public void addStockExchange(Exchange exchange){
		stockExchangeDAO.save(exchange);
	}
	 @PersistenceContext
	  private EntityManager em;

	 public Exchange findById(int id) {
		 Exchange exchange  =em.find(Exchange.class, id);
	        if (exchange == null) {
	            throw new EntityNotFoundException("Can't find Exchange for ID "
	                + id);
	        }

	        return exchange;
	    }

	public List<Company> getCompaniesList(int id) {
		Exchange exchange = findById(id);
		
		List<Company> companylist = new ArrayList<Company>();
		companylist = exchange.getCompany();
		return companylist;
	}
}
