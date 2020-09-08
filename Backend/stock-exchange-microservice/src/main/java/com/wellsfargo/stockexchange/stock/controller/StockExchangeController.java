package com.wellsfargo.stockexchange.stock.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wellsfargo.stockexchange.stock.entity.StockExchange;
import com.wellsfargo.stockexchange.stock.model.Company;
import com.wellsfargo.stockexchange.stock.model.CompanyList;
import com.wellsfargo.stockexchange.stock.service.StockExchangeService;

@RestController
@RequestMapping("/stockexchange")
public class StockExchangeController {
	
	private StockExchangeService stockExchangeService;

	@Autowired
    	public StockExchangeController(StockExchangeService thestockexchangeservice){
        stockExchangeService = thestockexchangeservice;

    	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/all")
	public List<StockExchange> findAll()
	{
       	List<StockExchange> stockExchanges = stockExchangeService.getAllStockExchange();
		return stockExchanges;
    	}

	@GetMapping("/{id}")
	public Optional<StockExchange> fineOne(@PathVariable int id)  {
        	Optional<StockExchange> stockExchange = stockExchangeService.getStockExchange(id);
		return stockExchange;
    	}
	
	@PostMapping
	public StockExchange addOne(@RequestBody StockExchange s)	{
		StockExchange stockExchange = stockExchangeService.saveStockExchange(s);
		return stockExchange;
    }
	
	@PutMapping
	public StockExchange updateOne(@RequestBody StockExchange s)
	{
        	Optional<StockExchange> stockExchange = stockExchangeService.getStockExchange(s.getId());
        	if (stockExchange == null)
		{
           	throw new RuntimeException("Stock Exchange to update doesn't exist.");
        	}
		else
        		return (stockExchangeService.updateStockExchange(s));
    }
	
	@DeleteMapping("/{id}")
	public String deleteStockExchange(@PathVariable int id)
	{
		return (stockExchangeService.deleteStockExchange(id));
	}
	
	 //Consuming the API from company 
	 //Retrieve the list of companies belonging to a stockExchange
		
		@GetMapping("/list-companies/{stockId}")
		public List<Company> getListCompany(@PathVariable int stockId)
		{
			CompanyList companies = restTemplate.getForObject("http://company-microservice/company/stock/"+ stockId, CompanyList.class);
			
			List<Company> list = companies.getCompanyList();
			return list;
			
			//return companies;
		}


}